package co.com.portafolio.jsbp199414.github.io.peliculas.vista;

import co.com.portafolio.jsbp199414.github.io.peliculas.servicio.CatalogoPeliculaImp;
import co.com.portafolio.jsbp199414.github.io.peliculas.servicio.ICatalogoPeliculas;
import java.util.Scanner;

public class CatalogoPeliculasVista {

    public static void main(String[] args) {
        var opcion = -1;
        var scanner = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculaImp();

        while (opcion != 0) {
            System.out.println("Escoge una opcion \n"
                    + "1. Iniciar catalogo peliculas \n"
                    + "2. Agregar pelicula \n"
                    + "3. Listar pelicula \n"
                    + "4. Buscar pelicula \n"
                    + "0. salir");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula");
                    var nombrePelicula = scanner.nextLine();
                    catalogo.agregarPeliculas(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Introduce una pelicula a buscar");
                    var buscar = scanner.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;
                case 0:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        }

    }
}

