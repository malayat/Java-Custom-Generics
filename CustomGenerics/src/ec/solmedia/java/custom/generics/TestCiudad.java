/*
 * Copyright (C) 2015 Alejandro Ayala
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ec.solmedia.java.custom.generics;

/**
 * <p>Clase que crea los direntes nodos de ciudades y planifica la ruta
 * especificando que ciudad es la primera y cual es la siguiente o la anterior
 * ciudad.</p>
 * <p>Finalmente se representan mediante metodos las ciudades que se debe
 * atravezar para establecer un viaje de ida y de vuelta.</p>
 * @author Alejandro Ayala
 */
public class TestCiudad {

    public static void main(String[] args) {
        Ciudad quito = new Ciudad("Quito");
        Ciudad guayaquil = new Ciudad("Guayaquil");
        Ciudad rio = new Ciudad("Riobamba");
        Ciudad cuenca = new Ciudad("Cuenca");
        
        Nodo<Ciudad> nodoQuito = new Nodo(quito);
        Nodo<Ciudad> nodoGuay = new Nodo(guayaquil);
        Nodo<Ciudad> nodoRio = new Nodo(rio);
        Nodo<Ciudad> nodoCuenca = new Nodo(cuenca);
        
        nodoQuito.setSiguiente(nodoRio);
        nodoRio.setSiguiente(nodoCuenca);
        nodoRio.setAnterior(nodoQuito);
        nodoCuenca.setAnterior(nodoRio);
        viajeIda(nodoQuito);
        System.out.println("================");
        viajeVuelta(nodoCuenca);
    }
    
    /**
     * Metodo recursivo que representa un viaje de "vuelta" entre dos ciudades
     * @param nodo      Generico Nodo ciudad
     */
    private static void viajeVuelta(Nodo<Ciudad> nodo) {
        System.out.println(nodo.getDato().getNombre());
        if(nodo.getAnterior() != null) {
            viajeVuelta(nodo.getAnterior());
        }
    }
    
    /**
     * Metodo recursivo que representa un viaje de "regreso" entre dos ciudades
     * @param nodo      Generico Nodo ciudad
     */
    private static void viajeIda(Nodo<Ciudad> nodo) {
        System.out.println(nodo.getDato().getNombre());
        if(nodo.getSiguiente() != null) {
            viajeIda(nodo.getSiguiente());
        }
    }
}
