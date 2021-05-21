package com.company.automatas.sintactico;

import com.company.pilaErrores.PilaErrores;
import com.company.tablaSimbolos.Simbolo;
import com.company.tablaSimbolos.TablaSimbolos;


public class Asignacion {
    public TablaSimbolos tablaSimbolos;
    public PilaErrores pilaErrores;
    public int posicion;

    public void nuevoError(int error){
        posicion--;
        Simbolo s = tablaSimbolos.tablaSimbolos.get(posicion);
        System.out.println(s.toString() + "  actual = " + posicion + "   error =" + error);
        pilaErrores.ingresa(error,s.getLinea());
    }

    public Asignacion(TablaSimbolos tablaSimbolos, PilaErrores pilaErrores,int posicion) {
        this.tablaSimbolos = tablaSimbolos;
        this.pilaErrores = pilaErrores;
        this.posicion = posicion;
        q0();
    }


    void q0(){
        //System.out.println("ASIGNACION q0 " + posicion);
        int token = tablaSimbolos.tablaSimbolos.get(posicion).getToken();
        if(token == 70){ //ID
            siguienteToken();
            q1();
        }
    }

    void q1(){
        //System.out.println("ASIGNACION q1 "+ posicion);
        switch (siguienteToken()){
            case 25: //IGUAL
                q2();
                break;
            default:
                nuevoError(218); //IGUAL
        }
    }

    void q2(){
        //System.out.println("ASIGNACION q2 "+ posicion);
        int ver = posicion;
        Entrada ent = new Entrada(tablaSimbolos,pilaErrores,posicion); //ENTRADA
        posicion = ent.posicion;
        if(ver == posicion) {
            Expresion exp = new Expresion(tablaSimbolos, pilaErrores,posicion); //EXPRESIONES
            posicion = exp.posicion;
            if(ver==posicion)
                nuevoError(217); //NO HAY QUE ASIGNAR
            else
                q4();
        }
        else{
            q3();
        }
    }

    void q3(){
        //System.out.println("ASIGNACION q3 "+ posicion);

    }

    void q4(){
        //System.out.println("ASIGNACION q4 "+ posicion);
        switch (siguienteToken()){
            case 60: //PUNTOYCOMA
                q3();
                break;
            default:
                nuevoError(219); //PUNTOYCOMA
        }
    }


    public int siguienteToken(){
        int x = tablaSimbolos.tablaSimbolos.get(posicion).getToken();
        posicion++;
        return x;
    }
}
