package com.alumni.dtos.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AdminUpdateUserDTO {
    private String newPassword;
    private Boolean isActive;

}
