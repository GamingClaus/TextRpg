package gamingclaus;

import java.util.Random;
import java.util.Scanner;

public class MonsterModel {

    private String monster_name;
    private String monster_rarirty; //like common ,uncommon,rare or boss
    Scanner scanner;
    String choice;
    Random random;
    MonsterModel(){
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
            if(battle<80){
                //battling the monster has a 80% chance of defeating the monster

                System.out.println("You defeated the monster!! It Dropped an Item.");
                Thread.sleep(850);
                System.out.println("You picked it up.");
                Thread.sleep(550);
                System.out.println("Then you went your own way.!");

            }
            else{
                System.out.println("You were killed by the monster :(");
                Thread.sleep(500);
                System.out.println("You were sent back to spawn!");
            }
        }
        
        
        if (choice.equalsIgnoreCase("run")) {
            random = new Random();
            int flee = random.nextInt(100);//generates random number between 1 and 2;
            if(flee<90){
                //flee has a 90% chance of actually fleeing from the monster
                System.out.println("You ran away Successfully!!");
                
            }
            else{
                //else you were killed by the monster
                System.out.println("You were killed by the monster :(");
                Thread.sleep(500);
                System.out.println("You were sent back to spawn!");
            }
        }
     }
        

}

    

