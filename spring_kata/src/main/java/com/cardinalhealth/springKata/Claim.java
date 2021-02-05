package com.cardinalhealth.springKata;

public class Claim {
    private final int id;
    private final String patientName;
    private final int amount;

    public Claim(int id, String patientName, int amount){
        this.id = id;
        this.patientName = patientName;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getAmount() {
        return amount;
    }
}
