package com.company.automatas.lexico;

public class Numero {
    //55    Entero
    //56    Real
    //103   Error
    //105   Error
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

    int q0(){
        if(actual <  tama){
            char car = entrada.charAt(actual);
            if(car=='0'|car=='1'|car=='2'|car=='3'|car=='4'|car=='5'|car=='6'|car=='7'|car=='8'|car=='9'){
                actual++;
                return q2();
            }else if(car=='+'|car=='-'){
                actual++;
                return q1();
            }else if(car=='.'){
                actual++;
                return q3();
            }else{
                return -1;
            }
        }else{
            return -1;
        }
    }

    int q1(){
        if(actual <  tama){
            char car = entrada.charAt(actual);
            if(car=='0'|car=='1'|car=='2'|car=='3'|car=='4'|car=='5'|car=='6'|car=='7'|car=='8'|car=='9'){
                actual++;
                return q2();
            }else if(car=='.'){
                actual++;
                return q3();
            }else{
                return 103;
            }
        }
        else{
            return -1;
        }
    }

    int q2(){
        if(actual <  tama){
            char car = entrada.charAt(actual);
            if(car=='0'|car=='1'|car=='2'|car=='3'|car=='4'|car=='5'|car=='6'|car=='7'|car=='8'|car=='9'){
                actual++;
                return q2();
            }else if(car=='.'){
                actual++;
                return q4();
            }
            else{
                return 103;
            }
        }
        else{
            return 55;
        }
    }

    int q3(){
        if(actual <  tama){
            char car = entrada.charAt(actual);
            if(car=='0'|car=='1'|car=='2'|car=='3'|car=='4'|car=='5'|car=='6'|car=='7'|car=='8'|car=='9'){
                actual++;
                return q4();
            }
            else if(car=='.'){
                return 105;
            }
            else{
                return 103;
            }
        }
        else {
            return -1;
        }
    }

    int q4(){
        if(actual <  tama){
            char car = entrada.charAt(actual);
            if(car=='0'|car=='1'|car=='2'|car=='3'|car=='4'|car=='5'|car=='6'|car=='7'|car=='8'|car=='9'){
                actual++;
                return q4();
            }
            else if(car=='.'){
                return 105;
            }
            else{
                return 103;
            }
        }
        else{
            return 56;
        }
    }
}

