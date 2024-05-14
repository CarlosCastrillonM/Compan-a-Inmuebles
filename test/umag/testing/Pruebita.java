/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umag.testing;

import umag.datos.*;
import javax.swing.JOptionPane;
/**
 *
 * @author carla
 */
public class Pruebita {
    private static final String MENSAJE_BIENVENIDA = "1. Agregar Inmueble\n2. Valor de Alquiler dado un Codigo\n3. % de Casas con más de 2 Habitaciones\n4. % de Inmuebles no alquilados\n5. Alquiler de Inmueble\n6. Listado de Inmueble por Cliente\n7. Buscar Inmueble por ID";
    
    public static void main(String[] args) {
        
        int op;
        
        Compania compa = new Compania ("El Pepe");
        
        //          hab, id, estrato, alquilado, cliente
        Cliente cliente1 = new Cliente(1, 23, "Carlos", "si");
        Cliente cliente2 = new Cliente(33, 11, "ElMigue", "siquiero");
        Cliente cliente3 = new Cliente(32, 72, "Danielin", "NoGracias");

        
        Casa casita1 = new Casa(10, 1, 6, true, cliente1);
        Casa casita2 = new Casa(2, 2, 3, true, cliente2);
        Casa casita3 = new Casa(3, 5, 3, true, cliente3);
        Casa casita4 = new Casa(2, 7, 2, false, null);
        Casa casita5 = new Casa(5, 11, 1, false, null);
        Casa casita6 = new Casa(6, 32, 4, true, cliente1);
        Casa casita7 = new Casa(2, 23, 4, false, null);
        Casa casita8 = new Casa(4, 43, 3, true, cliente3);
        Casa casita9 = new Casa(7, 41, 2, false, null);
        Casa casita10 = new Casa(3, 47, 6, true, cliente3);
        Casa casita11 = new Casa(6, 51, 6, true, cliente1);
        Casa casita12 = new Casa(9, 83, 3, true, cliente2);
        compa.addInmueble(casita1);
        compa.addInmueble(casita2);
        compa.addInmueble(casita3);
        compa.addInmueble(casita4);
        compa.addInmueble(casita5);
        compa.addInmueble(casita6);
        compa.addInmueble(casita7);
        compa.addInmueble(casita8);
        compa.addInmueble(casita9);
        compa.addInmueble(casita10);
        compa.addInmueble(casita11);
        compa.addInmueble(casita12);

        Apartamento ap1 = new Apartamento(1, 3, 6, false, null);
        Apartamento ap2 = new Apartamento(3, 4, 4, true, cliente1);
        Apartamento ap3 = new Apartamento(4, 6, 5, true, cliente1);
        Apartamento ap4 = new Apartamento(4, 8, 3, false, null);
        Apartamento ap5 = new Apartamento(5, 9, 1, false, null);
        Apartamento ap6 = new Apartamento(2, 10, 2, false, null);
        Apartamento ap7 = new Apartamento(4, 12, 3, true, cliente1);
        Apartamento ap8 = new Apartamento(1, 14, 3, true, cliente2);
        Apartamento ap9 = new Apartamento(11, 16, 4, true, cliente3);
        Apartamento ap10 = new Apartamento(10, 18, 6, true, cliente3);
        compa.addInmueble(ap1);
        compa.addInmueble(ap2);
        compa.addInmueble(ap3);
        compa.addInmueble(ap4);
        compa.addInmueble(ap5);
        compa.addInmueble(ap6);
        compa.addInmueble(ap7);
        compa.addInmueble(ap8);
        compa.addInmueble(ap9);
        compa.addInmueble(ap10);

        
        
        do {
            
            op = Integer.parseInt(JOptionPane.showInputDialog(MENSAJE_BIENVENIDA));
            
            switch(op){
                
                case 1:
                    Cliente cliente = null;
                    String[] opcion = {"Si", "No"};
                    boolean[] estados = {true, false};
                    
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Digite el ID del Inmueble"));
                    int estrato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el estrato"));
                    String tipo = JOptionPane.showInputDialog("Digite el tipo de Inmueble");
                    int estaAlquilado = JOptionPane.showOptionDialog(null, "El Inmueble se encuentra alquilado?", "Esta Alquilado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcion, "Si");
                    
                    if (estados[estaAlquilado] == true) {
                        int cedula = Integer.parseInt(JOptionPane.showInputDialog("Digite la Identificacion del Cliente"));
                        String nombre = JOptionPane.showInputDialog("Digite el Nombre del Dueño del Inmueble");
                        int edad = Integer.parseInt(JOptionPane.showInputDialog("Digite la edad"));
                        String sexo = JOptionPane.showInputDialog("Digite el Sexo");
                        
                        cliente = new Cliente(cedula, edad, nombre, sexo);
                    }
                    
                    if (tipo.equalsIgnoreCase("casa")) {
                        int numHab = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Numero de Habitaciones"));
                        Casa casa = new Casa(numHab, id, estrato, estados[estaAlquilado], cliente);
                        compa.addInmueble(casa);

                    
                    } else if(tipo.equalsIgnoreCase("apartamento")) {
                        int numPiso = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Numero del Piso"));
                        Apartamento apartamento = new Apartamento(numPiso, id, estrato, estados[estaAlquilado], cliente);
                        compa.addInmueble(apartamento);
                    }
                    
                    
                break;
                
                case 2:
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del inmueble"));
                    JOptionPane.showMessageDialog(null, "El Valor es: " + compa.buscarValAlquiler(codigo));
                break;
                
                case 3:
                    JOptionPane.showMessageDialog(null, "Porcentaje de casas con mas de dos habitaciones: " + compa.porcentajeCasas());
                break;
                
                case 4:
                    JOptionPane.showMessageDialog(null, "Porcentaje de inmuebles no alquilados: " + compa.porcentajeInmNoAlq());
                break;
                
                case 5:
                    JOptionPane.showMessageDialog(null,"Los Inmuebles disponibles son:\n" + compa.listaInmueblesDisp());
                    id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del Inmueble al cual le asignara el cliente"));
                    
                    int cedula = Integer.parseInt(JOptionPane.showInputDialog("Digite la Identificacion"));
                    String nombre = JOptionPane.showInputDialog("Digite el Nombre del Dueño del Inmueble");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Digite la edad"));
                    String sexo = JOptionPane.showInputDialog("Digite el Sexo");
                    
                    
                    cliente = new Cliente(cedula, edad, nombre, sexo);
                    compa.setListInmueblesPorId(id, cliente);
                break;
                
                case 6:
                    JOptionPane.showMessageDialog(null, compa.listaDeInmueblesPorCliente());
                break;
                
                case 7:
                    //buscar
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite el id del inmueble a buscar"));
                    JOptionPane.showMessageDialog(null, "El inmueble es:  " + compa.buscar(id));
                break;
            }
            
        } while (op != 9);
        
        
        
        
        
        
    }
}
