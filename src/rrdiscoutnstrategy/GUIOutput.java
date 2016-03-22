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
        // needs validation
        JOptionPane.showMessageDialog(null, data);
    }
}
