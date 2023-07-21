package com.alumni.dtos.response;

import com.alumni.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO {

    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private int failedLoginAttempts;
    private List<Role> roles;
    private String token;

}
