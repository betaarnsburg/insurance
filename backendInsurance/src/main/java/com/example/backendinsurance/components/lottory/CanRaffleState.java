package com.example.backendinsurance.components.lottory;

import java.util.Random;

public class CanRaffleState implements LottoState{
    RaffleActivity activity;

    public CanRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void reduceMoney() {
        System.out.println("Gelder schon ausgegeben!");
    }

    @Override
    public boolean raffle() {
        System.out.println("Ziehen...");
        Random random = new Random();
        int num = random.nextInt(10);
        if (num == 0) {
            activity.setLottoState(activity.getDispenseState());
            return true;
        }else{
            System.out.println("Leider nichts gewinnen!");
            activity.setLottoState(activity.getNoRaffleState());
            return false;
        }
    }

    @Override
    public void dispensePrize() {
        System.out.println("Keine Belohnung!");
    }
}
