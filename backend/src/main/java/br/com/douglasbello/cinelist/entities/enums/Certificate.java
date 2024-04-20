package br.com.douglasbello.cinelist.entities.enums;

public enum Certificate {
    EIGHTEEN(18),
    SIXTEEN(16),
    TWELVE(12),
    TEN(10),
    FREE(0);

    private int age;

    Certificate(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}