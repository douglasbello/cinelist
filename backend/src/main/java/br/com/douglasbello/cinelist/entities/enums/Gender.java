package br.com.douglasbello.cinelist.entities.enums;

public enum Gender {
    MALE("Female"),
    FEMALE("Male");

    private String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}