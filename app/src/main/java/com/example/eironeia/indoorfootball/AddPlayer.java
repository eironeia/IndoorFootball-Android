package com.example.eironeia.indoorfootball;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Eironeia on 15/3/16.
 */
public class AddPlayer extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_player);

        /* Preparing the spinner of the Teams */
        //if (notEnoughTeams()) openDialogTeams();
        final Spinner spinner = (Spinner) findViewById(R.id.listOfTeams);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                uploadListPlayers(spinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        //else {
            uploadTeamsOnSpinner();
        //}

    }

    public void onAddPlayer(View view){
        EditText playerNameValue = (EditText) findViewById(R.id.playerName);
        Spinner listOfTeamsValue = (Spinner) findViewById(R.id.listOfTeams);
        String nameValue = playerNameValue.getText().toString();
        String listTeamValue = listOfTeamsValue.getSelectedItem().toString();
        if (nameValue.isEmpty() || listTeamValue.isEmpty()) openDialogMissInfo(); // Some field empty
        else if (existsPlayer(nameValue)) openDialogAlreadyExistsPlayer(); //Already exists a player with this name
        else if (fullTeam(listTeamValue))openDialogFullTeam(); //Full Team size
        else {
            Player player2 = new Player();
            player2.setGoals(0);
            player2.setName(nameValue);
            player2.setTeam(listTeamValue);
            player2.save();
            Toast.makeText(this,"Player " + nameValue+ " added",Toast.LENGTH_SHORT).show();
            uploadListPlayers(listTeamValue);
        }

    }


    /* Go to addTeam because we don't have enough teams */
    private Boolean notEnoughTeams(){
        List<Team> l = Team.findWithQuery(Team.class, "Select * from team");
        if (l.size() == 10) return false;
        return true;
    }
    private void openDialogTeams(){
        new AlertDialog.Builder(this)
                .setTitle("Error with Teams")
                .setMessage("You must have to create 10 teams")
                .setNeutralButton("I will add the missing Teams", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                changeActivityToTeam();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
    private void changeActivityToTeam() {
        Intent myIntent = new Intent(this, AddTeam.class);
        this.startActivity(myIntent);
    }

    private void openDialogMissInfo(){
        new AlertDialog.Builder(this)
                .setTitle("Error adding")
                .setMessage("You must have to put a name of the Player and in which team he plays")
                .setNeutralButton("Okay", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
    private void openDialogAlreadyExistsPlayer(){
        new AlertDialog.Builder(this)
                .setTitle("Error adding")
                .setMessage("Already exists a player whith this name ")
                .setNeutralButton("Okay", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
    private void openDialogFullTeam(){
        new AlertDialog.Builder(this)
                .setTitle("Error adding")
                .setMessage("The team is full")
                .setNeutralButton("Okay", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


    private void uploadTeamsOnSpinner(){
        List<Team> l = Team.findWithQuery(Team.class, "Select * from team");

        Spinner spinner = (Spinner)findViewById(R.id.listOfTeams);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        for (int i = 0; i < l.size() ; ++i) {
            spinnerAdapter.add((l.get(i)).getName());
        }
        spinnerAdapter.notifyDataSetChanged();
    }
    private void uploadListPlayers(String teamPlayers){
        // Construct the data source
        List<Player> arrayOfPlayer = Player.findWithQuery(Player.class, "Select * from player WHERE team = ? ORDER BY name",teamPlayers);

        // Create the adapter to convert the array to views
        CustomListPlayer adapter = new CustomListPlayer(this, arrayOfPlayer);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.listOfPlayers);
        listView.setAdapter(adapter);

    }

    private Boolean existsPlayer(String s){
        List<Player> listP = Player.findWithQuery(Player.class,"Select name FROM player where name = ?", s);
        if (listP.size() > 0) { openDialogAlreadyExistsPlayer(); return true;}
        else return false;

    }
    private Boolean fullTeam(String nameOfTeam){
        List<Player> playerL = Player.findWithQuery(Player.class,"SELECT * FROM player WHERE team = ?", nameOfTeam);
        if (playerL.size() >= 12) return true;
        return false;
    }


}
