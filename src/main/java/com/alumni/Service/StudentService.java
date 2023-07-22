package com.alumni.Service;

import com.alumni.dtos.response.StudentResponseDTO;
import com.alumni.dtos.request.StudentRequestDto;
import com.alumni.entity.BaseUser;
import com.alumni.entity.Comment;
import com.alumni.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentResponseDTO> getList(int page, int size, Long state, Long city, String major, String name);

    void create(StudentRequestDto requestDto);

    StudentResponseDTO findById(Long id);

     void put(Long id, StudentRequestDto requestDto);

    void deleteById(Long id);

     void changePassword(Long id, String password);

    Student findByUserName(String s);

    void addComment(Long id, Comment comment);

    List<Comment> getComments(Long id);

    void editComment(Long commentId, Comment comment);

    void deleteCommentById(Long commentId);
}
