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
    
    public final void startNewSale(String custId, DatabaseStrategy db, String storeInfo, ReceiptFormatStrategy receiptStrategy) throws IllegalArgumentException{
        if(custId == null || custId.isEmpty() || db == null || storeInfo == null || storeInfo.isEmpty()){
            throw new IllegalArgumentException("Sorry customer ID, store info and database strategy object are all mandatory and cannot be empty.");
        }
        setReceiptStrategy(receiptStrategy);
        receipt = new Receipt(custId, db, storeInfo);
    }
    
    public final String endSale(){
        // return receipt in String format when sale ends
        return receiptStrategy.formatReceipt(receipt);
    }
    
    public final void addItemToSale(String prodId, int qty)throws IllegalArgumentException{
        if(prodId == null || prodId.isEmpty() || qty == 0){
            throw new IllegalArgumentException("Sorry product ID is mandatory and quantity must be greater than 0.");
        }
        receipt.addItemToReceipt(prodId, qty);
    }

    public final String getStoreInfo() {
        return storeInfo;
    }

    public final void setStoreInfo(String storeInfo) throws IllegalArgumentException{
        if(storeInfo == null || storeInfo.isEmpty()){
            throw new IllegalArgumentException("Sorry store info is mandatory and cannot be an empty string.");
        }
        this.storeInfo = storeInfo;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) throws IllegalArgumentException{
        if(receipt == null){
            throw new IllegalArgumentException("Sorry receipt object is mandatory.");
        }
        this.receipt = receipt;
    }

    public ReceiptFormatStrategy getReceiptStrategy() {
        return receiptStrategy;
    }

    public void setReceiptStrategy(ReceiptFormatStrategy receiptStrategy) throws IllegalArgumentException{
        if(receiptStrategy == null){
            throw new IllegalArgumentException("Sorry receipt format strategy object is mandatory.");
        }
        this.receiptStrategy = receiptStrategy;
    }
    
    
    
}
