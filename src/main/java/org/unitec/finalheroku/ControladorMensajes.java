/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.finalheroku;

import java.lang.reflect.Method;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") //api aplication portatil interface
public class ControladorMensajes {
    
    @Autowired RepositorioMensajito repomensa;
    
    @RequestMapping(value="/mensajito",method=RequestMethod.GET,
            headers={"Accept=application/json"})
    public ArrayList<Mensajito> hola(){
        
    
        return (ArrayList<Mensajito>) repomensa.findAll();
    }
    
    @RequestMapping(value="/mensajito/{id}/{titulo}/{cuerpo}",method=RequestMethod.GET,
            headers={"accept=application/json"})
    public Estatus guardar(@PathVariable String id,@PathVariable String titulo, @PathVariable String cuerpo){
        repomensa.save(new Mensajito(id,titulo, cuerpo));
        return new Estatus(true, "Guardado con exito");
    }
}
