package gamingclaus;

import java.util.Random;

public class test {
    public static void main(String[] args) {
        ItemManager itemManager = new ItemManager();
        Random random = new Random();
        int randomitem = random.nextInt(itemManager.getSize());
        System.out.println(randomitem);
    }
    
    
}
