package com.example.eironeia.indoorfootball;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Eironeia on 15/3/16.
 */
public class AddTeam extends Activity {

    /*
    * String name;
    String city;
    long numOfPlayers;
    long goals;
    long victories;
    long defeats;
    long draws;
    long score;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_team);
    }

    public void onAddTeam(View view) {
        EditText nameOfTeam = (EditText) findViewById(R.id.nameTeam);
        EditText nameOfCity = (EditText) findViewById(R.id.cityTeam);
        List<Team> teams = Team.find(Team.class, "name = ?", nameOfTeam.getText().toString());
        if (teams.size() > 0) {
            openDialogAlreadyExists();
        } else {
            Toast.makeText(this, "No it is", Toast.LENGTH_SHORT).show();
        }
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
}
