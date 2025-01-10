package com.example.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	 
	@GetMapping("/dashboard")
    public String ppdDashboardPage() {
        return "ppd_dashboard";
    }
	
	@GetMapping("/createCompetition")
    public String createCompetitionPage() {
        return "create_competition";
    }
	
	@PostMapping("/createCompetition")
	public String createCompetition(
	        @RequestParam("competitionName") String competitionName,
	        @RequestParam("competitionDescription") String competitionDescription,
	        @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
	        @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
	        @RequestParam("location") String location,
	        @RequestParam("status") String status,
	        @RequestParam("totalParticipants") int totalParticipants,
	        Model model) {

	    // Create a new competition object
	    Competition competition = new Competition();
	    competition.setName(competitionName);
	    competition.setDescription(competitionDescription);
	    competition.setStartDate(startDate);
	    competition.setEndDate(endDate);
	    competition.setLocation(location);
	    competition.setStatus(status);
	    competition.setTotalParticipants(totalParticipants);

	    // Save the competition using the service
	    ppdService.saveCompetition(competition);

	    // Add a success message to the model
	    model.addAttribute("successMessage", "Competition created successfully!");

	    // Redirect back to the create competition page
	    return "create_competition";
	}

	
	@GetMapping("/validateTVPSSInfo")
    public String validateTVPSSInfoPage() {
        return "tvpss_validation";
    }
	
	@GetMapping("/monitorTVPSSResource")
    public String monitorTVPSSResourcePage() {
        return "monitor_tvpss_resource";
    }
}
