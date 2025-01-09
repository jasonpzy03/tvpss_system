package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "crew_application") // Maps to a database table
public class CrewApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates unique IDs
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "ic_no", nullable = false, length = 20, unique = true)
    private String icNo;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "school", nullable = false, length = 100)
    private String school;

    // Default constructor (required by JPA)
    public CrewApplication() {
    }

    // Parameterized constructor
    public CrewApplication(String fullName, String icNo, String email, String school) {
        this.fullName = fullName;
        this.icNo = icNo;
        this.email = email;
        this.school = school;
        this.status = "Pending"; // Set the default status

    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIcNo() {
        return icNo;
    }

    public void setIcNo(String icNo) {
        this.icNo = icNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Column(name = "status", nullable = false)
    private String status; // You can set this to an appropriate default or allow it to be nullable

    // Getter and setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    // ToString method
    @Override
    public String toString() {
        return "CrewApplication{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", icNo='" + icNo + '\'' +
                ", email='" + email + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
