package com.example.workplanet;

import com.example.workplanet.entities.AppUser;
import com.example.workplanet.entities.JobPost;
import com.example.workplanet.repositories.AppUserRepository;
import com.example.workplanet.repositories.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class WorkPlanetApplication implements CommandLineRunner {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    JobPostRepository jobPostRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(WorkPlanetApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        AppUser MustiG = new AppUser("MustiG", passwordEncoder.encode("pass"));
        AppUser TimG = new AppUser("TimG", passwordEncoder.encode("pass"));
        System.out.println("Krypterat lösenord med Bcrypt:" + MustiG.getPassword());
        appUserRepository.saveAll(List.of(MustiG, TimG));

        JobPost jobPost = new JobPost(
                "Programmera",
                "Java utvecklare",
                "Hörby",
                "Tim Andersson",
                "Tim is a director of brand marketing, with experience managing global teams and multi-million-dollar campaigns. Her background in brand strategy, visual design, and account management inform her mindful but competitive approach.",
                "Java, Javascript, Sql, React",
                TimG
                );

        JobPost jobPost1 = new JobPost(
                "Lagerarbetare",
                "Truckförare",
                "Hörby",
                "Mustafa Polat",
                "Mustafa is a director of brand marketing, with experience managing global teams and multi-million-dollar campaigns. Her background in brand strategy, visual design, and account management inform her mindful but competitive approach.",
                "Small truck, Medium truck, Big truck",
                MustiG
        );

        jobPostRepository.saveAll(List.of(jobPost,jobPost1));

    }




}
