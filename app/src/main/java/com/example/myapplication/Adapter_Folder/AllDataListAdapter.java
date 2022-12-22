package com.example.myapplication.Adapter_Folder;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Data_Folder.AlldataList;
import com.example.myapplication.R;

import java.util.List;

public class AllDataListAdapter extends RecyclerView.Adapter<AllDataListAdapter.Holder> {

    private List<AlldataList> dataList;
    private Context context;

    public AllDataListAdapter(Context context, List<AlldataList> dataList) {
        this.context = context;
        this.dataList = dataList;
    }


    @Override
    public int getItemCount() {
        if (dataList == null)
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
            Fishbowl = itemView.findViewById(R.id.textFishbowl);
        }
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alldata, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        AlldataList item = dataList.get(position);

        holder.date.setText(item.getDate());

        holder.time.setText(item.getTime());
        holder.temper.setText(item.getTemper());
        holder.ph.setText(item.getPh());
        holder.light.setText(item.getLight());
        holder.Fishbowl.setText(item.getFishbowl());

        double temper = Double.parseDouble(item.getTemper());
        double fishbowl = Double.parseDouble(item.getFishbowl());
        double ph = Double.parseDouble(item.getPh());
        double light = Double.parseDouble(item.getLight());


        if (temper < 23 || temper > 21) {
            holder.temper.setBackgroundColor(Color.parseColor("#964b00"));
        }


        if (fishbowl < 200 || fishbowl > 800) {
            holder.Fishbowl.setBackgroundColor(Color.parseColor("#964b00"));
        }
        if (ph < 3 || ph > 6) {
            holder.ph.setBackgroundColor(Color.parseColor("#964b00"));

        }
        if (light < 30 || light > 70) {
            holder.light.setBackgroundColor(Color.parseColor("#964b00"));

        }


    }
}