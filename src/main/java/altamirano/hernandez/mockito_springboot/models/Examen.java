package altamirano.hernandez.mockito_springboot.models;

import java.util.List;

public class Examen {
    private int id;
    private String nombre;
    private List<String> preguntas;

    public Examen() {
    }

    public Examen(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Examen(int id, String nombre, List<String> preguntas) {
        this.id = id;
        this.nombre = nombre;
        this.preguntas = preguntas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<String> preguntas) {
        this.preguntas = preguntas;
    }
}
