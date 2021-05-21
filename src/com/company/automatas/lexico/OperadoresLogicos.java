package com.company.automatas.lexico;

public class OperadoresLogicos {
    //40    &
    //41    |
    //-1    No valida

    String entrada;
    int tama;
    int actual;

    public OperadoresLogicos() {
    }

    public OperadoresLogicos(String entrada) {
        this.entrada = entrada;
        this.tama = entrada.length();
        this.actual = 0;
    }

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
                case '&':
                    return q1();
                case '|':
                    return q2();
                default:
                    return -1;
            }
        }else{
            return -1;
        }
    }

    int q1(){
        if(actual ==  tama){
            return 40;
        }else{
            return -1;
        }
    }

    int q2(){
        if(actual ==  tama){
            return 41;
        }else{
            return -1;
        }
    }
}
