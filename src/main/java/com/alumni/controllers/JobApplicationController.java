package com.alumni.controllers;

import com.alumni.Service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("/job-applications")
@CrossOrigin
public class JobApplicationController {

    @Autowired
    private JobApplicationService service;

    public ResponseEntity<?> getAlljobApplications(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(required = false, defaultValue = "") Long StudentId,
            @RequestParam(required = false, defaultValue = "") Long JobId) {

        return ResponseEntity.ok(service.getList(page, size, StudentId, JobId));

    }


}
