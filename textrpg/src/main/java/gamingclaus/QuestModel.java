package gamingclaus;

import java.util.Random;
import java.util.Scanner;

public class QuestModel {
    private CoinSystem coinSystem;
    private Scanner scanner;
    private String choice;
    private Random random;
    private Inventory inventory;
    ItemManager itemManager = new ItemManager();
   
    QuestModel(Inventory inventory,CoinSystem coinSystem){
        this.coinSystem = coinSystem; // constructor to pass the inventory when ever the inventory is used
        this.inventory = inventory;
        scanner = new Scanner(System.in);
    }




    public void getquest() throws InterruptedException{
        Thread.sleep(700);
        System.out.println("You meet an Old man on the Way");
        Thread.sleep(1000);
        System.out.println("He seems like he wants to say something to you!");
        Thread.sleep(1000);
        System.out.println("You go in close to hear what the old man has to say");
        Thread.sleep(1000);
        System.out.println(" The Old Man Says : Can you do the quest please i am too old for it!!");
        System.out.println("What will you do??(Do/Run)");
        choice = "";
        while(!choice.equalsIgnoreCase("do") && !choice.equalsIgnoreCase("run")){
        choice = scanner.nextLine();
        }

        
        if (choice.equalsIgnoreCase("do")) {
            random = new Random();
            int battle = random.nextInt(100);//generates random number between 1 and 2;
            int randomitem = random.nextInt(itemManager.getSize());
            if(battle<60){
                //doing the quest has a 60% chance of completing the quest successfully
                ItemSystem item = itemManager.getItemById(randomitem);

                System.out.println("You Successfully Completed the quest.");
                Thread.sleep(1000);
                System.out.println("Old Man: Thank you!! My Dear Child here is your reward!");
                Thread.sleep(1000);
                int coinmanager = coinSystem.coinspawner();
                System.out.println("The Old man gave you " + item.getItemName() + "and" + coinmanager + " coins");
                coinSystem.addCoins(coinmanager);
                inventory.addItemtoInventory(item);
                System.out.println("You kept it in the inventory");
                Thread.sleep(1000);
                System.out.println("Then you went your own way.!");
                Thread.sleep(1500);
                System.out.print("\033[H\033[2J");
            }
            else{
                System.out.println("You messed up :(");
                Thread.sleep(500);
                System.out.println("You went back to adventure sadly!");
                Thread.sleep(1500);
                System.out.print("\033[H\033[2J");
                
            }
        }
        
        
        if (choice.equalsIgnoreCase("run")) {
            System.out.println("You hated your own weakness.So you ran away from the quest!");
            Thread.sleep(1000);
            System.out.print("\033[H\033[2J");
            }
    }
}
