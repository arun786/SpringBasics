package com.arun.didemo.SOLID.OpenClosedPrincipal;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("health")
public class HealthInsuranceClaimSurveyor implements InsuranceClaimSurveyor {
    @Override
    public boolean isValidClaim() {
        System.out.println("Health Insurance claim valid");
        return true;
    }
}
