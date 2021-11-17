/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author JuanLamasRubio
 */
@Entity
@Table(name="alumno")
public class Alumno implements Serializable {
    @Id
    @GeneratedValue( strategy=IDENTITY)
    
    private Long id;
    
    private String nombre;
    private Date nacimiento;
    
    //Esto no entra en el examen
    @Transient
    private Integer edad;
    
    @ManyToOne
    @JoinColumn( name = "curso_id")    
    private Curso curso;

    public Alumno() {
    }

    public Alumno(String nombre, Date nacimiento) {
        this.nombre = nombre;
        this.nacimiento = nacimiento;
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

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre=" + nombre + ", nacimiento=" + nacimiento + ", curso=" + curso.getNombre() + '}';
    }
      
}