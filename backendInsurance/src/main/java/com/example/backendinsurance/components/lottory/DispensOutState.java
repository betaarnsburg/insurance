package com.example.backendinsurance.components.lottory;

public class DispensOutState implements LottoState{
    RaffleActivity activity;

    public DispensOutState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void reduceMoney() {
        System.out.println("Bis nächstes Mal!");
    }

    @Override
    public boolean raffle() {
        System.out.println("Bis nächstes Mal!");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("Bis nächstes Mal!");
    }
}
