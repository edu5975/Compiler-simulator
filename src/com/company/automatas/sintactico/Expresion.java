package com.company.automatas.sintactico;

import com.company.AnalisisSintactico;
import com.company.pilaErrores.PilaErrores;
import com.company.tablaSimbolos.Simbolo;
import com.company.tablaSimbolos.TablaSimbolos;


public class Expresion {
    public TablaSimbolos tablaSimbolos;
    public PilaErrores pilaErrores;
    public int posicion;

    public void nuevoError(int error){
        posicion--;
        Simbolo s = tablaSimbolos.tablaSimbolos.get(posicion);
        System.out.println(s.toString() + "  actual = " + posicion + "   error =" + error);
        pilaErrores.ingresa(error,s.getLinea());
    }

    public Expresion(TablaSimbolos tablaSimbolos, PilaErrores pilaErrores,int posicion) {
        this.tablaSimbolos = tablaSimbolos;
        this.pilaErrores = pilaErrores;
        this.posicion = posicion;
        q0();
    }


    void q0(){
        int token = siguienteToken();
        //System.out.println("ESTADO EXPRESION q0: " + token);
        switch (token){
            case 70:
            case 55:
            case 56: //ID, ENTERO O REAL
                q5();
                break;
            case 20:
            case 21: //+-
                q4();
                break;
            case 63: //PARI
                q1();
                break;
            default:
                nuevoError(221);
        }
    }

    void q1(){
        //System.out.println("ESTADO EXPRESION q1");
        Expresion exp = new Expresion(tablaSimbolos,pilaErrores,posicion); //EXPRESIONES
        posicion = exp.posicion;
        q2();
    }

    void q2(){
        //System.out.println("ESTADO EXPRESION q2");
        switch (siguienteToken()){
            case 64: //PARD
                q3();
                break;
            default:
                nuevoError(216); //ID
        }
    }

    void q3(){
        //System.out.println("ESTADO EXPRESION q3");
        int token = siguienteToken();
        if(token==55||token==56||token==70){
            q0();
        }
        else if((token >= 20 && token < 25)||token==63){
            q4();
        }
        else{
            posicion--;
        }
    }

    void q4(){
        //System.out.println("ESTADO EXPRESION q4");
        Expresion exp = new Expresion(tablaSimbolos,pilaErrores,posicion); //EXPRESIONES
        posicion = exp.posicion;
        q3();
    }

    void q5(){
        //System.out.println("ESTADO EXPRESION q5");
        int token = siguienteToken();
        if(token >= 20 && token < 25){
            q4();
        }
        else{
            posicion--;
        }
    }


    public int siguienteToken(){

        int x = tablaSimbolos.tablaSimbolos.get(posicion).getToken();
        posicion++;
        tok = x;
        return x;
    }

    int tok;
}
