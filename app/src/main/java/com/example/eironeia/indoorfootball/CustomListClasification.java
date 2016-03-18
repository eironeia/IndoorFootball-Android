package com.example.eironeia.indoorfootball;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListClasification extends ArrayAdapter<Team> {
    public CustomListClasification(Context context, List<Team> teams) {
        super(context, 0, teams);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Team team = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_clasification_list, parent, false);
        }

        TextView posList = (TextView) convertView.findViewById(R.id.positionClasificationNumber);
        TextView nameTeam = (TextView) convertView.findViewById(R.id.nameTeamClasification);
        TextView numberPoints = (TextView) convertView.findViewById(R.id.pointsNumber);
        TextView numberWons = (TextView) convertView.findViewById(R.id.winsNumber);
        TextView numberTieds = (TextView) convertView.findViewById(R.id.tiedNumber);
        TextView numberLosts = (TextView) convertView.findViewById(R.id.lostNumber);
        // Populate the data into the template view using the data object
        nameTeam.setText(team.getName());
        numberPoints.setText(Long.toString(team.getScore()));
        numberWons.setText(Long.toString(team.getVictories()));
        numberTieds.setText(Long.toString(team.getDraws()));
        numberLosts.setText(Long.toString(team.getDefeats()));
        posList.setText(Integer.toString(position+1));


        // Return the completed view to render on screen
        return convertView;
    }
}
