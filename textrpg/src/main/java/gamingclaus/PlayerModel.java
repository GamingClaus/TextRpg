package gamingclaus;

import java.util.Scanner;

public class PlayerModel {
    private String Boy;
    private String Girl;
    Scanner scanner;
    
    PlayerModel(){
        scanner = new Scanner(System.in);

    
       
    }
    
    public String PlayerType(){
        System.out.println("Enter your Player Model(Boy/Girl):");
        String playertype = scanner.nextLine();
        return playertype;
    }
}

