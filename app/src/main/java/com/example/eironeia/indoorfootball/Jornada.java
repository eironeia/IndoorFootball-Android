package com.example.eironeia.indoorfootball;

import com.orm.SugarRecord;

/**
 * Created by Eironeia on 21/3/16.
 */
public class Jornada extends SugarRecord<Jornada> {
    long numJornada;
    String localTeam;
    String visitantTeam;
    long localGoals;
    long visitantGoals;

    public Jornada(){
        this.numJornada = 1;
        this.localTeam = "";
        this.visitantTeam = "";
        this.localGoals = 0;
        this.visitantGoals = 0;
    }

    public Jornada(long numJornada, String localTeam, String visitantTeam, long localGoals, long visitantGoals) {
        this.numJornada = numJornada;
        this.localTeam = localTeam;
        this.visitantTeam = visitantTeam;
        this.localGoals = localGoals;
        this.visitantGoals = visitantGoals;
    }

    public long getNumJornada() {
        return numJornada;
    }

    public void setNumJornada(long numJornada) {
        this.numJornada = numJornada;
    }

    public String getLocalTeam() {
        return localTeam;
    }

    public void setLocalTeam(String localTeam) {
        this.localTeam = localTeam;
    }

    public String getVisitantTeam() {
        return visitantTeam;
    }

    public void setVisitantTeam(String visitantTeam) {
        this.visitantTeam = visitantTeam;
    }

    public long getLocalGoals() {
        return localGoals;
    }

    public void setLocalGoals(long localGoals) {
        this.localGoals = localGoals;
    }

    public long getVisitantGoals() {
        return visitantGoals;
    }

    public void setVisitantGoals(long visitantGoals) {
        this.visitantGoals = visitantGoals;
    }
}
