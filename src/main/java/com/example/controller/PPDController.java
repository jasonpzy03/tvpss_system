package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Competition;
import com.example.service.PPDService;

@Controller
@RequestMapping("/ppd")
public class PPDController {
	
	 @Autowired
	    private PPDService ppdService;
	 
	@RequestMapping("/dashboard")
    public String ppdDashboardPage() {
        return "ppd_dashboard";
    }
	
	@RequestMapping("/createCompetition")
    public String createCompetitionPage() {
        return "create_competition";
    }
	
	 // POST mapping to handle form submission
    @PostMapping("/createCompetition")
    public String createCompetition(@RequestParam("competitionName") String competitionName,
                                    @RequestParam("competitionDescription") String competitionDescription,
                                    Model model) {
        // Create a new competition object
        Competition competition = new Competition();
        competition.setName(competitionName);
        competition.setDescription(competitionDescription);

        // Save the competition using the service
        ppdService.saveCompetition(competition);

        // Add a success message to the model
        model.addAttribute("successMessage", "Competition created successfully!");

        // Redirect back to the create competition page
        return "create_competition";
    }
	
	@RequestMapping("/validateTVPSSInfo")
    public String validateTVPSSInfoPage() {
        return "tvpss_validation";
    }
	
	@RequestMapping("/monitorTVPSSResource")
    public String monitorTVPSSResourcePage() {
        return "monitor_tvpss_resource";
    }
}
