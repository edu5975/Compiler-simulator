package com.company.automatas.sintactico;

import com.company.pilaErrores.PilaErrores;
import com.company.tablaSimbolos.Simbolo;
import com.company.tablaSimbolos.TablaSimbolos;


public class Concatenacion {
    public TablaSimbolos tablaSimbolos;
    public PilaErrores pilaErrores;
    public int posicion;

    public void nuevoError(int error){
        posicion--;
        Simbolo s = tablaSimbolos.tablaSimbolos.get(posicion);
        System.out.println(s.toString() + "  actual = " + posicion + "   error =" + error);
        pilaErrores.ingresa(error,s.getLinea());
    }

    public Concatenacion(TablaSimbolos tablaSimbolos, PilaErrores pilaErrores,int posicion) {
        this.tablaSimbolos = tablaSimbolos;
        this.pilaErrores = pilaErrores;
        this.posicion = posicion;
        q0();
    }


    void q0(){
        //System.out.println("Q0 " + posicion + " " + tablaSimbolos.tablaSimbolos.get(posicion).getLexema());
        if(siguienteToken()==57){
            q1();
        }
        else{
            posicion--;
            int ver = posicion;
            Expresion exp = new Expresion(tablaSimbolos,pilaErrores,posicion); //EXPRESIONES
            posicion = exp.posicion;
            if(ver==posicion){
                //nuevoError(0); //NO HAY CONCATENACION
            }
            else{
                q1();
            }
        }

    }

    void q1(){
        //System.out.println("Q1 " + posicion + " " + tablaSimbolos.tablaSimbolos.get(posicion).getLexema());
        if(siguienteToken()==68){
            q0();
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
