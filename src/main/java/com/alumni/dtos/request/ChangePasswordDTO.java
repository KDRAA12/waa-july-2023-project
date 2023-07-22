package com.alumni.dtos.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ChangePasswordDTO {

    private String OldPassword;
    private String NewPassword;

}
