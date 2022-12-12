package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserListAdapter3 extends RecyclerView.Adapter<UserListAdapter3.Holder> {

    ArrayList<UserInfo3> items = new ArrayList<>();

    public UserListAdapter3(ArrayList<UserInfo3> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person3, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        UserInfo3 item = items.get(position);
//        holder.profileImg.setImageDrawable(item.getProfile());
//        holder.nameAge.setText(item.getName() + "(" + item.getAge() + ")");
        holder.time.setText(item.getTime());
        holder.logData.setText(item.getLogData());



    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private TextView time;
        private TextView logData;
        private Button btn_delete;

        public Holder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.textTime);
            logData = itemView.findViewById(R.id.textLogData);
            btn_delete= itemView.findViewById(R.id.btn_delete);
        }
    }
}