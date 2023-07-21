package com.alumni.dtos;

import org.modelmapper.ModelMapper;

public interface DTO {
    default ModelMapper updateModelMapper(ModelMapper mapper, MappingUtils utils){
        return mapper;
    }
}
