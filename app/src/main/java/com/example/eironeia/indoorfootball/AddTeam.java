package com.example.eironeia.indoorfootball;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eironeia on 15/3/16.
 */
public class AddTeam extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_team);

        populateTeamList();
    }

    public void onAddTeam(View view) {
        EditText nameOfTeam = (EditText) findViewById(R.id.nameTeam);
        EditText nameOfCity = (EditText) findViewById(R.id.cityTeam);
        List<Team> teams = Team.find(Team.class, "name = ?", nameOfTeam.getText().toString());
        List<Team> t = Team.findWithQuery(Team.class, "Select * from team");

        if (teams.size() > 0) openDialogAlreadyExists();
        else if (t.size() >= 10) openDialogTenTeams();
        else {
            ArrayList<Player> players = new ArrayList<Player>();
            Team team = new Team(nameOfTeam.getText().toString(),nameOfCity.getText().toString(),players,0,0,0,0,0);
            team.save();
        }
    }


    private void populateTeamList() {
        // Construct the data source
        Team team;
        List<Team> arrayOfTeams = Team.listAll(Team.class);

        // Create the adapter to convert the array to views
        CustomListTeam adapter = new CustomListTeam(this, arrayOfTeams);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.listOfTeams);
        listView.setAdapter(adapter);
    }


    private void openDialogAlreadyExists(){
        new AlertDialog.Builder(this)
                .setTitle("Team exists")
                .setMessage("This team already exists")
                .setNeutralButton("Try other team", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
    private void openDialogTenTeams(){
        new AlertDialog.Builder(this)
                .setTitle("Maximum Teams")
                .setMessage("The maximum teams you can have is 10")
                .setNeutralButton("Okay", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
