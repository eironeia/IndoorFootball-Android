package com.example.eironeia.indoorfootball;

/**
 * Created by Eironeia on 13/3/16.
 */
public class Player {
    int id = 0;
    String name;
    int goals;
    int idTeam;

    public Player() {
    }

    public Player(String name, int goals, int idTeam){
        this.name = name;
        this.goals = goals;
        this.idTeam = idTeam;
    }

    /* Getters and setters */

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

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    /* Funcionts */

    public void incGoals(int goals){
        this.goals += goals;
    }



}
