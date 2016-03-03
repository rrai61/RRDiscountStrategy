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
public class Receipt {
    private String storeInfo;
    private DatabaseStrategy db;
    private Customer customer;
    private LineItem[] lineItems;

    public Receipt(String custId, DatabaseStrategy db, String storeInfo){
        // needs validation
        setDb(db);
        setCustomer(db.findCustomerById(custId));
        setStoreInfo(storeInfo);
        lineItems = new LineItem[0];
    }
            
    private void addItemToArray(LineItem[] origArray, LineItem item){
        LineItem[] tempArray = new LineItem[origArray.length + 1];
        System.arraycopy(origArray, 0, tempArray, 0, origArray.length);
        tempArray[tempArray.length -1] = item;
        origArray = tempArray;
        lineItems = origArray;
    }
    
    public final void addItemToReceipt(String prodId, int qty) {
        // needs validation
        LineItem item = new LineItem(prodId, qty, db);
        
        addItemToArray(lineItems, item);
    }
    
    public final double calcSubtotal() {
        // needs validation
        double total = 0;
        for(LineItem item: lineItems){
            total += item.getExtendedPrice();
        }
        return total;
    }
    
    public final double calcTotalDiscountAmt(){
        double total = 0;
        for(LineItem item: lineItems){
            total += item.calculateDiscount();
        }
        return total;
    }
    
    public final double calcGrandTotal() {
        // needs validation
        double total = calcSubtotal() - calcTotalDiscountAmt();
        return total;
    }
    
    
    public final DatabaseStrategy getDb() {
        return db;
    }

    public final void setDb(DatabaseStrategy db) {
        // needs validation
        this.db = db;
    }

    public final Customer getCustomer() {
        return customer;
    }

    public final void setCustomer(Customer customer) {
        // needs validation
        this.customer = customer;
    }

    public final LineItem[] getLineItems() {
        return lineItems;
    }

    public final void setLineItems(LineItem[] lineItems) {
        // needs validation
        this.lineItems = lineItems;
    }
    
    public final String getStoreInfo() {
        return storeInfo;
    }

    public final void setStoreInfo(String storeInfo) {
        // needs validation
        this.storeInfo = storeInfo;
    }
    
}
