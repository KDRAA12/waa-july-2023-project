package com.alumni.repository;

import com.alumni.entity.JobApplication;
import com.alumni.entity.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    @Query(value = "select * from job_application INNER JOIN student ON student.id = 'job_application'.student_id INNER JOIN job_advertisement.id = 'job_application'.job_id ", nativeQuery = true)
    List<Student> getList(@Param("state") String state, @Param("city") String city, @Param("major") String major, @Param("name") String name, Pageable pageable);
}
