package gamingclaus;

import java.util.Random;
import java.util.Scanner;

public class AdventureModel {
    TextAdventure textAdventure = new TextAdventure();
    MonsterModel monsterModel = new MonsterModel();
    QuestModel questmodel = new QuestModel();
    ItemManager itemManager = new ItemManager();
    Scanner scanner;
    Random random;
    AdventureModel(){



    }
    //List of basic Commands for tpg
    public void Go() throws InterruptedException{
        System.out.println( "You Started Adventuring!!" );
        Thread.sleep(1000);
        System.out.println(".");
        Thread.sleep(1000);
        System.out.println("..");        
        Thread.sleep(1000);
        System.out.println("...");
        Thread.sleep(1000);
        random = new Random();
        int paths = random.nextInt(3);
        int randomitem = random.nextInt(itemManager.getSize()+1); // gets the max number from the map adding 1 to it
        switch (paths) {
            case 0:
                questmodel.getquest();
                break;
            case 1:
                monsterModel.encounter();
                break;
            case 2:
                scanner = new Scanner(System.in);
                randomitem = random.nextInt(itemManager.getSize()+1);
                System.out.println("You found a " + itemManager.getItemById(randomitem));
                Thread.sleep(1000);
                System.out.println("Do you want to Keep?(Yes/No)");
                String userchoose = scanner.nextLine();

                while(!userchoose.equalsIgnoreCase("Yes") && !userchoose.equalsIgnoreCase("No")){
                    userchoose = scanner.nextLine();
                }
                
                if(userchoose.equalsIgnoreCase("Yes")){
                    System.out.println("You kept " + itemManager.getItemById(randomitem));
                    Thread.sleep(1000);
                    System.out.print("\033[H\033[2J");
                }
                else{
                    System.out.println("You didn't keep " + itemManager.getItemById(randomitem) );
                    Thread.sleep(1000);
                    System.out.print("\033[H\033[2J");
                }
               
                break;
        }

        
        
    }

    public void Take () throws InterruptedException{
        System.out.println( "You took an item." );
        Thread.sleep(1000);
        System.out.print("\033[H\033[2J");

    }
    public void Drop() throws InterruptedException{
        System.out.println( "You dropped an item.!!" );
        Thread.sleep(1000);
        System.out.print("\033[H\033[2J");

    }
    public void  Use() throws InterruptedException{
        System.out.println( "You used an item." );
        Thread.sleep(1000);
        System.out.print("\033[H\033[2J");

    }
    public void  Exit(){
        System.out.println( "You exited the game!!!" );
        System.exit(0);
    }
    
}
