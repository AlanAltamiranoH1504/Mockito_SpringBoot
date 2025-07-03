package altamirano.hernandez.mockito_springboot.services.impl;

import altamirano.hernandez.mockito_springboot.models.Examen;
import altamirano.hernandez.mockito_springboot.repositories.IExamenRepository;
import altamirano.hernandez.mockito_springboot.services.IExamenService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ExamenServiceTest {

    @Test
    @DisplayName("Test de busqueda de examen por nombre")
    void findByNombre() {
        //Mock de IExamenRepository
        IExamenRepository iExamenRepository = Mockito.mock(IExamenRepository.class);
        IExamenService iExamenService = new ExamenService(iExamenRepository);
        //Datos de prueba
        List<Examen> datos = Arrays.asList(
                new Examen(1, "Examen de arquitectura"),
                new Examen(2, "Examen del Proyectos"),
                new Examen(3, "Examen de buenas praticas"),
                new Examen(4, "Examen de sistemas informaticos")
        );
        //Cuando se invoque el metodo findAll del repositorio, se returna los datos de prueba
        Mockito.when(iExamenRepository.findAll()).thenReturn(datos);
        Optional<Examen> examen = iExamenService.findByNombre("Examen de arquitectura");

        assertTrue(examen.isPresent(), "El no fue encontrado");
        assertEquals("Examen de arquitectura", examen.get().getNombre(), "El nombre del examen no es 'Examen de arquitectura'");
        assertEquals(1, examen.get().getId(), "El id del examen no es igual a 1");
    }

    @Test
    @DisplayName("Test de busqueda de examen con lista vacia")
    void findByNombreEmpty() {
        //Mock de IExamenRepository
        IExamenRepository iExamenRepository = Mockito.mock(IExamenRepository.class);
        IExamenService iExamenService = new ExamenService(iExamenRepository);

        //Datos de prueba
        List<Examen> datosVacios = Collections.emptyList();
        Mockito.when(iExamenRepository.findAll()).thenReturn(datosVacios);
        Optional<Examen> examen = iExamenService.findByNombre("Examen de arquitectura");

        assertFalse(examen.isPresent(), "El examen si fue encontrado");
    }
}