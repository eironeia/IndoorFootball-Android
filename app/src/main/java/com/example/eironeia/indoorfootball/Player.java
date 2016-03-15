package com.example.eironeia.indoorfootball;

import com.orm.SugarRecord;

/**
 * Created by Eironeia on 13/3/16.
 */
public class Player extends SugarRecord <Player>{
    long id = 0;
    String name;
    long goals;
    long idTeam;

    public Player() {
    }

    public Player(String name, long goals, long idTeam){
        this.name = name;
        this.goals = goals;
        this.idTeam = idTeam;
    }

    /* Getters and setters */

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(long idTeam) {
        this.idTeam = idTeam;
    }

    /* Funcionts */

    public void incGoals(long goals){
        this.goals += goals;
    }



}
