package org.example;

import org.example.entities.Fine;
import org.example.entities.Observation;
import org.example.entities.Violation;
import org.example.rules.Rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RadarSystem {
    private List<Rule> rules = new ArrayList<>();
    private List<Fine> fines = new ArrayList<>();
    private Map<String,Integer> violationsCount = new HashMap<>();
    public void addRule(Rule rule) {
        rules.add(rule);
    }
    public Fine handleObservation(Observation observation){
        List<Violation> violations = new ArrayList<>();

        for(Rule rule:rules){
            if(rule.violated(observation)){
                String desc = rule.getViolationDescription(observation);
                double fee = rule.getFee();
                violations.add(new Violation(desc,fee));
                violationsCount.put(rule.getClass().getSimpleName(),
                        violationsCount.getOrDefault(rule.getClass().getSimpleName(),0)+1);
            }
        }
        if(violations.isEmpty()) return null;
        Fine fine = new Fine(observation.getPlateNumber(), violations);
        fines.add(fine);
        return fine;

    }
    public List<Fine> getAllFines(){
        return fines;
    }
    public Map<String,Integer> getAllViolatedRules(){
        return violationsCount;
    }
}
