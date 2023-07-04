package com.alumni.Service.impls;

import com.alumni.Exceptions.NotFoundException;
import com.alumni.Service.BaseUserService;
import com.alumni.Service.StudentService;
import com.alumni.dtos.response.StudentResponseDTO;
import com.alumni.dtos.request.StudentRequestDto;
import com.alumni.entity.BaseUser;
import com.alumni.entity.Role;
import com.alumni.entity.Student;
import com.alumni.repository.AttachmentRepository;
import com.alumni.repository.BaseUserRepository;
import com.alumni.repository.StudentRepository;
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
        Student entity= modelMapper.map(requestDto,Student.class);

        BaseUser baseUser= new BaseUser();
        baseUser.setEmail(requestDto.getEmail());
        baseUser.setPassword(bCryptPasswordEncoder.encode(requestDto.getEmail()));
        baseUser.setActiveAfter(LocalDateTime.now());
        baseUser.setActive(true);
        baseUser.setFailedLoginAttempts(0);
        baseUser.setRoles(List.of(Role.STUDENT));
        entity.setUser(baseUserRepository.save(baseUser));

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
        
    }


}
