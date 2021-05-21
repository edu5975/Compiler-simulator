package com.company.automatas.sintactico;

import com.company.pilaErrores.PilaErrores;
import com.company.tablaSimbolos.Simbolo;
import com.company.tablaSimbolos.TablaSimbolos;


public class Salida {
    public TablaSimbolos tablaSimbolos;
    public PilaErrores pilaErrores;
    public int posicion;

    public void nuevoError(int error){
        posicion--;
        Simbolo s = tablaSimbolos.tablaSimbolos.get(posicion);
        System.out.println(s.toString() + "  actual = " + posicion + "   error =" + error);
        pilaErrores.ingresa(error,s.getLinea());
    }

    public Salida(TablaSimbolos tablaSimbolos, PilaErrores pilaErrores,int posicion) {
        this.tablaSimbolos = tablaSimbolos;
        this.pilaErrores = pilaErrores;
        this.posicion = posicion;
        q0();
    }


    void q0(){
        int token = tablaSimbolos.tablaSimbolos.get(posicion).getToken();
        if(token == 5){
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
        Concatenacion conc = new Concatenacion(tablaSimbolos,pilaErrores,posicion); //ASIGNACION
        posicion = conc.posicion;
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
            case 60: //PUNTOYCOMA
                q5();
                break;
            default:
                nuevoError(219); //PUNTOYCOMA
        }
    }

    void q5(){
    }

    public int siguienteToken(){
        int x = tablaSimbolos.tablaSimbolos.get(posicion).getToken();
        posicion++;
        return x;
    }
}
