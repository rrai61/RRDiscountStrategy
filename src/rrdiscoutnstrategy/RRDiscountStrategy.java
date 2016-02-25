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
public class RRDiscountStrategy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // KLUDGE: Do configuration here
        DatabaseStrategy db = new FakeDatabase();
        
        // Start talking to objects
        Register register = new Register();
        register.startNewSale("100", db);
        
        // test code
        Customer customer = register.getReceipt().getCustomer();
        System.out.println("Customer " + customer.getCustomerName() + " found and added to receipt.");
    }
    
}
