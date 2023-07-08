package com.alumni.Service;

import com.alumni.dtos.request.JobAdvertisementRequestDto;
import com.alumni.dtos.response.JobAdvertisementResponseDto;
import java.util.List;

public interface JobAdvertisementService {
    List<JobAdvertisementResponseDto> getList(int page, int size,  List<Long> tags, String state, String city);

    void create(JobAdvertisementRequestDto requestDto);

    JobAdvertisementResponseDto findById(Long id);

     void put(Long id, JobAdvertisementRequestDto requestDto);

    void deleteById(Long id);

}
