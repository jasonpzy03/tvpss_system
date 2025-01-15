package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "schools")
public class School {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String videoUrl; // URL for the video content
    private String equipment; // Add this field
    private String studioLevel; // Add this field
    private String tvpssVersion;
    
    
    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getStudioLevel() {
        return studioLevel;
    }

    public void setStudioLevel(String studioLevel) {
        this.studioLevel = studioLevel;
    }

	public String getTvpssVersion() {
		return tvpssVersion;
	}

	public void setTvpssVersion(String tvpssVersion) {
		this.tvpssVersion = tvpssVersion;
	}
}