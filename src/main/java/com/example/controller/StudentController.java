package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/student")
public class StudentController {

   

    @RequestMapping("/viewTVPSSContent")
    public String viewTVPSSContentPage() {
        return "viewTVPSSContent";
    }
    
    @RequestMapping("/viewSchoolContent")
    public String viewSchoolContent() {
     
        return "school_content"; // A new JSP page to display school details
    }


    @RequestMapping("/applycrew")
    public String applyCrewPage() {
        return "crew_application";
    }

    @RequestMapping(value = "/submitCrewApplication", method = RequestMethod.POST)
    public String submitCrewApplication() {
  
        return "redirect:/student/application_status";
    }

   
}
