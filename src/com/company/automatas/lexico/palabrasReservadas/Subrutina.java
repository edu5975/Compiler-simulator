package com.company.automatas.lexico.palabrasReservadas;

public class Subrutina {
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
            if(car=='s')
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
            if(car=='u')
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
            if(car=='b')
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
            if(car=='r')
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
            if(car=='u')
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
            if(car=='t')
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
            if(car=='i')
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
            if(car=='n')
                return q8();
            else
                return -1;
        }else{
            return -1;
        }
    }

    int q8(){
        if(actual <  tama){
            char car = entrada.charAt(actual);
            actual++;
            if(car=='a')
                return q9();
            else
                return -1;
        }else{
            return -1;
        }
    }

    int q9(){
        if(actual <  tama){
            return -1;
        }else{
            return 3;
        }
    }
}
