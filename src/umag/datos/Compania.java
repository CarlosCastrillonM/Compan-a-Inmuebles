/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umag.datos;

import java.util.ArrayList;
/**
 *
 * @author carla
 */
public class Compania {
    private String nombre;
    private ArrayList<Inmueble> inmuebles;
    private ArrayList<Cliente> clientes;

    public Compania(String nombre) {
        this.nombre = nombre;
        inmuebles = new ArrayList<>();
        clientes = new ArrayList<>();
    }
    
    public void addInmueble(Inmueble inmueble) {
        inmuebles.add(inmueble);
    }
    
    public float buscarValAlquiler(int id) {
        if (!inmuebles.isEmpty()) {
            for (Inmueble inmueble : inmuebles) {
                if (inmueble.getId() == id) {
                    return inmueble.getValor();
                }
            }
        }
        return -1;
    }
    
    public float porcentajeCasas() {
        if (!inmuebles.isEmpty()) {
            int count = 0;
            float total = 0;
            
            for (Inmueble inmueble : inmuebles) {
                if (inmueble instanceof Casa casa) {
                    if (casa.getHabitaciones() > 2) {
                        count++;
                    }
                    total++;
                }
            }
            return (float)count/total*100;
        }
        return -1;
    }
    
    public float porcentajeInmNoAlq() {
        if (!inmuebles.isEmpty()) {
            int count = 0;
            
            for (Inmueble inmueble : inmuebles) {
                if (!inmueble.isEstaAlquilado()) {
                    count++;
                }
            }
            return (float)count/inmuebles.size()*100;
        }
        return -1;
    }
    
    public String listaInmueblesDisp() {
        if (!inmuebles.isEmpty()) {
            String lista = "";
            
            for (Inmueble inmueble : inmuebles) {
                if (!inmueble.isEstaAlquilado()) {    
                    if (inmueble instanceof Casa casa) {
                        lista += "Casa  id: " + casa.getId() + "   Numero de Habitaciones: " + casa.getHabitaciones() + "\n";

                    } else if (inmueble instanceof Apartamento ap) {
                        lista += "Apartamento  id: " + ap.getId() + "   Numero de Piso: " + ap.getNumPisos() + "\n";
                    }
                }
            }
            return lista;
        }
        return "No hay inmuebles disponibles";
    }
    
    public void setListInmueblesPorId(int id, Cliente cliente) {
        if (!inmuebles.isEmpty()) {
            for (int i = 0; i < inmuebles.size(); i++) {
                if (!inmuebles.get(i).isEstaAlquilado() && inmuebles.get(i).getId() == id) {
                    inmuebles.get(i).setCliente(cliente);
                    inmuebles.get(i).setEstaAlquilado(true);
                }
            }
        }
    }
    
    //Listado de inmueble por cliente
    public String listaDeInmueblesPorCliente() {
        
        ArrayList<Integer> idClientes = new ArrayList<>();
        String lista = "";
        
        for (int i = 0; i < inmuebles.size(); i++) {
            
            if (inmuebles.get(i).getCliente() == null) {
                continue;
            }
            
             Cliente cliente = inmuebles.get(i).getCliente();
            
             if (idClientes.contains(cliente.getId())) {
                 continue;
             }
             
            idClientes.add(cliente.getId());
            
            lista += "Estos son los inmuebles de " + cliente.getNombre() + "\n";
            
            for (Inmueble inmueble : inmuebles) {
                if (inmueble.getCliente() == null || inmueble.getCliente().getId() != cliente.getId()) {
                    continue;
                }
                
                lista += inmueble.toString() + "\n";
            }
        }
        //      [1, 4, 7, 9]        [1, 4, 7, 9]
        return lista;
    }
    
    

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the inmuebles
     */
    public ArrayList<Inmueble> getInmuebles() {
        return inmuebles;
    }

    /**
     * @param inmuebles the inmuebles to set
     */
    public void setInmuebles(ArrayList<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    @Override
    public String toString() {
        return "Compania{" + "nombre=" + nombre + ", inmuebles=" + inmuebles + '}';
    }
    
}
