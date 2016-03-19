package com.example.eironeia.indoorfootball;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Eironeia on 19/3/16.
 */
public class DescendTeam extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.descend_team);

        uploadTeamsOnSpinner();



    }

    public void onAscendDescendTeam(View view){

        Spinner spinnerTeamsDescends = (Spinner) findViewById(R.id.spinnerTeamsDescend);
        EditText nameOfTeam = (EditText) findViewById(R.id.nameTeamDescend);
        EditText nameOfCity = (EditText) findViewById(R.id.nameCityDescend);
        List<Team> teams = Team.find(Team.class, "name = ?", nameOfTeam.getText().toString());
        if (nameOfCity.getText().toString().isEmpty() || nameOfTeam.getText().toString().isEmpty()) openDialogEmptyFields();
        else if (teams.size() > 0) openDialogAlreadyExists();
        else {
            Team team = Team.find(Team.class, "name = ?", spinnerTeamsDescends.getSelectedItem().toString()).get(0);
            team.delete();
            Team team2 = new Team();
            team2.setName(nameOfTeam.getText().toString());
            team2.setCity(nameOfCity.getText().toString());
            team2.save();
            List<Player> players = Player.find(Player.class, "team = ?", nameOfTeam.getText().toString());
            for (int i = 0; i < players.size(); ++i) players.get(i).delete();
            Toast.makeText(this,"Team ascended: "+ nameOfTeam.getText().toString()
                    + "\nTeam descended: "+spinnerTeamsDescends.getSelectedItem().toString()
                    ,Toast.LENGTH_LONG).show();
            cleanFields();
        }

    }

    private void uploadTeamsOnSpinner(){
        List<Team> l = Team.findWithQuery(Team.class, "Select * from team ORDER BY name");

        Spinner spinner = (Spinner)findViewById(R.id.spinnerTeamsDescend);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        for (int i = 0; i < l.size() ; ++i) {
            spinnerAdapter.add((l.get(i)).getName());
        }
        spinnerAdapter.notifyDataSetChanged();
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
    private void openDialogEmptyFields(){
        new AlertDialog.Builder(this)
                .setTitle("Empty Fields")
                .setMessage("You must have to complete all the fields")
                .setNeutralButton("Okay, I understand", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
    private void cleanFields(){
        EditText nameOfTeam = (EditText) findViewById(R.id.nameTeamDescend);
        EditText nameOfCity = (EditText) findViewById(R.id.nameCityDescend);
        nameOfCity.setText("");
        nameOfTeam.setText("");
    }
}

