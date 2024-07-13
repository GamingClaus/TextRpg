package gamingclaus;

import java.util.Scanner;

public class PlayerModel {
    private String Boy;
    private String Girl;
    Scanner scanner;
    
    final String ANSI_UNDERLINE = "\u001B[4m"; 
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_Bold = "\033[0;1m";

    
    PlayerModel(){
        scanner = new Scanner(System.in);

    
       
    }
    
    public String PlayerType(){
        System.out.println(ANSI_Bold + "Enter your Player Model(Boy/Girl):" + ANSI_RESET);
        String playertype = scanner.next();
        return playertype;
    }
}

