package com.arun.didemo.SOLID.OpenClosedPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClaimApprovalManager {

    private InsuranceClaimSurveyor healthInsuranceClaimSurveyor;
    private InsuranceClaimSurveyor vehicleInsuranceClaimSurveyor;

    @Autowired
    public ClaimApprovalManager(InsuranceClaimSurveyor healthInsuranceClaimSurveyor, InsuranceClaimSurveyor vehicleInsuranceClaimSurveyor) {
        this.healthInsuranceClaimSurveyor = healthInsuranceClaimSurveyor;
        this.vehicleInsuranceClaimSurveyor = vehicleInsuranceClaimSurveyor;
    }

    public void processHealthClaim() {
        boolean validClaim = healthInsuranceClaimSurveyor.isValidClaim();
        if (validClaim) {
            System.out.println("Approved");
        }
    }

    public void processVehicleClaim() {
        boolean validClaim = vehicleInsuranceClaimSurveyor.isValidClaim();
        if (validClaim) {
            System.out.println("Approved");
        }
    }
}
