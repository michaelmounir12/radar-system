package org.example.entities;

import java.util.List;

public class Fine {
    private String plateNumber;
    private List<Violation> violations;

    public Fine(String plateNumber,List<Violation> violations){
        this.plateNumber=plateNumber;
        this.violations=violations;
    }
    public String getPlateNumber() {
        return plateNumber;
    }

    public List<Violation> getViolations() {
        return violations;
    }

    public double getTotalAmount() {
        double total = 0;
        for (Violation v : violations) {
            total += v.getFee();
        }
        return total;
    }
    public void printFine(){
        double totalAmount=0;
        for(Violation violation:violations){
            totalAmount+= violation.getFee();
        }
        System.out.println("traffic fine for car "+ plateNumber);
        System.out.println("total amount: " +String.valueOf(totalAmount));
        System.out.println("violations: ");
        for(Violation violation:violations) {
            System.out.println("- " +violation.getDescription() +": " + violation.getFee()+ " EGP");

        }
    }
}
