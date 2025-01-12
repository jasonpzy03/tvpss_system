package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Competition;
import com.example.service.JPNJService;    

@Controller
@RequestMapping("/jpnj")
public class JPNJController {

	@Autowired
    private JPNJService jpnjService;
	

    @GetMapping("/dashboard")
    public String jpnjDashboardPage(Model model) {
        try {
            // Get competitions by status  
            List<Competition> upcomingCompetitions = jpnjService.getUpcomingCompetitions();
            List<Competition> ongoingCompetitions = jpnjService.getOngoingCompetitions();
            List<Competition> allCompetitions = jpnjService.getAllCompetitions();
 
            // Add to model
            model.addAttribute("upcomingCompetitions", upcomingCompetitions);
            model.addAttribute("ongoingCompetitions", ongoingCompetitions);
            model.addAttribute("allCompetitions", allCompetitions); 
            model.addAttribute("totalSchools", 50); 

            return "jpnj_dashboard";   
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error loading dashboard data: " + e.getMessage());
            return "jpnj_dashboard";
        }
    }
    
    @GetMapping("/filterByDistrict")
    public String filterByDistrict(String district, Model model) {
        try {
            List<Competition> districtCompetitions = jpnjService.getCompetitionsByDistrict(district);
            model.addAttribute("competitions", districtCompetitions);
            model.addAttribute("selectedDistrict", district);
            return "jpnj_dashboard";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error filtering competitions: " + e.getMessage());
            return "jpnj_dashboard";
        }
    }

    @GetMapping("/statistics")
    public String statisticsPage() {
        return "jpnj_statistics";
    }

    @GetMapping("/monitorTVPSSResource")
    public String monitorTVPSSResourcePage() {
        return "monitor_tvpss_resource"; // Returning JSP name
    }
}
