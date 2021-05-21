package com.company;

import com.company.pilaErrores.PilaErrores;
import com.company.tablaSimbolos.Simbolo;
import com.company.tablaSimbolos.TablaSimbolos;

import java.util.ArrayList;

public class AnalisisSemantico {
    public TablaSimbolos tablaSimbolos = new TablaSimbolos();
    public PilaErrores pilaErrores = new PilaErrores();
    public int actual = 0;
    ArrayList<Simbolo> variables = new ArrayList<>();

    public AnalisisSemantico(TablaSimbolos tablaSimbolos, PilaErrores pilaErrores) {
        this.tablaSimbolos = tablaSimbolos;
        this.pilaErrores = pilaErrores;
    }

    public AnalisisSemantico() {
    }

    public void analizar(){
        declaracion();
        verificarUso();
        verificarValores();
        for (Simbolo s:variables) {
            System.out.println(s + "   " + s.getTipo());
        }
    }

    public void declaracion(){
        for(int i = 0; i < tablaSimbolos.tablaSimbolos.size(); i++){
            Simbolo simbolo = tablaSimbolos.tablaSimbolos.get(i);
            if(simbolo.getToken()>=50 && simbolo.getToken()<55 || simbolo.getToken()==3 || simbolo.getToken()==1){
                int tipo = simbolo.getToken();
                do{
                    i++;
                    simbolo = tablaSimbolos.tablaSimbolos.get(i);
                    simbolo.setTipo(tipo);
                    Simbolo simbolo1 = new Simbolo(
                            simbolo.getId(),
                            simbolo.getToken(),
                            simbolo.getLexema(),
                            simbolo.getLinea(),
                            simbolo.getValor(),
                            simbolo.getTipo()
                    );
                    variables.add(simbolo1);
                    i++;
                    simbolo = tablaSimbolos.tablaSimbolos.get(i);
                }while(simbolo.getToken()==67);
            }
        }
    }
    
    

    public void verificarUso(){
        for(int i = 1; i < tablaSimbolos.tablaSimbolos.size(); i++){
            Simbolo simbolo = tablaSimbolos.tablaSimbolos.get(i);
            Simbolo simboloAnterior = tablaSimbolos.tablaSimbolos.get(i-1);
            if(simbolo.getToken()==70){
                int ban = 0;
                for (Simbolo s:variables) {
                    if (s.getLexema().equals(simbolo.getLexema()))
                        ban = 1;
                }
                if(ban == 0)
                    pilaErrores.ingresa(301,simbolo.getLinea());
            }
        }
    }

    public void verificarValores(){
        for(int i = 0; i < tablaSimbolos.tablaSimbolos.size()-1; i++){
            Simbolo simbolo = tablaSimbolos.tablaSimbolos.get(i);
            Simbolo simboloSiguiente = tablaSimbolos.tablaSimbolos.get(i+1);
            if(simbolo.getToken()==70 && i!=1 && simboloSiguiente.getToken()==25){
                int id = simbolo.getId();
                String lexema = simbolo.getLexema();
                String valor = "";
                int tipo=0;
                for (Simbolo s:variables)
                    if(s.getLexema().equals(lexema))
                        tipo = s.getTipo();
                i+=2;
                simbolo = tablaSimbolos.tablaSimbolos.get(i);
                while(simbolo.getToken()!=60) {
                    i++;
                    valor += simbolo.getLexema();
                    if(simbolo.getToken()==70){
                        int tipo2=0;
                        for (Simbolo s:variables)
                            if(s.getLexema().equals(simbolo.getLexema())) {
                                tipo2 = s.getTipo();
                                if(s.getValor().equals("")||s.getValor().equals(".")){
                                    pilaErrores.ingresa(303,simbolo.getLinea());
                                }
                            }
                        System.out.println(tipo2);
                        switch (tipo){
                            case 50: //enteros
                                if(tipo2!=50)
                                    pilaErrores.ingresa(300,simbolo.getLinea());
                                break;
                            case 51: //real
                                if(tipo2!=50 && tipo2!=51)
                                    pilaErrores.ingresa(300,simbolo.getLinea());
                                break;
                            case 52: //cadena
                                if(tipo2!=52)
                                    pilaErrores.ingresa(300,simbolo.getLinea());
                                break;
                        }
                    }
                    if(simbolo.getToken()==55)
                        if(tipo!=50&&tipo!=51&&tipo!=52)
                            pilaErrores.ingresa(300,simbolo.getLinea());
                    if(simbolo.getToken()==56)
                        if(tipo!=51&&tipo!=52)
                            pilaErrores.ingresa(300,simbolo.getLinea());
                    if(simbolo.getToken()==57)
                        if(tipo!=52)
                            pilaErrores.ingresa(300,simbolo.getLinea());
                    simbolo = tablaSimbolos.tablaSimbolos.get(i);
                }
                for (Simbolo s:variables)
                    if(s.getLexema().equals(lexema))
                        s.setValor(valor);
                tablaSimbolos.tablaSimbolos.get(id).setValor(valor);
            }
        }
    }
}
