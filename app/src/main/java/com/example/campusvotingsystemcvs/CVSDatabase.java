package com.example.campusvotingsystemcvs;

import com.google.firebase.database.FirebaseDatabase;

public class CVSDatabase {


    private static FirebaseDatabase mDatabase;

    public static FirebaseDatabase getDatabase() {
        if (mDatabase == null) {
            mDatabase = FirebaseDatabase.getInstance();
            mDatabase.setPersistenceEnabled(true);
            // ...
        }

        return mDatabase;

    }
}
