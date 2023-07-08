package com.alumni.dtos.response;

import com.alumni.entity.Student;
import com.alumni.entity.Tag;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class JobAdvertisementResponseDto {

    private Long id;
    private String state;
    private String city;
    private String company;
    private String attachments;
    private Student postedBy;
    private List<Tag> tags= new ArrayList<>();

}
