package com.example.workplanet.security;

import com.example.workplanet.entities.AppUser;
import com.example.workplanet.repositories.AppUserRepository;
import com.example.workplanet.views.JobCard;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class PrincipalUtils {

    @Autowired
    AppUserRepository appUserRepository;

    public AppUser getAppUserFromFromPrincipal() {
        return appUserRepository.findAppUserByUsername(getName()).orElseThrow();
    }

    public static String getName(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public static boolean isAuthenticated() {
            return !SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getName()
                    .equalsIgnoreCase("anonymousUser");
        }

        public static void logout() {
            UI.getCurrent().navigate(JobCard.class);
            new SecurityContextLogoutHandler().logout(VaadinServletRequest.getCurrent().getHttpServletRequest(), null, null);
        }

    }


