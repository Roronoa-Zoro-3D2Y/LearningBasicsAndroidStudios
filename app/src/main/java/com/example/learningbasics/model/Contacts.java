package com.example.learningbasics.model;

public class Contacts {
    private int id;
    private String name;
    private String phone_num;

    public Contacts(String name, String phone_num) {
        this.name = name;
        this.phone_num = phone_num;
    }

    public Contacts(int id, String name, String phone_num) {
        this.id = id;
        this.name = name;
        this.phone_num = phone_num;
    }

    public Contacts() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }
}
