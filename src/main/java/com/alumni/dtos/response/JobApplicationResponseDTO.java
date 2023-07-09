package com.alumni.dtos.response;


import com.alumni.entity.enums.JobApplicationStatus;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class JobApplicationResponseDTO {

    private Long id;
    private JobApplicationStatus status;

}
