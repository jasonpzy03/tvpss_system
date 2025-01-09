package com.example.controller;

import com.example.entity.School; // Ensure you have a School model
import com.example.service.SchoolService; // Assuming you have a service to fetch schools
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/jpnj")
public class JPNJController {

    @Autowired
    private SchoolService schoolService; // Injecting the service

    @RequestMapping("/dashboard")
    public String jpnjDashboardPage() {
        return "jpnj_dashboard";
    }

    @RequestMapping("/statistics")
    public String statisticsPage() {
        return "jpnj_statistics";
    }

    @RequestMapping("/monitorTVPSSResource")
    public String monitorTVPSSResourcePage(Model model) {
        List<School> schools = schoolService.getAllSchools(); // Fetching schools from service
        model.addAttribute("schools", schools); // Adding schools to model
        return "monitor_tvpss_resource"; // Returning JSP name
    }
}
