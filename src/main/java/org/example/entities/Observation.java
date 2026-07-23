package org.example.entities;

import org.example.enums.CarType;

import java.time.LocalDateTime;

public class Observation {
    private String plateNumber;
    private LocalDateTime date;
    private CarType carType;
    private double speed;
    private boolean seatbeltFastened;

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public boolean isSeatbeltFastened() {
        return seatbeltFastened;
    }

    public void setSeatbeltFastened(boolean seatbeltFastened) {
        this.seatbeltFastened = seatbeltFastened;
    }
}
