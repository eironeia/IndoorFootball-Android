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

import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.ArrayList;
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
        /*List<Team> l = Team.findWithQuery(Team.class, "Select name from team ");
        if (l.size() != 10) { // s'ha de modificar a != 10
            openDialogTeams();
        }
        else {
            Spinner spinner = (Spinner)findViewById(R.id.listOfTeams);
            ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(spinnerAdapter);
            for (int i = 0; i < l.size() ; ++i) {
                spinnerAdapter.add((l.get(i)).getName());
            }
            spinnerAdapter.notifyDataSetChanged();
        }*/



        /* */
    }



    public void onAddPlayer(View view){
        /*EditText namePlayer = (EditText) findViewById(R.id.playerName);
        Spinner spinner = (Spinner)findViewById(R.id.listOfTeams);
        String s = spinner.getSelectedItem().toString();
        if (namePlayer.toString().isEmpty() || s.isEmpty()){
            openDialogMissInfo();
        }
        else{

            List<Team> l = Team.findWithQuery(Team.class, "Select players from team where name = ?",s);

            if (l.size() > 0) {
                Toast.makeText(this,Integer.toString(l.size()),Toast.LENGTH_LONG).show();

            }
            else{
                Toast.makeText(this,"9999",Toast.LENGTH_LONG).show();

            }
        }*/



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


}
