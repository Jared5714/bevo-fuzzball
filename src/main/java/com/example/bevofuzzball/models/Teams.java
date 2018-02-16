package com.example.bevofuzzball.models;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Teams {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    private int wins;
    private int loses;

    public Teams(int id, String name, int wins, int loses) {
        this.id = id;
        this.name = name;
        this.wins = wins;
        this.loses = loses;
    }

    public Teams() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }
}
