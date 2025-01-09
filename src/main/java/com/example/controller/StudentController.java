package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.CrewApplication;
import com.example.entity.School;
import com.example.service.ApplicationService;
import com.example.service.SchoolService;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping("/viewTVPSSContent")
    public String viewTVPSSContentPage(Model model) {
        model.addAttribute("schools", schoolService.getAllSchools());
        return "viewTVPSSContent";
    }
    
    @RequestMapping("/viewSchoolContent")
    public String viewSchoolContent(@RequestParam("id") String schoolId, Model model) {
        // Fetch school by ID or mock the data
        School school = schoolService.getAllSchools()
                                      .stream()
                                      .filter(s -> s.getId().equals(schoolId))
                                      .findFirst()
                                      .orElse(null);

        model.addAttribute("school", school);
        return "school_content"; // A new JSP page to display school details
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
        
        CrewApplication application = new CrewApplication(fullName, icNo, email, school);
        applicationService.saveApplication(application);
        return "redirect:/student/application_status";
    }

    @PostMapping("/checkApplicationStatus")
    public String checkApplicationStatus(
            @RequestParam("icNo") String icNo,
            @RequestParam("email") String email,
            Model model) {
        
        String statusMessage = applicationService.getApplicationStatus(icNo, email);
        model.addAttribute("statusMessage", statusMessage);
        return "application_status";
    }
}
