/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author JuanLamasRubio
 */
@Entity
@Table(name="curso")
public class Curso implements Serializable {
    
    @Id
    @GeneratedValue( strategy=IDENTITY)
    
    private Long id;
    private String nombre;
    private String profesor;
    
    //No siempre es necesario
    //Se pone curso porque es el atributo de la otra clase
    @OneToMany( mappedBy = "curso", cascade = CascadeType.ALL)
    //Importante iniciarla
    private Set<Alumno> alumnos = new HashSet(0);
    
    public Curso() {
    }

    public Curso(String nombre, String profesor) {
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", nombre=" + nombre + ", profesor=" + profesor + ", alumnos=" + alumnos + '}';
    }
    
}
