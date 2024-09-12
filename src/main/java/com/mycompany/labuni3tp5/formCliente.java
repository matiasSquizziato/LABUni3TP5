
package com.mycompany.labuni3tp5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JOptionPane;

/**
 *
 * @author matiSqui
 */
public class formCliente{
    
    
    private int dniCliente;
    private String nameCliente;
    private String apellCliente;
    private String addsCliente;
    private String ciudadCliente;
    private int telCliente;
    
//    private TreeSet<formCliente> listClientes = new TreeSet<>();
    private static Map<Integer, formCliente> contactos = new HashMap<>();




    

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
    public String toString() {
        return "DNI: " + dniCliente + " Nombre: " + nameCliente + "Apellido: " + apellCliente + "Direccion: " + addsCliente + "Ciudad" + ciudadCliente + "TEL:" + telCliente + '}';
    }

    
    
    
   
    public void agregarCliente(int telefono) {
        
        if (contactos.containsKey(telefono)) {
            JOptionPane.showMessageDialog(null, "El número de teléfono ya existe.");
            return;
        }

      
        contactos.put(telefono, this);
        JOptionPane.showMessageDialog(null, "Contacto agregado correctamente.");
        System.out.println("Cliente:" + contactos.toString());
    }

  
    public static formCliente obtenerContacto(int telefono) {
        return contactos.get(telefono);
    }
    
   public static String buscarTel(int telefono) {
    for (Map.Entry<Integer, formCliente> entry : contactos.entrySet()) {
        if (entry.getKey().equals(telefono)) {
            System.out.println("Cliente encontado: " + entry.getKey());
           return contactos.toString(); 
            
        }else {
            System.out.println("Contacto no encontrado");
    }  
            
            }
        return null;
}
  
   
    public static Set<Long> obtenerTelefonosPorApellido(String apellido) {
   Set<Long> telefonos = new HashSet<>();

    for (Map.Entry<Integer, formCliente> entry : contactos.entrySet()) {
        Integer telefono = entry.getKey(); // Obtener el número de teléfono
        formCliente cliente = entry.getValue(); // Obtener el objeto cliente
        
        if (telefono != null && cliente != null) {
            if (cliente.getApellCliente().equalsIgnoreCase(apellido)) {
                telefonos.add((long) telefono); // Agregar al conjunto si el apellido coincide
            }
        }
    }

    return telefonos;
}
   
   
   }

  
      


