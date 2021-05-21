package com.company.tablaSimbolos;

import java.util.ArrayList;

public class TablaSimbolos {
    public ArrayList<Simbolo> tablaSimbolos = new ArrayList<>();
    //public ArrayList<Simbolo> respaldoSintactico = new ArrayList<>();

    //MÉTODO QUE MUESTRA LO CONTENIDO EN LA TABLA DE SIMBOLOS
    public void consultar(){
        System.out.println("=====================================================================================");
        System.out.println("ID\t\tTOKEN\tLEXEMA\t\t\tLINEA\tVALOR");
        for (int i=0;i<tablaSimbolos.size();i++)
            System.out.println(tablaSimbolos.get(i).toString());
        System.out.println("=====================================================================================");
    }

    //MÉTODO QUE PERMITE INGRESAR UN REGISTRO EN LA TABLA DE SIMBOLOS
    public void ingresar(Simbolo s){
        if(s.getToken()!=-1&&s.getToken()<100) {
            s.setId(tablaSimbolos.size());
            tablaSimbolos.add(s);
            //respaldoSintactico.add(s);
        }
    }

    //MÉTODO QUE VACIA LA TABLA DE SIMBOLOS
    public void eliminar(){
        tablaSimbolos.clear();
    }

    //MÉTODO QUE PERMITE BUSCAR UN REGISTRO DENTRO DE LA TABLA DE SIMBOLOS
    public Simbolo buscar(int id){
        boolean ban = false;
        int i = 0;
        while(ban&&i<tablaSimbolos.size()){
            if(tablaSimbolos.get(i).getId()==id){
                return tablaSimbolos.get(i);
            }
            i++;
        }
        return null;
    }
}


