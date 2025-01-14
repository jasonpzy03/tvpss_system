package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.service.CrewApplicationService;
import com.example.service.TeacherService;

import com.example.entity.Competition;
import com.example.entity.CrewApplication;
import com.example.entity.District;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired 
	private TeacherService teacherService;
	
	 @Autowired
	 private CrewApplicationService crewApplicationService; // Inject the service
	
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
    public String availableCompetitions(Model model) {
    	List<Competition> competitions = teacherService.getAllCompetitions();
		model.addAttribute("competitions", competitions);
		model.addAttribute("districts", District.values());
		System.out.println("Number of competitions: " + competitions.size());
		  for (Competition comp : competitions) {
			  System.out.println("Competition: " + comp.getName() + ", District: " + comp.getDistrict());
	      }
	        
	    return "available_competitions";

    }
    
    @GetMapping("/crewapplications")
    public String viewCrewApplications(Model model) {
        List<CrewApplication> applications = crewApplicationService.getAllApplications();
        System.out.println(crewApplicationService.getAllApplications());
        System.out.println("Applications retrieved in controller: " + applications); // Debug log
        model.addAttribute("applications", applications);
        return "view_tvpss_crew_application"; // Ensure this matches your Thymeleaf template name
    }
 



    @PostMapping("/crewapplications/{id}/update")
    public String updateCrewApplicationStatus(
            @PathVariable Long id,
            @RequestParam String action,
            Model model) {
        try {
            crewApplicationService.updateStatus(id, action.equalsIgnoreCase("accept") ? "Accepted" : "Rejected");
            model.addAttribute("successMessage", "Application status updated successfully!");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error updating application status.");
        }
        return "redirect:/teacher/crewapplications";
    }
    
    

    @PostMapping("/competition/{id}/join")
    public String joinCompetition(@PathVariable("id") Long competitionId, 
                                Authentication authentication,
                                RedirectAttributes redirectAttributes) {
        try {
            String username = authentication.getName(); // Get username from authentication
            teacherService.joinCompetition(competitionId, username);
            redirectAttributes.addFlashAttribute("successMessage", "Successfully joined the competition!");
            return "redirect:/teacher/mycompetitions";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/teacher/availablecompetitions";
        } 
    } 

    @GetMapping("/mycompetitions")
    public String myCompetitions(Model model, Authentication authentication) {
        String username = authentication.getName();
        List<Competition> userCompetitions = teacherService.getUserCompetitions(username);
        model.addAttribute("competitions", userCompetitions); 
        return "my_competitions";
    }
    
    @GetMapping("/updateinformation")
    public String updateTVPSSInformation() {
        return "update_school_tvpss_information";
    }
}
