package com.example.eironeia.indoorfootball;

import com.orm.SugarRecord;

/**
 * Created by Eironeia on 13/3/16.
 */
public class Player extends SugarRecord <Player>{
    private String name;
    private String teamPlayer;
    private long goals;

    public Player() {
        this.name = "noName";
        this.teamPlayer = "noName";
        this.goals = 0;
    }

    public Player(String name, String teamPlayer, long goals){
        this.name = name;
        this.teamPlayer = teamPlayer;
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

    public String getteamPlayer() {
        return teamPlayer;
    }

    public void setteamPlayer(String teamPlayer) {
        this.teamPlayer = teamPlayer;
    }

    /* Funcionts */

    public void incGoals(long goals){
        this.goals += goals;
    }



}
