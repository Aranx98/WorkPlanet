package com.example.workplanet.services;

import com.example.workplanet.entities.JobPost;
import com.example.workplanet.repositories.JobPostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    //@Autowired
    JobPostRepository jobPostRepository;

    public JobService(JobPostRepository jobPostRepository) {
        this.jobPostRepository = jobPostRepository;

    }

    public List<JobPost> findAll() { //GET
        return jobPostRepository.findAll();

    }

    public JobPost findJobById(int id) { //GET/ID
        return jobPostRepository.findById(id).orElseThrow();

    }

    public void deleteById(int id) { //DELETE
        jobPostRepository.deleteById(id);

    }

    public JobPost createJob(JobPost jobPost) { // POST
        return jobPostRepository.save(jobPost);

    }

    public JobPost updateJobById(int id, JobPost changedJobPost){ // PUT

        JobPost jobPost = jobPostRepository.findById(id).orElseThrow();

        if (changedJobPost.getJobbCategory() !=null)
            jobPost.setJobbCategory(changedJobPost.getJobbCategory());

        if (changedJobPost.getTitle() !=null)
            jobPost.setTitle(changedJobPost.getTitle());

        if (changedJobPost.getLocation() !=null)
            jobPost.setLocation(changedJobPost.getLocation());

        if (changedJobPost.getFullName() !=null)
            jobPost.setLocation(changedJobPost.getFullName());

        if (changedJobPost.getAboutMe() !=null)
            jobPost.setLocation(changedJobPost.getAboutMe());

        if (changedJobPost.getExperiences() !=null)
            jobPost.setLocation(changedJobPost.getExperiences());

        return jobPostRepository.save(jobPost);

    }

    public List<JobPost> findPostByAppUserUsername(String name){ //GET=?Username
        return jobPostRepository.findByAppUser_Username(name);
    }

}
