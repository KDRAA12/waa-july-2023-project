package com.alumni.entity.composite_ids;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class JobApplicationId implements Serializable {

    private Long studentId;
    private Long jobAdvertisementId;

}
