/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umag.datos;

/**
 *
 * @author carla
 */
public abstract class Inmueble {
    private int id;
    private String tipo;
    protected float valor;
    private int estrato;
    private boolean estaAlquilado;
    private Cliente cliente;

    public Inmueble(int id, String tipo, int estrato, boolean estaAlquilado) {
        this.id = id;
        this.tipo = tipo;
        this.estrato = estrato;
        this.estaAlquilado = estaAlquilado;
    }

    public Inmueble(int id, String tipo, int estrato, boolean estaAlquilado, Cliente cliente) {
        this.id = id;
        this.tipo = tipo;
        this.estrato = estrato;
        this.estaAlquilado = estaAlquilado;
        this.cliente = cliente;
    }
    
    
    public abstract void valorAlquiler();
    
    
    public void valPorEstratoSeis() {
        if (getEstrato() == 6) {
            setValor(valor + valor* 0.10f);
        }
    }
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        valorAlquiler();
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    /**
     * @return the estrato
     */
    public int getEstrato() {
        return estrato;
    }

    /**
     * @param estrato the estrato to set
     */
    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }
    
    /**
     * @return the estaAlquilado
     */
    public boolean isEstaAlquilado() {
        return estaAlquilado;
    }

    /**
     * @param estaAlquilado the estaAlquilado to set
     */
    public void setEstaAlquilado(boolean estaAlquilado) {
        this.estaAlquilado = estaAlquilado;
    }
    
    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Inmueble{" + "id=" + id + ", tipo=" + tipo + ", valor=" + valor + ", estrato=" + estrato + ", estaAlquilado=" + estaAlquilado + ", cliente=" + cliente + '}';
    }
}
