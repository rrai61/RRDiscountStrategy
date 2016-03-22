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
        ReceiptFormatStrategy receiptFmt = new ComplexReceipt();
        // Start talking to objects
        Register register = new Register();
        try{
        register.startNewSale("100", db, "Kohl's Department Store", receiptFmt);
        
        // test code
//        Customer customer = register.getReceipt().getCustomer();
//        System.out.println("Customer " + customer.getCustomerName() + " found and added to receipt.");
        
        register.addItemToSale("11", 2);
        register.addItemToSale("22", 1);
        register.addItemToSale("33", 3);
        
//        // test... 
//        LineItem[] items = register.getReceipt().getLineItems();
//        for(LineItem item: items){
//            System.out.println(item.getProduct().getProdName());
//        }
        }
        catch(IllegalArgumentException e) {
            e.getMessage();
        }
        
        System.out.println(register.endSale());
    }
    
}
