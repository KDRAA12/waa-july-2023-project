package com.alumni.controllers;


import com.alumni.Service.AttachmentService;
import com.alumni.dtos.response.AttachmentDTO;
import com.alumni.dtos.response.AttachmentUploadResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController()
@RequestMapping("/api/v1/attachments")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class uploadsController {

    @Autowired
    private AttachmentService attachmentService;

    @GetMapping("/{name}")
    public ResponseEntity<?> getAttachment(@PathVariable String name){
        try {
            AttachmentDTO data = attachmentService.getAttachment(name);
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(data.type)).body(data.data);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @PostMapping()
    public ResponseEntity<?> postAttachment(@RequestParam("image")MultipartFile file){
        try {
             AttachmentUploadResponseDTO uploadImage = attachmentService.uploadAttachment(file);
            return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
