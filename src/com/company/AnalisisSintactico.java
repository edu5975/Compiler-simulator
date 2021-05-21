package com.company;

import com.company.automatas.sintactico.*;
import com.company.pilaErrores.PilaErrores;
import com.company.tablaSimbolos.Simbolo;
import com.company.tablaSimbolos.TablaSimbolos;

public class AnalisisSintactico{
    public TablaSimbolos tablaSimbolos = new TablaSimbolos();
    public PilaErrores pilaErrores = new PilaErrores();
    public int actual = 0;

    public AnalisisSintactico(TablaSimbolos tablaSimbolos, PilaErrores pilaErrores) {
        this.tablaSimbolos = tablaSimbolos;
        this.pilaErrores = pilaErrores;
    }

    public AnalisisSintactico() {
    }

    public void analizar(){
        if(siguienteToken()!=1)  nuevoError(210);  //PROGRAMA
        if(siguienteToken()!=70) nuevoError(211);  //ID
        if(siguienteToken()!=61) nuevoError(212);  //LLAVEI
        Declaraciones dec = new Declaraciones(tablaSimbolos,pilaErrores,actual); //DECLARACIONES
        actual = dec.posicion;
        Procedimientos poc = new Procedimientos(tablaSimbolos,pilaErrores,actual); //PROCEDIMIENTOS
        actual = poc.posicion;
        if(siguienteToken()!=2)  nuevoError(214);  //PRINCIPAL
        if(siguienteToken()!=63) nuevoError(215);  //PARI
        if(siguienteToken()!=64) nuevoError(216);  //PARD
        if(siguienteToken()!=61) nuevoError(212);  //LLAVEI
        Instrucciones ins = new Instrucciones(tablaSimbolos,pilaErrores,actual); //INSTRUCCIONES
        actual = ins.posicion;
        if(siguienteToken()!=62) nuevoError(213);  //LLAVED
        if(siguienteToken()!=62) nuevoError(213);  //LLAVED
    }

    public int siguienteToken(){
        int x = tablaSimbolos.tablaSimbolos.get(actual).getToken();
        actual++;
        return x;
    }

    public void nuevoError(int error){
        actual--;
        Simbolo s = tablaSimbolos.tablaSimbolos.get(actual);
        System.out.println(s.toString() + "  actual = " + actual + "   error =" + error);
        pilaErrores.ingresa(error,s.getLinea());
    }
}
