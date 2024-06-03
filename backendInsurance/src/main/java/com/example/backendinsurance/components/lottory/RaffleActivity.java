package com.example.backendinsurance.components.lottory;


import lombok.Getter;
import lombok.Setter;

@Setter
public class RaffleActivity {

    @Getter
    LottoState lottoState = null;
    int counter = 0;

    @Getter
    LottoState noRaffleState = new NoRaffleState(this);
    @Getter
    LottoState canRaffleState = new CanRaffleState(this);
    @Getter
    LottoState dispenseState = new DispenseState(this);
    @Getter
    LottoState dispensOutState = new DispensOutState(this);

    public RaffleActivity(int counter){
        this.lottoState = getNoRaffleState();
        this.counter = counter;
    }
    public void reduceMoney(){
        lottoState.reduceMoney();
    }
    public void raffle(){
        if(lottoState.raffle()){
            lottoState.dispensePrize();
        }
    }

    public int getCounter() {
        int currentCounter = counter;
        counter--;
        return currentCounter;
    }

}
