package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "inschoolrecording")
public class InSchoolRecording {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "evidence")
    private String evidence;  // Assume it's a file path or URL
    
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "tvpss_information_id")  // Foreign key to TVPSSInformation
    private TVPSSInformation tvpssInformation;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public TVPSSInformation getTvpssInformation() {
        return tvpssInformation;
    }

    public void setTvpssInformation(TVPSSInformation tvpssInformation) {
        this.tvpssInformation = tvpssInformation;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
