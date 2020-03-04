package com.example.campusvotingsystemcvs;

import java.util.ArrayList;

public class KeyStore {

    private String titleKey;
    private ArrayList<String> candidateKeyList;

    public KeyStore(String titleKey, ArrayList <String> candidateKeyList) {
        this.titleKey = titleKey;
        this.candidateKeyList = candidateKeyList;
    }

    public String getTitleKey() {
        return titleKey;
    }

    public void setTitleKey(String titleKey) {
        this.titleKey = titleKey;
    }

    public ArrayList <String> getCandidateKeyList() {
        return candidateKeyList;
    }

    public void setCandidateKeyList(ArrayList <String> candidateKeyList) {
        this.candidateKeyList = candidateKeyList;
    }
}
