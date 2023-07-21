package com.alumni.controllers;

import com.alumni.Service.CityService;
import com.alumni.Service.StateService;
import com.alumni.dtos.response.CityResponseDTO;
import com.alumni.dtos.response.StateResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/states")
@AllArgsConstructor
public class StateController {
    public final StateService service;

    @GetMapping
    public ResponseEntity<List<StateResponseDTO>> getStates() {
        return ResponseEntity.ok(service.getList());
    }

}
