package gamingclaus;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TextAdventure{
    public static void main(String[] args) throws InterruptedException {

        String[] listcommands = {"adventure","inventory","inventory_throw","use","commands","exit"};
        List<String> validcommands = Arrays.asList(listcommands); // converts the array into arraylist
        String playername = "";
        String playercommand = " ";

        final String ANSI_UNDERLINE = "\u001B[4m"; 
        final String ANSI_RESET = "\u001B[0m";
        Inventory inventory = new Inventory();
        CoinSystem coinSystem = new CoinSystem();
        AdventureModel adventureModel = new AdventureModel();
        PlayerModel playermodel = new PlayerModel();
        
        MonsterModel monsterModel = new MonsterModel(inventory,coinSystem);
        QuestModel questModel = new QuestModel(inventory,coinSystem);
        
        ItemManager itemManager = new ItemManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to The World Of Text-Based-Rpg Game!!!");
        Thread.sleep(1000);
        String player = playermodel.PlayerType();
        //checks the player if they have chosen a right player type
        while(!player.equalsIgnoreCase("Boy") && !player.equalsIgnoreCase("Girl")){
            System.out.println("Please Enter a Correct Type!!!");
            player = playermodel.PlayerType(); 
            
        }
         Thread.sleep(200);
         System.out.println("Enter your name:");
         playername = scanner.nextLine();
         System.out.println("Hello " + ANSI_UNDERLINE + playername + ANSI_RESET + " Welcome to the World of Text-Rpg."  );
        
       

        while(true){
            System.out.println("\nEnter What you Want to do:");
            playercommand = scanner.nextLine();
            playercommand.toLowerCase(); //switches the userinput to all lowercase

            //checks if the commands are valid ones

            if(validcommands.contains(playercommand))
            playercommand.toLowerCase(); //switches the userinput to all lowercase
            switch (playercommand) {
                case "commands":
                    System.out.println("The List of commands are: " + validcommands);
                    break;
                case "adventure":
                    adventureModel.Go();
                    Thread.sleep(500);
                    break;
                case "inventory":
                    adventureModel.Inventory();
                    break;
                case "inventory_throw":
                    adventureModel.Throw();
                    break;
                case "use":
                    adventureModel.Use();
                    break;
                case "exit":
                    adventureModel.Exit();
                    break;
                
                default:
                    break;
            }
        }
       
    }

}