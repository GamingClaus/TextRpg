package gamingclaus;

public class AdventureModel {
    TextAdventure textAdventure = new TextAdventure();
    AdventureModel(){



    }
    //List of basic Commands for tpg
    public void  Go(){
        System.out.println( "Starts Walking!!" );
    }

    public void  Take (){
        System.out.println( "You took an item." );
    }
    public void  Drop(){
        System.out.println( "You dropped an item.!!" );
    }
    public void  Use(){
        System.out.println( "You used an item." );
    }
    public void  Exit(){
        System.out.println( "You exited the game!!!" );
        System.exit(0);
    }
    
}
