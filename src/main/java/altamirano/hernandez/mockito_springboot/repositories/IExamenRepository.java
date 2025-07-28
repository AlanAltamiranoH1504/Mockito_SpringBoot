package altamirano.hernandez.mockito_springboot.repositories;

import altamirano.hernandez.mockito_springboot.models.Examen;

import java.util.List;

public interface IExamenRepository {
    List<Examen> findAll();
    Examen saveExamen(Examen examen);
}
