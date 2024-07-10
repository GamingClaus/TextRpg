package gamingclaus;

import java.util.Random;
import java.util.Scanner;

public class MonsterModel {
    ItemManager itemManager = new ItemManager();
    private CoinSystem coinSystem = new CoinSystem();
    private String monster_name;
    private String monster_rarirty; //like common ,uncommon,rare or boss
    private Inventory inventory;
    private Scanner scanner;
    private String choice;
    private Random random;
    
    MonsterModel(Inventory inventory,CoinSystem coinSystem){ 
        this.coinSystem = coinSystem; //constructor to pass the inventory when ever the inventory is used
        this.inventory = inventory;
        scanner = new Scanner(System.in);
        

    }
    

    public void encounter() throws InterruptedException{
        System.out.println("You found a monster!");
        Thread.sleep(1000);
        System.out.println("Fight or Run?");
        choice = "";
         //loops until the user has given fight or run command
        while(!choice.equalsIgnoreCase("fight") && !choice.equalsIgnoreCase("run")){
        choice = scanner.nextLine();
        }

        
        if (choice.equalsIgnoreCase("fight")) {
            random = new Random();
            int battle = random.nextInt(100);//generates random number between 1 and 2;
            int randomitem = random.nextInt(itemManager.getSize());
            if(battle<80){
                //battling the monster has a 80% chance of defeating the monster
                ItemSystem item = itemManager.getItemById(randomitem);
                System.out.println("You defeated the monster!! It Dropped "+ itemManager.getItemNameById(randomitem));
                inventory.addItemtoInventory(item);
                Thread.sleep(850);
                System.out.println("You picked "+ item.getItemName()+" and added it to inventory");
                Thread.sleep(550);
                int coinmanager = coinSystem.coinspawner();
                System.out.println("You also got " + coinmanager +" coins and kept it in bag");
                coinSystem.addCoins(coinmanager);
                System.out.println("Then you went your own way.!");
                Thread.sleep(2000);
                System.out.print("\033[H\033[2J");

            }
            else{
                System.out.println("You were killed by the monster :(");
                Thread.sleep(500);
                int coinmanager = coinSystem.coinspawner();
                System.out.println("You dropped " + coinmanager + " coins");
                coinSystem.removeCoins(coinmanager);
                System.out.println("You were sent back to spawn!");
                Thread.sleep(2000);
                System.out.print("\033[H\033[2J");
            }
        }
        
        
        if (choice.equalsIgnoreCase("run")) {
            random = new Random();
            int flee = random.nextInt(100);//generates random number between 1 and 2;
            if(flee<90){
                //flee has a 90% chance of actually fleeing from the monster
                System.out.println("You ran away Successfully!!");
                Thread.sleep(1500);
                System.out.print("\033[H\033[2J");
                
            }
            else{
                //else you were killed by the monster
                System.out.println("You were killed by the monster :(");
                Thread.sleep(500);
                System.out.println("You were sent back to spawn!");
                Thread.sleep(1500);
                System.out.print("\033[H\033[2J");
            }
        }

    }
}

    

