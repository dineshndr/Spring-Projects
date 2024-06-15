package com.example.jobapp.JobApp.Service;

import com.example.jobapp.JobApp.DAO.JobRepo;
import com.example.jobapp.JobApp.Model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {
    @Autowired
    JobRepo jobrepo;


    public List<JobPost> getAllJobs()
    {
        return jobrepo.findAll();
    }

    public JobPost getJob(int id) {
       return  jobrepo.findById(id).orElse(null);
    }

    public JobPost addJob(JobPost jobpost) {
        return jobrepo.save(jobpost);
    }

    public JobPost updateJob(JobPost jobpost) {
        return jobrepo.save(jobpost);

    }

    public void deleteJob(int id)
    {
        jobrepo.deleteById(id);
    }
    public void load()
    {
        List<JobPost> jobs= new ArrayList<>(List.of(
                new JobPost("Software Engineer", 1,"Engineer"),
                new JobPost("Devops Engineer", 2, "Engineer")
        ));
        jobrepo.saveAll(jobs);
    }


    public List<JobPost> findByJobNameContainingOrJobDescContaining(String name) {
        return jobrepo.findByJobNameContainingOrJobDescContaining(name,name);
    }
}
