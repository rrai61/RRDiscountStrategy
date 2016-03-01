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
public class LineItem {
    private Product product;   
    private int qty;

    public LineItem(String prodId, int qty, DatabaseStrategy db) {
        setQty(qty);
        setProduct(db.findProductById(prodId));
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
        double extendedPrice = product.getUnitCost() * qty;
        return extendedPrice;
    }
    
    public final String getLineItemData(){
        String data = product.getProdId() + "              " + qty +  "               " + getExtendedPrice() 
                + "              " + calculateDiscount() + "\n";
        return data;
    }
    
    public final double calculateDiscount() {
        double calculatedDiscount =  getExtendedPrice() - product.getDiscount().getDiscountAmt(qty, product.getUnitCost());
        return calculatedDiscount;
    }
    
    
}
