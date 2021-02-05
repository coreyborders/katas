package com.cardinalhealth.springKata;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ClaimService {
    private final HashMap<Integer, Claim> claimMap = new HashMap();

    public ClaimService(){
        claimMap.put(0, new Claim(0, "Bob", 2));
    }

    public Claim getClaim(int id) {
        return claimMap.get(id);
    }

    public Claim saveClaim(int id, String patientId, int amount) {
        return null;
    }
}
