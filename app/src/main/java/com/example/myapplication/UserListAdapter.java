package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.Holder> {

    ArrayList<UserInfo> items = new ArrayList<>();

    public UserListAdapter(ArrayList<UserInfo> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        UserInfo item = items.get(position);
        holder.profileImg.setImageDrawable(item.getProfile());
        holder.nameAge.setText(item.getName() + "(" + item.getAge() + ")");
        holder.about.setText(item.getAbout());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView profileImg;
        private TextView nameAge;
        private TextView about;
        public Holder(@NonNull View itemView) {
            super(itemView);
            profileImg = itemView.findViewById(R.id.profile_img);
            nameAge = itemView.findViewById(R.id.name_age);
            about = itemView.findViewById(R.id.about);
        }
    }
}