package com.alumni.Service.impls;

import com.alumni.Exceptions.NotFoundException;
import com.alumni.Service.JobApplicationService;
import com.alumni.entity.JobApplication;
import com.alumni.repository.JobApplicationRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JobApplicationServiceImpl implements JobApplicationService {

    private final ModelMapper modelMapper;


    @Autowired
    private final JobApplicationRepository repository;

    @Override
    public List<JobApplication> getList(int page, int size, Long jobId, Long studentId){
        return repository.findAll(PageRequest.of(page,size)).stream().map((JobApplication jobApplication)->modelMapper.map(jobApplication, JobApplication.class)).collect(Collectors.toList());
    }

    @Override
    public void create(JobApplication record){
        repository.save(record);
    }

    @Override
    public JobApplication findById(Long id){
        return repository.findById(id).orElseThrow(()->new NotFoundException("Job Application with ID: " +id +" was not found"));
    }

    @Override
    public void put(Long id, JobApplication record){
        JobApplication source= findById(id);
        record.setId(id);
        repository.save(source);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
