package com.company.automatas.lexico;

public class Delimitadores {
    //60    ;
    //61    {
    //62    }
    //63    (
    //64    )
    //65    /*
    //66    */
    //67    ,
    //68    _
    //-1    No valida

    String entrada;
    int tama;
    int actual;

    public Delimitadores() {
    }

    public Delimitadores(String entrada) {
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
                case ';':
                    return q1();
                case '{':
                    return q2();
                case '}':
                    return q3();
                case '(':
                    return q4();
                case ')':
                    return q5();
                case '/':
                    return q6();
                case '*':
                    return q8();
                case ',':
                    return q10();
                case '_':
                    return q11();
                default:
                    return -1;
            }
        }else{
            return -1;
        }
    }

    int q1(){
        if(actual ==  tama){
            return 60;
        }else{
            return -1;
        }
    }

    int q2(){
        if(actual ==  tama){
            return 61;
        }else{
            return -1;
        }
    }

    int q3(){
        if(actual ==  tama){
            return 62;
        }else{
            return -1;
        }
    }

    int q4(){
        if(actual ==  tama){
            return 63;
        }else{
            return -1;
        }
    }

    int q5(){
        if(actual ==  tama){
            return 64;
        }else{
            return -1;
        }
    }

    int q6(){
        if(actual < tama){
            char car = entrada.charAt(actual);
            actual++;
            switch (car){
                case '*':
                    return q7();
                default:
                    return -1;
            }
        }else{
            return -1;
        }
    }

    int q7(){
        if(actual ==  tama){
            return 65;
        }else{
            return -1;
        }
    }

    int q8(){
        if(actual < tama){
            char car = entrada.charAt(actual);
            actual++;
            switch (car){
                case '/':
                    return q9();
                default:
                    return -1;
            }
        }else{
            return -1;
        }
    }

    int q9(){
        if(actual ==  tama){
            return 65;
        }else{
            return -1;
        }
    }

    int q10(){
        if(actual ==  tama){
            return 67;
        }else{
            return -1;
        }
    }

    int q11(){
        if(actual ==  tama){
            return 68;
        }else{
            return -1;
        }
    }

}
