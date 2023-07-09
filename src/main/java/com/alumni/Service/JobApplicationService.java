package com.alumni.Service;
import com.alumni.entity.JobApplication;

import java.util.List;

public interface JobApplicationService  {
    List<JobApplication> getList(int page, int size, Long jobId, Long studentId);

    void create(JobApplication record);

    JobApplication findById(Long id);

    void put(Long id, JobApplication record);

    void deleteById(Long id);

}
