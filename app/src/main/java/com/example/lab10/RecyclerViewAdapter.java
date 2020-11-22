package com.example.lab10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab10.database.MessageData;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<MessageData> messageData = new ArrayList<MessageData>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<MessageData> messageData, Context mContext) {
        this.messageData = messageData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.subject.setText(String.valueOf(messageData.get(position).getSubject()));
        holder.message.setText(String.valueOf(messageData.get(position).getMessage()));
    }

    @Override
    public int getItemCount() {
        return messageData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView subject,message;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subject = itemView.findViewById(R.id.heading);
            message = itemView.findViewById(R.id.heading2);
        }
    }
}
