/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrdiscoutnstrategy;

import javax.swing.JOptionPane;

/**
 *
 * @author ritu
 */
public class GUIOutput implements OutputStrategy{
    
    @Override
    public final void output(String data) {
        if(data == null || data.isEmpty()){
            throw new IllegalArgumentException("Sorry data String is manddatory and cannot be an empty string.");
        }
        JOptionPane.showMessageDialog(null, data);
    }
}
