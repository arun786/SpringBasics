package com.arun.didemo.SOLID.OpenClosedPrincipal;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("vehicle")
public class VehicleInsuranceClaimSurveyor implements InsuranceClaimSurveyor {
    @Override
    public boolean isValidClaim() {
        System.out.println("Vehicle claim validated");
        return true;
    }
}
