/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybeans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author pdavila
 */
public class FirstBean implements Serializable {
    
    //Propietats restringides
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    public static final String PROP_QUANTITAT = "quantitat";
    
    //Propietats Lligades
    private String sampleProperty;
    private PropertyChangeSupport propertySupport;
    
    private VetoableChangeSupport vetoableSupport;
    
    //Propietats Simples
    private int quantitat = 0;
    private boolean ple = false;
    
    //Propietat Indexada
    private int[] capacitats = {50,100,150};
    
    public FirstBean() {
        propertySupport = new PropertyChangeSupport(this);
        vetoableSupport = new VetoableChangeSupport(this);
    }
    
    public String getSampleProperty() {
        return sampleProperty;
    }
    
    public void setSampleProperty(String value) {
        String oldValue = sampleProperty;
        sampleProperty = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, sampleProperty);
    }
    
    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int nouValor) throws PropertyVetoException {
        int vellValor = quantitat;
        
        //Abans de fer el canvi activem els vetadors
        vetoableSupport.fireVetoableChange(PROP_QUANTITAT, vellValor, nouValor);
        this.quantitat = nouValor;
    }

    public boolean isPle() {
        return ple;
    }

    public void setPle(boolean ple) {
        this.ple = ple;
    }
    
    public int[] getCapacitats() {
        return capacitats;
    }

    public void setCapacitats(int[] capacitats) {
        this.capacitats = capacitats;
    }
    
    public int getCapacitats(int index) {
        return capacitats[index];
    }
    
    public void setCapacitats(int index, int valor) {
        this.capacitats[index] = valor;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
    public void addVetoableChangeListener(VetoableChangeListener listener) {
        vetoableSupport.addVetoableChangeListener(listener);
    }

    public void removeVetoableChangeListener(VetoableChangeListener listener) {
        vetoableSupport.removeVetoableChangeListener(listener);
    }   
    
}
