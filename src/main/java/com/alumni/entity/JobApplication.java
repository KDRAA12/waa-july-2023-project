package com.alumni.entity;

import com.alumni.entity.enums.JobApplicationStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(indexes = {
        @Index(name = "jop_application_u_index", columnList = "student_id, job_advertisment_id", unique = true)
})
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private JobApplicationStatus status;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "job_advertisment_id")
    private JobAdvertisement jobAdvertisement;
}