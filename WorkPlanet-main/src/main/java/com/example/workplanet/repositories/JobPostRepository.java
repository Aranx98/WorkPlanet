package com.example.workplanet.repositories;

import com.example.workplanet.entities.JobPost;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, Integer> {

    List<JobPost> findByAppUser_Username(String username);

    Optional<JobPost> findJobPostsById(int id);

}
