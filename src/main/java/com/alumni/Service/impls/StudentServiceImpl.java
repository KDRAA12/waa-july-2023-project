package com.alumni.Service.impls;

import com.alumni.Exceptions.NotFoundException;
import com.alumni.Service.StudentService;
import com.alumni.dtos.response.StudentResponseDTO;
import com.alumni.dtos.request.StudentRequestDto;
import com.alumni.entity.BaseUser;
import com.alumni.entity.Comment;
import com.alumni.entity.Role;
import com.alumni.entity.Student;
import com.alumni.entity.enums.RoleEnum;
import com.alumni.repository.*;
import com.alumni.utils.RepositoryUtils;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final ModelMapper modelMapper;


    @Autowired
    private final StudentRepository repository;

    private final RoleRepository roleRepository;

    private final CommentRepository commentRepository;

    @Autowired
    public AttachmentRepository attachmentRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final BaseUserRepository baseUserRepository;



    @Override
    public List<StudentResponseDTO> getList(int page, int size, String state, String city, String major, String name) {


    return repository.getList(RepositoryUtils.searchFormatter(state),
            RepositoryUtils.searchFormatter(city),
            RepositoryUtils.searchFormatter(major),
            RepositoryUtils.searchFormatter(name),
                    PageRequest.of(page,size)
                    )
                    .stream().map((Student student)->modelMapper.map(student,StudentResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void create(StudentRequestDto requestDto) {

        Role studentRole = roleRepository.findByName(RoleEnum.STUDENT.toString());
        Student entity= modelMapper.map(requestDto,Student.class);

        System.out.println(requestDto);
        BaseUser user = new BaseUser();
        user.setFirstName(requestDto.getFirstName());
        user.setLastName(requestDto.getLastName());

        user.setCity(requestDto.getCity());
        user.setState(requestDto.getState());
        user.setEmail(requestDto.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(requestDto.getPassword()));
        user.setActiveAfter(LocalDateTime.now());
        user.setActive(true);
        user.setFailedLoginAttempts(0);
        user.setRoles(List.of(studentRole));
        entity.setUser(baseUserRepository.save(user));
        repository.save(entity);



    }

    @Override
    public StudentResponseDTO findById(Long id) {
        Student entity=getByID(id);
        return modelMapper.map(entity,StudentResponseDTO.class);
    }

    private Student getByID(Long id){
        return repository.findById(id).orElseThrow(()->new NotFoundException("Student with ID: " +id +" was not found"));
    }

    @Override
    public void put(Long id, StudentRequestDto requestDto) {
        Student source=getByID(id);
        modelMapper.map(requestDto,source);
        source.setId(id);
        repository.save(source);
    }

    @Override
    public void deleteById(Long id) {
         repository.deleteById(id);

    }

    @Override
    public void changePassword(Long id, String password) {
        Student student=repository.findById(id).orElseThrow(()->new RuntimeException("not found"));
        student.getUser().setPassword(bCryptPasswordEncoder.encode(password));
        repository.save(student);
    }

    @Override
    public Student findByUserName(String s) {
        return repository.findByUserEmail(s);
    }

    @Override
    public void addComment(Long id, Comment comment) {
        Student s =new Student();
        s.setId(id);
        comment.setStudent(s);
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getComments(Long id) {
        return commentRepository.findAllByStudentId(id);
    }

    @Override
    public void editComment(Long commentId, Comment comment) {
        comment.setId(commentId);
        commentRepository.save(comment);
    }

    @Override
    public void deleteCommentById(Long commentId) {
        commentRepository.deleteById(commentId);

    }


}
