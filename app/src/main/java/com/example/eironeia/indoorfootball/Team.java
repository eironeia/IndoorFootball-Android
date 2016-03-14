package com.example.eironeia.indoorfootball;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Eironeia on 13/3/16.
 */
public class Team {

    String name;
    String city;
    ArrayList<Player> players;
    int goals;
    int victories;
    int defeats;
    int draws;
    int score;


    public Team(){

    }

    public Team (String name, String city, ArrayList<Player> players,
                 int goals, int victories, int defeats, int draws, int score){
        this.name = name;
        this.city = city;
        this.players = players;
        this.goals = goals;
        this.victories = victories;
        this.defeats = defeats;
        this.draws = draws;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getVictories() {
        return victories;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
