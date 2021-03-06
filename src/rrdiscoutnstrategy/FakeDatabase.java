/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrdiscoutnstrategy;

/**
 *
 * 
 * @author ritu
 */
public class FakeDatabase implements DatabaseStrategy {
    private Customer[] customers = {
        new Customer("100", "Bob James"), 
        new Customer("200", "Sally Smith"), 
        new Customer("300", "Peter Piper")
    };
    
    private Product[] products = {
        new Product("11", "Brewer's Hat     ", 29.95, new PercentOffDiscount(.10)), 
        new Product("22", "Women's Blouse   ", 49.95, new FlatAmtDiscount(5.00)),
        new Product("33", "Men's Black Belt ", 39.95, new NoDiscount())
    };
    
    /**
     * CAUTION: findProductById method not validated
     * Finds a product by its unique id.
     * @param prodId
     * @return a Product object or null if not found
     */

    @Override
    public final Product findProductById(String prodId) throws IllegalArgumentException{
        if(prodId == null || prodId.isEmpty()){
            throw new IllegalArgumentException("Sorry product Id is manddatory and cannot be an empty string.");
        }
        Product product = null;
        
        for(Product c : products) {
            if(c.getProdId().equals(prodId)) {
                product = c;
                break;
            }
        }
     
        return product;
    }
    
     /**
     * CAUTION: findCustomerById method not validated
     * Finds a customer by unique id.
     * @param custId
     * @return a customer object or null if not found
     */
    @Override
    public final Customer findCustomerById(String custId) throws IllegalArgumentException{
        if(custId == null || custId.isEmpty()){
            throw new IllegalArgumentException("Sorry customer Id is manddatory and cannot be an empty string.");
        }
        Customer customer = null;
        
        for(Customer c : customers) {
            if(c.getCustomerNum().equals(custId)) {
                customer = c;
                break;
            }
        }
     
        return customer;
    };
    
    
}
