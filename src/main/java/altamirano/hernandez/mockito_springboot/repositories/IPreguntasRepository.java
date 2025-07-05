package altamirano.hernandez.mockito_springboot.repositories;

import java.util.List;

public interface IPreguntasRepository {
    public abstract List<String> findPreguntasByExamenId(int examenId);
}
