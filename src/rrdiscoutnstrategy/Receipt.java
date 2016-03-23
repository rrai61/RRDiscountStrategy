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

    public Receipt(String custId, DatabaseStrategy db, String storeInfo) throws IllegalArgumentException{
        setDb(db);
        setCustomer(db.findCustomerById(custId));
        setStoreInfo(storeInfo);
        lineItems = new LineItem[0];
    }
            
    private void addItemToArray(LineItem[] origArray, LineItem item) throws IllegalArgumentException{
        if(item == null){
            throw new IllegalArgumentException("Sorry line item cannot be null.");
        }
        LineItem[] tempArray = new LineItem[origArray.length + 1];
        System.arraycopy(origArray, 0, tempArray, 0, origArray.length);
        tempArray[tempArray.length -1] = item;
        origArray = tempArray;
        lineItems = origArray;
    }
    
    public final void addItemToReceipt(String prodId, int qty) throws IllegalArgumentException{
        if(prodId == null || prodId.isEmpty() || qty == 0){
            throw new IllegalArgumentException("Sorry product ID is mandatory and quantity must be greater than 0.");
        }
        LineItem item = new LineItem(prodId, qty, db);
        
        addItemToArray(lineItems, item);
    }
    
    public final double calcSubtotal() {
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
        double total = calcSubtotal() - calcTotalDiscountAmt();
        return total;
    }
    
    
    public final DatabaseStrategy getDb() {
        return db;
    }

    public final void setDb(DatabaseStrategy db)throws IllegalArgumentException {
        if(db == null){
            throw new IllegalArgumentException("Sorry database strategy cannot be null.");
        }
        this.db = db;
    }

    public final Customer getCustomer() {
        return customer;
    }

    public final void setCustomer(Customer customer) throws IllegalArgumentException{
        if(customer == null){
            throw new IllegalArgumentException("Sorry customer cannot be null");
        }
        this.customer = customer;
    }

    public final LineItem[] getLineItems() {
        return lineItems;
    }

    public final void setLineItems(LineItem[] lineItems) throws IllegalArgumentException{
        if(lineItems == null){
            throw new IllegalArgumentException("Sorry line items cannot be null.");
        }
        this.lineItems = lineItems;
    }
    
    public final String getStoreInfo() {
        return storeInfo;
    }

    public final void setStoreInfo(String storeInfo) throws IllegalArgumentException{
        if(storeInfo == null || storeInfo.isEmpty()){
            throw new IllegalArgumentException("Sorry store info cannot be null or empty string.");
        }
        this.storeInfo = storeInfo;
    }
    
}
