package model;

public class Catedratico {
    private int id;
    private String nombre;

    public Catedratico(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Catedratico() {
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

    @Override
    public String toString() {
        return "Catedratico{" + "id=" + id + ", nombre=" + nombre + '}';
    }
}
