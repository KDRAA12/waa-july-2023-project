package com.alumni.controllers;

import com.alumni.dtos.response.StatisticsResponseDTO;
import com.alumni.repository.JobAdvertisementRepository;
import com.alumni.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/statistics")
@AllArgsConstructor
public class StatisticsController {
private JobAdvertisementRepository jobAdvertisementRepository;
private StudentRepository   studentRepository;

    @GetMapping("/tags-count")
    public ResponseEntity<List<StatisticsResponseDTO>> getStatistics() {
        List<Object[]> tagscount = jobAdvertisementRepository.findJobAdvertisementCountPerTag();
        ArrayList<StatisticsResponseDTO> responseTagsCount = new ArrayList<>();

        for(Object[] tagCount: tagscount){
            responseTagsCount.add(StatisticsResponseDTO.builder()
                    .name(String.valueOf(tagCount[1]))
                    .value(Integer.valueOf(tagCount[0].toString()))
                    .build()
            );
        }
        return ResponseEntity.ok(responseTagsCount);
    }


    @GetMapping("/job-per-state")
    public ResponseEntity<List<StatisticsResponseDTO>> getJobsPerStateStats() {
        List<Object[]> tagscount = jobAdvertisementRepository.findJobAdvertisementCountPerState();
        ArrayList<StatisticsResponseDTO> responseTagsCount = new ArrayList<>();

        for(Object[] tagCount: tagscount){
            responseTagsCount.add(StatisticsResponseDTO.builder()
                    .name(String.valueOf(tagCount[1]))
                    .value(Integer.valueOf(tagCount[0].toString()))
                    .build()
            );
        }
        return ResponseEntity.ok(responseTagsCount);
    }

    @GetMapping("/job-per-city")
    public ResponseEntity<List<StatisticsResponseDTO>> getJobsPerCityStats() {
        List<Object[]> tagscount = jobAdvertisementRepository.findJobAdvertisementCountPerCity();
        ArrayList<StatisticsResponseDTO> responseTagsCount = new ArrayList<>();

        for(Object[] tagCount: tagscount){
            responseTagsCount.add(StatisticsResponseDTO.builder()
                    .name(String.valueOf(tagCount[1]))
                    .value(Integer.valueOf(tagCount[0].toString()))
                    .build()
            );
        }
        return ResponseEntity.ok(responseTagsCount);
    }

    @GetMapping("/job-per-company")
    public ResponseEntity<List<StatisticsResponseDTO>> getJobsPerCompanyStats() {
        List<Object[]> tagscount = jobAdvertisementRepository.findJobAdvertisementCountPerCompany();
        ArrayList<StatisticsResponseDTO> responseTagsCount = new ArrayList<>();

        for(Object[] tagCount: tagscount){
            responseTagsCount.add(StatisticsResponseDTO.builder()
                    .name(String.valueOf(tagCount[1]))
                    .value(Integer.valueOf(tagCount[0].toString()))
                    .build()
            );
        }
        return ResponseEntity.ok(responseTagsCount);
    }

    @GetMapping("/student-per-state")
    public ResponseEntity<List<StatisticsResponseDTO>> getStudentPerStateStats() {
        List<Object[]> tagscount = studentRepository.getStudentCountPerState();
        ArrayList<StatisticsResponseDTO> responseTagsCount = new ArrayList<>();

        for(Object[] tagCount: tagscount){
            responseTagsCount.add(StatisticsResponseDTO.builder()
                    .name(String.valueOf(tagCount[1]))
                    .value(Integer.valueOf(tagCount[0].toString()))
                    .build()
            );
        }
        return ResponseEntity.ok(responseTagsCount);
    }

    @GetMapping("/student-per-city")
    public ResponseEntity<List<StatisticsResponseDTO>> getStudentPerCityStats() {
        List<Object[]> tagscount = studentRepository.getStudentCountPerCity();
        ArrayList<StatisticsResponseDTO> responseTagsCount = new ArrayList<>();

        for(Object[] tagCount: tagscount){
            responseTagsCount.add(StatisticsResponseDTO.builder()
                    .name(String.valueOf(tagCount[1]))
                    .value(Integer.valueOf(tagCount[0].toString()))
                    .build()
            );
        }
        return ResponseEntity.ok(responseTagsCount);
    }

}

