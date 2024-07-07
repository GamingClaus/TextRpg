package gamingclaus;

import java.util.HashMap;

public class ItemSystem {
    private int id;
    private String item_name;
    private String item_type;
    
    ItemSystem(int id,String item_name,String item_type ){
        this.id = id;
        this.item_name = item_name;
        this.item_type = item_type;
    }

    //Getters

    public int getId(){
        return id;
    }

    public String getItemName(){
        return item_name;
    }

    public String getItemtype(){
        return item_type;
    }


    @Override
    public String toString(){
        return "Items\n"+ "Id:"+id + " Item Name:"+item_name+ " Item Type:"+item_type;
        
    }

    
}

