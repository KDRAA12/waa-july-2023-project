package com.alumni.controllers;

import com.alumni.Service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("/job-applications")
public class JobApplicationController {

    @Autowired
    private JobApplicationService service;

    public EntityResponse<?> getAlljobApplications(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(required = false, defaultValue = "") Long StudentId,
            @RequestParam(required = false, defaultValue = "") Long JobId) {

        return service.getList(page, size, StudentId, JobId);

    }


}
