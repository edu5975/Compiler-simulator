package com.company.pilaErrores;

import java.util.Stack;

public class PilaErrores {
    public Stack<Error> pila = new Stack<Error>();

    //MÉTODO PARA INGRESAR ALGÚN ERROR ENCONTRADO EN LA PILA DE ERRORES
    public void ingresa(int id,int linea){
        if(pila.empty())
            pila.push(new Error(id,linea));
        else if((pila.lastElement().getId()!=id || pila.lastElement().linea!=linea))
            pila.push(new Error(id,linea));
    }

    //MÉTODO PARA MOSTRAR LO CONTENIDO EN LA PILA DE ERRORES
    public void mostrar(){
        System.out.println("=====================================================================================");
        System.out.println("ID\tLINEA\tMENSAJE");
        while (!pila.empty())
            //System.out.println(listaErrores(pila.pop()));
            System.out.println(listaErrores(pila.remove(0)));
        System.out.println("=====================================================================================");
    }
    
    //MÉTODO PARA MOSTRAR LO CONTENIDO EN LA PILA DE ERRORES
    public String imprimir(){
        String aux = "ID   LINEA   MENSAJE\n";
        while (!pila.empty())
            aux+=listaErrores(pila.remove(0)) + "\n";
        return aux;
    }

    //MÉTODO PARA IMPRIMIR EL CORRESPONDIENTE MENSAJE DE ERROR
    public String listaErrores(Error e){
        String aux = String.format("%-8d", e.getId())+String.format("%-8d", e.getLinea());
        switch (e.id){
            case 100:
                aux+= "No puede definirse como un identificador, debe de iniciar con un signo de $";
                break;
            case 101:
                aux += "No deben de existir espacios en blanco entre los identificadores";
                break;
            case 102:
                aux += "El token no se puede establecer como identificador ni palabra reservada, no pertenece al lenguaje";
                break;
            case 103:
                aux += "Las constantes numéricas no pueden mezclarse con letras o caracteres extraños";
                break;
            case 104:
                aux += "No se puede establecer como identificador";
                break;
            case 105:
                aux += "Los números decimales no son válidos";
                break;
            case 106:
                aux += "Los caracteres con acentos no son válidos";
                break;
            case 107:
                aux += "Token invalido no se pueden utilizar operadores en la nomenclatura de las variables";
                break;
            case 108:
                aux += "Se deben de separar los tokens";
                break;
            case 210:
                aux += "No se inicio el programa";
                break;
            case 211:
                aux += "No se asigno un identificador";
                break;
            case 212:
                aux += "Se esperaba que se abriera una llave {";
                break;
            case 213:
                aux += "Se esperaba el cierre de llaves }";
                break;
            case 214:
                aux += "No se incluyo el metodo principal";
                break;
            case 215:
                aux += "Se esperaba abrir un parentesis (";
                break;
            case 216:
                aux += "Se esperaba el cierre de parentesis )";
                break;
            case 217:
                aux += "Se esperaba la asignacion a la variable";
                break;
            case 218:
                aux += "No se asigno nada a la variable";
                break;
            case 219:
                aux += "Falto punto y coma";
                break;
            case 220:
                aux += "No hay operador relacional";
                break;
            case 221:
                aux += "Expresion no reconocida";
                break;
            case 222:
                aux += "Error en la condición";
                break;
            case 300:
                aux += "No coinciden los tipos ";
                break;
            case 301:
                aux += "Variable no declarada ";
                break;
            case 302:
                aux += "Fuera de alcance ";
                break;
            case 303:
                aux += "Variable sin valor";
                break;
        }
        return aux;
    }
}

