package com.alumni.entity;

import com.alumni.entity.composite_ids.JobApplicationId;
import com.alumni.entity.enums.JobApplicationStatus;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class JobApplication {

    @EmbeddedId
    private JobApplicationId id;

    private JobApplicationStatus status;

}