/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umag.datos;

/**
 *
 * @author carla
 */
public class Casa extends Inmueble {
    private int habitaciones;

    public Casa(int habitaciones, int id, int estrato, boolean estaAlquilado, Cliente cliente) {
        super(id, "casa", estrato, estaAlquilado, cliente);
        this.habitaciones = habitaciones;
    }
    
    @Override
    public void valorAlquiler () {
        if (habitaciones > 0) {
            setValor((habitaciones-2)*(120000f) + 250000f);
            super.valPorEstratoSeis();
        }
    }
    
    /**
     * @return the habitaciones
     */
    public int getHabitaciones() {
        return habitaciones;
    }

    /**
     * @param habitaciones the habitaciones to set
     */
    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    @Override
    public String toString() {
        return  " Casa (" + getId() + ")  Numero de Habitaciones: " + habitaciones + "  Estrato: " + getEstrato();
    }
    
}
