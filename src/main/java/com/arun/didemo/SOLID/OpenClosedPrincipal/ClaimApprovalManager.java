package com.arun.didemo.SOLID.OpenClosedPrincipal;

import org.springframework.stereotype.Component;

@Component
public class ClaimApprovalManager {

    public void processClaim(InsuranceClaimSurveyor insuranceClaimSurveyor) {
        boolean validClaim = insuranceClaimSurveyor.isValidClaim();
        if (validClaim) {
            System.out.println("Approved claim");
        }
    }
}
