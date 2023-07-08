package com.alumni.Service;

import com.alumni.dtos.request.StudentRequestDto;
import com.alumni.dtos.response.StudentResponseDTO;

import java.util.List;

public interface JobApplicationService  {
    List<StudentResponseDTO> getList(int page, int size, Long jobId, Long studentId);

    void create(StudentRequestDto requestDto);

    StudentResponseDTO findById(Long id);

    void put(Long id, StudentRequestDto requestDto);

    void deleteById(Long id);

    void changePassword(Long id, String password);
}
