/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrdiscoutnstrategy;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author ritu
 */
public class SimpleReceipt implements ReceiptFormatStrategy{
    private String fmtReceipt;
    private final String dataHeader = "Prod ID\t\tProd Name\t\t\tQty\t\tExt. Price\n" +
                "-------\t\t---------\t\t\t---\t\t----------\n";
    
    @Override
    public final String formatReceipt(Receipt receipt){
        fmtReceipt = receipt.getStoreInfo() + "\n";
        fmtReceipt += dataHeader;
        for(LineItem item: receipt.getLineItems()){
            fmtReceipt += getLineItemData(item);
        }
        NumberFormat formatter = new DecimalFormat("#0.00");    
        String fmt = formatter.format(receipt.calcGrandTotal()); 
        fmtReceipt += "Sub Total = " + fmt;
        return fmtReceipt;
    }
    
    private String getLineItemData(LineItem item){
        String data = item.getProduct().getProdId() + "\t\t" +item.getProductName() + "\t\t" +item.getQty() +  "\t\t" 
                + item.getExtendedPrice() + "\n";
        return data;
    }
        
    }
