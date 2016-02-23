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
    private String customerId;
    private String customerName;

    public Customer(String customerId, String customerName) {
        setCustomerId(customerName);
        setCustomerName(customerName);
    }
    
    public final String getCustomerId() {
        return customerId;
    }

    public final void setCustomerId(String customerID) {
        // needs validation
        this.customerId = customerID;
    }

    public final String getCustomerName() {
        return customerName;
    }

    public final void setCustomerName(String customerName) {
        // needs validation
        this.customerName = customerName;
    }
    
}
