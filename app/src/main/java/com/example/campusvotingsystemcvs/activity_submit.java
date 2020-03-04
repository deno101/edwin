package com.example.campusvotingsystemcvs;

import android.os.Bundle;
import android.preference.TwoStatePreference;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.CollationElementIterator;
import java.util.ArrayList;

public class activity_submit extends AppCompatActivity {
    public class  ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        adapter=new MyAdapter(this,getCandidates());
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sb=new StringBuilder();
//                int i=0;
//                do {
//                    CandidateList candidateList=adapter.checkedCandidates.get(i);
//                    sb.append(candidateList.getName());
//                    if (i !=adapter.checkedCandidates.size()-1){
//                        sb.append("\n");
//                    }
//                    i++;
//
//                }while (i < adapter.checkedCandidates.size());
//                if (adapter.checkedCandidates.size()>0){
//                    Toast.makeText(activity_submit.this,sb.toString(),Toast.LENGTH_SHORT) .show();
//
//                }else{
//                    Toast.makeText(activity_submit.this,"Please Check A Candidate First",Toast.LENGTH_SHORT) .show();
//                }
//            }
//        });
        //RECYCLER
        RecyclerView rv= findViewById(R.id.myRecycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());

        //SET ADAPTER
        rv.setAdapter(adapter);
    }
    //END

    public class CandidateList {
        private String name;
        private String admission;
        private boolean isSelected;

        public CandidateList(String name, String admission) {
            this.name = name;
            this.admission = admission;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAdmission() {
            return admission;
        }

        public void setAdmission(String admission) {
            this.admission = admission;
        }

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean b) {
        }
    }

    static class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
        activity_submit c;
        CandidateList[] candidates;
        ArrayList<CandidateList> checkedCandidates = new ArrayList<>();

        public MyAdapter(activity_submit c, CandidateList[] candidates) {
            this.c = c;
            this.candidates = candidates;

        }

        //VIEWHOLDER IS INITIATED
        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_model, null);
            View itemview = null;
            final MyHolder myHolder = new MyHolder(itemview);
            return myHolder;
        }
        @NonNull
        @Override
        public int getItemCount() {
            String TAG = new String();
            Log.d(TAG,"getItemCount:"+ checkedCandidates.size());
            return 0;
        }

        //DATA IS BOUND TO VIEWS
        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            final CandidateList candidate = candidates[position];
            holder.nameTxt.setText(candidate.getName());
            holder.nameTxt.setText(candidate.getAdmission());
            holder.myCheckBox.setChecked(candidate.isSelected());

            holder.setItemOnClickListener(new MyHolder.ItemClickListener() {
            });

        }

        public static class MyHolder extends RecyclerView.ViewHolder {
            public CollationElementIterator nameTxt;
            public TwoStatePreference myCheckBox;

            public MyHolder(View itemView) {
                super(itemView);
            }

            public void setItemOnClickListener(ItemClickListener itemClickLIstener) {
            }

            public static class ItemClickListener {
                private CandidateList[] candidates;
                private ArrayList<CandidateList> checkedCandidates;

                public void onItemClick(View v, int pos) {
                    CheckBox myCheckBox = (CheckBox) v;
                    CandidateList currentCandidate = candidates[pos];
                    if (myCheckBox.isChecked()) {
                        currentCandidate.setSelected(true);
                        checkedCandidates.add(currentCandidate);
                    } else if (!myCheckBox.isChecked()) {
                        currentCandidate.setSelected(false);
                        checkedCandidates.remove(currentCandidate);
                    }
                }
            }
        }
    }

    static class MyHolder extends RecyclerView.ViewHolder implements OnClickListener, com.example.campusvotingsystemcvs.MyHolder {
        TextView nameTxt, posTxt;
        CheckBox myCheckBox;

        ItemClickListener itemClickListener;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            nameTxt = itemView.findViewById(R.id.nameTextView);
            nameTxt = itemView.findViewById(R.id.admissionTextView);
            myCheckBox = itemView.findViewById(R.id.myCheckBox);

            myCheckBox.setOnClickListener((OnClickListener) this);

        }

        @Override
        public void setItemClickListener(ItemClickListener ic) {
            this.itemClickListener = ic;
        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick(v, getLayoutPosition());
        }

    }


    public CandidateList[] getCandidates(){
        return new CandidateList[]{
                new CandidateList("luceno","001"),
                new CandidateList("amalemba" ,"002")

        };

    }
    StringBuilder sb=null;
    MyAdapter adapter;

}


