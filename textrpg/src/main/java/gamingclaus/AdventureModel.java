package gamingclaus;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class AdventureModel {
    TextAdventure textAdventure = new TextAdventure();
    CoinSystem  coinSystem = new CoinSystem();
    Inventory inventory;
    MonsterModel monsterModel;
    QuestModel questmodel;
    Shop shop;
    ItemManager itemManager = new ItemManager();
    Scanner scanner;
    Random random;
    AdventureModel(){
        inventory = new Inventory();
        monsterModel = new MonsterModel(inventory,coinSystem);
        questmodel = new QuestModel(inventory,coinSystem);
        shop = new Shop (inventory,coinSystem);
       
        

    }
    //List of basic Commands for tpg
    public void Go() throws InterruptedException{
        System.out.println( "You Started Adventuring!!" );
        //Thread.sleep(1000);
        //System.out.println(".");
        //Thread.sleep(1000);
        //System.out.println("..");        
        //Thread.sleep(1000);
        //System.out.println("...");
        //Thread.sleep(1000);
        random = new Random();
        int paths = random.nextInt(3);
        int randomitem = random.nextInt(itemManager.getSize()); // gets the max number from the map adding 1 to it
        switch (paths) {
            case 0:
                questmodel.getquest();
                break;
            case 1:
                monsterModel.encounter();
                break;
            case 2:
                scanner = new Scanner(System.in);
                randomitem = random.nextInt(itemManager.getSize());
                System.out.println("You found " + itemManager.getItemNameById(randomitem));
                Thread.sleep(1000);
                System.out.println("Do you want to Keep?(Yes/No)");
                String userchoose = scanner.nextLine();

                while(!userchoose.equalsIgnoreCase("Yes") && !userchoose.equalsIgnoreCase("No")){
                    userchoose = scanner.nextLine();
                }
                
                if(userchoose.equalsIgnoreCase("Yes")){
                    ItemSystem item = itemManager.getItemById(randomitem);
                    System.out.println("You have successfully kept " + item.getItemName()+ " in the inventory." );
                    inventory.addItemtoInventory(item);
                    Thread.sleep(1000);
                    System.out.print("\033[H\033[2J");
                }
                else{
                    System.out.println("You didn't keep " + itemManager.getItemNameById(randomitem) );
                    Thread.sleep(1000);
                    System.out.print("\033[H\033[2J");
                }
                break;

            }

       
    }

    public void Inventory () throws InterruptedException{
        inventory.displayInventory();
        //Thread.sleep(2500);
    }

    public void Throw() throws InterruptedException{
        try {
            scanner = new Scanner(System.in);
            System.out.println("\nEnter the row and column of the item which you wanna throw away.");
            System.out.print("Enter Row:");
            int inventory_row = scanner.nextInt();
            System.out.print("Enter Column:");
            int inventory_column = scanner.nextInt();
            inventory.removeItemfromInventory(inventory_row, inventory_column);
            Thread.sleep(1500);
            System.out.print("\033[H\033[2J");
        } catch (InputMismatchException e) {
            System.out.println("Invalid Type/ Put in an Integer");
        }
    

    }

    public void Wallet() throws InterruptedException{
        System.out.println("Your current balance is "+ coinSystem.currentCoins() + " Coins.");
    
    }

    public void ShopBuy() throws InterruptedException{
        shop.buyItem();
    }
    
    public void ShopSell() throws InterruptedException{
        shop.sellItem();
    }

    public void  Exit(){
        System.out.println( "You exited the game!!!" );
        System.exit(0);
    }
}


