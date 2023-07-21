package com.alumni.controllers;

import com.alumni.Service.CityService;
import com.alumni.Service.impls.CityServiceImpl;
import com.alumni.dtos.response.CityResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1/cities")
@AllArgsConstructor
public class CityController {

    public final CityService service;

    @GetMapping
    public ResponseEntity<List<CityResponseDTO>> getCities(@RequestParam(required = false, defaultValue = "") String state) {
        if(!state.isEmpty()){
            return ResponseEntity.ok(service.FindAllByStateId(Long.valueOf(state)));
        }

        return ResponseEntity.ok(service.getList());
    }


}
