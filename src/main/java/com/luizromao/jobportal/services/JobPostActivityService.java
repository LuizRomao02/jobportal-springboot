package com.luizromao.jobportal.services;

import com.luizromao.jobportal.dto.RecruiterJobsDto;
import com.luizromao.jobportal.entity.IRecruiterJobs;
import com.luizromao.jobportal.entity.JobCompany;
import com.luizromao.jobportal.entity.JobLocation;
import com.luizromao.jobportal.entity.JobPostActivity;
import com.luizromao.jobportal.repository.JobPostActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobPostActivityService {

    private final JobPostActivityRepository jobPostActivityRepository;

    @Autowired
    public JobPostActivityService(JobPostActivityRepository jobPostActivityRepository) {
        this.jobPostActivityRepository = jobPostActivityRepository;
    }

    public JobPostActivity addNew(JobPostActivity jobPostActivity) {
        return jobPostActivityRepository.save(jobPostActivity);
    }

    public List<RecruiterJobsDto> getRecruiterJobs(int recruiterId){
        List<IRecruiterJobs> recruiterJobsDto = jobPostActivityRepository.getRecruiterJobs(recruiterId);

        List<RecruiterJobsDto> recruiterJobsDtoList = new ArrayList<>();

        for(IRecruiterJobs recruiterJob : recruiterJobsDto){
            JobLocation loc = new JobLocation(recruiterJob.getLocationId(), recruiterJob.getCity(), recruiterJob.getState(), recruiterJob.getCountry());
            JobCompany comp = new JobCompany(recruiterJob.getCompanyId(), recruiterJob.getName(), "");
            recruiterJobsDtoList.add(new RecruiterJobsDto(recruiterJob.getTotalCandidates(), recruiterJob.getJob_post_id(), recruiterJob.getJob_title(), loc, comp));
        }

        return recruiterJobsDtoList;
    }

    public JobPostActivity getOne(int id) {
        return jobPostActivityRepository.findById(id).orElseThrow(() -> new RuntimeException("Job not found"));
    }
}
