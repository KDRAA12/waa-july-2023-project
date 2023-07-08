package com.alumni.repository;

import com.alumni.entity.JobAdvertisement;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement,Long> {


    List<JobAdvertisement> findAllByTagsInAndStateContainsIgnoreCaseAndCityContainsIgnoreCaseOrderByPostedAtDesc(List<Long> tags, String state, String city, PageRequest of);

    List<JobAdvertisement> findAllByStateContainsIgnoreCaseAndCityContainsIgnoreCaseOrderByPostedAtDesc(String state, String city, PageRequest of);
}
