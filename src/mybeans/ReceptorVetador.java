/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybeans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

/**
 *
 * @author pdavila
 */
public class ReceptorVetador implements VetoableChangeListener {

    @Override
    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
        //Si la nova quantitat no està entre 0 i 150 ho impedim llançant una excepció
        if((int) evt.getNewValue() < 0 || (int) evt.getNewValue() > 150) {
          System.out.println("Impedint el canvi a la propietat " + evt.getPropertyName());
          System.out.println("Motiu: nou valor " + evt.getNewValue() + " incorrecte");
          throw new PropertyVetoException("error", evt);
        } else {
            System.out.println("Canvi a la propietat " + evt.getPropertyName());
            System.out.println("Valor anterior: " + evt.getOldValue());
            System.out.println("Valor actual: " + evt.getNewValue());
        }
    }
    
}
