package gamingclaus;

import java.util.HashMap;

public class ItemManager {
    private HashMap<Integer,ItemSystem> items; 
    ItemManager(){
        items = new HashMap<>();
        itemMap();
    }


    private void itemMap(){
        items.put(1,new ItemSystem(1, "a Sword", "Weapon"));
        items.put(2,new ItemSystem(2, "an Apple", "Food"));
        items.put(3,new ItemSystem(3, "Water", "Food"));
        items.put(4,new ItemSystem(4, "Seeds", "Food"));
        items.put(5,new ItemSystem(5, "a Potion", "Heal"));
    }


    public String getItemById(int id){
        ItemSystem item = items.get(id);
        if(item!=null){
            return item.getItemName();

        }
        else{
            return null;
        }

    }

    public int getSize(){
        return items.size();
    }


}



