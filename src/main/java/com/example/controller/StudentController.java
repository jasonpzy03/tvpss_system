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

     // Indicate successful application submission
        model.addAttribute("applicationSuccess", true);
        return "crew_application"; // Return to the same page
    }
    
    @RequestMapping("/checkStatus")
    public String checkStatusPage() {
        return "check_status"; // Return the check status page
    }

    @PostMapping("/checkCrewStatus")
    public String checkCrewStatus(
            @RequestParam("icNo") String icNo,
            @RequestParam("email") String email,
            Model model) {

        CrewApplication application = crewApplicationService.findApplicationByIcNoAndEmail(icNo, email);

        if (application != null) {
            model.addAttribute("application", application); // Add application details to the model
            model.addAttribute("successMessage", "CONGRATULATIONS! YOUR APPLICATION HAS BEEN ACCEPTED!"); // Add success message
        } else {
            model.addAttribute("error", "Application not found.");
        }

        return "status_result"; // Return to the same page with results
    }

}
	