/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockItem;
/**
 *
 * @author Carlo
 */
/**
 *
 * @author Ethan
 */
//Settings are void and public - can change the variabe without compromising the private state of varable
//Getters are public and return what ever the value is  e.g vat
//Using inheritence to get the RateVAT interface

public class StockItem implements IRateVAT {
    //Creating the variables for all stock items
    static String fixedStockCode;
    
    private int quantity;//quantity = stock
    private static int amountSell;// what is going to be sold
    private int addedStock;// used in addStock() method
    
    private double priceStock;
    private int code = 100;   
    private String stockName;
    private String stockDesc;
    private double VAT = IRateVAT.getVAT();
    private double priceAfterVAT;
    private int updateedStockAmount;
    private int stockBeforeSell;
    
  
    
    StockItem(){
        System.out.println("There was not values entered.");               
    }
    /*  added "orederedItems" for what is going to be taken sold
                stock = quantity - orederedItems
        added "addToStock"
    */
    public StockItem(String StockCode, int quantity, int orederedItems,int addToStock, double price){
        //Passing variables throught the method and then storing them in the class level variables using this 
        this.fixedStockCode = StockCode;
        this.quantity = quantity;
        this.priceStock = price;   
        this.amountSell = orederedItems;//new input
        this.addedStock = addToStock;//new input
        
        //Calling the getStockName and GetStockDescription then storing them in the vairables
        createStockCode();      
        setVAT(priceStock);             
    }  
    //calculating the VAT getting the variable from the RateVAT interface
    //Sets the VAT after the price
    private void setVAT(double price){
        //change this to the a return method and and return the vat to a variable.s
       priceAfterVAT = (VAT * priceStock)+price ;    
    }
    
    private double getVAT(){
        return priceAfterVAT;
    }
    
    private static int getSoldStock(){
        return amountSell;
    }
    
    //returning the stock name
    private String getStockName(){
        return "Unknown Stock Name";
    }
    // returning the stock description
    private String getStockDescription(){
        return "Unknow Stock Description";
    }
    
    private int getStockBeforeSell(){
        return stockBeforeSell;
    }
    
    private int getQuantity(){           
           return updateedStockAmount;
    }
    
    private double getPrices(){
        return priceStock;
    }
    
    private String getStockCode(){
        return fixedStockCode;
    }
    
    //creating the stock code then incrementing the code by one to make a new code for each new stock item
    private void createStockCode(){      
        fixedStockCode = "W" + "" + code;
        code++;
    }
    
    public void addStock(){       
        if(addedStock <= 1 || addedStock >= 100){
            System.out.println("ERROR");
        }else{
            quantity = quantity + addedStock;              
            stockBeforeSell = quantity;        
        }
    }
    
    public String getSellStock(){      
        if(sellStock() == true){
            return "REDUCTION SUCCESSFUL";
            
        }
        else if(sellStock() == false){
            System.out.println("ERROR - Cannot have negative stock.");
            
        }else{
            System.out.println("THERE WAS NO EFFECT - Please try again.");
            
        }
        return "REDUCTION UNSUCCESSFUL";
    }
    
   public boolean sellStock(){            
        if(quantity < 0){           
            return false;
        }
        if(amountSell <= stockBeforeSell){  
            quantity = stockBeforeSell - amountSell;
            updateedStockAmount = quantity;  
            return true;        
        }else{            
            return false;
        }
    
   }
   
    
    public void toWordString(){
        System.out.println();
        System.out.println("Creating a stock with " + getQuantity() + " units "
                + getStockName() + ", price " + getPrices() 
                + " each, and item code " + getStockCode());
        System.out.println();
        //Printing out the the information for the 
        System.out.println("STOCK CODE: " + getStockCode() + "\nSTOCK TYPE: " + getStockName()
                +  "\nSTOCK DESCRIPTION: " + getStockDescription() + "\nPRICE BEFORE VAT: " + getPrices() + "\nPRICE AFTER VAT: " + getVAT() + "\nTotal units in stock: " + getStockBeforeSell() + 
                "\nSold " + getSoldStock() + " units" + "\n" + getSellStock() + "\nAMOUNT AFTER SOLD STOCK: " + getQuantity() );    
    }
    
}

