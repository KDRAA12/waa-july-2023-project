package com.alumni.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String state;
    private String city;
    private String company;

    private String title;


@Lob
    private String description;

    private String attachments;
    private String postedBy;
    private Date postedAt=new Date();

    @ManyToMany
    private List<Tag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "jobAdvertisement")
    private List<JobApplication> jobApplications;
}