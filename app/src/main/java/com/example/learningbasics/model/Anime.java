package com.example.learningbasics.model;

public class Anime {
    int id;
    String animeName;
    String mainCharacter;

    public Anime(String animeName, String mainCharacter) {
        this.animeName = animeName;
        this.mainCharacter = mainCharacter;
    }

    public Anime() {
    }

    public Anime(int id, String animeName, String mainCharacter) {
        this.id = id;
        this.animeName = animeName;
        this.mainCharacter = mainCharacter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimeName() {
        return animeName;
    }

    public void setAnimeName(String animeName) {
        this.animeName = animeName;
    }

    public String getMainCharacter() {
        return mainCharacter;
    }

    public void setMainCharacter(String mainCharacter) {
        this.mainCharacter = mainCharacter;
    }
}
