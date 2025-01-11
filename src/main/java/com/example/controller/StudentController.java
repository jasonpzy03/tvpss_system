package com.example.controller;

import com.example.entity.CrewApplication;
import com.example.entity.School;
import com.example.service.CrewApplicationService;
import com.example.service.SchoolService;

import java.util.List;

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

    @Autowired
    private SchoolService schoolService; // Inject the school service

    @RequestMapping("/viewTVPSSContent")
    public String viewTVPSSContentPage(Model model) {
        List<School> schools = schoolService.getAllSchools();
        model.addAttribute("schools", schools); // Add schools to the model
        return "viewTVPSSContent"; // Return the view page
    }
    
    @RequestMapping("/viewSchoolContent")
    public String viewSchoolContent(@RequestParam("id") Long schoolId, Model model) {
        School school = schoolService.findSchoolById(schoolId);
        if (school != null) {
            model.addAttribute("school", school);
            model.addAttribute("videoUrl", school.getVideoUrl()); // Pass the video URL to the view
        } else {
            model.addAttribute("error", "School not found.");
        }
        return "viewSchoolContent"; // Return the view page
    }

 // New method to show video list
    @RequestMapping("/viewSchoolVideos")
    public String viewSchoolVideos(@RequestParam("id") Long schoolId, Model model) {
        School school = schoolService.findSchoolById(schoolId);
        if (school != null) {
            model.addAttribute("school", school);
            model.addAttribute("videoUrl", school.getVideoUrl()); // Pass the video URL to the view
        } else {
            model.addAttribute("error", "School not found.");
        }
        return "viewSchoolVideos"; // Return a new view page for videos
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
        return "application_successful"; // Return to the same page
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

            // Check the status of the application
            if (application.getStatus() == null) {
                model.addAttribute("error", "Your application has not been accepted by the teacher.");
            } else {
                model.addAttribute("successMessage", "CONGRATULATIONS! YOUR APPLICATION HAS BEEN ACCEPTED!");
            }
        } else {
            model.addAttribute("error", "Application not found.");
        }

        return "status_result"; // Return to the same page with results
    }

}
	