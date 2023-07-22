package com.alumni.dtos.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class StatisticsResponseDTO {
    private String name;
    private Integer value;

}
