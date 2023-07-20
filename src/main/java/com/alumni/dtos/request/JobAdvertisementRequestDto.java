package com.alumni.dtos.request;

import com.alumni.entity.Tag;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class JobAdvertisementRequestDto {
    private String state;
    private String city;
    private String company;

    private String title;
    private String description;


    private List<Long> tags= new ArrayList<>();

}
