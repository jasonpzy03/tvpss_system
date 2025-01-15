package com.example.controller;

<<<<<<< Updated upstream
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
=======
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Collaboration;
import com.example.entity.InSchoolRecording;
import com.example.entity.OutSchoolRecording;
import com.example.entity.TVPSSInformation;
import com.example.entity.User;
import com.example.repository.CollaborationDAO;
import com.example.repository.InSchoolRecordingDAO;
import com.example.repository.OutSchoolRecordingDAO;
import com.example.repository.TVPSSInformationDAO;
import com.example.repository.UserDAO;
>>>>>>> Stashed changes

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TVPSSInformationDAO tvpssInformationDAO;
	
	@Autowired
	private InSchoolRecordingDAO inSchoolRecordingDAO;
	
	@Autowired
	private OutSchoolRecordingDAO outSchoolRecordingDAO;
	
	@Autowired
	private CollaborationDAO collaborationDAO;
	
	@Autowired
	private UserDAO userDAO;

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
    
    @PostMapping("/submitSchoolTVPSSInfo")
    public String submitSchoolTVPSSInfo(
	    @RequestParam(required = false) MultipartFile logo,
	    @RequestParam(required = false) String youtubeLink,
	    @RequestParam(required = true) Boolean greenScreen,
	    @RequestParam(required = false) String equipment,
	    @RequestParam(value="inSchoolRecording[]", required=false) String[] inSchoolRecording,
	    @RequestParam(value="outSchoolRecording[]", required=false) String[] outSchoolRecording,
	    @RequestParam(value="inEvidence[]", required=false) MultipartFile[] inEvidence,
	    @RequestParam(value="outEvidence[]", required=false) MultipartFile[] outEvidence,
	    @RequestParam(value="collaboration[]", required=false) String[] collaboration,
	    @RequestParam(value="collaborationEvidence[]", required=false) MultipartFile[] collaborationEvidence
	) {
    	
    	String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();  // Get the username from the authenticated user
        } else {
            username = principal.toString();  // In case the principal is not an instance of UserDetails
        }

        // Now you can fetch the user from the database using the username
        User user = userDAO.findByUsername(username); // Assuming you have a method to find a user by username
        
    	TVPSSInformation tvpssInformation = new TVPSSInformation();
    	tvpssInformation.setLogo(storeFile(logo));
    	tvpssInformation.setYoutubeChannelLink(youtubeLink);
    	tvpssInformation.setGreenScreenUsed(greenScreen);
    	tvpssInformation.setRecordingEquipment(equipment);
    	tvpssInformation.setTeacher(user);
    	tvpssInformation.setSchool(user.getSchool());
    	tvpssInformation.setStatus("Pending");
    	tvpssInformation.setDateSubmitted(new Date());
    	
    	tvpssInformationDAO.save(tvpssInformation);
    	
    	// Save InSchoolRecording entities
    	if (inSchoolRecording != null) {
    		for (int i = 0; i < inSchoolRecording.length; i++) {
                InSchoolRecording inSchoolRecordingEntity = new InSchoolRecording();
                inSchoolRecordingEntity.setDescription(inSchoolRecording[i]);  // Set description
                inSchoolRecordingEntity.setEvidence(storeFile(inEvidence[i]));  // Set evidence (you can adjust how the evidence is handled)
                inSchoolRecordingEntity.setTvpssInformation(tvpssInformation);  // Set the relationship to TVPSSInformation

                inSchoolRecordingDAO.save(inSchoolRecordingEntity);
            }
    	}
        
    	if (outSchoolRecording != null) {
    		// Save OutSchoolRecording entities
            for (int i = 0; i < outSchoolRecording.length; i++) {
                OutSchoolRecording outSchoolRecordingEntity = new OutSchoolRecording();
                outSchoolRecordingEntity.setDescription(outSchoolRecording[i]);  // Set description
                outSchoolRecordingEntity.setEvidence(storeFile(outEvidence[i]));  // Set evidence (you can adjust how the evidence is handled)
                outSchoolRecordingEntity.setTvpssInformation(tvpssInformation);  // Set the relationship to TVPSSInformation

                outSchoolRecordingDAO.save(outSchoolRecordingEntity);
            }
    	}
        
    	if (collaboration != null) {
    		// Save Collaboration entities
            for (int i = 0; i < collaboration.length; i++) {
                Collaboration collaborationEntity = new Collaboration();
                collaborationEntity.setDescription(collaboration[i]);  // Set description
                collaborationEntity.setEvidence(storeFile(collaborationEvidence[i]));  // Set evidence
                collaborationEntity.setTvpssInformation(tvpssInformation);  // Set the relationship to TVPSSInformation

                collaborationDAO.save(collaborationEntity);
            }
    	}
        
        return "redirect:dashboard";
    }
    
    private String storeFile(MultipartFile file) {
        try {
            // Dynamically resolve the absolute path for the upload directory
            String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/images/evidences/";
            
            System.out.println("Working Directory = " + System.getProperty("user.dir"));
            
            // Ensure the directory exists
            Path dirPath = Paths.get(uploadDir);
            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath); // Create directories if they do not exist
            }

            // Get the original file name and create a unique name to avoid conflicts
            String fileName = file.getOriginalFilename();
            String uniqueFileName = System.currentTimeMillis() + "_" + fileName;

            // Create a path to save the file
            Path filePath = dirPath.resolve(uniqueFileName);

            // Save the file to the disk
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Return the relative path (can be customized to match your server's URL structure)
            return "/tvpss_system/images/evidences/" + uniqueFileName;

        } catch (IOException e) {
            e.printStackTrace();
            return null; // Handle error appropriately
        }
    }

    
}
