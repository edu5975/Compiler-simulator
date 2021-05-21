package com.company.automatas.lexico.palabrasReservadas;

public class Programa {
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
            if(car=='p')
                return q1();
            else
                return -1;
        }else{
            return -1;
        }
    }

    int q1(){
        if(actual <  tama){
            char car = entrada.charAt(actual);
            actual++;
            if(car=='r')
                return q2();
            else
                return -1;
        }else{
            return -1;
        }
    }

    int q2(){
        if(actual <  tama){
            char car = entrada.charAt(actual);
            actual++;
            if(car=='o')
                return q3();
            else
                return -1;
        }else{
            return -1;
        }
    }

    int q3(){
        if(actual <  tama){
            char car = entrada.charAt(actual);
            actual++;
            if(car=='g')
                return q4();
            else
                return -1;
        }else{
            return -1;
        }
    }

    int q4(){
        if(actual <  tama){
            char car = entrada.charAt(actual);
            actual++;
            if(car=='r')
                return q5();
            else
                return -1;
        }else{
            return -1;
        }
    }

    int q5(){
        if(actual <  tama){
            char car = entrada.charAt(actual);
            actual++;
            if(car=='a')
                return q6();
            else
                return -1;
        }else{
            return -1;
        }
    }

    int q6(){
        if(actual <  tama){
            char car = entrada.charAt(actual);
            actual++;
            if(car=='m')
                return q7();
            else
                return -1;
        }else{
            return -1;
        }
    }

    int q7(){
        if(actual <  tama){
            char car = entrada.charAt(actual);
            actual++;
            if(car=='a')
                return q8();
            else
                return -1;
        }else{
            return -1;
        }
    }

    int q8(){
        if(actual <  tama){
            return -1;
        }else{
            return 1;
        }
    }
}
