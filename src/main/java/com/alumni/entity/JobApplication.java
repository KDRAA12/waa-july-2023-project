package com.alumni.entity;

import com.alumni.composite_ids.JobApplicationId;
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



}
