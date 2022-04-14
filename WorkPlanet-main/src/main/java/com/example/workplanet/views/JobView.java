package com.example.workplanet.views;

import com.example.workplanet.entities.JobPost;
import com.example.workplanet.repositories.JobPostRepository;
import com.example.workplanet.security.PrincipalUtils;
import com.example.workplanet.services.JobService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

import java.util.List;
import java.util.Map;

@Route(value = "/job", layout = AppView.class)
@AnonymousAllowed
public class JobView extends VerticalLayout implements BeforeEnterObserver {

    @Autowired
    JobPostRepository jobPostRepository;

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {

        Map<String, List<String>> map = beforeEnterEvent.getLocation().getQueryParameters().getParameters();
        if (map.containsKey("jobId")) {
            map.get("jobId").forEach(id -> {
                JobPost jobPost = jobPostRepository.findJobPostsById(Integer.valueOf(id)).orElseThrow();

                JobViewLayout test = new JobViewLayout(jobPost);
                add(test);

            });
        }


    }
}

