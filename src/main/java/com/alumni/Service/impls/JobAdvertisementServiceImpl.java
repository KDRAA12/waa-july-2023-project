package com.alumni.Service.impls;

import com.alumni.Exceptions.NotFoundException;
import com.alumni.Service.JobAdvertisementService;
import com.alumni.dtos.request.JobAdvertisementRequestDto;
import com.alumni.dtos.response.JobAdvertisementResponseDto;
import com.alumni.entity.JobAdvertisement;
import com.alumni.entity.Tag;
import com.alumni.repository.JobAdvertisementRepository;
import com.alumni.repository.TagRepository;
import jakarta.transaction.Transactional;
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

    @Autowired final TagRepository tagRepository;




    @Override
    @Transactional
    public List<JobAdvertisementResponseDto> getList(int page, int size, List<Long> tags, String state, String city) {

List<JobAdvertisement> list;
    if(tags!=null)
        list=repository.findAllByTagsInAndStateContainsIgnoreCaseAndCityContainsIgnoreCaseOrderByPostedAtDesc(tags,state,city,PageRequest.of(page,size));
    else
        list=repository.findAllByStateContainsIgnoreCaseAndCityContainsIgnoreCaseOrderByPostedAtDesc(state,city,PageRequest.of(page,size));

    return list.stream().map((JobAdvertisement jobAdvertisement)->modelMapper.map(jobAdvertisement,JobAdvertisementResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public void create(JobAdvertisementRequestDto requestDto) {


//        tagRepository.save(new Tag(1L, "Information Technology (IT)"));
//        tagRepository.save(new Tag(2L, "Marketing and Advertising"));
//        tagRepository.save(new Tag(3L, "Finance and Accounting"));
//        tagRepository.save(new Tag(4L, "Sales and Business Development"));
//        tagRepository.save(new Tag(5L, "Human Resources (HR)" ));
//        tagRepository.save(new Tag(6L, "Healthcare and Medical"));
//        tagRepository.save(new Tag(7L, "Education and Teaching"));
//        tagRepository.save(new Tag(8L, "Engineering and Technology"));
//        tagRepository.save(new Tag(9L, "Creative Arts and Design"));
//        tagRepository.save(new Tag(10L, "Customer Service and Support"));

        JobAdvertisement jobAdvertisement= modelMapper.map(requestDto,JobAdvertisement.class);
    if(requestDto.getTags()!=null){
        jobAdvertisement.setTags(
                requestDto.getTags().stream().map(x-> {
                    Tag  tag=  new Tag();
                    tag.setId(x);
                    return tag;
                }).collect(Collectors.toList())
        );

    }


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
