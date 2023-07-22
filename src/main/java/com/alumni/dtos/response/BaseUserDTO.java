package com.alumni.dtos.response;

import com.alumni.dtos.DTO;
import com.alumni.dtos.MappingUtils;
import com.alumni.entity.BaseUser;
import com.alumni.entity.City;
import com.alumni.entity.State;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;

@Data
public class BaseUserDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private State state;
    private City city;



}
