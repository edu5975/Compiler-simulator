package com.company.automatas.sintactico;

import com.company.pilaErrores.PilaErrores;
import com.company.tablaSimbolos.Simbolo;
import com.company.tablaSimbolos.TablaSimbolos;


public class EstructuraDecision {
    public TablaSimbolos tablaSimbolos;
    public PilaErrores pilaErrores;
    public int posicion;

    public void nuevoError(int error){
        posicion--;
        Simbolo s = tablaSimbolos.tablaSimbolos.get(posicion);
        System.out.println(s.toString() + "  actual = " + posicion + "   error =" + error);
        pilaErrores.ingresa(error,s.getLinea());
    }

    public EstructuraDecision(TablaSimbolos tablaSimbolos, PilaErrores pilaErrores,int posicion) {
        this.tablaSimbolos = tablaSimbolos;
        this.pilaErrores = pilaErrores;
        this.posicion = posicion;
        q0();
    }


    void q0(){
        int token = tablaSimbolos.tablaSimbolos.get(posicion).getToken();
        if(token == 6){
            siguienteToken();
            q1();
        }
    }

    void q1(){
        switch (siguienteToken()){
            case 63: //PARI
                q2();
                break;
            default:
                nuevoError(215); //PARI
        }
    }

    void q2(){
        Condicion con = new Condicion(tablaSimbolos,pilaErrores,posicion); //CONDICION
        posicion = con.posicion;
        q3();
    }

    void q3(){
        switch (siguienteToken()){
            case 64: //PARD
                q4();
                break;
            default:
                nuevoError(216); //PARD
        }
    }

    void q4(){
        switch (siguienteToken()){
            case 61: //LLAVEI
                q5();
                break;
            default:
                nuevoError(212); //LLAVEI
        }
    }

    void q5(){
        Instrucciones ins = new Instrucciones(tablaSimbolos,pilaErrores,posicion); //INSTRUCCIONES
        posicion = ins.posicion;
        q6();
    }

    void q6(){
        switch (siguienteToken()){
            case 62: //LLAVED
                q7();
                break;
            default:
                nuevoError(213); //LLAVED
        }
    }

    void q7(){
        if(siguienteToken()==7){
            q8();
        }
        else{
            posicion--;
        }
    }

    void q8(){
        switch (siguienteToken()){
            case 61: //LLAVEI
                q9();
                break;
            default:
                nuevoError(212); //LLAVEI
        }
    }

    void q9(){
        Instrucciones ins = new Instrucciones(tablaSimbolos,pilaErrores,posicion); //INSTRUCCIONES
        posicion = ins.posicion;
        q10();
    }

    void q10(){
        switch (siguienteToken()){
            case 62: //LLAVED
                q11();
                break;
            default:
                nuevoError(213); //LLAVED
        }
    }

    void q11(){

    }

    public int siguienteToken(){
        int x = tablaSimbolos.tablaSimbolos.get(posicion).getToken();
        posicion++;
        return x;
    }
}
