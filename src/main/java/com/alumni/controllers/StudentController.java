package com.alumni.controllers;


import com.alumni.Service.StudentService;
import com.alumni.dtos.response.StudentResponseDTO;
import com.alumni.dtos.request.StudentRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService service;


    @GetMapping
    public List<StudentResponseDTO> getList(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(required = false,defaultValue = "") String state,
            @RequestParam(required = false,defaultValue = "") String  city,
            @RequestParam(required = false,defaultValue = "") String  major,
            @RequestParam(required = false,defaultValue = "") String  name
            ){
        return service.getList(page,size,state, city, major, name);

    }


    @PostMapping
    public void createOne(@RequestBody StudentRequestDto requestDto){
         service.create(requestDto);
    }

    @GetMapping("/{id}")
    public StudentResponseDTO findById(@PathVariable(name = "id") Long id){
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
                       @RequestBody StudentRequestDto requestDto){
        service.put(id,requestDto);
    }



}
