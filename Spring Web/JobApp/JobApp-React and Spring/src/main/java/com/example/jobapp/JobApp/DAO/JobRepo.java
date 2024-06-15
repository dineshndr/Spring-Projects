package com.example.jobapp.JobApp.DAO;

import com.example.jobapp.JobApp.Model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer>{

List<JobPost> findByJobNameContainingOrJobDescContaining(String name, String Desc);

}
//    JobPost jobpost;
//
//    List<JobPost> jobs= new ArrayList<>(Arrays.asList(
//            new JobPost("Software Engineer", 1,"Engineer"),
//            new JobPost("Devops Engineer", 2, "Engineer")
//            ));
//    public List<JobPost> getAllJobs()
//    {
//        return jobs;
//    }
//
//    public JobPost  getJob(int id) {
//        for(JobPost job: jobs) {
//            System.out.println(job.getJobId());
//            if (job.getJobId() == id) return job;
//        }
//        return null;
//    }
//
//    public JobPost addJob(JobPost jobpost) {
//        jobs.add(jobpost);
//        return jobpost;
//    }
//
//    public JobPost updateJob(JobPost jobpost) {
//        for(JobPost job : jobs)
//        {
//            if(jobpost.getJobId()==job.getJobId())
//            {
//                job.setJobId(jobpost.getJobId());
//                job.setJobName(jobpost.getJobName());
//                job.setJobDesc(jobpost.getJobDesc());
//            }
//        }
//        return jobpost;
//    }
//
//    public String deleteJob(int id)
//    {
//        for(JobPost job: jobs)
//        {
//            if(job.getJobId()==id-1)
//            {
//                jobs.remove(id-1);
//            }
//        }
//        return "Done";
//    }

