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
public class Customer {
    private String customerNum;
    private String customerName;

    public Customer(String customerNum, String customerName) {
        setCustomerNum(customerNum);
        setCustomerName(customerName);
    }

    public final String getCustomerNum() {
        return customerNum;
    }

    public final void setCustomerNum(String customerNum) throws IllegalArgumentException {
        if(customerNum == null || customerNum.isEmpty()){
            throw new IllegalArgumentException("Sorry customer number is mandatory and must not be empty");
        }
        this.customerNum = customerNum;
    }

    public final String getCustomerName() {
        return customerName;
    }

    public final void setCustomerName(String customerName) {
        if(customerName == null || customerName.isEmpty()){
            throw new IllegalArgumentException("Sorry customer name is mandatory and must not be empty");
        }
        this.customerName = customerName;
    }
}
