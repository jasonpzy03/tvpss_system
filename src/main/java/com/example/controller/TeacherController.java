package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.TeacherService;

import com.example.entity.Competition;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired 
	private TeacherService teacherService;
	
	
    @GetMapping("/dashboard")
    public String teacherDashboardPage(Model model) {
		
		try {
			List<Competition> competitions = teacherService.getAllCompetitions();
			model.addAttribute("competitions", competitions);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("errorMessage", "An error occurred while fetching competitions.");
		}
        
        return "teacher_dashboard";
    }
    
    
    @GetMapping("/competition/{id}")
    public String getCompetitionDetails(@PathVariable("id") Long competitionId, Model model) {
        // Fetch the competition by ID from the service
        Competition competition = teacherService.getCompetitionById(competitionId);

        // Add competition to the model
        model.addAttribute("competition", competition);

        // Return the Thymeleaf template for the competition details page
        return "competition_details";  // This should correspond to your HTML page
    }
    
    @GetMapping("/availablecompetitions")
    public String availableCompetitions() {
        return "available_competitions";
    }
    
    @GetMapping("/crewapplications")
    public String viewTVPSSCrewApplication() {
        return "view_tvpss_crew_application";
    }
    
    @GetMapping("/updateinformation")
    public String updateTVPSSInformation() {
        return "update_school_tvpss_information";
    }
}
