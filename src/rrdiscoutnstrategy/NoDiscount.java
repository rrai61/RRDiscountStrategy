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
public class NoDiscount implements DiscountStrategy{
    private double discountRate;
    private final int NO_DISCOUNT =0;
      
    @Override
    public final double getDiscountAmt(int qty, double unitCost) {
        // needs validation
        return NO_DISCOUNT;
    }

    public final double getDiscountRate() {
        return discountRate;
    }

    public final void setDiscountRate(double discountRate) throws IllegalArgumentException{
        if(discountRate >= 100){
            throw new IllegalArgumentException("Sorry discount rate cannot be greater than 100");
        }
        this.discountRate = discountRate;
    }

}
