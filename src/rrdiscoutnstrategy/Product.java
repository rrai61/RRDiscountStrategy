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
public class Product {
    private String prodId;
    private String prodName;
    private double unitCost;
    private DiscountStrategy discount;

    public Product(String prodId, String prodName, double unitCost, DiscountStrategy discount) throws IllegalArgumentException{
        setProdId(prodId);
        setProdName(prodName);
        setUnitCost(unitCost);
        setDiscount(discount);
    }

    public final String getProdId() {
        return prodId;
    }

    public final void setProdId(String prodId) throws IllegalArgumentException{
        if(prodId == null || prodId.isEmpty()){
            throw new IllegalArgumentException("Sorry product ID is mandatory and cannot be empty string.");
        }
        this.prodId = prodId;
    }

    public final String getProdName() {
        return prodName;
    }

    public final void setProdName(String prodName) throws IllegalArgumentException{
        if(prodName == null || prodName.isEmpty()){
            throw new IllegalArgumentException("Sorry product name is mandatory and cannot be empty string.");
        }
        this.prodName = prodName;
    }

    public final double getUnitCost() {
        return unitCost;
    }

    public final void setUnitCost(double unitCost) throws IllegalArgumentException{
        if(unitCost <= 0.0){
            throw new IllegalArgumentException("Sorry unit cost cannot be less than or equal to 0.");
        }
        this.unitCost = unitCost;
    }

    public final DiscountStrategy getDiscount() {
        return discount;
    }

    public final void setDiscount(DiscountStrategy discount) throws IllegalArgumentException{
        if(discount == null){
            throw new IllegalArgumentException("Sorry discount strategy object is mandatory");
        }
        this.discount = discount;
    }
    
    
}
