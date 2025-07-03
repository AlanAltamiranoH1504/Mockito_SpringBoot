package altamirano.hernandez.mockito_springboot.services;

import altamirano.hernandez.mockito_springboot.models.Examen;

import java.util.List;
import java.util.Optional;

public interface IExamenService {
    public abstract List<Examen> findAll();
    public abstract Examen findById(int id);
    public abstract Optional<Examen> findByNombre(String nombre);
    public abstract void save(Examen examen);
}
