package co.com.portafolio.jsbp199414.github.io.peliculas.datos;

import co.com.portafolio.jsbp199414.github.io.peliculas.domain.Pelicula;
import co.com.portafolio.jsbp199414.github.io.peliculas.excepciones.*;
import java.util.List;

public interface IAccesoDatos {

    boolean existe(String nombreRecurso) throws DatosAccesoEx;

    List<Pelicula> listar(String nombreRecurso) throws LecturaAccesoEx;

    void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreRecurso, String buscar) throws LecturaAccesoEx;

    void crear(String nombreRecurso) throws DatosAccesoEx;

    void borrar(String nombreRecurso) throws DatosAccesoEx;

}
