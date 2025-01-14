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
import com.example.entity.District;
import com.example.entity.Participant;
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
            List<Participant> participants = jpnjService.getAllParticipants();
  
            // Add to model
            model.addAttribute("upcomingCompetitions", upcomingCompetitions);
            model.addAttribute("ongoingCompetitions", ongoingCompetitions);
            model.addAttribute("allCompetitions", allCompetitions); 
            model.addAttribute("participants", participants);
            model.addAttribute("totalSchools", 50);  

            return "jpnj_dashboard";   
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error loading dashboard data: " + e.getMessage());
            return "jpnj_dashboard";
        }  
    }
    
    @GetMapping("/createCompetition")
    public String showCreateCompetitionForm(Model model) {
        model.addAttribute("districts", District.values());
        return "jpnj_create_competition";
    }
    
    @PostMapping("/createCompetition") 
    public String createCompetition(
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
            Competition competition = new Competition();
            competition.setName(name);
            competition.setDescription(description);
            competition.setStartDate(startDate);
            competition.setEndDate(endDate);
            competition.setLocation(location);
            competition.setDistrict(district);
            competition.setStatus(status);
            competition.setTotalParticipants(totalParticipants);
            
            
            jpnjService.createCompetition(competition);
            redirectAttributes.addFlashAttribute("successMessage", "Competition created successfully!");
            return "redirect:/jpnj/dashboard";
        } catch (Exception e) {
             redirectAttributes.addFlashAttribute("errorMessage", "Error creating competition: " + e.getMessage());
             return "redirect:/jpnj/createCompetition";
         }
     }
    
    @GetMapping("/editCompetition/{id}")
    public String showEditCompetitionForm(@PathVariable Long id, Model model) {
        try {
            Competition competition = jpnjService.getCompetitionById(id);
            if (competition == null) {
                throw new RuntimeException("Competition not found");
            }
            model.addAttribute("competition", competition);
            model.addAttribute("districts", District.values());
            return "jpnj_edit_competition";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error loading competition: " + e.getMessage());
            return "redirect:/jpnj/dashboard";
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
            Competition competition = jpnjService.getCompetitionById(id);
            if (competition == null) {
                throw new RuntimeException("Competition not found");
            }
            
            competition.setName(name);
            competition.setDescription(description);
            competition.setStartDate(startDate);
            competition.setEndDate(endDate);
            competition.setLocation(location);
            competition.setDistrict(district);
            competition.setStatus(status);
            competition.setTotalParticipants(totalParticipants);

            jpnjService.updateCompetition(competition);
            return "redirect:/jpnj/dashboard";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error updating competition: " + e.getMessage());
            return "redirect:/jpnj/editCompetition/" + id;
        }
    }
    
    @GetMapping("/deleteCompetition/{id}")
    public String deleteCompetition(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            jpnjService.deleteCompetition(id);
            redirectAttributes.addFlashAttribute("successMessage", "Competition deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error deleting competition: " + e.getMessage());
        }
        return "redirect:/jpnj/dashboard";
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
