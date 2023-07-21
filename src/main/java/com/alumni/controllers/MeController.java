package com.alumni.controllers;

import com.alumni.Service.BaseUserService;
import com.alumni.dtos.request.BaseUseRequestrDTO;
import com.alumni.dtos.response.FacultyResponseDTO;
import com.alumni.entity.BaseUser;
import com.alumni.entity.enums.RoleEnum;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1/me")
@AllArgsConstructor
public class MeController {

    private final BaseUserService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity get(Principal principal){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        BaseUser baseUser = (BaseUser)authentication.getPrincipal();


//        System.out.println("authentication" + authentication);
//        FacultyResponseDTO
        if(service.isAdmin(baseUser)){
            return ResponseEntity.ok(modelMapper.map(baseUser ,FacultyResponseDTO.class));
        }
        if(service.isStudent(baseUser)){
            return ResponseEntity.ok(modelMapper.map(baseUser ,FacultyResponseDTO.class));

        }
        if(service.isFaculty(baseUser)){
            return ResponseEntity.ok(modelMapper.map(baseUser ,FacultyResponseDTO.class));

        }
        return ResponseEntity.ok("");
    }


    @PutMapping
    public ResponseEntity update(@RequestBody BaseUseRequestrDTO baseUseRequestrDTO){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        BaseUser baseUser = (BaseUser)authentication.getPrincipal();
        baseUser = service.update(baseUser.getId(),baseUseRequestrDTO);
//        System.out.println("authentication" + authentication);
//        FacultyResponseDTO
        if(service.isAdmin(baseUser)){
            return ResponseEntity.ok(modelMapper.map(baseUser ,FacultyResponseDTO.class));
        }
        if(service.isStudent(baseUser)){
            return ResponseEntity.ok(modelMapper.map(baseUser ,FacultyResponseDTO.class));

        }
        if(service.isFaculty(baseUser)){
            return ResponseEntity.ok(modelMapper.map(baseUser ,FacultyResponseDTO.class));

        }
        return ResponseEntity.ok(baseUser);
    }


}
