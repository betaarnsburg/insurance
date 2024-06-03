package com.example.backendinsurance.components.lottory;

public class ClientTest {
    public static void main(String[] args) {
        RaffleActivity activity = new RaffleActivity(1);

        for (int i = 0; i < 20; i++){
            System.out.println((i+1) + " mal Lotto ziehen");
            activity.reduceMoney();
            activity.raffle();
        }
    }
}
