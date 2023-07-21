package com.alumni.Service;

import com.alumni.dtos.request.FacultyRequestDto;
import com.alumni.dtos.response.FacultyResponseDTO;

import java.util.List;

public interface FacultyService {
    List<FacultyResponseDTO> getList(int page, int size);

    void create(FacultyRequestDto requestDto);

    FacultyResponseDTO findById(Long id);

     void put(Long id, FacultyRequestDto requestDto);

    void deleteById(Long id);

     void changePassword(Long id, String password);
}
