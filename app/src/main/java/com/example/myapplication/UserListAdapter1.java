package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserListAdapter1 extends RecyclerView.Adapter<UserListAdapter1.Holder> {

    private List<UserInfo1> dataList;
    private Context context;

    public UserListAdapter1(Context context, List<UserInfo1> dataList) {
        this.context = context;
        this.dataList = dataList;
    }



    @Override
    public int getItemCount() {
        if(dataList==null)
            return 0;
        return dataList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private TextView date;
        private TextView time;
        private TextView temper;
        private TextView ph;
        private TextView light;
        private TextView Fishbowl;
        public Holder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.textDate);
            time = itemView.findViewById(R.id.textTime);
            temper = itemView.findViewById(R.id.textTemper);
            ph = itemView.findViewById(R.id.textPH);
            light = itemView.findViewById(R.id.textLight);
            Fishbowl=itemView.findViewById(R.id.textFishbowl);
        }
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person1, parent, false);
        return new Holder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        UserInfo1 item = dataList.get(position);

        holder.date.setText(item.getDate());
        holder.time.setText(item.getTime());
        holder.temper.setText(item.getTemper());
        holder.ph.setText(item.getPh());
        holder.light.setText(item.getLight());
        holder.Fishbowl.setText(item.getFishbowl());


    }


}