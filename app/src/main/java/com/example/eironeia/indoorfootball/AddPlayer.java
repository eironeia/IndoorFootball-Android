package com.example.eironeia.indoorfootball;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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
        uploadTeamsOnSpinner();
        uploadListPlayers();
    }



    public void onAddPlayer(View view){

    }


    /* Go to addTeam because we don't have enough teams */
    private void openDialogTeams(){
        new AlertDialog.Builder(this)
                .setTitle("Error with Teams")
                .setMessage("You must have to create 10 teams")
                .setNeutralButton("I will add the missing Teams", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                    changeActivity();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
    private void changeActivity() {
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
                .setMessage("Already exists ")
                .setNeutralButton("Okay", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private void uploadTeamsOnSpinner(){
        List<Team> l = Team.findWithQuery(Team.class, "Select name from team");

        Spinner spinner = (Spinner)findViewById(R.id.listOfTeams);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        for (int i = 0; i < l.size() ; ++i) {
            spinnerAdapter.add((l.get(i)).getName());
        }
        spinnerAdapter.notifyDataSetChanged();
    }
    private void uploadListPlayers(){
       /* List<Team> l = Team.findWithQuery(Team.class, "Select name from team");

        Spinner spinner = (Spinner)findViewById(R.id.listOfTeams);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        for (int i = 0; i < l.size() ; ++i) {
            spinnerAdapter.add((l.get(i)).getName());
        }
        spinnerAdapter.notifyDataSetChanged();*/
    }
    private Boolean existsPlayer(String s){
        List<Player> listP = Player.findWithQuery(Player.class,"Select name FROM player where name = ?", s);
        if (listP.size() > 0) { openDialogAlreadyExistsPlayer(); return true;}
        else return false;

    }

}
