package com.company.automatas.lexico;

public class Simbolos {
    char car;

    public boolean comprobar(char entrada){
        this.car = entrada;
        return q0();
    }

    public boolean comprobar(){
        return q0();
    }

    boolean q0(){
        if(     car=='0'||car=='1'||car=='2'||car=='3'||car=='4'||car=='5'||car=='6'||car=='7'||car=='8'||car=='9'||
                car=='a'||car=='b'||car=='c'||car=='d'||car=='e'||car=='f'||car=='g'||car=='h'||car=='i'||car=='j'||
                car=='k'||car=='l'||car=='m'||car=='n'||car=='ñ'||car=='o'||car=='p'||car=='q'||car=='r'||car=='s'||
                car=='t'||car=='u'||car=='w'||car=='v'||car=='x'||car=='y'||car=='z'||
                car=='A'||car=='B'||car=='C'||car=='D'||car=='E'||car=='F'||car=='G'||car=='H'||car=='I'||car=='J'||
                car=='K'||car=='L'||car=='M'||car=='N'||car=='Ñ'||car=='O'||car=='P'||car=='Q'||car=='R'||car=='S'||
                car=='T'||car=='U'||car=='W'||car=='V'||car=='X'||car=='Y'||car=='Z'||
                car=='!'||car=='"'||car=='$'||car=='&'||car=='|'||car=='='||car=='/'||car=='*'||car=='+'||car=='-'||
                car=='('||car==')'||car=='<'||car=='>'||car=='{'||car=='}'||car==';'||car==','||car=='.'||car=='_'||
                car=='?'||car=='¡'||car=='¿'||car=='#'||car==':'||car=='['||car==']'||car=='°'||car=='^'||car=='%'||
                car==' '||car=='\t'||car=='\n')
            return true;
        else
            return false;
    }
}
