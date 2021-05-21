package com.company.automatas.lexico.palabrasReservadas;

public class TipoDato {
    //50    ent
    //51    rea
    //52    cad
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
                case 'e':
                    return q1();
                case 'r':
                    return q4();
                case 'c':
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
                case 'n':
                    return q2();
                default:
                    return -1;
            }
        }else{
            return -1;
        }
    }

    int q2(){
        if(actual < tama){
            char car = entrada.charAt(actual);
            actual++;
            switch (car){
                case 't':
                    return q3();
                default:
                    return -1;
            }
        }else{
            return -1;
        }
    }

    int q3(){
        if(actual ==  tama){
            return 50;
        }else{
            return -1;
        }
    }

    int q4(){
        if(actual < tama){
            char car = entrada.charAt(actual);
            actual++;
            switch (car){
                case 'e':
                    return q5();
                default:
                    return -1;
            }
        }else{
            return -1;
        }
    }

    int q5(){
        if(actual < tama){
            char car = entrada.charAt(actual);
            actual++;
            switch (car){
                case 'a':
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
            return 51;
        }else{
            return -1;
        }
    }

    int q7(){
        if(actual < tama){
            char car = entrada.charAt(actual);
            actual++;
            switch (car){
                case 'a':
                    return q8();
                default:
                    return -1;
            }
        }else{
            return -1;
        }
    }

    int q8(){
        if(actual < tama){
            char car = entrada.charAt(actual);
            actual++;
            switch (car){
                case 'd':
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
            return 52;
        }else{
            return -1;
        }
    }
}
