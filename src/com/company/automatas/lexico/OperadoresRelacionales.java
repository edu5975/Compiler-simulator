package com.company.automatas.lexico;

public class OperadoresRelacionales {
    //30    <
    //31    >
    //32    ==
    //33    >=
    //34    <=
    //35    !=
    //-1    No valida

    String entrada;
    int tama;
    int actual;

    public OperadoresRelacionales() {
    }

    public OperadoresRelacionales(String entrada) {
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
                case '>':
                    return q1();
                case '<':
                    return q3();
                case '=':
                    return q5();
                case '!':
                    return q7();
                default:
                    return -1;
            }
        }else{
            return -1;
        }
    }

    int q1(){
        if(actual < tama){
            char car = entrada.charAt(actual);
            actual++;
            switch (car){
                case '=':
                    return q2();
                default:
                    return -1;
            }
        }else{
            return 31;
        }
    }

    int q2(){
        if(actual ==  tama){
            return 33;
        }else{
            return -1;
        }
    }

    int q3(){
        if(actual < tama){
            char car = entrada.charAt(actual);
            actual++;
            switch (car){
                case '=':
                    return q4();
                default:
                    return -1;
            }
        }else{
            return 30;
        }
    }

    int q4(){
        if(actual ==  tama){
            return 34;
        }else{
            return -1;
        }
    }

    int q5(){
        if(actual < tama){
            char car = entrada.charAt(actual);
            actual++;
            switch (car){
                case '=':
                    return q6();
                default:
                    return -1;
            }
        }else{
            return -1;
        }
    }

    int q6(){
        if(actual ==  tama){
            return 32;
        }else{
            return -1;
        }
    }

    int q7(){
        if(actual < tama){
            char car = entrada.charAt(actual);
            actual++;
            switch (car){
                case '=':
                    return q8();
                default:
                    return -1;
            }
        }else{
            return -1;
        }
    }

    int q8(){
        if(actual ==  tama){
            return 35;
        }else{
            return -1;
        }
    }
}
