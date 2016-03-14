package com.example.eironeia.indoorfootball;

import com.orm.SugarApp;
import com.orm.SugarRecord;

import java.util.ArrayList;

/**
 * Created by Eironeia on 13/3/16.
 */
public class Clasification extends SugarRecord {

    ArrayList<Team> teams;
    int jornada;


    public Clasification(){
        jornada = 0;

    }

    public Clasification(ArrayList<Team> teams, int jornada) {
        this.teams = teams;
        this.jornada = jornada;
    }

 /* Getter and setters */

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    /* Functions */


}
