package com.example.designpatterns.chainOfResponsibility;

public class Rs50Dispenser implements DispenseChain {

    private DispenseChain chain;

    public static final int dispensedAmount  = 50;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency curr) {
        if(curr.getAmount() >= dispensedAmount) {
            int num = curr.getAmount()/dispensedAmount;
            int remainder = curr.getAmount() % dispensedAmount;
            System.out.println("Dispensing "+num+" "+dispensedAmount+ "note");
            if(remainder !=0) this.chain.dispense(new Currency(remainder));
        } else {
            this.chain.dispense(curr);
        }
    }
}
