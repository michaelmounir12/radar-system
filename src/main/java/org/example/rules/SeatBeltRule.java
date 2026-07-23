package org.example.rules;

import org.example.entities.Observation;

public class SeatBeltRule implements Rule {

    @Override
    public boolean violated(Observation observation) {
        return !observation.isSeatbeltFastened();
    }

    @Override
    public double getFee() {
        return 100;
    }

    @Override
    public String getViolationDescription(Observation observation) {
        return "Seatbelt not fastned";
    }
}