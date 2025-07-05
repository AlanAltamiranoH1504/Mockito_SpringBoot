package altamirano.hernandez.mockito_springboot.services.impl;

import altamirano.hernandez.mockito_springboot.Datos;
import altamirano.hernandez.mockito_springboot.models.Examen;
import altamirano.hernandez.mockito_springboot.repositories.IExamenRepository;
import altamirano.hernandez.mockito_springboot.repositories.IPreguntasRepository;
import altamirano.hernandez.mockito_springboot.services.IExamenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ExamenServiceTest {
    //Atributos de la clase
    @Mock
    IExamenRepository iExamenRepository;
    @Mock
    IPreguntasRepository iPreguntasRepository;
    @InjectMocks
    ExamenService ExamenService;


    @BeforeEach
    void setUp() {
        //Habilitacion de inyeccion de anotaciones
        MockitoAnnotations.openMocks(this);
        //Mock de IExamenRepository

//        iExamenRepository = Mockito.mock(IExamenRepository.class);
//        iPreguntasRepository = Mockito.mock(IPreguntasRepository.class);
//        ExamenService = new ExamenService(iExamenRepository, iPreguntasRepository);
    }

    @Test
    @DisplayName("Test de busqueda de examen por nombre")
    void findByNombre() {
//        //Datos de prueba
//        List<Examen> datos = Arrays.asList(
//                new Examen(1, "Examen de arquitectura"),
//                new Examen(2, "Examen del Proyectos"),
//                new Examen(3, "Examen de buenas praticas"),
//                new Examen(4, "Examen de sistemas informaticos")
//        );
        //Cuando se invoque el metodo findAll del repositorio, se returna los datos de prueba
        Mockito.when(iExamenRepository.findAll()).thenReturn(Datos.EXAMENES);
        Optional<Examen> examen = ExamenService.findByNombre("Examen de arquitectura");

        assertTrue(examen.isPresent(), "El no fue encontrado");
        assertEquals("Examen de arquitectura", examen.get().getNombre(), "El nombre del examen no es 'Examen de arquitectura'");
        assertEquals(1, examen.get().getId(), "El id del examen no es igual a 1");
    }

    @Test
    @DisplayName("Test de busqueda de examen con lista vacia")
    void findByNombreEmpty() {
        //Datos de prueba
        List<Examen> datosVacios = Collections.emptyList();
        Mockito.when(iExamenRepository.findAll()).thenReturn(datosVacios);
        Optional<Examen> examen = ExamenService.findByNombre("Examen de arquitectura");

        assertFalse(examen.isPresent(), "El examen si fue encontrado");
    }

    @Test
    @DisplayName("Test de busqueda de preguntas de examen por ID de examen")
    void testPreguntasExamen() {
        Mockito.when(iExamenRepository.findAll()).thenReturn(Datos.EXAMENES);
        Mockito.when(iPreguntasRepository.findPreguntasByExamenId(1)).thenReturn(Datos.PREGUNTAS);
        Optional<Examen> examen = ExamenService.findByNombreAndPreguntas("Examen de arquitectura");
        assertEquals(3, examen.get().getPreguntas().size(), "El numero de preguntas del examen no es igual a 3");
        assertTrue(examen.get().getPreguntas().contains("Diferencias"), "La pregunta no se encuentra");
    }

    @Test
    @DisplayName("Test de verificacion de invocacion de metodo findAll y findPreguntasPorId")
    void testPreguntasExamenVerify() {
        Mockito.when(iExamenRepository.findAll()).thenReturn(Datos.EXAMENES);
        Mockito.when(iPreguntasRepository.findPreguntasByExamenId(1)).thenReturn(Datos.PREGUNTAS);
        Optional<Examen> examen = ExamenService.findByNombreAndPreguntas("Examen de arquitectura");
        assertEquals(3, examen.get().getPreguntas().size(), "El numero de preguntas del examen no es igual a 3");
        assertTrue(examen.get().getPreguntas().contains("Diferencias"), "La pregunta no se encuentra");
        //Verficiar que se invoco el metodo findAll y findPreguntasPorId
        Mockito.verify(iExamenRepository).findAll();
        Mockito.verify(iPreguntasRepository).findPreguntasByExamenId(1);
    }

    @Test
    @DisplayName("Test de verificacion de no invovacion al metodo findAll y findPreguntasPorId")
    void testPreguntasExameNotVerify() {
        Mockito.when(iExamenRepository.findAll()).thenReturn(Datos.EXAMENES);
        Mockito.when(iPreguntasRepository.findPreguntasByExamenId(1)).thenReturn(Datos.PREGUNTAS);
        Optional<Examen> examen = ExamenService.findByNombreAndPreguntas("Examen de arquitectura");

        //Verificiar que no se invoque los metodos
        Mockito.verify(iExamenRepository, Mockito.never()).findAll();
        Mockito.verify(iExamenRepository, Mockito.never());
    }
}