package gamingclaus;

public class ShopItem {
    private int shop_item_id; // has the Id of the item which is unique
    private String shop_item_name; // has the name of the item 
    private int shop_item_price; // price of the item

    ShopItem(int shop_item_id,String shop_item_name,int shop_item_price){
        this.shop_item_id = shop_item_id;
        this.shop_item_name = shop_item_name;
        this.shop_item_price = shop_item_price;
       
    }
    
    public int getId(){
        return shop_item_id;
    }

    public String getItemName(){
        return shop_item_name;
    }

    public int getItemPrice(){
        return shop_item_price;
    }

   
    @Override 
    public String toString(){
        return "Id: "+shop_item_id+ "\t" + "Name: "+shop_item_name + "\t" + "Price: "+shop_item_price + "\t";
    } 


}
