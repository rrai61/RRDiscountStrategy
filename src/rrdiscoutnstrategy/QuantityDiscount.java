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
public class QuantityDiscount implements DiscountStrategy{
    private double discountRate;
    private int minQty;
    private final int NO_DISCOUNT = 0;

    public QuantityDiscount(double discountRate, int minQty) throws IllegalArgumentException {
        setDiscountRate(discountRate);
        setMinQty(minQty);
    }
      
    @Override
    public final double getDiscountAmt(int qty, double unitCost) throws IllegalArgumentException{
        if(qty <= 0 || unitCost <= 0){
            throw new IllegalArgumentException("Sorry minimum quantity/unit cost cannot be negative or 0");
        }
        if (qty >= minQty){
            return unitCost * qty * discountRate;
        } else {
            return NO_DISCOUNT;
        }
    }

    public final double getDiscountRate() {
        return discountRate;
    }

    public final void setDiscountRate(double discountRate) throws IllegalArgumentException{
        if((discountRate < 0) || (discountRate >= 100)){
            throw new IllegalArgumentException("Sorry discount rate cannot be negative or greater than or equal to 100");
        }
        this.discountRate = discountRate;
    }

    public final int getMinQty() {
        return minQty;
    }

    public final void setMinQty(int minQty) throws IllegalArgumentException{
        if(minQty <= 0){
            throw new IllegalArgumentException("Sorry minimum quantity cannot be less than or equal to 0");
        }
        this.minQty = minQty;
    }

}
