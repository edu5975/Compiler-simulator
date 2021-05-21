package com.company.tablaSimbolos;

public class Simbolo {
    private int id;
    private int token;
    private String lexema;
    private int linea;
    private String valor = "";
    private int tipo;

    public Simbolo(int id, int token, String lexema, int linea, String valor) {
        this.id = id;
        this.token = token;
        this.lexema = lexema;
        this.linea = linea;
        this.valor = valor;
    }

    public Simbolo(int token, String lexema, int linea, String valor) {
        this.token = token;
        this.lexema = lexema;
        this.linea = linea;
        this.valor = valor;
    }
    
    public Simbolo(int id, int token, String lexema, int linea, String valor, int tipo) {
        this.id = id;
        this.token = token;
        this.lexema = lexema;
        this.linea = linea;
        this.valor = valor;
        this.tipo = tipo;
    }

    public Simbolo(int token, String lexema, int linea) {
        this.token = token;
        this.lexema = lexema;
        this.linea = linea;
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
    
    
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return  String.format("%-8d", id) +
                String.format("%-8d", token) +
                String.format("%-16s", lexema) +
                String.format("%-8d", linea) +
                String.format("%-16s", valor);
    }
}
