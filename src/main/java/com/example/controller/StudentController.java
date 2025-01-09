package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.CrewApplication;
import com.example.service.ApplicationService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/viewTVPSSContent")
    public String viewTVPSSContentPage() {
        return "viewTVPSSContent";
    }
	
	@RequestMapping("/applycrew")
    public String applyCrewPage() {
        return "crew_application";
    }
	
	@RequestMapping(value = "/submitCrewApplication", method = RequestMethod.POST)
	public String submitCrewApplication(
	        @RequestParam("fullName") String fullName,
	        @RequestParam("icNo") String icNo,
	        @RequestParam("email") String email,
	        @RequestParam("school") String school) {
	    
	    // Create a new CrewApplication object and save it using the applicationService
	    CrewApplication application = new CrewApplication(fullName, icNo, email, school);
	    applicationService.saveApplication(application); // Ensure you have a saveApplication method in the service
	    
	    // Redirect to the application status page or another page
	    return "redirect:/student/application_status"; // Change this to your desired return page
	}
	
	@Autowired
    private ApplicationService applicationService; // Ensure you have this service

    @PostMapping("/checkApplicationStatus")
    public String checkApplicationStatus(
            @RequestParam("icNo") String icNo,
            @RequestParam("email") String email,
            Model model) {
        
        // Logic to check application status based on the provided IC number and email
        String statusMessage = applicationService.getApplicationStatus(icNo, email);
        
        // Add the status message to the model
        model.addAttribute("statusMessage", statusMessage);
        
        // Return to the application status JSP page
        return "application_status";
    }
}
