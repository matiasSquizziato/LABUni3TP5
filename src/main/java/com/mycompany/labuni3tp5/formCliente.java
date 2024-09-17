
package com.mycompany.labuni3tp5;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author matiSqui
 */
public class FormCliente{
    
    
    private int dniCliente;
    private String nameCliente;
    private String apellCliente;
    private String addsCliente;
    private String ciudadCliente;
    private Long telCliente;
    
    
    private static Map<Integer, FormCliente> contactos = new HashMap<>();
    private ArrayList<FormCliente> listaClientes = new ArrayList<>();



    

    public FormCliente(int dniCliente, String nameCliente, String apellCliente, String addsCliente, String ciudadCliente, Long telCliente) {
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

    public Long getTelCliente() {
        return telCliente;
    }

    public void setTelCliente(Long telCliente) {
        this.telCliente = telCliente;
    }

    @Override
    public String toString() {
        return "DNI: " + dniCliente + ", Nombre: " + nameCliente + ", Apellido: " + apellCliente + ", Direccion: " + addsCliente + ", Ciudad: " + ciudadCliente + "TEL:" + telCliente;
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

  
    public static FormCliente obtenerContacto(int telefono) {
        return contactos.get(telefono);
    }
    
    
    //buscamos por telefono y retorna el cliente
  public static FormCliente buscarTel(int telefono) {
    for (Map.Entry<Integer, FormCliente> entry : contactos.entrySet()) {
        if (entry.getKey().equals(telefono)) {
            // Encontramos al cliente, retornamos el objeto FormCliente directamente
            return entry.getValue();
        }
    }

    // Si llegamos aquí, el cliente no fue encontrado
    System.out.println("Contacto no encontrado");
    return null;
}
   
  
   //buscamos por apellido y retorna una lista de numeros asociados a un apellido
    public static Set<Long> obtenerTelefonosPorApellido(String apellido) {
   Set<Long> telefonos = new HashSet<>();

    for (Map.Entry<Integer, FormCliente> entry : contactos.entrySet()) {
        Integer telefono = entry.getKey(); // Obtener el número de teléfono
        FormCliente cliente = entry.getValue(); // Obtener el objeto cliente
        
        if (telefono != null && cliente != null) {
            if (cliente.getApellCliente().equalsIgnoreCase(apellido)) {
                telefonos.add(telefono.longValue()); // Agregar al conjunto si el apellido coincide
            }
        }
    }

    return telefonos;
}
 
    //buscamos por ciudad y nos devuelve un array de contactos
    public static ArrayList<Long> buscarCiudad(String ciudad){
        ArrayList<Long> listaClientes = new ArrayList<>();
            
         for (Map.Entry<Integer, FormCliente> entry : contactos.entrySet()) {
        Integer telefono = entry.getKey();
        FormCliente cliente = entry.getValue();

        if (telefono != null && cliente != null) {
            if (cliente.getCiudadCliente().equalsIgnoreCase(ciudad)) {
                listaClientes.add(telefono.longValue());
            }
        }
    }

    return listaClientes;       
        
    }
    
    //Buscamos y eliminamos los clientes por el numero de telefono
  public static void buscarEliminar(Long telefono) {
    // Iteramos sobre las entradas del mapa
    Iterator<Map.Entry<Integer, FormCliente>> iterator = contactos.entrySet().iterator();
    while (iterator.hasNext()) {
        Map.Entry<Integer, FormCliente> entry = iterator.next();
        Integer telefonoCliente = entry.getKey();

        // Comparación explícita con longValue()
        if (telefonoCliente.longValue() == telefono) {
            System.out.println("Cliente encontrado y eliminado: " + telefono);
            iterator.remove();
            break;
        }
    }
}
   
        
       
    
   
   }

  
      


