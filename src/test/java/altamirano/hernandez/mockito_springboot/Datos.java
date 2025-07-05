package altamirano.hernandez.mockito_springboot;

import altamirano.hernandez.mockito_springboot.models.Examen;

import java.util.Arrays;
import java.util.List;

public class Datos {
    //Datos de prueba
    public static final List<Examen> EXAMENES = Arrays.asList(
            new Examen(1, "Examen de arquitectura"),
            new Examen(2, "Examen del Proyectos"),
            new Examen(3, "Examen de buenas praticas"),
            new Examen(4, "Examen de sistemas informaticos")
    );
    public static final List<String> PREGUNTAS = Arrays.asList("Diferencias", "Integral", "Geometria");
}
