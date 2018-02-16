package com.example.bevofuzzball.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.text.DecimalFormat;
import java.text.NumberFormat;

@Entity
public class Pitch {

    @Id
    @GeneratedValue
    private int id;

    private int pitchStatYear;
    private double wins;
    private double saves;
    private double inningsPitched;
    private double strikeouts;
    private double walks;
    private double hitsAllowed;
    private double runsAllowed;
    private double ERA;
    private double hrAllowed;
    private double walksPerNine;
    private double WHIP;

    public Pitch(int id, int pitchStatYear, double wins, double saves, double inningsPitched, double strikeouts, double walks, double hitsAllowed, double runsAllowed, double ERA, double hrAllowed, double walksPerNine, double WHIP) {
        this.id = id;
        this.pitchStatYear = pitchStatYear;
        this.wins = wins;
        this.saves = saves;
        this.inningsPitched = inningsPitched;
        this.strikeouts = strikeouts;
        this.walks = walks;
        this.hitsAllowed = hitsAllowed;
        this.runsAllowed = runsAllowed;
        this.ERA = ERA;
        this.hrAllowed = hrAllowed;
        this.walksPerNine = walksPerNine;
        this.WHIP = WHIP;
    }

    public Pitch(double wins, double saves, double inningsPitched, double strikeouts, double walks, double hitsAllowed, double runsAllowed, double hrAllowed) {
        this.wins = wins;
        this.saves = saves;
        this.inningsPitched = inningsPitched;
        this.strikeouts = strikeouts;
        this.walks = walks;
        this.hitsAllowed = hitsAllowed;
        this.runsAllowed = runsAllowed;
        this.hrAllowed = hrAllowed;
    }

    public Pitch(double inningsPitched, double runsAllowed, double walks, double hitsAllowed) {
        this.inningsPitched = inningsPitched;
        this.runsAllowed = runsAllowed;
        this.walks = walks;
        this.hitsAllowed = hitsAllowed;
    }

    public Pitch(){

    }

    //Methods to calculate Stats

    public void calcERA(double inningsPitched, double runsAllowed){
        NumberFormat formatter = new DecimalFormat("#0.00");
        this.ERA = (runsAllowed * 9) / inningsPitched;
        System.out.println("Your ERA is: " + formatter.format(ERA));
    }

    public void calcWalksPerNine(double walks, double inningsPitched){
        NumberFormat formatter = new DecimalFormat("#0.0");
        this.walksPerNine = inningsPitched / walks;
        System.out.println("Walks per 9: " + formatter.format(walksPerNine));
    }

    public void calcWHIP(double walks, double inningsPitched, double hitsAllowed){
        NumberFormat formatter = new DecimalFormat("#0.0000");
        this.WHIP = (hitsAllowed + walks) / inningsPitched;
        System.out.println("WHIP: " + formatter.format(WHIP));
    }

    //Getters and Setters


    public int getId() {
        return id;
    }

    public int getPitchStatYear() {
        return pitchStatYear;
    }

    public void setPitchStatYear(int pitchStatYear) {
        this.pitchStatYear = pitchStatYear;
    }

    public double getWins() {
        return wins;
    }

    public void setWins(double wins) {
        this.wins = wins;
    }

    public double getSaves() {
        return saves;
    }

    public void setSaves(double saves) {
        this.saves = saves;
    }

    public double getInningsPitched() {
        return inningsPitched;
    }

    public void setInningsPitched(double inningsPitched) {
        this.inningsPitched = inningsPitched;
    }

    public double getStrikeouts() {
        return strikeouts;
    }

    public void setStrikeouts(double strikeouts) {
        this.strikeouts = strikeouts;
    }

    public double getWalks() {
        return walks;
    }

    public void setWalks(double walks) {
        this.walks = walks;
    }

    public double getERA() {
        return ERA;
    }

    public void setERA(double ERA) {
        this.ERA = ERA;
    }

    public double getHrAllowed() {
        return hrAllowed;
    }

    public void setHrAllowed(double hrAllowed) {
        this.hrAllowed = hrAllowed;
    }

    public double getWalksPerNine() {
        return walksPerNine;
    }

    public void setWalksPerNine(double walksPerNine) {
        this.walksPerNine = walksPerNine;
    }

    public double getWHIP() {
        return WHIP;
    }

    public void setWHIP(double WHIP) {
        this.WHIP = WHIP;
    }

    public double getRunsAllowed() {
        return runsAllowed;
    }

    public void setRunsAllowed(double runsAllowed) {
        this.runsAllowed = runsAllowed;
    }

    public double getHitsAllowed() {
        return hitsAllowed;
    }
}