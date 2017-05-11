/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybeans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author pdavila
 */
public class Receptor implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Canvi a la propietat " + evt.getPropertyName());
        System.out.println("Valor anterior: " + evt.getOldValue());
        System.out.println("Valor actual: " + evt.getNewValue());
    }
    
}
