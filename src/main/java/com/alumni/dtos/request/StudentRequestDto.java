package com.alumni.dtos.request;

import com.alumni.entity.JobExperience;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Data
public class StudentRequestDto {
    private long id;
    private String state;
    private String city;

    private String major;

    private String name;

    private String cvUrl;
    private List<JobExperience> jobExperiences;
    private String email;
    private String password;
}
