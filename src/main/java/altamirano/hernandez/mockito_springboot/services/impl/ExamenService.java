package altamirano.hernandez.mockito_springboot.services.impl;

import altamirano.hernandez.mockito_springboot.models.Examen;
import altamirano.hernandez.mockito_springboot.repositories.IExamenRepository;
import altamirano.hernandez.mockito_springboot.repositories.IPreguntasRepository;
import altamirano.hernandez.mockito_springboot.services.IExamenService;

import java.util.List;
import java.util.Optional;

public class ExamenService implements IExamenService {
    private IExamenRepository iExamenRepository;
    private IPreguntasRepository iPreguntasRepository;

    public ExamenService(IExamenRepository iExamenRepository, IPreguntasRepository iPreguntasRepository) {
        this.iExamenRepository = iExamenRepository;
        this.iPreguntasRepository = iPreguntasRepository;
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
    public Optional<Examen> findByNombreAndPreguntas(String nombreExamen) {
        Optional<Examen> examen = this.findByNombre(nombreExamen);
        if (examen.isPresent()) {
            List<String> preguntas = iPreguntasRepository.findPreguntasByExamenId(examen.get().getId());
            examen.get().setPreguntas(preguntas);
        }
        return examen;
    }

    @Override
    public void save(Examen examen) {

    }

    @Override
    public Examen saveExamen(Examen examen) {
        if (!examen.getPreguntas().isEmpty()){
            iPreguntasRepository.guardarPreguntas(examen.getPreguntas());
        }
        return iExamenRepository.saveExamen(examen);
    }
}
