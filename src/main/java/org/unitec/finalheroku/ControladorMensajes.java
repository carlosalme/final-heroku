/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.finalheroku;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api") //api aplication portatil interface
public class ControladorMensajes {
    
    @Autowired RepositorioMensajito repomensa;
    
    //Buscar todo
    @CrossOrigin
    @RequestMapping(value="/mensajito",method=RequestMethod.GET,
            headers={"Accept=application/json"})
    public ArrayList<Mensajito> hola(){
        
    
        return (ArrayList<Mensajito>) repomensa.findAll();
    }
    
    //buscar por id
    @CrossOrigin
    @RequestMapping(value="/mensajito",method=RequestMethod.GET,
            headers={"Accept=application/json"})
    public Mensajito hola(@PathVariable String id){
        
    return repomensa.findOne(id);
    }
    
    
    //Actualizar
    @CrossOrigin
    @RequestMapping(value="/mensajito/{id}/{titulo}/{cuerpo}",method=RequestMethod.PUT,
            headers={"accept=application/json"})
    public Estatus actualizar(@PathVariable String id,@PathVariable String titulo, @PathVariable String cuerpo){
        repomensa.save(new Mensajito(id,titulo, cuerpo));
        return new Estatus(true, "Actualizado con exito");
    }
    
    //Guardar
    @CrossOrigin
    @RequestMapping(value="/mensajito/{titulo}/{cuerpo}",method=RequestMethod.POST,
            headers={"accept=application/json"})
    public Estatus guardar(@PathVariable String titulo, @PathVariable String cuerpo){
        repomensa.save(new Mensajito(titulo, cuerpo));
        return new Estatus(true, "Guardado con exito");
    }
    
    //Guardar json
    @CrossOrigin
    @RequestMapping(value="/mensajito",method=RequestMethod.POST,
            headers={"accept=application/json"})
    public Estatus guardarJSON(@RequestBody String json)throws Exception{
        
        ObjectMapper maper=new ObjectMapper();
        Mensajito mensa= maper.readValue(json,Mensajito.class);
        repomensa.save(mensa);
        return new Estatus(true, "Guardado con exito");
    }
    
    //Borrar
    @CrossOrigin
    @RequestMapping(value="/mensajito/{id}",method = RequestMethod.DELETE,
            headers={"Accept=application/json"})
    public Estatus borrarMensaje(@PathVariable String id){
    
    Estatus estatus=new Estatus(true, "borrado con exito");
    repomensa.delete(new Mensajito(id));
    return estatus;
     }
}
