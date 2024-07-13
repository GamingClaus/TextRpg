package gamingclaus;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Shop {
    private Map<Integer,ShopItem> shop_map;
    private Scanner scanner = new Scanner(System.in);
    private Inventory playerinventory = new Inventory();
    private CoinSystem playercoins = new CoinSystem();

    Shop(Inventory playerinventory,CoinSystem playercoins){
        shop_map = new HashMap<Integer,ShopItem>();
        this.playerinventory = playerinventory;
        this.playercoins = playercoins;
        shop_item_list();
    }

    private void shop_item_list(){
        shop_map.put(0, new ShopItem(1,"Apple",50));
        shop_map.put(1, new ShopItem(2,"Sword",100));
        shop_map.put(2, new ShopItem(3,"Potion",250));
        shop_map.put(3, new ShopItem(4,"Water",20));
    }


    private void shopdisplay(){
        System.out.println("Shop Items\n");
        System.out.println("Name"+ "\t" + "Price"+  "\t" +"Stock" + "\t");
        for(Map.Entry<Integer, ShopItem> entry : shop_map.entrySet()){
            ShopItem item = entry.getValue();
            System.out.println(item.getItemName() + "\t" + item.getItemPrice() + "\t");
        }
    }

    //for buying items by the players
    public void buyItem() throws InterruptedException{
        shopdisplay();
        Thread.sleep(1500);
        System.out.println("\nEnter the Name of the Item which you want to buy:");
        String choice = scanner.nextLine().toLowerCase();
        
        boolean itemfound = false;
        for(Map.Entry<Integer, ShopItem> entry : shop_map.entrySet())
        {
            ShopItem selecteditem = entry.getValue();
            if(selecteditem.getItemName().equalsIgnoreCase(choice)){
                itemfound = true;
                if(playercoins.currentCoins() >= selecteditem.getItemPrice()){
                    playerinventory.addItemtoInventory(new ItemSystem(selecteditem.getItemName()));
                    playercoins.removeCoins(selecteditem.getItemPrice()); // removes the coins from players wallet
                    System.out.println("You bought " + selecteditem.getItemName() + " for " + selecteditem.getItemPrice()+" Coins.");
                }
                else{
                    System.out.println("Not Enough Coins!");
                 }
            }     
        } 
        if(!itemfound){
            System.out.println("Invalid Item! Write the correct item name.");
        }
    }

    public void sellItem() throws InterruptedException{
        playerinventory.displayInventory();
        Thread.sleep(1500);
        System.out.println("\nEnter the Row And Column of the Item which you want to sell from your inventory:");
        
    try{ 
        System.out.print("Row of the item: ");
        int row = scanner.nextInt();
        System.out.print("Column of the item: ");
        int column = scanner.nextInt();

        ItemSystem item = playerinventory.returnItemFromInventory(row, column);{
            if(item!=null){
                //Shop shop = new Shop(playerinventory, playercoins);
                playerinventory.returnItemFromInventory(row, column);
                int Itemprice = this.getItemPrice(item.getItemName());
                int halfprice = Itemprice/2;
                playercoins.addCoins(halfprice);
                System.out.println("You sold " + item.getItemName() + " for " + halfprice + " coins.");
                playerinventory.removeItemfromInventory(row, column); // removes item from player inventory after the item is bought
                
            }

        } 
    }
    catch(InputMismatchException e){
        System.out.println("Try Putting in correct values!");
    }
    
}

    public int getItemPrice(String itemName){
        for(Map.Entry<Integer, ShopItem> entry : shop_map.entrySet()){
            ShopItem item = entry.getValue();
            if(item.getItemName().equalsIgnoreCase(itemName)){
                return item.getItemPrice();
            }
        }
        return 0;
        
    
    }






}

 