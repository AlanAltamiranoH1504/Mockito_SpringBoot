package altamirano.hernandez.mockito_springboot.repositories;

import altamirano.hernandez.mockito_springboot.models.Examen;

import java.util.Collections;
import java.util.List;

public class ImplExamenRepository implements IExamenRepository {
    @Override
    public List<Examen> findAll() {
//        return Arrays.asList(
//                new Examen(1, "Examen de arquitectura"),
//                new Examen(2, "Examen del Proyectos"),
//                new Examen(3, "Examen de buenas praticas"),
//                new Examen(4, "Examen de sistemas informaticos")
//        );
        return Collections.emptyList();
    }

    @Override
    public Examen saveExamen(Examen examen) {
        return null;
    }
}
