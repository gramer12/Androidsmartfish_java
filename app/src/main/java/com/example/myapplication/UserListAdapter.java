package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.Holder> {

    private List<UserInfo1> dataList;
    private Context context;
    private String sensorName;
    public UserListAdapter( Context context,List<UserInfo1> dataList,String sensorname ) {
        this.dataList = dataList;
        this.context = context;
        this.sensorName = sensorname;

    }
    @Override
    public int getItemCount() {
        try {
            return dataList.size();
        }catch (Exception e){
            Log.e("gello",""+e);
            return 0;
        }

    }

    public class Holder extends RecyclerView.ViewHolder {

        private TextView date;
        private TextView time;
        private TextView data;

        public Holder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.textDate);
            time = itemView.findViewById(R.id.textTime);
            data = (TextView) itemView.findViewById(R.id.sensorData);

        }
    }


    @NonNull
    @Override
    public UserListAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, parent, false);
        return new UserListAdapter.Holder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.Holder holder, int position) {
        UserInfo1 item = dataList.get(position);

        holder.date.setText(item.getDate());
        holder.time.setText(item.getTime());
        switch (sensorName){
            case "temper":
                holder.data.setText(item.getTemper());
                break;
            case "fishbowl":
                holder.data.setText(item.getFishbowl());
                break;
            case "light":
                holder.data.setText(item.getLight());
                break;
            case "ph":
                holder.data.setText(item.getPh());
                break;
        }


    }

}