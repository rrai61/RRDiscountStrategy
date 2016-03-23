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
public class PercentOffDiscount implements DiscountStrategy{
    private double discountRate;

    public PercentOffDiscount(double discountRate) throws IllegalArgumentException{
        setDiscountRate(discountRate);
    }
      
    @Override
    public final double getDiscountAmt(int qty, double unitCost) {
        if(qty <= 0 || unitCost <= 0){
            throw new IllegalArgumentException("Sorry quantity and unit cost cannot be less than or equal to 0");
        }
        return unitCost * qty * discountRate;
    }

    public final double getDiscountRate() {
        return discountRate;
    }

    public final void setDiscountRate(double discountRate) throws IllegalArgumentException{
        if((discountRate <= 0) || (discountRate >= 100)){
            throw new IllegalArgumentException("Sorry discount rate must be greater than 0 or greater than or equal to 100");
        }
        this.discountRate = discountRate;
    }

}
