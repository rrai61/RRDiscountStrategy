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
      
    public final double getDiscountRate(int qty, double unitCost) {
        // needs validation
        double discountAmt = unitCost - discountRate;
        return discountAmt;
    }
    
    @Override
    public final double getDiscountAmt(int qty, double unitCost) {
        return discountRate;
    }

    public final void setDiscountAmt(double discountRate) {
        // needs validation
        this.discountRate = discountRate;
    }

}
