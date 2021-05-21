package com.company.automatas.lexico;

public class Identificador {
    //70    Identificador
    //102   Error
    //104   Error
    //107   Error
    //-1    No valido

    String entrada;
    int tama;
    int actual;

    public Identificador(String entrada) {
        this.entrada = entrada;
        this.tama = entrada.length();
        this.actual = 0;
    }

    public Identificador() {
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
            if(car=='$'){
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
            if(car=='a'||car=='b'||car=='c'||car=='d'||car=='e'||car=='f'||car=='g'||car=='h'||car=='i'||car=='j'||
                    car=='k'||car=='l'||car=='m'||car=='n'||car=='ñ'||car=='o'||car=='p'||car=='q'||car=='r'||car=='s'||
                    car=='t'||car=='u'||car=='w'||car=='v'||car=='x'||car=='y'||car=='z'||
                    car=='A'||car=='B'||car=='C'||car=='D'||car=='E'||car=='F'||car=='G'||car=='H'||car=='I'||car=='J'||
                    car=='K'||car=='L'||car=='M'||car=='N'||car=='Ñ'||car=='O'||car=='P'||car=='Q'||car=='R'||car=='S'||
                    car=='T'||car=='U'||car=='W'||car=='V'||car=='X'||car=='Y'||car=='Z'){
                actual++;
                return q2();
            }
            else if(car=='$'){
                return 104;
            }
            else if (car == ';' || car == '(' || car == ')' ||
                    car == ',' || car == '{' || car == '}' ||
                    car == '+' || car == '-' || car == '*' ||
                    car == '/' || car == '=' || car == '<' ||
                    car == '>' || car == '&' || car == '|'){
                return 107;
            }
            else if(new Simbolos().comprobar(car)==false){
                return 102;
            }
            else{
                return -1;
            }
        }else{
            return -1;
        }
    }

    int q2(){
        if(actual <  tama){
            char car = entrada.charAt(actual);
            if(car=='0'||car=='1'||car=='2'||car=='3'||car=='4'||car=='5'||car=='6'||car=='7'||car=='8'||car=='9'||
                    car=='a'||car=='b'||car=='c'||car=='d'||car=='e'||car=='f'||car=='g'||car=='h'||car=='i'||car=='j'||
                    car=='k'||car=='l'||car=='m'||car=='n'||car=='ñ'||car=='o'||car=='p'||car=='q'||car=='r'||car=='s'||
                    car=='t'||car=='u'||car=='w'||car=='v'||car=='x'||car=='y'||car=='z'||
                    car=='A'||car=='B'||car=='C'||car=='D'||car=='E'||car=='F'||car=='G'||car=='H'||car=='I'||car=='J'||
                    car=='K'||car=='L'||car=='M'||car=='N'||car=='Ñ'||car=='O'||car=='P'||car=='Q'||car=='R'||car=='S'||
                    car=='T'||car=='U'||car=='W'||car=='V'||car=='X'||car=='Y'||car=='Z'){
                actual++;
                return q2();
            }
            else if(car=='$'){
                return 104;
            }
            else if (car == ';' || car == '(' || car == ')' ||
                    car == ',' || car == '{' || car == '}' ||
                    car == '+' || car == '-' || car == '*' ||
                    car == '/' || car == '=' || car == '<' ||
                    car == '>' || car == '&' || car == '|'){
                return 107;
            }
            else if(new Simbolos().comprobar(car)==false){
                return 102;
            }
            else {
                return -1;
            }
        }
        else{
            return 70;
        }
    }
}

