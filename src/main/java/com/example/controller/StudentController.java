package com.example.controller;

import com.example.entity.CrewApplication;
import com.example.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@PostMapping("/submitCrewApplication")
	public String submitCrewApplication(
	        @RequestParam("fullName") String fullName,
	        @RequestParam("icNo") String icNo,
	        @RequestParam("email") String email,
	        @RequestParam("school") String school,
	        org.springframework.ui.Model model) {

	    CrewApplication application = new CrewApplication();
	    application.setFullName(fullName);
	    application.setIcNo(icNo);
	    application.setEmail(email);
	    application.setSchool(school);

	    // Add details to the model for the result page
	    model.addAttribute("application", application);
	    return "application_result"; // Navigate to result page
	}
}
