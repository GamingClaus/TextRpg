package gamingclaus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CoinSystem {
    private Random random;
    private QuestModel questModel;
    private MonsterModel monsterModel;
    private int coin_count;
    private final int max_coin_count;
    private final int min_coin_count;
    private List<Integer> numbers_gap;
         
    //in starting player has a coin count of 50;
    
    CoinSystem(){
        this.coin_count = 50;
        this.min_coin_count = 0;
        this.max_coin_count = 99999999;
        this.numbers_gap = new ArrayList<>();
        coinspawner();
    }



    public int coinspawner(){ 
        random = new Random();
        for(int i =5; i<= 500;i +=5){
            numbers_gap.add(i);
        }
        int coin_random_spawner = random.nextInt(numbers_gap.size());
        return numbers_gap.get(coin_random_spawner);
    }

    public void addCoins(int coin_amount_add){ // for adding coins for the player 
        if(coin_count + coin_amount_add <= max_coin_count  ){
            coin_count += coin_amount_add; // coin_count = coin_count+ coin_amount_add;
            System.out.println("Now your balance is " + coin_count);
        }
        else{
            coin_count = max_coin_count;
        }
    }

    public void removeCoins(int coin_amount_remove){  //for removing the coins of the player
        if(coin_count - coin_amount_remove > min_coin_count  ){
            coin_count -= coin_amount_remove; // coin_count = coin_count - coin_amount_remove;
            System.out.println("Now your balance is " + coin_count);
        }
        else{
            coin_count = min_coin_count;
        }
    }





}
