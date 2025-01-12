package com.example.entity;

public enum District {
    JOHOR_BAHRU("Johor Bahru"),
    KULAI("Kulai"),
    PONTIAN("Pontian"),
    KOTA_TINGGI("Kota Tinggi"),
    MERSING("Mersing"),
    MUAR("Muar"),
    BATU_PAHAT("Batu Pahat"),
    SEGAMAT("Segamat"),
    KLUANG("Kluang"),
    TANGKAK("Tangkak");

    private final String displayName;

    District(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}