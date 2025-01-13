package com.example.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.example.entity.Competition;

import com.example.entity.School;

import com.example.entity.District;

import com.example.service.PPDService;
import com.example.service.SchoolService;

@Controller
@RequestMapping("/ppd")
public class PPDController {
	
	 @Autowired
	 private PPDService ppdService;
	 
	 @Autowired
	 private SchoolService schoolService; // Inject the school service
	  
	@GetMapping("/dashboard")
	public String ppdDashboardPage(Model model) {
		District[] districts = District.values();
		  
	    List<Competition> competitionList = ppdService.getAllCompetitions(); 

	    model.addAttribute("competitions", competitionList);
	    model.addAttribute("districts", districts);
	    model.addAttribute("competitionList", competitionList); 
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
	        @RequestParam("district") District district,
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
	    competition.setDistrict(district);
	    competition.setStatus(status); 
	    competition.setTotalParticipants(totalParticipants);  

	    // Save the competition using the service
	    ppdService.saveCompetition(competition);
 
	    // Add a success message to the model
	    model.addAttribute("successMessage", "Competition created successfully!");

	    // Redirect back to the create competition page
	    return "redirect:/ppd/dashboard";
	}
	
	 @GetMapping("/editCompetition/{id}")
	    public String editCompetitionForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
	        try {
	            Competition competition = ppdService.getCompetitionById(id);
	            if (competition == null) {
	                redirectAttributes.addFlashAttribute("errorMessage", "Competition not found");
	                return "redirect:/ppd/dashboard";
	            }
	            model.addAttribute("competition", competition);
	            return "edit_competition";
	        } catch (Exception e) {
	            redirectAttributes.addFlashAttribute("errorMessage", "Error loading competition: " + e.getMessage());
	            return "redirect:/ppd/dashboard";
	        }
	    }
	 
	  @PostMapping("/updateCompetition/{id}")
	    public String updateCompetition(
	            @PathVariable Long id,
	            @RequestParam("name") String name,
	            @RequestParam("description") String description,
	            @RequestParam("startDate") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate startDate,
	            @RequestParam("endDate") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate endDate,
	            @RequestParam("location") String location,
	            @RequestParam("district") District district,
	            @RequestParam("status") String status,
	            @RequestParam("totalParticipants") int totalParticipants,
	            RedirectAttributes redirectAttributes) {
	        
	        try {
	            Competition competition = ppdService.getCompetitionById(id);
	            if (competition == null) {
	                redirectAttributes.addFlashAttribute("errorMessage", "Competition not found");
	                return "redirect:/ppd/dashboard";
	            }
	             
	            competition.setName(name);
	            competition.setDescription(description);
	            competition.setStartDate(startDate);
	            competition.setLocation(location);
	            competition.setDistrict(district);
	            competition.setStatus(status);
	            competition.setTotalParticipants(totalParticipants);
	            
	            ppdService.updateCompetition(competition);
	            redirectAttributes.addFlashAttribute("successMessage", "Competition updated successfully!");
	            return "redirect:/ppd/dashboard";
	            
	        } catch (Exception e) {
	            redirectAttributes.addFlashAttribute("errorMessage", "Error updating competition: " + e.getMessage());
	            return "redirect:/ppd/editCompetition/" + id;
	        }
	    }
	 
	  @GetMapping("/deleteCompetition/{id}")
	    public String deleteCompetition(@PathVariable Long id, RedirectAttributes redirectAttributes) {
	        try {
	            Competition competition = ppdService.getCompetitionById(id);
	            if (competition == null) {
	                redirectAttributes.addFlashAttribute("errorMessage", "Competition not found");
	                return "redirect:/ppd/dashboard";
	            }
	            
	            ppdService.deleteCompetition(id);
	            redirectAttributes.addFlashAttribute("successMessage", "Competition deleted successfully!");
	            return "redirect:/ppd/dashboard";
	            
	        } catch (Exception e) {
	            redirectAttributes.addFlashAttribute("errorMessage", "Error deleting competition: " + e.getMessage());
	            return "redirect:/ppd/dashboard";
	        }
	    }
	
	@GetMapping("/validateTVPSSInfo")
    public String validateTVPSSInfoPage() {
        return "tvpss_validation";
    }
	
	@GetMapping("/monitorTVPSSResource")

	public String monitorTVPSSResourcePage(Model model) {
	    List<School> schools = schoolService.getAllSchools(); // Retrieve all schools from the service
	    model.addAttribute("schools", schools); // Add the schools to the model
	    return "monitor_tvpss_resource"; // Return the name of the view
	}


    public String monitorTVPSSResourcePage() {
        return "monitor_tvpss_resource";
    }
	

}
