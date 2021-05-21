package com.company.automatas.sintactico;

import com.company.AnalisisSintactico;
import com.company.pilaErrores.PilaErrores;
import com.company.tablaSimbolos.Simbolo;
import com.company.tablaSimbolos.TablaSimbolos;


public class Declaraciones  {
    public TablaSimbolos tablaSimbolos;
    public PilaErrores pilaErrores;
    public int posicion;

    public void nuevoError(int error){
        posicion--;
        Simbolo s = tablaSimbolos.tablaSimbolos.get(posicion);
        System.out.println(s.toString() + "  actual = " + posicion + "   error =" + error);
        pilaErrores.ingresa(error,s.getLinea());
    }

    public Declaraciones(TablaSimbolos tablaSimbolos, PilaErrores pilaErrores,int posicion) {
        this.tablaSimbolos = tablaSimbolos;
        this.pilaErrores = pilaErrores;
        this.posicion = posicion;
        q0();
    }


    void q0(){
        int token = tablaSimbolos.tablaSimbolos.get(posicion).getToken();
        if(token >=50 && token < 60){
            siguienteToken();
            q1();
        }
    }

    void q1(){
        switch (siguienteToken()){
            case 70: //ID
                q2();
                break;
            default:
                nuevoError(211); //ID
        }
    }

    void q2(){
        switch (siguienteToken()){
            case 67: //COMA
                q1();
                break;
            case 60: //PUNTOCOMA
                q3();
                break;
            default:
                nuevoError(219); //ID
        }
    }

    void q3(){
        int token = siguienteToken();
        if(token >= 50 && token < 60){
            q1();
        }
        else{
            posicion--;
        }
    }

    public int siguienteToken(){
        int x = tablaSimbolos.tablaSimbolos.get(posicion).getToken();
        posicion++;
        return x;
    }
}
