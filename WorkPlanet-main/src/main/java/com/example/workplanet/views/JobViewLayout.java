package com.example.workplanet.views;


import com.example.workplanet.entities.JobPost;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class JobViewLayout extends VerticalLayout {

    public JobViewLayout(JobPost jobPost) {

            H2 category = new H2(jobPost.getJobbCategory());
            Span title = new Span(jobPost.getTitle());
            Paragraph location = new Paragraph(jobPost.getLocation());

            H4 fullNameH4 = new H4("Full Name:");
            Paragraph fullName = new Paragraph(jobPost.getFullName());

            H4 aboutMeH4 = new H4("About Me:");
            Paragraph aboutMe = new Paragraph(jobPost.getAboutMe());

            H4  experiencesH4 = new H4("Experiences:");
            Paragraph experiences = new Paragraph(jobPost.getExperiences());

            add(category, title, location, new Hr(),fullNameH4, fullName, new Hr(), aboutMeH4, aboutMe, new Hr(), experiencesH4, experiences);

    }

}
