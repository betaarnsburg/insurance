package com.example.backendinsurance.components.lottory;

public class NoRaffleState implements LottoState{
    RaffleActivity activity;

    public NoRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void reduceMoney() {
        System.out.println("Gelder ausgeben");
        activity.setLottoState(activity.getCanRaffleState());
    }

    @Override
    public boolean raffle() {
        System.out.println("Darf nicht Lotto ziehen!");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("Keine Belohnung!");
    }
}
