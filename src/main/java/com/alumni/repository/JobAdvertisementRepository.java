package com.alumni.repository;

import com.alumni.entity.JobAdvertisement;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement,Long> {


    List<JobAdvertisement> findAllByTagsInAndStateContainsIgnoreCaseAndCityContainsIgnoreCaseOrderByPostedAtDesc(List<Long> tags, String state, String city, PageRequest of);

    List<JobAdvertisement> findAllByStateContainsIgnoreCaseAndCityContainsIgnoreCaseOrderByPostedAtDesc(String state, String city, PageRequest of);

    @Query(value = "select count(job_advertisement_id), tag.value from  job_advertisement_tags \n" +
            "inner join tag on tag.id =job_advertisement_tags.tags_id group by tags_id, tag.value;", nativeQuery = true)
    List<Object[]> findJobAdvertisementCountPerTag();

    @Query(value = "select count(id), city from job_advertisement group by city;", nativeQuery = true)
    List<Object[]> findJobAdvertisementCountPerCity();

    @Query(value = "select count(id), state from job_advertisement group by state;", nativeQuery = true)
    List<Object[]> findJobAdvertisementCountPerState();

    @Query(value = "select count(id), company from job_advertisement group by company;", nativeQuery = true)
    List<Object[]> findJobAdvertisementCountPerCompany();

}
