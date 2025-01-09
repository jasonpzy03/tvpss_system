package com.example.entity;

public class School {
    private String id;
    private String name;
    private String equipment;
    private int studioLevel;

    public School(String id, String name, String equipment, int studioLevel) {
        this.id = id;
        this.name = name;
        this.equipment = equipment;
        this.studioLevel = studioLevel;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public int getStudioLevel() {
        return studioLevel;
    }

    public void setStudioLevel(int studioLevel) {
        this.studioLevel = studioLevel;
    }
}
