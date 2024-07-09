package gamingclaus;

import java.util.HashMap;

public class ItemManager {
    private HashMap<Integer,ItemSystem> items; 
    ItemManager(){
        items = new HashMap<>();
        itemMap();
    }


    private void itemMap(){
        items.put(0,new ItemSystem(1, "Sword", "Weapon"));
        items.put(1,new ItemSystem(2, "Apple", "Food"));
        items.put(2,new ItemSystem(3, "Water", "Food"));
        items.put(3,new ItemSystem(4, "Seeds", "Food"));
        items.put(4,new ItemSystem(5, "Potion", "Heal"));
    }


    public ItemSystem getItemById(int id){
            return items.get(id);
        }

    public String getItemNameById(int id){
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



