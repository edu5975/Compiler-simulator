package com.company.automatas.lexico;

public class OperadoresAsignacion {
    //25    =
    //-1    No valido

    String entrada;
    int tama;
    int actual;

    public int comprobar(String entrada){
        this.entrada = entrada;
        this.tama = entrada.length();
        this.actual = 0;
        return q0();
    }

    public int comprobar(){
        return q0();
    }

    int q0(){
        if(actual <  tama){
            char car = entrada.charAt(actual);
            actual++;
            switch (car){
                case '=':
                    return q1();
                default:
                    return -1;
            }
        }else{
            return -1;
        }
    }

    int q1(){
        if(actual ==  tama){
            return 25;
        }else{
            return -1;
        }
    }
}
