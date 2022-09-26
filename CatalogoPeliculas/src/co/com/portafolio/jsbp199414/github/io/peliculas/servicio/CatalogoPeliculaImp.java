package co.com.portafolio.jsbp199414.github.io.peliculas.servicio;

import co.com.portafolio.jsbp199414.github.io.peliculas.datos.AccesoDatosImple;
import co.com.portafolio.jsbp199414.github.io.peliculas.datos.IAccesoDatos;
import co.com.portafolio.jsbp199414.github.io.peliculas.domain.Pelicula;
import co.com.portafolio.jsbp199414.github.io.peliculas.excepciones.DatosAccesoEx;
import co.com.portafolio.jsbp199414.github.io.peliculas.excepciones.LecturaAccesoEx;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CatalogoPeliculaImp implements ICatalogoPeliculas {
    
    private final IAccesoDatos datos;
    
    public CatalogoPeliculaImp() {
        this.datos = new AccesoDatosImple();
    }
    
    @Override
    public void agregarPeliculas(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (DatosAccesoEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
    }
    
    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            for (Pelicula pelicula : peliculas) {
                System.out.println("Pelicula " + pelicula);
            }
        } catch (DatosAccesoEx ex) {
            System.out.println("Error acceso datos");
            ex.printStackTrace(System.out);
        }
    }
    
    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (DatosAccesoEx ex) {
            System.out.println("Error acceso datos");
            ex.printStackTrace(System.out);
        }
        System.out.println("resultado: Pelicula no encontrada");
    }
    
    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if (this.datos.existe(NOMBRE_RECURSO)) {
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }else{
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (DatosAccesoEx ex) {
             System.out.println("Error al iniciar catalogo peliculas");
            ex.printStackTrace(System.out);
        }
    }
    
}
