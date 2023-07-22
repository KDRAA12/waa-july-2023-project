package com.alumni.controllers;


import com.alumni.Service.FacultyService;
import com.alumni.dtos.request.FacultyRequestDto;
import com.alumni.dtos.response.FacultyResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/faculties")
@AllArgsConstructor
@CrossOrigin(origins="*")
public class FacultyController {
    private final FacultyService service;

    @GetMapping
    public List<FacultyResponseDTO> getList(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(required = false,defaultValue = "") String  name
            ){
        return service.getList(page,size);
    }


    @PostMapping
    public void createOne(@RequestBody FacultyRequestDto requestDto){
         service.create(requestDto);
    }

    @GetMapping("/{id}")
    public FacultyResponseDTO findById(@PathVariable(name = "id") Long id){
        return service.findById(id);
    }


    @PostMapping("/{id}/change-password")
    public void changePassword(@PathVariable(name = "id") Long id,@RequestBody String password){
         service.changePassword(id,password);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
         service.deleteById(id);
    }


    @PutMapping("/{id}")
    public void update(@PathVariable(name = "id") Long id,
                       @RequestBody FacultyRequestDto requestDto){
        service.put(id,requestDto);
    }



}
