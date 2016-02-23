/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrdiscoutnstrategy;

/**
 *
 * @author ritu
 */
public class Register {
    private Receipt receipt;
    private String storeName;
    
    public final void startNewSale(String custId, DatabaseStrategy db){
        // needs validation
        receipt = new Receipt(custId, db);
    }
    
    public final void endSale(){
        
    }
    
    public final void addItemToSale(String prodId, int qty){
        
    }

    public final Receipt getReceipt() {
        return receipt;
    }

    public final void setReceipt(Receipt receipt) {
        // needs validation
        this.receipt = receipt;
    }

    public final String getStoreName() {
        return storeName;
    }

    public final void setStoreName(String storeName) {
        // needs validation
        this.storeName = storeName;
    }
    
    
    
}
