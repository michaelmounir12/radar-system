package org.example.rules;

import org.example.entities.Observation;

public interface Rule {
    boolean violated(Observation observation);
    double getFee();
    String getViolationDescription(Observation observation);
}
