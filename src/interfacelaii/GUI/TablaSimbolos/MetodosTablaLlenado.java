
package interfacelaii.GUI.TablaSimbolos;

import interfacelaii.GUI.TablaSimbolos.tablaSimbolos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import com.company.tablaSimbolos.*;

public class MetodosTablaLlenado {
    Vector vPrincipal= new Vector();
    //guardar datos en un vector
    public void guardar(tablaSimbolos tablaSimbolos){
        vPrincipal.addElement(tablaSimbolos);
    }
    
    //guardar en un archivo txt los datos de la tabla
    public void guardarArchivo(TablaSimbolos tablaSimbolos) throws IOException{
        FileWriter fw= new FileWriter("tablaSimbolos.txt",false);
        BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(bw);
        for(int i = 0; i< tablaSimbolos.tablaSimbolos.size(); i++){            
            pw.print(tablaSimbolos.tablaSimbolos.get(i).getId());
            pw.print("|"+tablaSimbolos.tablaSimbolos.get(i).getToken());
            pw.print("|"+tablaSimbolos.tablaSimbolos.get(i).getLexema());
            pw.print("|"+tablaSimbolos.tablaSimbolos.get(i).getLinea());
            pw.print("|"+tablaSimbolos.tablaSimbolos.get(i).getValor());
            if(i<tablaSimbolos.tablaSimbolos.size()-1)
                pw.print("|");
        }
        pw.close();
    }
    
    //funcion para mostrar los datos en un Jtable
    public DefaultTableModel listaTablaSimbolos(){
        Vector cabeceras= new Vector();
        cabeceras.addElement("ID");
        cabeceras.addElement("TOKEN");
        cabeceras.addElement("LEXEMA");
        cabeceras.addElement("LINEA");
        cabeceras.addElement("VALOR");
        //creamos el vector que contenga las cabeceras
        //creamos un modelo de tabla para agregar el vector en la ubicacion 0
        DefaultTableModel mdlTabla= new DefaultTableModel(cabeceras,0);
        
        try{
            FileReader fr = new FileReader("tablaSimbolos.txt");
            BufferedReader br=new BufferedReader(fr);
            String d;
            if((d=br.readLine())!=null){
                StringTokenizer dato=new StringTokenizer(d,"|");
                Vector x= new Vector();
                int i = 0;
                while(dato.hasMoreTokens()){
                    x.addElement(dato.nextToken());
                    i++;
                    if(i==5){                        
                        mdlTabla.addRow(x);
                        x = new Vector();
                        i=0;
                    }
                }
        }
        }catch(Exception e){
            System.out.println(e);
       
    }return mdlTabla;
    }
}
     
