package com.alumni.dtos.response;
import com.alumni.entity.City;
import com.alumni.entity.JobExperience;
import com.alumni.entity.State;
import lombok.Data;

import java.util.List;

@Data
public class StudentResponseDTO {
    private long id;
    private State state;
    private City city;
    private String major;
    private String cvUrl;
    private BaseUserDTO user;
    private List<JobExperience> jobExperiences;

}
