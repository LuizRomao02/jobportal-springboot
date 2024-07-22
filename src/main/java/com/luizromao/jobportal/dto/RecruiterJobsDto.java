package com.luizromao.jobportal.dto;

import com.luizromao.jobportal.entity.JobCompany;
import com.luizromao.jobportal.entity.JobLocation;

public class RecruiterJobsDto {

    private Long totalCandidates;
    private Integer jobPostId;
    private String jobTitle;
    private JobLocation jobLocationId;
    private JobCompany jobCompanyId;

    public RecruiterJobsDto(Long totalCandidates, Integer jobPostId, String jobTitle, JobLocation jobLocationId, JobCompany jobCompanyId) {
        this.totalCandidates = totalCandidates;
        this.jobPostId = jobPostId;
        this.jobTitle = jobTitle;
        this.jobLocationId = jobLocationId;
        this.jobCompanyId = jobCompanyId;
    }

    public Long getTotalCandidates() {
        return totalCandidates;
    }

    public Integer getJobPostId() {
        return jobPostId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public JobLocation getJobLocationId() {
        return jobLocationId;
    }

    public JobCompany getJobCompanyId() {
        return jobCompanyId;
    }

}
