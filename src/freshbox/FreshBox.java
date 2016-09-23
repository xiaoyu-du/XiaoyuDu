
package freshbox;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Emily
 */
public class FreshBox {
    private Boolean recipe;
    private String whichRecipe;
    //private static final int[] trayNumber = {1,2,3,4};
    FruitAndVeg[] tray = new FruitAndVeg[4];
    
    /**
     *constructor
     */
    public FreshBox () { //comment
        
    }
    
    public FreshBox(Boolean recipe, String whichRecipe, FruitAndVeg[] tray){
        this.whichRecipe = whichRecipe;
        this.recipe = recipe;;
        this.tray = tray;
    }

    /**
     *
     * set methods;
     */
    public void setTrayItem(String[] list){  
        for (int i = 0; i < 4; i++) {
            tray[i].fvName = list[i];
        }
    }
    
    public void setRecipe(Boolean recipe){
        this.recipe= recipe;
    }
    
    public void setWhichRecipe(String whichRecipe){
        this.whichRecipe= whichRecipe;
    }
 
    /**
     * get methods;
     */
    public Boolean getRecipe(){
        return recipe;
    }
    
     public String getWhichRecipe(){
        return whichRecipe;
    }
     
     /**
     * oString method;
     */
    @Override
    public String toString(){
        String output = "";
        String str = "";
        for (int i = 0; i < 4; i++) {
            str += this.tray[i].fvName + " ";
        }
        output = "Your FreshBox contains : " + str + "\n" ;
        if (this.recipe == true) {
            output += "Your also got recipe: " + this.whichRecipe;
        }
        return output;
    }
    
    public static void main(String[] args) {
        FreshBox freshbox = new FreshBox();
        String[] contentName;
        contentName = new String[] {"Banana","Apple","Cauliflower","Potato","Capsicum"};
        //randomly put items into trays;
        String[] itemList = new String[4];
        for (int i = 0; i < 4; i++) {
            int ran = (int)(Math.random()*5);
            itemList[i] = (contentName[ran]);
        }
        for(int i=0;i<4;i++){
            freshbox.tray[i] = new FruitAndVeg();
            freshbox.tray[i].setFvName(itemList[i]);
        }
        
        System.out.println("The contents of your freshbox: ");
        for (int i = 0; i < 4; i++) {
            System.out.println(freshbox.tray[i].fvName);
        }
       
        //user substituting...
        System.out.println("Do you want to replace items? 1 for yes, 2 for no");
        Scanner input = new Scanner(System.in);
        int willing = input.nextInt();
        while(willing!=1 && willing!=2){
            System.out.println("Invalid Input, please try again. ");
            willing = input.nextInt();
        }//rule out invalid input;
        while (willing == 1) {            
            System.out.println("Which tray do you want to replace? Enter 1~4 ");
            int toBeReplace = input.nextInt();
            while (toBeReplace != 1 && toBeReplace != 2 && toBeReplace != 3 && toBeReplace != 4) {
                System.out.println("Invalid Input, please try again. ");
                toBeReplace = input.nextInt();
            }
                System.out.println("Which item do you want? 1 for Banana, 2 for Apple, 3 for Cauliflower, 4 for Potato, 5 for Capsicum. ");
                int replaceWith = input.nextInt();
                while (replaceWith != 1 && replaceWith != 2 && replaceWith != 3 && replaceWith != 4 && replaceWith != 5) {
                    System.out.println("Invalid Input, please try again. ");
                    replaceWith = input.nextInt();
                }
                freshbox.tray[(toBeReplace - 1)].fvName = contentName[(replaceWith - 1)];
                System.out.println("Your updated contents are: ");
                for (int i = 0; i < 4; i++) {
                    System.out.println(freshbox.tray[i].fvName);
                }
                System.out.println("Do you want to replace other items? 1 for yes, 2 for no");
                willing = input.nextInt();
            }
            
        
        //add recipes to freshbox(if have duplicate items);
        freshbox.whichRecipe = "";
        freshbox.recipe = false;
        ArrayList<String> list = new ArrayList();
        ArrayList<String> doneList = new ArrayList();
        for (int i = 0; i < 4; i++) {
            if(list.contains(freshbox.tray[i].fvName) && !doneList.contains(freshbox.tray[i].fvName)){
                freshbox.recipe = true;
                freshbox.whichRecipe += "How to cook " + freshbox.tray[i].fvName + "; ";
                doneList.add(freshbox.tray[i].fvName);
            }
            else{
                list.add(freshbox.tray[i].fvName);
            }
        } 
        
        System.out.println(freshbox.toString());

    }
    
}
