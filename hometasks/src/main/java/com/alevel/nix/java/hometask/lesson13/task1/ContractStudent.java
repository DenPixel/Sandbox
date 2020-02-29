package com.alevel.nix.java.hometask.lesson13.task1;

public class ContractStudent extends Student {
    private double contractCost;

    ContractStudent(String fullName, int age, double contractCost){
        super(fullName, age);
        this.contractCost = contractCost;
    }

    public double getContractCost() {
        return contractCost;
    }
}
