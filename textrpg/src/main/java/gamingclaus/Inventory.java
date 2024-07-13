package gamingclaus;

import java.util.InputMismatchException;

public class Inventory {

    private ItemSystem[][] grid;
    private int rows = 3;
    private int columns = 3;

    Inventory(){
        grid = new ItemSystem[rows][columns];                                        
    }
    

    public boolean addItemtoInventory(ItemSystem item)
    {
        for(int i=0; i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                if(grid[i][j]==null)
                { //checks if the i and j are null or not.If it is then it adds an item
                    grid[i][j] = item;
                    return true;    //successfully adds an item
                }
            }
        }
        return false; //Inventory is full
    }

    public boolean useItemfromInventory(int row,int column){
        if(isValidPosition(row,column) && grid[row][column]!=null){
            System.out.println("Using the" + grid[row][column].getItemName()); 
            grid[row][column] = null; // makes the solt empty after the use
            return true; // sucessfully used item 
        }
        return false; // Invalid position or invalid slot
    }

    public void removeItemfromInventory(int row,int column)    {
        
        if(isValidPosition(row,column) && grid[row][column]!=null){
            String getname = grid[row][column].getItemName();
            grid[row][column] = null;
            //System.out.println("Sucessfully Removed "+ getname);// sucessfully removed item 
        }
        else{
            System.out.println("Invalid Position/Slot"); // Invalid position or invalid slot
        }
       
        
    }

    public void displayInventory(){
        System.out.println("Displaying Inventoy:");
        for(int i= 0;i<rows;i++){
            for(int j = 0;j<columns;j++){
                if(grid[i][j]!=null){
                    System.out.print("|"+grid[i][j].getItemName()+" ");
                }
                else{
                    System.out.print("|"+"   \t");
                }
                System.out.print("|");
            }
            System.out.print("\n");  
        }
    }

    public ItemSystem returnItemFromInventory(int row, int column){
        if(row >= 0 && row < grid.length && column >= 0 && column < grid.length){
            return grid[row][column];
        }
        return null;
        
        
    }
    
    private boolean isValidPosition(int row, int column) {
        return row >=0 && row < rows && column >=0 && column <columns;    
    }



}
