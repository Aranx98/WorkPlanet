package com.example.workplanet.views;

import com.example.workplanet.security.PrincipalUtils;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class AppView extends AppLayout {

    public AppView() {
        HorizontalLayout navbarLayout = new HorizontalLayout();
        H1 navbarTitle = new H1("WorkPlanet");
        navbarLayout.add(new DrawerToggle(), navbarTitle);

        Button loginButton = new Button("Login", e -> UI.getCurrent().navigate(LoginView.class));
        loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        Button logoutButton = new Button("Logout", evt -> PrincipalUtils.logout());
        logoutButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        navbarLayout.add(PrincipalUtils.isAuthenticated() ? logoutButton : loginButton);

        if(PrincipalUtils.isAuthenticated())
            Notification.show(PrincipalUtils.getName());

        navbarLayout.setWidthFull();
        navbarLayout.setMargin(true);
        navbarLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        navbarLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        addToNavbar(navbarLayout);

        RouterLink jobViewLink = new RouterLink("View JobPosts", JobCard.class);
        RouterLink managePostLink = new RouterLink("Manage your job", ManageJobsView.class);

        addToDrawer(new VerticalLayout(jobViewLink, managePostLink));

    }


}

