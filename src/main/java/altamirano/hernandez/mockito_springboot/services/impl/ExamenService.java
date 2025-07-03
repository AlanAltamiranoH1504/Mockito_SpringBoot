package altamirano.hernandez.mockito_springboot.services.impl;

import altamirano.hernandez.mockito_springboot.models.Examen;
import altamirano.hernandez.mockito_springboot.repositories.IExamenRepository;
import altamirano.hernandez.mockito_springboot.services.IExamenService;

import java.util.List;
import java.util.Optional;

public class ExamenService implements IExamenService {
    private IExamenRepository iExamenRepository;

    public ExamenService(IExamenRepository iExamenRepository) {
        this.iExamenRepository = iExamenRepository;
    }

    @Override
    public List<Examen> findAll() {
        return List.of();
    }

    @Override
    public Examen findById(int id) {
        return null;
    }

    @Override
    public Optional<Examen> findByNombre(String nombre) {
        Optional<Examen> examenToFound = iExamenRepository.findAll()
                .stream()
                .filter(examen -> examen.getNombre().equals(nombre)).findFirst();
        return examenToFound;
    }

    @Override
    public void save(Examen examen) {

    }
}
