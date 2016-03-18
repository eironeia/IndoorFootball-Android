package com.example.eironeia.indoorfootball;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    int aux = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (emptyDB()) addSampleDB();
        //Team.findWithQuery(Team.class, "delete from team");

        /*
        Player player = new Player("Messi",24, 2);
        player.save();
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player);
        Team team = new Team("FcBarcelona", "BCN", players, 0, 1, 2, 3, 10);
        team.save();
        ArrayList <Team> teams = new ArrayList<Team>();
        teams.add(team);
        Clasification clasification = new Clasification(teams,0);
        clasification.save();*/

    }

    public void onAddPlayer(View view){
        Intent myIntent = new Intent(this, AddPlayer.class);
        this.startActivity(myIntent);
    }

    public void onRemovePlayer(View view){
        Intent myIntent = new Intent(this, RemovePlayer.class);
        this.startActivity(myIntent);

    }

    public void onAddTeam(View view){
        Intent myIntent = new Intent(this, AddTeam.class);
        this.startActivity(myIntent);

    }

    public void onRemoveTeam(View view){
        Intent myIntent = new Intent(this, RemoveTeam.class);
        this.startActivity(myIntent);

    }

    public void onContinueGame(View view){
        Intent myIntent = new Intent(this, ClasificationActivity.class);
        this.startActivity(myIntent);

    }

    public void onDeleteAll (View view){
        Team.deleteAll(Team.class);
        Player.deleteAll(Player.class);
    }

    public void onAutoComplete(View view){
        addSampleDB();
        Toast.makeText(this,"#Equips: "+Team.listAll(Team.class).size()+"\n#Jugadors: "+ Player.listAll(Player.class).size(),Toast.LENGTH_LONG).show();
    }

    public Boolean emptyDB(){
        List<Player> players = Player.listAll(Player.class);
        List<Team> teams = Team.listAll(Team.class);
        if (players.size() == 0 && teams.size() == 0) return true;
        return false;
    }

    public void addSampleDB(){
        for (int i = 1; i <= 10; ++i){
            String playerTeam = new String();
            for (int j = 1; j <= 12; ++j){
                int posFix = i*12+j;
                String playerName = "player"+posFix;
                playerTeam = "Team"+i;
                Player player = new Player(playerName,playerTeam,0);
                player.save();
            }
            Team team = new Team();
            team.setName(playerTeam);
            team.setCity("BCN");
            team.save();
        }
    }






}
