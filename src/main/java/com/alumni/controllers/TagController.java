package com.alumni.controllers;


import com.alumni.Service.JobAdvertisementService;
import com.alumni.Service.TagService;
import com.alumni.dtos.request.JobAdvertisementRequestDto;
import com.alumni.dtos.request.TagRequestDTO;
import com.alumni.dtos.response.JobAdvertisementResponseDto;
import com.alumni.dtos.response.TagResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
@AllArgsConstructor
public class TagController {
    private final TagService service;


    @GetMapping
    public List<TagResponseDTO> getList(
            @RequestParam int page,
            @RequestParam int size
            ){
        return service.getList(page,size);

    }


    @PostMapping
    public void createOne(
            @RequestBody TagRequestDTO requestDto){
        service.create(requestDto);
    }

    @GetMapping("/{id}")
    public TagResponseDTO findById(@PathVariable(name = "id") Long id){
        return service.findById(id);
    }



    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
         service.deleteById(id);
    }


    @PutMapping("/{id}")
    public void update(@PathVariable(name = "id") Long id,
                       @RequestBody TagRequestDTO requestDto){
        service.put(id,requestDto);
    }



}
