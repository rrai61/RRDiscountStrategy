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
public class ConsoleOutput implements OutputStrategy{
    
    @Override
    public final void output(String data) throws IllegalArgumentException{
        if(data == null || data.isEmpty()){
            throw new IllegalArgumentException("Sorry data is madatory and must not be empty");
        }
        System.out.println(data);
    }
    
}
