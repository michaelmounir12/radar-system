package org.example;

import org.example.entities.Fine;
import org.example.entities.Observation;
import org.example.enums.CarType;
import org.example.rules.PrivateSpeedRule;
import org.example.rules.SeatBeltRule;
import org.example.rules.TruckSpeedRule;

import java.time.LocalDateTime;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RadarSystem radar = new RadarSystem();
        radar.addRule(new PrivateSpeedRule());
        radar.addRule(new TruckSpeedRule());
        radar.addRule(new SeatBeltRule());

        Observation o1 = new Observation();
        o1.setPlateNumber("ABC1234");
        o1.setDate(LocalDateTime.now());
        o1.setCarType(CarType.PRIVATE);
        o1.setSpeed(94);
        o1.setSeatbeltFastened(false);

        Observation o2 = new Observation();
        o2.setPlateNumber("TRK555");
        o2.setDate(LocalDateTime.now());
        o2.setCarType(CarType.TRUCK);
        o2.setSpeed(50);
        o2.setSeatbeltFastened(true);

        Fine f1 = radar.handleObservation(o1);
        if (f1 != null) f1.printFine();

        Fine f2 = radar.handleObservation(o2);
        if (f2 != null) f2.printFine();
        else System.out.println("No violations for " +o2.getPlateNumber());

        System.out.println();
        System.out.println("All fines:");
        for(Fine fine:radar.getAllFines()){
            fine.printFine();
        }

        System.out.println();
        System.out.println("Violated rules count:");
        for (Map.Entry<String, Integer> entry : radar.getAllViolatedRules().entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

    }
}