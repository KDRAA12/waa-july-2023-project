package com.alumni.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;


@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String state;
    private String city;
    private String major;
    private String name;
    private String cvUrl;
    @OneToMany(cascade = CascadeType.ALL)
    private List<JobExperience> jobExperiences;
    @OneToOne
    private BaseUser user;
    @OneToOne
    @JoinColumn(name = "attachment_id")
    private Attachment cv;

    @OneToMany(mappedBy = "student")
    private List<JobApplication> jobApplications ;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return id == student.id && Objects.equals(state, student.state) && Objects.equals(city, student.city) && Objects.equals(major, student.major) && Objects.equals(name, student.name) && Objects.equals(cvUrl, student.cvUrl) && Objects.equals(jobExperiences, student.jobExperiences) && Objects.equals(user, student.user) && Objects.equals(cv, student.cv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state, city, major, name, cvUrl, jobExperiences, user, cv);
    }
}
