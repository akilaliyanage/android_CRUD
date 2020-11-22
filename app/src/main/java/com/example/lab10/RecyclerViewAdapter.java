package com.example.lab10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab10.database.MessageData;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<MessageData> messageData = new ArrayList<MessageData>();
    private Context mContext;
    private  OnNoteListner listner;

    public RecyclerViewAdapter(ArrayList<MessageData> messageData, Context mContext,OnNoteListner onNoteListner) {
        this.messageData = messageData;
        this.mContext = mContext;
        this.listner = onNoteListner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view,listner);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, final int position) {
        holder.subject.setText(String.valueOf(messageData.get(position).getSubject()));
        holder.message.setText(String.valueOf(messageData.get(position).getMessage()));

    }

    @Override
    public int getItemCount() {
        return messageData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView subject,message;
        RelativeLayout layout;
        OnNoteListner onNoteListner;

        public ViewHolder(@NonNull View itemView,OnNoteListner onNoteListner) {
            super(itemView);
            subject = itemView.findViewById(R.id.heading);
            message = itemView.findViewById(R.id.heading2);
            this.onNoteListner = onNoteListner;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNoteListner.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListner{
        void onNoteClick(int position);
    }
}
