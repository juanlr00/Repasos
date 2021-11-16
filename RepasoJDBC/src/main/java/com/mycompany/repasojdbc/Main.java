/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repasojdbc;

import java.util.ArrayList;
import models.Coche;

/**
 *
 * @author JuanLamasRubio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    CocheDAO dao = new CocheDAO();
    
    Coche c = new Coche("Tesla","1234GTC");
    
    dao.add(c);
    
        System.out.println(c);
        
        System.out.println("Contenido del garaje");
        System.out.println("--------------------");
        
        ArrayList<Coche> garaje = dao.List();
        garaje.forEach(
                (el) ->{
                    System.out.println(el.getModelo()+" ("+el.getMatricula()+")");
                }
        );
        
        System.out.println("Contenido del garaje");
        System.out.println("--------------------");
        
        ArrayList<Coche> teslas = dao.listTesla();
        
        garaje.forEach(
                (el) ->{
                    System.out.println(el.getModelo()+" ("+el.getMatricula()+")");
                }
        );
    }
    
}
