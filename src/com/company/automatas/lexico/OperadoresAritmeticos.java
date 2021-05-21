package com.company.automatas.lexico;

public class OperadoresAritmeticos {
    //20    +
    //21    -
    //22    *
    //23    /
    //-1    No valida

    String entrada;
    int tama;
    int actual;

    public OperadoresAritmeticos() {
    }

    public OperadoresAritmeticos(String entrada) {
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
                case '+':
                    return q1();
                case '-':
                    return q2();
                case '*':
                    return q3();
                case '/':
                    return q4();
                default:
                    return -1;
            }
        }else{
            return -1;
        }
    }

    int q1(){
        if(actual ==  tama){
            return 20;
        }else{
            return -1;
        }
    }

    int q2(){
        if(actual ==  tama){
            return 21;
        }else{
            return -1;
        }
    }

    int q3(){
        if(actual ==  tama){
            return 22;
        }else{
            return -1;
        }
    }

    int q4(){
        if(actual ==  tama){
            return 23;
        }else{
            return -1;
        }
    }
}
