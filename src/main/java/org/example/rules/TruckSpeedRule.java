package org.example.rules;

import org.example.entities.Observation;
import org.example.enums.CarType;

public class TruckSpeedRule implements Rule {
    private double speedLimit = 60;

    @Override
    public boolean violated(Observation observation) {
        if (observation.getCarType() != CarType.TRUCK) return false;
        return observation.getSpeed() > getSpeedLimit();
    }

    @Override
    public double getFee() {
        return 300;
    }

    @Override
    public String getViolationDescription(Observation observation) {
        return "speed of " + (int) observation.getSpeed()
                + " exceeded max allowed " + (int) getSpeedLimit();
    }

    public double getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(double speedLimit) {
        this.speedLimit = speedLimit;
    }
}