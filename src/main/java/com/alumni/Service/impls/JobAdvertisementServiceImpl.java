package com.alumni.Service.impls;

import com.alumni.Exceptions.NotFoundException;
import com.alumni.Service.JobAdvertisementService;
import com.alumni.dtos.request.JobAdvertisementRequestDto;
import com.alumni.dtos.response.JobAdvertisementResponseDto;
import com.alumni.entity.JobAdvertisement;
import com.alumni.repository.JobAdvertisementRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class JobAdvertisementServiceImpl implements JobAdvertisementService {
    private final ModelMapper modelMapper;


    @Autowired
    private final JobAdvertisementRepository repository;




    @Override
    public List<JobAdvertisementResponseDto> getList(int page, int size, List<Long> tags, String state, String city) {

List<JobAdvertisement> list= new ArrayList<>();
    if(tags!=null)
        list=repository.findAllByTagsInAndStateContainsIgnoreCaseAndCityContainsIgnoreCaseOrderByPostedAtDesc(tags,state,city,PageRequest.of(page,size));
    else
        list=repository.findAllByStateContainsIgnoreCaseAndCityContainsIgnoreCaseOrderByPostedAtDesc(state,city,PageRequest.of(page,size));

    return list.stream().map((JobAdvertisement jobAdvertisement)->modelMapper.map(jobAdvertisement,JobAdvertisementResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public void create(JobAdvertisementRequestDto requestDto) {
        JobAdvertisement jobAdvertisement= modelMapper.map(requestDto,JobAdvertisement.class);
    repository.save(jobAdvertisement);
    }



    @Override
    public JobAdvertisementResponseDto findById(Long id) {
        JobAdvertisement entity=getByID(id);
        return modelMapper.map(entity,JobAdvertisementResponseDto.class);

    }



    private JobAdvertisement getByID(Long id){
        return repository.findById(id).orElseThrow(()->new NotFoundException("Job Advertisement with ID: " +id +" was not found"));
    }

    @Override
    public void put(Long id, JobAdvertisementRequestDto requestDto) {
        JobAdvertisement source=getByID(id);
        modelMapper.map(requestDto,source);
        source.setId(id);
        repository.save(source);
    }

    @Override
    public void deleteById(Long id) {
         repository.deleteById(id);

    }




}
