package gamingclaus;

import java.util.Random;

public class AdventureModel {
    TextAdventure textAdventure = new TextAdventure();
    MonsterModel monsterModel = new MonsterModel();
    QuestModel questmodel = new QuestModel();
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
        switch (paths) {
            case 0:
                questmodel.getquest();
                break;
            case 1:
                monsterModel.encounter();
                break;
            case 2:
                System.out.println("You found an item and you kept it inventory");
                break;
        }

        
        
    }

    public void Take (){
        System.out.println( "You took an item." );
    }
    public void Drop(){
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
