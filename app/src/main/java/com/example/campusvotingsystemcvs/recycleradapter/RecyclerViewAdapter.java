package com.example.campusvotingsystemcvs.recycleradapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.campusvotingsystemcvs.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<String> candidateName;
    private ArrayList<String> admissionNumber;

    public RecyclerViewAdapter(ArrayList<String> candidateName, ArrayList<String> admissionNumber) {
        this.candidateName = candidateName;
        this.admissionNumber = admissionNumber;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_model,parent, false);
        return (new MyViewHolder(view));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // Function Responsible forpopulating each individual View
        MyViewHolder holder1 = (MyViewHolder) holder;
        holder1.candidate.setText(candidateName.get(position));
        holder1.admNo.setText(admissionNumber.get(position));
    }

    @Override
    public int getItemCount() {
        return Math.max(this.admissionNumber.size(), this.candidateName.size());
    }

    // Class Holding all components of the view
    public class MyViewHolder  extends RecyclerView.ViewHolder{

        public TextView candidate, admNo;
        public CheckBox checkBox;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.candidate = itemView.findViewById(R.id.nameTextView);
            this.admNo = itemView.findViewById(R.id.admissionTextView);
            this.checkBox = itemView.findViewById(R.id.myCheckBox);
        }
    }
}
