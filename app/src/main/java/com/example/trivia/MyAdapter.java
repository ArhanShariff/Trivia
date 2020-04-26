package com.example.trivia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<DataModel> dataModels;

    public MyAdapter(@NonNull Context context, ArrayList<DataModel> dataModels) {
        this.context = context;
        this.dataModels = dataModels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.trivia, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // set the data in items
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.name.setText("Name: " + dataModels.get(position).getName());
        myViewHolder.date.setText(dataModels.get(position).getDate());
        myViewHolder.cricketer.setText(dataModels.get(position).getCricketer());
        myViewHolder.flagColors.setText(dataModels.get(position).getFlagColor());
        myViewHolder.game.setText("GAME " + (position + 1));


    }
    @Override
    public int getItemCount() {
        return dataModels.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, date, cricketer, flagColors, game;// init the item view's
        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.name);
            date = (TextView) itemView.findViewById(R.id.date);
            cricketer = (TextView) itemView.findViewById(R.id.cricketerQuestion);
            flagColors = (TextView) itemView.findViewById(R.id.flagColorsQuestion);
            game = (TextView) itemView.findViewById(R.id.gameNumber);
        }
    }
}
