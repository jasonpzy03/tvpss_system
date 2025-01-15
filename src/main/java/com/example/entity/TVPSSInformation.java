package com.example.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tvpss_information")  // Define the table name
public class TVPSSInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")  // Column name for the ID
    private Long id;

    @Column(name = "logo")  // Column name for the logo
    private String logo;  // Assume it's a file path or URL

    @Column(name = "youtube_channel_link", length = 255)  // Column name for the YouTube channel link
    private String youtubeChannelLink;

    @Column(name = "green_screen_used")
    private Boolean greenScreenUsed;

    @Column(name = "recording_equipment")  // Column name for recording equipment
    private String recordingEquipment;

    @ManyToOne
    @JoinColumn(name = "teacher_id")  
    private User user;

    @Column(name = "school")  
    private String school;

    @Column(name = "date_submitted", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)  // Use TIMESTAMP for date and time
    private Date dateSubmitted;

    @Column(name = "status", nullable = false)
    private String status;  // Store the status (e.g., "pending", "approved", "rejected")

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getYoutubeChannelLink() {
        return youtubeChannelLink;
    }

    public void setYoutubeChannelLink(String youtubeChannelLink) {
        this.youtubeChannelLink = youtubeChannelLink;
    }

    public Boolean getGreenScreenUsed() {
        return greenScreenUsed;
    }

    public void setGreenScreenUsed(Boolean greenScreenUsed) {
        this.greenScreenUsed = greenScreenUsed;
    }

    public String getRecordingEquipment() {
        return recordingEquipment;
    }

    public void setRecordingEquipment(String recordingEquipment) {
        this.recordingEquipment = recordingEquipment;
    }

    public User getTeacher() {
        return user;
    }

    public void setTeacher(User user) {
        this.user = user;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Date getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(Date dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
