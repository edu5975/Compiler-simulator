package com.company.pilaErrores;

public class Error {
    int id;
    int linea;
    String lexema;

    public Error(int id, int linea) {
        this.id = id;
        this.linea = linea;
    }

    public Error(int id, int linea, String lexema) {
        this.id = id;
        this.linea = linea;
        this.lexema = lexema;
    }

    public Error() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }


}
