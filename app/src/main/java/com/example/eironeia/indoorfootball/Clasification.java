package com.example.eironeia.indoorfootball;

import com.orm.SugarApp;
import com.orm.SugarRecord;

import java.util.ArrayList;

/**
 * Created by Eironeia on 13/3/16.
 */
public class Clasification extends SugarRecord<Clasification>{

    private String nameTeam;
    private long pointsTeam;
    private long wonMatches;
    private long tiedMatches;
    private long lostMatches;

    public Clasification(){
        this.nameTeam = "";
        this.pointsTeam = 0;
        this.wonMatches = 0;
        this.tiedMatches = 0;
        this.lostMatches = 0;
    }

    public Clasification(String nameTeam, long pointsTeam, long wonMatches, long tiedMatches, long lostMatches) {
        this.nameTeam = nameTeam;
        this.pointsTeam = pointsTeam;
        this.wonMatches = wonMatches;
        this.tiedMatches = tiedMatches;
        this.lostMatches = lostMatches;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    public long getPointsTeam() {
        return pointsTeam;
    }

    public void setPointsTeam(long pointsTeam) {
        this.pointsTeam = pointsTeam;
    }

    public long getWonMatches() {
        return wonMatches;
    }

    public void setWonMatches(long wonMatches) {
        this.wonMatches = wonMatches;
    }

    public long getTiedMatches() {
        return tiedMatches;
    }

    public void setTiedMatches(long tiedMatches) {
        this.tiedMatches = tiedMatches;
    }

    public long getLostMatches() {
        return lostMatches;
    }

    public void setLostMatches(long lostMatches) {
        this.lostMatches = lostMatches;
    }
}
