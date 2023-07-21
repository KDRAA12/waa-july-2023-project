package com.alumni.dtos.response;

import lombok.Builder;
import lombok.Data;

@Data
public class CityResponseDTO {
    private long id;
    private String name;
    private Long stateId;
}
