package com.example.eironeia.indoorfootball;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Eironeia on 15/3/16.
 */
public class ClasificationActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clasification_activity);
        updateClasificationList();
    }

    private void updateClasificationList(){
        // Construct the data source
        List<Team> arrayOfTeam = Team.findWithQuery(Team.class, "Select * from team ORDER BY score DESC");
        Toast.makeText(this,Integer.toString(arrayOfTeam.size()),Toast.LENGTH_SHORT).show();

        // Create the adapter to convert the array to views
        CustomListClasification adapter = new CustomListClasification(this, arrayOfTeam);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.listClasification);
        listView.setAdapter(adapter);
    }
}
