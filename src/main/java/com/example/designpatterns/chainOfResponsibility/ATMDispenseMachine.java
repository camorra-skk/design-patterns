package com.example.designpatterns.chainOfResponsibility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ATMDispenseMachine {

    private DispenseChain c1;

    ATMDispenseMachine() {
        this.c1 = new Rs50Dispenser();
        DispenseChain c2 = new Rs20Dispenser();
        DispenseChain c3 = new Rs10Dispenser();

        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }

    public static void main(String[] args) {
        ATMDispenseMachine atmDispenseMachine = new ATMDispenseMachine();

//        while (true) {
            int amount = 120;
            if(amount %10 != 0) {
                log.info("Not able to dispense");
                return;
            } else {
                log.info("Inside else part");
                atmDispenseMachine.c1.dispense(new Currency(amount));
            }
//        }
    }


}
