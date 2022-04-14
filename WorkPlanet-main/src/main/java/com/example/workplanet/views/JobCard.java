package com.example.workplanet.views;

import com.example.workplanet.services.JobService;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import java.util.List;
import java.util.Map;


@Route(value = "/", layout = AppView.class)
@AnonymousAllowed
public class JobCard extends VerticalLayout {

    JobService jobService;

    public JobCard(JobService jobService) {
        this.jobService = jobService;

        setAlignItems(Alignment.CENTER);


        jobService.findAll().forEach(jobPost -> {

            RouterLink category = new RouterLink(jobPost.getJobbCategory(), JobView.class);

            category.setQueryParameters(new QueryParameters(Map.of("jobId", List.of(String.valueOf(jobPost.getId())))));
            category.getStyle().set("font-seize", "34");
            category.getStyle().set("font-weight", "bold");
            Span title = new Span(jobPost.getTitle());

            Paragraph location = new Paragraph(jobPost.getLocation());
            Paragraph postedBy = new Paragraph("Posted By: ");
            Span author = new Span(jobPost.getAppUser().getUsername());
            author.getStyle().set("font-weight", "bold");
            category.getStyle().set("font-weight", "bold");
            postedBy.add(author);

            add(category, title, location, postedBy, new Hr());

        });
    }
}
