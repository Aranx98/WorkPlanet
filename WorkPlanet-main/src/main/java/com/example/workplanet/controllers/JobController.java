package com.example.workplanet.controllers;

import com.example.workplanet.entities.JobPost;
import com.example.workplanet.services.JobService;
import org.atmosphere.config.service.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/job")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping
    public String getJobPostList(
            @RequestParam(required = false) String username,
            Model model
    ) {
        List<JobPost> jobPostList = jobService.findAll();
        model.addAttribute("jobPostList", jobPostList);
        return "job";
    }

    @GetMapping("/{id}")
    public JobPost getJobPostById(@PathVariable("id") int id){
        JobPost jobPost = jobService.findJobById(id);
        return jobPost;
    }

    @GetMapping("/addjob")
    public String addJobForm() {
        return "addjobform";
    }






}
