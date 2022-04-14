package com.example.workplanet.views;

import com.example.workplanet.entities.JobPost;
import com.example.workplanet.security.PrincipalUtils;
import com.example.workplanet.services.JobService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;

@Route(value = "/manageposts", layout = AppView.class)
@PermitAll
public class ManageJobsView extends VerticalLayout {
    JobService jobService;
    Grid<JobPost> grid = new Grid<>(JobPost.class, false);
    JobForm jobForm;
    PrincipalUtils principalUtils;

    public ManageJobsView(JobService jobService, PrincipalUtils principalUtils) {
        this.principalUtils = principalUtils;
        this.jobService = jobService;

        jobForm = new JobForm(jobService, this);
        setAlignItems(Alignment.CENTER);
        add(new H1("Manage your job"));

        grid.setItems(jobService.findPostByAppUserUsername(PrincipalUtils.getName()));

        grid.addComponentColumn(blogPost -> {

            Button deleteButton = new Button(new Icon(VaadinIcon.TRASH), evt -> {
                jobService.deleteById(blogPost.getId());
                updateItems();
            });

            deleteButton.addThemeVariants(
                    ButtonVariant.LUMO_PRIMARY,
                    ButtonVariant.LUMO_SMALL,
                    ButtonVariant.LUMO_ERROR
            );

            return deleteButton;
        });

        grid.addColumn(JobPost::getId).setHeader("Id").setSortable(true);
        grid.addColumn(JobPost::getJobbCategory).setHeader("Category").setSortable(true);
        grid.addColumn(JobPost::getTitle).setHeader("Jobtitle").setSortable(true);
        grid.addColumn(JobPost::getLocation).setHeader("Location").setSortable(true);
        grid.addColumn(JobPost::getFullName).setHeader("FullName").setSortable(true);
        grid.addColumn(JobPost::getAboutMe).setHeader("AboutMe").setSortable(true);
        grid.addColumn(JobPost::getExperiences).setHeader("Experiences").setSortable(true);

        grid.asSingleSelect().addValueChangeListener(evt -> {
            jobForm.setJobPost(evt.getValue());
        });

        HorizontalLayout main = new HorizontalLayout(grid, jobForm);
        main.setSizeFull();

        add(main);

        Button button = new Button("Add new jobpost", evt -> {
            Dialog dialog = new Dialog();
            JobForm jobForm = new JobForm(jobService, this);

            JobPost jobPost = new JobPost();
            jobPost.setAppUser(principalUtils.getAppUserFromFromPrincipal());
            jobForm.setJobPost(jobPost);

            dialog.add(jobForm);
            dialog.open();
        });

        add(button);
    }

    public void updateItems() {
        grid.setItems(jobService.findPostByAppUserUsername(PrincipalUtils.getName()));
    }

}
