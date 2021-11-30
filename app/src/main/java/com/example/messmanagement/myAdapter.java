package com.example.messmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {
    Context context;
    ArrayList<memberModel>arrayList;

    public myAdapter(Context context, ArrayList<memberModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public myAdapter() {
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_member,parent,false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        memberModel m = arrayList.get(position);
        holder.numbering.setText(String.valueOf(position+1)+" . ");
        holder.name.setText("Name : "+m.getName());
        holder.amount.setText("Balance : "+m.getAmount());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{
        TextView numbering,name,amount;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
