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
public class ComplexReceipt implements ReceiptFormatStrategy {
    private String fmtReceipt;
    private final String dataHeader = "Prod ID\tProd Name\t\t\tQty\tExt. Price\tDiscount\n" +
                "-------\t---------\t\t\t---\t\t\t----------\t-------- \n";
    
    @Override
    public final String formatReceipt(Receipt receipt) throws IllegalArgumentException{
        if(receipt == null){
            throw new IllegalArgumentException("Sorry receipt cannot be null");
        }
        fmtReceipt = receipt.getStoreInfo() + "\n";
        fmtReceipt += dataHeader;
        for(LineItem item: receipt.getLineItems()){
            fmtReceipt += getLineItemData(item);
        }
        fmtReceipt += "Sub Total = " + receipt.calcGrandTotal();
        return fmtReceipt;
    }
    
    private String getLineItemData(LineItem item) throws IllegalArgumentException{
        if(item == null){
            throw new IllegalArgumentException("Sorry line item cannot be null");
        }
        String data = item.getProduct().getProdId() + "\t" +item.getProductName() + "\t" +item.getQty() +  "\t" 
        + item.getExtendedPrice() + "\t" + item.calculateDiscount() + "\n";
        return data;
    }
}
