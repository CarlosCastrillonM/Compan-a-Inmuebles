/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umag.datos;

/**
 *
 * @author carla
 */
public class Apartamento extends Inmueble {
    private int numPiso;

    public Apartamento(int numPisos, int id, int estrato, boolean estaAlquilado, Cliente cliente) {
        super(id, "apartamento", estrato, estaAlquilado, cliente);
        this.numPiso = numPisos;
    }
    
    
    @Override
    public void valorAlquiler () {
        
        if (numPiso > 0 && numPiso <= 5) {
            setValor(500000f);
        
        } else if (numPiso > 5 && numPiso <= 10) {
            setValor(700000f);
        
        } else if (numPiso == 11) {
            setValor(1000000f);
        }
        super.valPorEstratoSeis();
    }

    /**
     * @return the numPisos
     */
    public int getNumPisos() {
        return numPiso;
    }

    /**
     * @param numPisos the numPisos to set
     */
    public void setNumPisos(int numPisos) {
        this.numPiso = numPisos;
    }

    @Override
    public String toString() {
         return  " Apartamento (" + getId() + ")  Numero de Piso: " + numPiso + "  Estrato: " + getEstrato();
    }
    
}
