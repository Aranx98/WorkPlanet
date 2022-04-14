package com.example.workplanet.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Genererar automatiskt ett id 1,2,3...
    private int id;

    @Column(nullable = false)
    @NotBlank
    private String jobbCategory;

    @Column(nullable = false)
    @NotBlank
    private String title;

    @Column(nullable = false)
    @NotBlank
    private String location;

    @NotBlank
    @Column(nullable = false)
    private String fullName;

    @NotBlank
    @Column(nullable = false)
    private String aboutMe;

    @NotBlank
    @Column(nullable = false)
    private String experiences;


    @ManyToOne //Flera JobPoster kan skapas av en User
    @JoinColumn(name = "appuser_id")
    private AppUser appUser;


    public JobPost(String jobbCategory, String title, String location, String fullName, String aboutMe, String experiences, AppUser appUser) {
        this.jobbCategory = jobbCategory;
        this.title = title;
        this.location = location;
        this.fullName = fullName;
        this.aboutMe = aboutMe;
        this.experiences = experiences;
        this.appUser = appUser;
    }

    public JobPost() {

    }

    public String getFullName() {
        return fullName;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public String getExperiences() {
        return experiences;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public void setExperiences(String experiences) {
        this.experiences = experiences;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getJobbCategory() {
        return jobbCategory;
    }

    public void setJobbCategory(String jobbCategory) {
        this.jobbCategory = jobbCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}

