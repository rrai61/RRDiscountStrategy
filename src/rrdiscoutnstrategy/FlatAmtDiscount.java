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
public class FlatAmtDiscount implements DiscountStrategy{
    private double discountRate;

    public FlatAmtDiscount(double discountRate) {
        setDiscountAmt(discountRate);
    }
      
    public final double getDiscountRate(int qty, double unitCost) throws IllegalArgumentException {
        // needs validation
        if(qty ==0 || unitCost ==0) {
            throw new IllegalArgumentException("Sorry quantity and unit cost must be greater than 0");
        }
        double discountAmt = unitCost - discountRate;
        return discountAmt;
    }
    
    @Override
    public final double getDiscountAmt(int qty, double unitCost) {
        return discountRate;
    }

    public final void setDiscountAmt(double discountRate) throws IllegalArgumentException {
        if(discountRate >= 100) {
            throw new IllegalArgumentException("Sorry discount rate cannot be greater than or equal to 100");
        }
        this.discountRate = discountRate;
    }

}
