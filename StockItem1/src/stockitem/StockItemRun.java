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
public class StockItemRun {
    
    public static void main(String args[]){
        //Creating the stock object and passing values through to the class
        
        /*now needs 5 values = stock code | quantity(curent stock amount) |
                    the amount of items ordered |stock added to current stock |
                    the item price*/
        StockItem stock = new StockItem("",5,8,10,4.99);
        
        //StockItem stock2 = new StockItem("",4,6,5,9.99);
        
        
        
        stock.addStock();
        stock.sellStock();
        stock.toWordString();
        
//        stock2.addStock();
//        stock2.sellStock();
//        stock2.toWordString();
        
    }
     
    
     
    
}
