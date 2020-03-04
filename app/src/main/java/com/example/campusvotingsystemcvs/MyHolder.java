package com.example.campusvotingsystemcvs;

import android.view.View;

interface MyHolder {
    void setItemClickListener(ItemClickListener ic);

    void onClick(View v);

    public interface ItemClickListener {
        void onItemClick(View v, int pos);
    }
}
