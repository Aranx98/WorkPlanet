package com.example.workplanet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true) // Vi använder Unique för att user namnet ska var unikt.
    private String username;

    @Column
    private String password;

    @OneToMany(mappedBy = "appUser")  //En användare kan ha flera JobPoster
    @JsonIgnore
    private Set<JobPost> jobPosts;


    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AppUser() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<JobPost> getJobPosts() {
        return jobPosts;
    }

    public void setJobPosts(Set<JobPost> jobPosts) {
        this.jobPosts = jobPosts;
    }
}
