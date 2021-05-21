package com.company.automatas.sintactico;

import com.company.pilaErrores.PilaErrores;
import com.company.tablaSimbolos.Simbolo;
import com.company.tablaSimbolos.TablaSimbolos;

public class Instrucciones {

    public TablaSimbolos tablaSimbolos;
    public PilaErrores pilaErrores;
    public int posicion;

    public void nuevoError(int error){
        posicion--;
        Simbolo s = tablaSimbolos.tablaSimbolos.get(posicion);
        System.out.println(s.toString() + "  actual = " + posicion + "   error =" + error);
        pilaErrores.ingresa(error,s.getLinea());
    }

    public Instrucciones(TablaSimbolos tablaSimbolos, PilaErrores pilaErrores,int posicion) {
        this.tablaSimbolos = tablaSimbolos;
        this.pilaErrores = pilaErrores;
        this.posicion = posicion;
        instrucciones();
    }

    public void instrucciones(){
        int cambio = posicion;
        Entrada ent = new Entrada(tablaSimbolos,pilaErrores,posicion); //ENTRADA
        posicion = ent.posicion;
        Salida sal = new Salida(tablaSimbolos,pilaErrores,posicion); //ENTRADA
        posicion = sal.posicion;
        EstructuraCiclo cic = new EstructuraCiclo(tablaSimbolos,pilaErrores,posicion); //MIENTRAS
        posicion = cic.posicion;
        EstructuraDecision des = new EstructuraDecision(tablaSimbolos,pilaErrores,posicion); //MIENTRAS
        posicion = des.posicion;
        Asignacion asg = new Asignacion(tablaSimbolos,pilaErrores,posicion); //ASIGNACION
        posicion = asg.posicion;
        if(cambio!=posicion)
            instrucciones();
    }
}
