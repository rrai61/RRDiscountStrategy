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
public class LineItem {
    private Product product;   
    private int qty;
    private String prodName;

    public LineItem(String prodId, int qty, DatabaseStrategy db) {
        setQty(qty);
        setProduct(db.findProductById(prodId));
        setProductName(db.findProductById(prodId).getProdName());
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        this.product = product;
    }

    public final int getQty() {
        return qty;
    }

    public final void setQty(int qty) {
        this.qty = qty;
    }
    
    public final double getExtendedPrice(){
        NumberFormat formatter = new DecimalFormat("#0.00");     
         String fmt = formatter.format(product.getUnitCost() * qty);
         double extendedPrice = Double.parseDouble(fmt);
        return extendedPrice;
    }
   
    public final double calculateDiscount(){
        double discount = product.getDiscount().getDiscountAmt(qty, product.getUnitCost());
        return discount;
    }
    
    public final double getCalculatedDiscount() {
        double calculatedDiscount =  getExtendedPrice() - product.getDiscount().getDiscountAmt(qty, product.getUnitCost());
        return calculatedDiscount;
    }
    
    public final void setProductName(String prodName){
        // needs validation
        this.prodName = prodName;
    }
    
    public final String getProductName(){
        return prodName;
    }
    
    
    
    
}
