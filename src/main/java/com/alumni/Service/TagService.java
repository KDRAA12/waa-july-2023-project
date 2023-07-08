package com.alumni.Service;

import com.alumni.dtos.request.JobAdvertisementRequestDto;
import com.alumni.dtos.request.TagRequestDTO;
import com.alumni.dtos.response.JobAdvertisementResponseDto;
import com.alumni.dtos.response.TagResponseDTO;

import java.util.List;

public interface TagService {
    List<TagResponseDTO> getList(int page, int size);

    void create(TagRequestDTO requestDto);

    TagResponseDTO findById(Long id);

     void put(Long id, TagRequestDTO requestDto);

    void deleteById(Long id);

}
