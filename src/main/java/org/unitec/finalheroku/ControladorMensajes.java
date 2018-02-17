/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.finalheroku;

import java.lang.reflect.Method;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") //api aplication portatil interface
public class ControladorMensajes {
    
    @RequestMapping(value="/mensajito",method=RequestMethod.GET,
            headers={"Accept=application/json"})
    public Mensajito hola(){
    Mensajito mensa=new Mensajito("hola","Me asustan los temblores!");
    
    return mensa;
    }
}
