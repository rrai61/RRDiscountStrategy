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
    private LineItem[] items;

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        this.product = product;
    }

    public final LineItem[] getItems() {
        return items;
    }

    public final void addItems() {
        
    }
    
    
}
