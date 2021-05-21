package com.company.automatas.lexico;

public class Cadena {
    //57    Valor cadena
    //-1    No valido

    String entrada;
    int tama;
    int actual;

    public Cadena(String entrada) {
        this.entrada = entrada;
        this.tama = entrada.length();
        this.actual = 0;
    }

    public Cadena() {
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
            if(car=='"'){
                actual++;
                return q1();
            }
            else{
                return -1;
            }
        }else{
            return -1;
        }
    }


    int q1(){
        if(actual <  tama){
            char car = entrada.charAt(actual);
            if(car=='"'){
                actual++;
                return q2();
            }
            else if(new Simbolos().comprobar(car)){
                actual++;
                return q1();
            }
            else{
                return -1;
            }
        }else{
            return -1;
        }
    }

    int q2(){
        if(actual ==  tama){
            return 57;
        }else{
            return -1;
        }
    }
}