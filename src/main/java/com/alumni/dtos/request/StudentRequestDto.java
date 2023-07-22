package com.alumni.dtos.request;

import com.alumni.entity.City;
import com.alumni.entity.JobExperience;
import com.alumni.entity.State;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Data
public class StudentRequestDto {
    private long id;
    private State state;
    private City city;

    private String major;

    private String firstName;
    private String lastName;

    private String cvUrl;
    private List<JobExperience> jobExperiences;
    private String email;
    private String password;
}
