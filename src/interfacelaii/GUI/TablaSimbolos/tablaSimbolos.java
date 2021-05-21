/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacelaii.GUI.TablaSimbolos;

public class tablaSimbolos {
 private int id,token;
 private String lexema;
 private int linea;
 private String valor;

    public tablaSimbolos(int id, int token, String lexema, int linea, String valor) {
        this.id = id;
        this.token = token;
        this.lexema = lexema;
        this.linea = linea;
        this.valor = valor;
    }

    public tablaSimbolos() {
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
 
}
