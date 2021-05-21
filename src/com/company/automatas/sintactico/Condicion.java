package com.company.automatas.sintactico;

import com.company.pilaErrores.PilaErrores;
import com.company.tablaSimbolos.Simbolo;
import com.company.tablaSimbolos.TablaSimbolos;


public class Condicion {
    public TablaSimbolos tablaSimbolos;
    public PilaErrores pilaErrores;
    public int posicion;

    public void nuevoError(int error){
        posicion--;
        Simbolo s = tablaSimbolos.tablaSimbolos.get(posicion);
        System.out.println(s.toString() + "  actual = " + posicion + "   error =" + error);
        pilaErrores.ingresa(error,s.getLinea());
    }

    public Condicion(TablaSimbolos tablaSimbolos, PilaErrores pilaErrores,int posicion) {
        this.tablaSimbolos = tablaSimbolos;
        this.pilaErrores = pilaErrores;
        this.posicion = posicion;
        q0();
    }


    void q0(){
        //System.out.println("ESTADO q0");
        switch (siguienteToken()){
            case 63:
                q4();
                break;
            default:
                posicion--;
                Expresion exp = new Expresion(tablaSimbolos,pilaErrores,posicion); //EXPRESIONES
                posicion = exp.posicion;
                q1();
                break;
        }
    }

    void q1(){
        //System.out.println("ESTADO q1");
        int token = siguienteToken();
        if(token >= 30 || token < 40){
            q2();
        }
        else{
            nuevoError(220);
        }
    }

    void q2(){
        //System.out.println("ESTADO q2");
        Expresion exp = new Expresion(tablaSimbolos,pilaErrores,posicion); //EXPRESIONES
        posicion = exp.posicion;
        q3();
    }

    void q3(){
        //System.out.println("ESTADO q3");
        int token = siguienteToken();
        if(token >= 40 && token < 45){
            q0();
        }
        else{
            posicion--;
        }
    }

    void q4(){
        //System.out.println("ESTADO q4");
        Condicion exp = new Condicion(tablaSimbolos,pilaErrores,posicion); //EXPRESIONES
        posicion = exp.posicion;
        q5();
    }

    void q5(){
        //System.out.println("ESTADO q5");
        switch (siguienteToken()){
            case 64:
                q3();
                break;
            default:
                nuevoError(216);
                break;
        }
    }


    public int siguienteToken(){
        int x = tablaSimbolos.tablaSimbolos.get(posicion).getToken();
        posicion++;
        return x;
    }
}
