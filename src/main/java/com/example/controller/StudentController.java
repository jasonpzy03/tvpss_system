package com.example.controller;

import com.example.entity.CrewApplication;
import com.example.service.CrewApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private CrewApplicationService crewApplicationService; // Inject the service

    @RequestMapping("/viewTVPSSContent")
    public String viewTVPSSContentPage() {
        return "viewTVPSSContent";
    }

    @RequestMapping("/applycrew")
    public String applyCrewPage() {
        return "crew_application";
    }

    @PostMapping("/submitCrewApplication")
    public String submitCrewApplication(
            @RequestParam("fullName") String fullName,
            @RequestParam("icNo") String icNo,
            @RequestParam("email") String email,
            @RequestParam("school") String school,
            Model model) {

        CrewApplication application = new CrewApplication();
        application.setFullName(fullName);
        application.setIcNo(icNo);
        application.setEmail(email);
        application.setSchool(school);

        // Use the service to save the application
        crewApplicationService.submitApplication(application);

        // Add details to the model for the result page
        model.addAttribute("application", application);
        return "application_result"; // Navigate to result page
    }
}
	