package com.example.eironeia.indoorfootball;

import android.widget.ImageView;
import android.widget.TextView;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eironeia on 13/3/16.
 */
public class Team  extends SugarRecord <Team>{

    String name;
    String city;
    List<Player> players;
    long goals;
    long victories;
    long defeats;
    long draws;
    long score;


    public Team(){

    }

    public Team(String name, String city, List<Player> players, long goals, long victories, long defeats, long draws, long score) {
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

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public long getGoals() {
        return goals;
    }

    public void setGoals(long goals) {
        this.goals = goals;
    }

    public long getVictories() {
        return victories;
    }

    public void setVictories(long victories) {
        this.victories = victories;
    }

    public long getDefeats() {
        return defeats;
    }

    public void setDefeats(long defeats) {
        this.defeats = defeats;
    }

    public long getDraws() {
        return draws;
    }

    public void setDraws(long draws) {
        this.draws = draws;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }
}
