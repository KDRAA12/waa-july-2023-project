package com.alumni.controllers;

import com.alumni.Service.BaseUserService;
import com.alumni.dtos.request.AdminUpdateUserDTO;
import com.alumni.entity.BaseUser;
import com.alumni.repository.BaseUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")
public class BaseUserController {

    public final BaseUserService service;
    public final BaseUserRepository repository;


    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {
        Optional<BaseUser> user = repository.findById(id);
        if (user.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found");
        }
        return ResponseEntity.ok(user.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity putUser(@PathVariable Long id, @RequestBody AdminUpdateUserDTO adminUpdateUserDTO) {
        Optional<BaseUser> user = repository.findById(id);
        if (user.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found");
        }

        if (adminUpdateUserDTO.getNewPassword() != null) {
            service.changePassword(user.get(), adminUpdateUserDTO.getNewPassword());
            return ResponseEntity.ok(user.get());

        }


        if(adminUpdateUserDTO.getIsActive() != null){
            user.get().setActive(adminUpdateUserDTO.getIsActive());
            service.update(user.get());
        }

        return ResponseEntity.ok(user.get());
    }




}
