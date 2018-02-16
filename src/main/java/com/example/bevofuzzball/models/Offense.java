package com.example.bevofuzzball.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.text.DecimalFormat;
import java.text.NumberFormat;

@Entity
public class Offense {

    @Id
    @GeneratedValue
    private int id;
    private double atBats;
    private double hits;
    private double battingAverage;
    private double onBase;
    private double slug;
    private double walks;
    private double hitByPitch;
    private double singles;
    private double doubles;
    private double triples;
    private double homeRuns;
    private double totalBases;

    @Column(name = "ops", precision = 5, scale = 5)
    private double OPS;
    private int playerId;

    public Offense(double atBats, double hits, double walks, double hitByPitch, double singles, double doubles, double triples, double homeRuns, int playerId) {
        this.atBats = atBats;
        this.hits = hits;
        this.walks = walks;
        this.hitByPitch = hitByPitch;
        this.singles = singles;
        this.doubles = doubles;
        this.triples = triples;
        this.homeRuns = homeRuns;
        this.playerId = playerId;
    }

    public Offense() {
    }

    // Methods to calculate statistics

    public void calcAvg(double hits, double atBats){
        NumberFormat formatter = new DecimalFormat("#.000");
        this.battingAverage = hits / atBats;
        System.out.println("Your batting average is " + formatter.format(battingAverage));
    }

    public void calcSlug(double singles, double doubles, double triples, double homeRuns, double atBats){
        NumberFormat formatter = new DecimalFormat("#.000");
        this.totalBases = singles + doubles * 2 + triples * 3 + homeRuns * 4;
        this.slug = totalBases / atBats;
        System.out.println("Your slugging percentage is " + formatter.format(slug));
    }

    public void calcOnBase(double hits, double atBats, double walks, double hitByPitch){
        NumberFormat formatter = new DecimalFormat("#.000");
        this.onBase = (hits + walks + hitByPitch) / (atBats + walks + hitByPitch);
        System.out.println("Your OBP is " + formatter.format(onBase));
    }

    public void calcOPS(double onBase, double slug){
        NumberFormat formatter = new DecimalFormat("#0.0000");
        this.OPS = onBase + slug;
        System.out.println("Your OPS is " + formatter.format(OPS));
    }

    //Getters and Setters


    public int getId() {
        return id;
    }

    public double getAtBats() {
        return atBats;
    }

    public void setAtBats(double atBats) {
        this.atBats = atBats;
    }

    public double getHits() {
        return hits;
    }

    public void setHits(double hits) {
        this.hits = hits;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public void setBattingAverage(double battingAverage) {
        this.battingAverage = battingAverage;
    }

    public double getOnBase() {
        return onBase;
    }

    public void setOnBase(double onBase) {
        this.onBase = onBase;
    }

    public double getSlug() {
        return slug;
    }

    public void setSlug(double slug) {
        this.slug = slug;
    }

    public double getWalks() {
        return walks;
    }

    public void setWalks(double walks) {
        this.walks = walks;
    }

    public double getHitByPitch() {
        return hitByPitch;
    }

    public void setHitByPitch(double hitByPitch) {
        this.hitByPitch = hitByPitch;
    }

    public double getSingles() {
        return singles;
    }

    public void setSingles(double singles) {
        this.singles = singles;
    }

    public double getDoubles() {
        return doubles;
    }

    public void setDoubles(double doubles) {
        this.doubles = doubles;
    }

    public double getTriples() {
        return triples;
    }

    public void setTriples(double triples) {
        this.triples = triples;
    }

    public double getHomeRuns() {
        return homeRuns;
    }

    public void setHomeRuns(double homeRuns) {
        this.homeRuns = homeRuns;
    }

    public double getTotalBases() {
        return totalBases;
    }

    public void setTotalBases(double totalBases) {
        this.totalBases = totalBases;
    }

    public double getOPS() {
        return OPS;
    }

    public void setOPS(double OPS) {
        this.OPS = OPS;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}
