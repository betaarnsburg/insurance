package com.example.backendinsurance.components.lottory;

public class DispenseState implements LottoState{
    RaffleActivity activity;

    public DispenseState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void reduceMoney() {
        System.out.println("Keine Gelder ausgeben!");
    }

    @Override
    public boolean raffle() {
        System.out.println("Nicht Lotto ziehen!");
        return false;
    }

    @Override
    public void dispensePrize() {
        if(activity.getCounter() > 0) {
            System.out.println("Herzlichen Glückwunsch!");
            activity.setLottoState(activity.getNoRaffleState());
        }else{
            System.out.println("Leider alle Belohnung schon ausgegeben!");
            activity.setLottoState(activity.getDispensOutState());
        }

    }
}
