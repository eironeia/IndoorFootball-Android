package com.example.eironeia.indoorfootball;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int aux = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* */
        Player player = new Player("Messi",24, 2);
        player.save();
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player);
        Team team = new Team("FcBarcelona", "BCN", players, 0, 1, 2, 3, 10);
        team.save();
        ArrayList <Team> teams = new ArrayList<Team>();
        teams.add(team);
        Clasification clasification = new Clasification(teams,0);
        clasification.save();

    }

    public void onClick(View view){
        Player.executeQuery("Delete  FROM player where id = 4");

    }


}
