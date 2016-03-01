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
    private DatabaseStrategy db;
    private Customer customer;
    private LineItem[] lineItems;
    private String dataHeader = "Prod ID          Qty          Ext. Price           Discount \n" +
                "-------           ---          ----------          -------- \n";
    
    public Receipt(String custId, DatabaseStrategy db){
        // needs validation
        setDb(db);
        setCustomer(db.findCustomerById(custId));
        lineItems = new LineItem[0];
    }
    
    public final void addItemToReceipt(String prodId, int qty) {
        LineItem item = new LineItem(prodId, qty, db);
        
        addItemToArray(lineItems, item);
    }
    
    private void addItemToArray(LineItem[] origArray, LineItem item){
        LineItem[] tempArray = new LineItem[origArray.length + 1];
        System.arraycopy(origArray, 0, tempArray, 0, origArray.length);
        tempArray[tempArray.length -1] = item;
        origArray = tempArray;
        lineItems = origArray;
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
        this.lineItems = lineItems;
    }
    
    public final double calcGrandTotal(LineItem[] lineItems) {
        double total = 0;
        for(LineItem item: lineItems){
            total += item.getExtendedPrice();
        }
        return total;
    }
    
    public final String createReceipt() {
        String receipt = dataHeader;
        for(LineItem item: lineItems){
            receipt += item.getLineItemData();
        }
        receipt += "Sub Total = " + calcGrandTotal(lineItems);
        return receipt;
    }

    
}
