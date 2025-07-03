package altamirano.hernandez.mockito_springboot.repositories;

import altamirano.hernandez.mockito_springboot.models.Examen;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IExamenRepositoryOther implements IExamenRepository{

    @Override
    public List<Examen> findAll() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
