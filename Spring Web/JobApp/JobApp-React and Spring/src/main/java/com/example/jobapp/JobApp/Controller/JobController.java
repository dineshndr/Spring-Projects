package com.example.jobapp.JobApp.Controller;

import com.example.jobapp.JobApp.Model.JobPost;
import com.example.jobapp.JobApp.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins="http://localhost:3000")
public class JobController {
    @Autowired
    private JobService service;

    @GetMapping("jobPosts")

    public List<JobPost> getAllJobs()
    {
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int id)
    {
        return service.getJob(id);
    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobpost)
    {
        service.addJob(jobpost);
        return service.getJob(jobpost.getJobId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobpost)
    {
        service.updateJob(jobpost);
        return service.getJob(jobpost.getJobId());
    }

    @DeleteMapping("jobPost/{postId}")
    public void deleteJob(@PathVariable("postId") int id)
    {
        service.deleteJob(id);
    }
    @GetMapping("/")
    public String loadData()
    {
        service.load();
        return "Done";
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> findByJobNameContainingOrJobDescContaining(@PathVariable("keyword") String name)
    {
        return service.findByJobNameContainingOrJobDescContaining(name);
    }

}
