/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repasohibernate;

import java.util.ArrayList;
import models.Alumno;
import models.Curso;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author JuanLamasRubio
 */
public class AcademiaDAO {
    
    private static SessionFactory sessionFactory;
    
    static{
        try{
        sessionFactory = new Configuration().configure().buildSessionFactory();
        System.out.println("Conexion establecida");
        
        }catch (Exception ex) {
            System.out.println("Error al conectar");
            System.out.println(ex);
        }
    }
    
    //Añadir alumno a un curso
    public void addToCurso(Alumno a, Curso c) {
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        a.setCurso(c);
        c.getAlumnos().add(a);
        s.saveOrUpdate(c);
        s.saveOrUpdate(a);
        t.commit();
        s.close();
    }
    
    public void print() {
        Session s = sessionFactory.openSession();
        //Opcion 1 exclusiva de hibernate
        Query q = s.createQuery("FROM Curso");
        //Opcion 2
        //Query <Curso> q2 = s.createNamedQuery("FROM Curso", Curso.class);
        
        ArrayList<Curso> todo = (ArrayList<Curso>) q.list();
        
        System.out.println("\n\nEn la academia hay "+todo.size()+" curso:");
        
        //Opcion 1
        for(Curso c : todo) {
            System.out.println(c.getNombre());
            System.out.println(c.getProfesor());
            System.out.println(c.getAlumnos());
            System.out.println();
        }
        
        //Opcion 2
//        todo.forEach(
//                (c) ->{
//                    System.out.println(c.getNombre());
//                    System.out.println(c.getProfesor());
//                    System.out.println(c.getAlumnos());
//                    System.out.println();;
//                }
//        );
        
        s.close();
    }
}
