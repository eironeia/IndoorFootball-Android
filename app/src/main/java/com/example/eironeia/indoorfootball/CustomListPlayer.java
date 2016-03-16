package com.example.eironeia.indoorfootball;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListPlayer extends ArrayAdapter<Player> {
    public CustomListPlayer(Context context, List<Player> player) {
        super(context, 0, player);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Player player = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_player, parent, false);
        }
        // Lookup view for data population
        TextView namePlayer = (TextView) convertView.findViewById(R.id.namePlayer);
        TextView teamPlayer = (TextView) convertView.findViewById(R.id.nameTeam);
        // Populate the data into the template view using the data object
        namePlayer.setText(player.getName());
        teamPlayer.setText(player.getteamPlayer());
        // Return the completed view to render on screen
        return convertView;
    }
}
