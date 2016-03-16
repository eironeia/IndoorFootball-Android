package com.example.eironeia.indoorfootball;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomListTeam extends ArrayAdapter<Team> {
    public CustomListTeam(Context context, List<Team> teams) {
        super(context, 0, teams);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Team team = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_team, parent, false);
        }
        // Lookup view for data population
        TextView nameTeam = (TextView) convertView.findViewById(R.id.nameoftheteam);
        TextView cityTeam = (TextView) convertView.findViewById(R.id.nameofthecity);
        // Populate the data into the template view using the data object
        nameTeam.setText(team.getName());
        cityTeam.setText(team.getCity());
        // Return the completed view to render on screen
        return convertView;
    }
}
