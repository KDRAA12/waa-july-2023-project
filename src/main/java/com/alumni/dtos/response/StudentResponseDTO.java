package com.alumni.dtos.response;
import com.alumni.entity.JobExperience;
import lombok.Data;

import java.util.List;

@Data
public class StudentResponseDTO {
    private long id;
    private String state;
    private String city;
    private String major;
    private String name;
//    private String cvUrl;
    private List<JobExperience> jobExperiences;

}
