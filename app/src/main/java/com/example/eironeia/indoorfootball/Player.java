package com.example.eironeia.indoorfootball;

import com.orm.SugarRecord;

/**
 * Created by Eironeia on 13/3/16.
 */
public class Player extends SugarRecord <Player>{
    private String name;
    private String team;
    private long goals;

    public Player() {
        this.name = "noName";
        this.team = "noName";
        this.goals = 0;
    }

    public Player(String name, String team, long goals){
        this.name = name;
        this.team = team;
        this.goals = goals;
    }

    /* Getters and setters */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGoals() {
        return goals;
    }

    public void setGoals(long goals) {
        this.goals = goals;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

/* Funcionts */

    public void incGoals(long goals){
        this.goals += goals;
    }



}
