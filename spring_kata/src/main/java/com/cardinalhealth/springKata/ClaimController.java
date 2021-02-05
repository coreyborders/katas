package com.cardinalhealth.springKata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("claim")
public class ClaimController {
    private final ClaimService service;

    public ClaimController(@Autowired ClaimService service) {
        this.service = service;
    }

    @GetMapping
    public Claim getClaim(int id) {
        return null;
    }
}
