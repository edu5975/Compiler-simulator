package com.company;

import com.company.automatas.lexico.*;
import com.company.automatas.lexico.palabrasReservadas.*;
import com.company.pilaErrores.PilaErrores;
import com.company.tablaSimbolos.Simbolo;
import com.company.tablaSimbolos.TablaSimbolos;

import java.io.BufferedReader;
import java.io.FileReader;

public class AnalisisLexico {
    public TablaSimbolos tablaSimbolos = new TablaSimbolos();
    public PilaErrores pilaErrores = new PilaErrores();   
    public String codigo;

    //MÉTODO QUE SEPARA EL PROGRAMA EN LEXEMAS
    public void lexemas(){
        //String codigo = leerCodigo("src/com/company/programas/programa.txt");
        String aux = "";

        for(int c = 0, linea = 1; c < codigo.length();c++){
            if(codigo.charAt(c)=='\n')
                linea++;
            if(new Simbolos().comprobar(codigo.charAt(c))==false)
                pilaErrores.ingresa(102,linea);
                //COMENTARIOS
                if ((codigo.charAt(c) == '/' && codigo.charAt(c + 1) == '*')) {
                    while (!(codigo.charAt(c) == '*' && codigo.charAt(c + 1) == '/')) {
                        c++;
                        if(codigo.charAt(c)=='\n')
                            linea++;
                    }
                    c++;
                    if(codigo.charAt(c)=='\n')
                        linea++;
                }
                //DELIMITADORES IMPLICITOS
                else if (codigo.charAt(c) == ' ' || codigo.charAt(c) == '\t' || codigo.charAt(c) == '\n') {
                    if (aux != "" && aux != "\t" && aux != "\n" && aux != " ")
                        tablaSimbolos.ingresar(new Simbolo(tokenizar(aux, linea), aux, linea, "."));
                    aux = "";
                }
                //DELIMITADORES
                else if ((codigo.charAt(c) == '=' && codigo.charAt(c + 1) == '=') ||
                        (codigo.charAt(c) == '>' && codigo.charAt(c + 1) == '=') ||
                        (codigo.charAt(c) == '<' && codigo.charAt(c + 1) == '=') ||
                        (codigo.charAt(c) == '!' && codigo.charAt(c + 1) == '=')) {
                    if (aux != "" && aux != "\t" && aux != "\n" && aux != " ") {
                        tablaSimbolos.ingresar(new Simbolo(tokenizar(aux, linea), aux, linea, "."));
                        aux = "";
                    }
                    aux += codigo.charAt(c);
                    c++;
                    aux += codigo.charAt(c);
                    tablaSimbolos.ingresar(new Simbolo(tokenizar(aux, linea), aux, linea, "."));
                    aux = "";
                } else if (codigo.charAt(c) == ';' || codigo.charAt(c) == '(' || codigo.charAt(c) == ')' ||
                        codigo.charAt(c) == ',' || codigo.charAt(c) == '{' || codigo.charAt(c) == '}' ||
                        codigo.charAt(c) == '+' || codigo.charAt(c) == '-' || codigo.charAt(c) == '_' ||
                        codigo.charAt(c) == '/' || codigo.charAt(c) == '=' || codigo.charAt(c) == '<' ||
                        codigo.charAt(c) == '>' || codigo.charAt(c) == '&' || codigo.charAt(c) == '|') {
                    if (aux != "" && aux != "\t" && aux != "\n" && aux != " ") {
                        tablaSimbolos.ingresar(new Simbolo(tokenizar(aux, linea), aux, linea, "."));
                        aux = "";
                    }
                    aux += codigo.charAt(c);
                    tablaSimbolos.ingresar(new Simbolo(tokenizar(aux, linea), aux, linea, "."));
                    aux = "";
                }
                //CADENAS
                else if (codigo.charAt(c) == '"') {
                    aux += codigo.charAt(c);
                    c++;
                    while (codigo.charAt(c) != '"') {
                        aux += codigo.charAt(c);
                        c++;
                    }
                    aux += codigo.charAt(c);
                    c++;
                    if(codigo.charAt(c)==')')
                        c--;
                } else {
                    aux += codigo.charAt(c);
                }
            }

    }

    //MÉTODO QUE CONVIERTE LOS LEXEMAS EN SUS RESPECTIVOS TOKENS
    int tokenizar(String lexema, int linea){
        int id=-1;
        if(id==-1) id = new Entrada().comprobar(lexema);
        if(id==-1) id = new Mientras().comprobar(lexema);
        if(id==-1) id = new Principal().comprobar(lexema);
        if(id==-1) id = new Programa().comprobar(lexema);
        if(id==-1) id = new Salida().comprobar(lexema);
        if(id==-1) id = new Si().comprobar(lexema);
        if(id==-1) id = new Subrutina().comprobar(lexema);
        if(id==-1) id = new TipoDato().comprobar(lexema);
        if(id==-1) id = new Cadena().comprobar(lexema);
        if(id==-1) id = new Delimitadores().comprobar(lexema);
        if(id==-1) id = new Identificador().comprobar(lexema);
        if(id==-1) id = new Numero().comprobar(lexema);
        if(id==-1) id = new OperadoresAritmeticos().comprobar(lexema);
        if(id==-1) id = new OperadoresAsignacion().comprobar(lexema);
        if(id==-1) id = new OperadoresLogicos().comprobar(lexema);
        if(id==-1) id = new OperadoresRelacionales().comprobar(lexema);
        if(id==-1||id>=100) {
            //System.out.println("ERROR EN LINEA: " + linea);
            if(id==-1)
                pilaErrores.ingresa(100,linea);
            else
                pilaErrores.ingresa(id,linea);
            //System.out.println(lexema);
        }
        return id;
    }

    //MÉTODO QUE LEE EL CÓDIGO FUENTE DEL ARCHIVO
    String leerCodigo(String archivo){
        String cadena = "";
        try {
            FileReader f = new FileReader(archivo);
            BufferedReader b = new BufferedReader(f);
            String aux;
            while((aux = b.readLine())!=null) {
                cadena = cadena + aux + "\n";
            }
            b.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cadena;
    }
    
    public void darCodigo(String codigo){
        this.codigo = codigo;
    }
}


