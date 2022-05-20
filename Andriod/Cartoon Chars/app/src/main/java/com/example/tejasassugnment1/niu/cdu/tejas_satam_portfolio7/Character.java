package com.example.tejasassugnment1.niu.cdu.tejas_satam_portfolio7;

public class Character {
    private String characterDescription;
    private int characterID;

    public Character(String description, int id) {
        this.characterDescription = description;
        this.characterID = id;
    }

    public String getCharacterDescription() {
        return characterDescription;
    }

    public void setCharacterDescription(String description) {
        this.characterDescription = description;
    }

    public int getCharacterID() {
        return characterID;
    }

    public void setCharacterID(int newID) {
        this.characterID = newID;
    }
}
