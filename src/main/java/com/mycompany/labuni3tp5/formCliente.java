
package com.mycompany.labuni3tp5;

import java.util.TreeSet;
import javax.swing.JOptionPane;

/**
 *
 * @author matiSqui
 */
public class formCliente implements Comparable<formCliente>{
    
    
    private int dniCliente;
    private String nameCliente;
    private String apellCliente;
    private String addsCliente;
    private String ciudadCliente;
    private int telCliente;
    
    private TreeSet<formCliente> listClientes = new TreeSet<>();

    

    public formCliente(int dniCliente, String nameCliente, String apellCliente, String addsCliente, String ciudadCliente, int telCliente) {
        this.dniCliente = dniCliente;
        this.nameCliente = nameCliente;
        this.apellCliente = apellCliente;
        this.addsCliente = addsCliente;
        this.ciudadCliente = ciudadCliente;
        this.telCliente = telCliente;
       
    }

    public int getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(int dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getNameCliente() {
        return nameCliente;
    }

    public void setNameCliente(String nameCliente) {
        this.nameCliente = nameCliente;
    }

    public String getApellCliente() {
        return apellCliente;
    }

    public void setApellCliente(String apellCliente) {
        this.apellCliente = apellCliente;
    }

    public String getAddsCliente() {
        return addsCliente;
    }

    public void setAddsCliente(String addsCliente) {
        this.addsCliente = addsCliente;
    }

    public String getCiudadCliente() {
        return ciudadCliente;
    }

    public void setCiudadCliente(String ciudadCliente) {
        this.ciudadCliente = ciudadCliente;
    }

    public int getTelCliente() {
        return telCliente;
    }

    public void setTelCliente(int telCliente) {
        this.telCliente = telCliente;
    }

    @Override
    public int compareTo(formCliente other) {
    return Integer.compare(this.dniCliente, other.dniCliente);
    }
    
    
    
    public void agregarCliente(formCliente nCliente){
        
        if (listClientes.add(nCliente) == true) {
            
            JOptionPane.showMessageDialog(null,"Cliente: " + nCliente.getNameCliente() + " cargado correctamente");
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Cliente: " + nCliente.getNameCliente() + " ya esta cargado");
            
        }
         
    }
    
    
    public int getSizeList(){
        
    return listClientes.size();
        
    }
    
}
