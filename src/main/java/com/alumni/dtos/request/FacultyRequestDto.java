package com.alumni.dtos.request;

import com.alumni.entity.City;
import com.alumni.entity.JobExperience;
import com.alumni.entity.State;
import lombok.Data;

import java.util.List;


@Data
public class FacultyRequestDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Long stateId;
    private Long cityId;
}
