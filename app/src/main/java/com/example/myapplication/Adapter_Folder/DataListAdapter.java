package com.example.myapplication.Adapter_Folder;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Data_Folder.AlldataList;
import com.example.myapplication.R;

import java.util.List;

public class DataListAdapter extends RecyclerView.Adapter<DataListAdapter.Holder> {

    private List<AlldataList> dataList;
    private Context context;
    private String sensorName;
    public DataListAdapter(Context context, List<AlldataList> dataList, String sensorname ) {
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
    public DataListAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_datalist, parent, false);
        return new DataListAdapter.Holder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull DataListAdapter.Holder holder, int position) {
        AlldataList item = dataList.get(position);

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