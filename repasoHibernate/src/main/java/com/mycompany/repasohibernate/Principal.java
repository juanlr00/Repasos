package com.mycompany.repasohibernate;

import java.util.Date;
import models.Alumno;
import models.Curso;

/**
 *
 * @author JuanLamasRubio
 */
public class Principal {

    public static void main(String[] args) {
       
        AcademiaDAO dao = new AcademiaDAO();
        
        Alumno a = new Alumno("Francisco",new Date());
        Alumno a1 = new Alumno("Pablo",new Date());
        Alumno a2 = new Alumno("Juan",new Date());
        
        Curso c = new Curso("Acceso a datos","Romero");
        Curso c1 = new Curso("Interfaces","Romero");
        
        dao.addToCurso(a, c);
         dao.addToCurso(a1, c);
          dao.addToCurso(a2, c);
           dao.addToCurso(a2, c1);
           
        dao.print();
        
    }
    
}
