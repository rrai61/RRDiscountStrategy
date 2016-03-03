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
    private ReceiptFormatStrategy receiptStrategy;
    private String storeInfo;
    
    public final void startNewSale(String custId, DatabaseStrategy db, String storeInfo, ReceiptFormatStrategy receiptStrategy){
        // needs validation
        setReceiptStrategy(receiptStrategy);
        receipt = new Receipt(custId, db, storeInfo);
    }
    
    public final String endSale(){
        // return receipt in String format when sale ends
        return receiptStrategy.formatReceipt(receipt);
    }
    
    public final void addItemToSale(String prodId, int qty){
        receipt.addItemToReceipt(prodId, qty);
    }

    public final String getStoreInfo() {
        return storeInfo;
    }

    public final void setStoreInfo(String storeInfo) {
        // needs validation
        this.storeInfo = storeInfo;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        // needs validation
        this.receipt = receipt;
    }

    public ReceiptFormatStrategy getReceiptStrategy() {
        return receiptStrategy;
    }

    public void setReceiptStrategy(ReceiptFormatStrategy receiptStrategy) {
        // needs validation
        this.receiptStrategy = receiptStrategy;
    }
    
    
    
}
