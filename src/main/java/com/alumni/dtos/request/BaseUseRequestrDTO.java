package com.alumni.dtos.request;

import com.alumni.entity.City;
import com.alumni.entity.State;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseUseRequestrDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long RoleId;
    private Long stateId;
    private Long cityId;
}
