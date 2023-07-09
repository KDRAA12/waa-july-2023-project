package com.alumni.dtos.request;


import com.alumni.entity.enums.JobApplicationStatus;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class JobApplicationRequestDTO {

    private Long studentId;
    private Long jobAdvertisementId;
    private JobApplicationStatus status;


}
