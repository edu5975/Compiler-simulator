/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacelaii.GUI;

import com.company.AnalisisLexico;
import com.company.AnalisisSemantico;
import interfacelaii.GUI.TablaSimbolos.MetodosTablaLlenado;
import interfacelaii.GUI.TablaSimbolos.tablaSimbolos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.company.tablaSimbolos.*;
import com.company.AnalisisSintactico;

/**
 *
 * @author usuario
 */
public class principal extends javax.swing.JFrame {
JFileChooser seleccionar=new JFileChooser();
File archivo;
FileInputStream entrada;
FileOutputStream salida;
tablaSimbolos datos= new tablaSimbolos();
MetodosTablaLlenado metodos=new MetodosTablaLlenado();
DefaultTableModel modelSimbolos;
Vector vCabeceras= new Vector();
private final String ruta=System.getProperties().getProperty("user.dir");
   


    public principal() {
        
        initComponents();
        texto.setVisible(false);
        
        vCabeceras.addElement("ID");
        vCabeceras.addElement("TOKEN");
        vCabeceras.addElement("LEXEMA");
        vCabeceras.addElement("LINEA");
        vCabeceras.addElement("VALOR");
        modelSimbolos= new DefaultTableModel(vCabeceras,0);
       
        
    }
public String AbrirArchivo(File archivo){
    String documento="";
    try {
        entrada=new FileInputStream(archivo);
        int ascci;
        while((ascci=entrada.read())!=-1){
            char caracter=(char)ascci;
            documento+=caracter;
        }
        entrada.close();
    }catch(Exception e){
        
    } return documento;
}

public String GuardarArchivo(File archivo,String documento){
    String mensaje=null;
    try{
        salida=new FileOutputStream(archivo);
        byte[] bytxt=documento.getBytes();
        salida.write(bytxt);
        
        mensaje="ARCHIVO GUARDADO";
        salida.close();
    }catch(Exception e ){
        
    }return mensaje;
}

public void MostrarDatosTSimbolos(){
    
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        gris = new javax.swing.JButton();
        amarillo = new javax.swing.JButton();
        verde_rojo = new javax.swing.JButton();
        texto = new javax.swing.JTextField();
        pnlTabla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSimbolos = new javax.swing.JTable();
        pnlSalida = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaSalida = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaCodigo = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuAbrir = new javax.swing.JMenuItem();
        menuGuardar = new javax.swing.JMenuItem();
        menuNuevo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuCompilarLexico = new javax.swing.JMenuItem();
        menuCompilarSintactico = new javax.swing.JMenuItem();
        menuCompilarSemantico = new javax.swing.JMenuItem();
        menuCompilarTodos = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        abrirA1 = new javax.swing.JMenuItem();
        abrirA2 = new javax.swing.JMenuItem();
        abrirA3 = new javax.swing.JMenuItem();
        abrirA4 = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setToolTipText("");
        jPanel1.setName("pnlSemaforo"); // NOI18N

        jLabel1.setText("Status");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(185, 185, 185)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(gris, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(amarillo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addComponent(verde_rojo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gris, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amarillo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verde_rojo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pnlTabla.setBackground(new java.awt.Color(255, 255, 255));

        tblSimbolos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "TOKEN", "LEXEMA", "LINEA", "VALOR"
            }
        ));
        jScrollPane2.setViewportView(tblSimbolos);
        if (tblSimbolos.getColumnModel().getColumnCount() > 0) {
            tblSimbolos.getColumnModel().getColumn(2).setResizable(false);
            tblSimbolos.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout pnlTablaLayout = new javax.swing.GroupLayout(pnlTabla);
        pnlTabla.setLayout(pnlTablaLayout);
        pnlTablaLayout.setHorizontalGroup(
            pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTablaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlTablaLayout.setVerticalGroup(
            pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );

        pnlSalida.setBackground(new java.awt.Color(204, 204, 255));

        txtAreaSalida.setEditable(false);
        txtAreaSalida.setBackground(new java.awt.Color(204, 204, 255));
        txtAreaSalida.setColumns(20);
        txtAreaSalida.setRows(5);
        txtAreaSalida.setToolTipText("");
        txtAreaSalida.setName("txtAreaSalida"); // NOI18N
        jScrollPane3.setViewportView(txtAreaSalida);

        javax.swing.GroupLayout pnlSalidaLayout = new javax.swing.GroupLayout(pnlSalida);
        pnlSalida.setLayout(pnlSalidaLayout);
        pnlSalidaLayout.setHorizontalGroup(
            pnlSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        pnlSalidaLayout.setVerticalGroup(
            pnlSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSalidaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setName("pnlCodigo"); // NOI18N

        txtAreaCodigo.setColumns(20);
        txtAreaCodigo.setRows(5);
        jScrollPane1.setViewportView(txtAreaCodigo);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jMenu1.setText("Archivo");

        menuAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/open.png"))); // NOI18N
        menuAbrir.setText("Abrir");
        menuAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(menuAbrir);

        menuGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        menuGuardar.setText("Guardar");
        menuGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(menuGuardar);

        menuNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/new.png"))); // NOI18N
        menuNuevo.setText("Nuevo");
        menuNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNuevoActionPerformed(evt);
            }
        });
        jMenu1.add(menuNuevo);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Compilar");

        menuCompilarLexico.setText("Análisis léxico");
        menuCompilarLexico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCompilarLexicoActionPerformed(evt);
            }
        });
        jMenu2.add(menuCompilarLexico);

        menuCompilarSintactico.setText("Análisis sintáctico");
        menuCompilarSintactico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCompilarSintacticoActionPerformed(evt);
            }
        });
        jMenu2.add(menuCompilarSintactico);

        menuCompilarSemantico.setText("Análisis semántico");
        menuCompilarSemantico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCompilarSemanticoActionPerformed(evt);
            }
        });
        jMenu2.add(menuCompilarSemantico);

        menuCompilarTodos.setText("Todos los análisis");
        menuCompilarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCompilarTodosActionPerformed(evt);
            }
        });
        jMenu2.add(menuCompilarTodos);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Ayuda");

        abrirA1.setText("Gramática");
        abrirA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirA1ActionPerformed(evt);
            }
        });
        jMenu4.add(abrirA1);

        abrirA2.setText("Lexíco");
        abrirA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirA2ActionPerformed(evt);
            }
        });
        jMenu4.add(abrirA2);

        abrirA3.setText("Sintáctico");
        abrirA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirA3ActionPerformed(evt);
            }
        });
        jMenu4.add(abrirA3);

        abrirA4.setText("Semántico");
        abrirA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirA4ActionPerformed(evt);
            }
        });
        jMenu4.add(abrirA4);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 1, Short.MAX_VALUE)
                                .addComponent(pnlTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAbrirActionPerformed
       if(seleccionar.showDialog(null, "Abrir")==JFileChooser.APPROVE_OPTION){
           archivo=seleccionar.getSelectedFile();
           if(archivo.canRead()){
               if(archivo.getName().endsWith("txt")){
                   String documento=AbrirArchivo(archivo);
                   txtAreaCodigo.setText(documento);
                  
               }else{
                   txtAreaSalida.setText("Archivo no encontrado");
               }
           }
       }
    }//GEN-LAST:event_menuAbrirActionPerformed

    private void menuCompilarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCompilarTodosActionPerformed
String codigo = txtAreaCodigo.getText();
 AnalisisLexico analisisLexico = new AnalisisLexico();
 analisisLexico.darCodigo(codigo);
 analisisLexico.lexemas();
 AnalisisSintactico analisisSintactico = new AnalisisSintactico();
 analisisSintactico.tablaSimbolos = analisisLexico.tablaSimbolos;
 analisisSintactico.pilaErrores = analisisLexico.pilaErrores;
 analisisSintactico.analizar();
 AnalisisSemantico analisisSemantico = new AnalisisSemantico();
 analisisSemantico.tablaSimbolos = analisisSintactico.tablaSimbolos;
 analisisSemantico.pilaErrores = analisisSintactico.pilaErrores;
 analisisSemantico.analizar();
  
boolean ban = false;
if(analisisSemantico.pilaErrores.pila.empty()){
    ban = true;
    txtAreaSalida.setText("Analis exitoso");
}
else{
    txtAreaSalida.setText(analisisSemantico.pilaErrores.imprimir());
}
ProcesoSemaforo objeto = new ProcesoSemaforo(gris,amarillo,verde_rojo,texto,ban);
objeto.start();
        
 //************************SEMAFOROO******************************+      
    try {
        this.GuardarDatosTSimbolos(analisisSemantico.tablaSimbolos);
        
    } catch (IOException ex) {
        Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
    }
    
 //******************LLENADO DE LA TABLA*********************
  tblSimbolos.setModel(metodos.listaTablaSimbolos());        // TODO add your handling code here:
    }//GEN-LAST:event_menuCompilarTodosActionPerformed

    private void abrirA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirA2ActionPerformed
       AbrirPDF(ruta+"//pdf/a2.pdf");
    }//GEN-LAST:event_abrirA2ActionPerformed

    private void menuGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGuardarActionPerformed
      if(seleccionar.showDialog(null, "Guardar")==JFileChooser.APPROVE_OPTION){
           archivo=seleccionar.getSelectedFile();
           if(archivo.getName().endsWith("txt")){
           String Documento=txtAreaCodigo.getText(); 
           String mensaje=GuardarArchivo(archivo,Documento);
           if(mensaje!=null){
               txtAreaSalida.setText(mensaje);
           }else{
               txtAreaSalida.setText("Archivo no compatible");
           }
           }else{
               txtAreaSalida.setText("Guardar documento de texto");
           }
       }
    }//GEN-LAST:event_menuGuardarActionPerformed

    private void menuNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNuevoActionPerformed
      txtAreaCodigo.setText("");
      txtAreaSalida.setText("");
      tblSimbolos.setModel(null);
    }//GEN-LAST:event_menuNuevoActionPerformed

    
public void GuardarDatosTSimbolos(TablaSimbolos tabla) throws IOException{
  metodos.guardarArchivo(tabla);
  modelSimbolos = metodos.listaTablaSimbolos();
  
}   

    private void menuCompilarLexicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCompilarLexicoActionPerformed
 String codigo = txtAreaCodigo.getText();
 AnalisisLexico analisisLexico = new AnalisisLexico();
 analisisLexico.darCodigo(codigo);
 analisisLexico.lexemas();
  
boolean ban = false;
if(analisisLexico.pilaErrores.pila.empty()){
    ban = true;
    txtAreaSalida.setText("Analis lexico exitoso");
}
else{
    txtAreaSalida.setText(analisisLexico.pilaErrores.imprimir());
}
ProcesoSemaforo objeto = new ProcesoSemaforo(gris,amarillo,verde_rojo,texto,ban);
objeto.start();
        
 //************************SEMAFOROO******************************+      
    try {
        this.GuardarDatosTSimbolos(analisisLexico.tablaSimbolos);
        
    } catch (IOException ex) {
        Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
    }
    
 //******************LLENADO DE LA TABLA*********************
  tblSimbolos.setModel(metodos.listaTablaSimbolos());
        
    
    
    
    
    }//GEN-LAST:event_menuCompilarLexicoActionPerformed

    private void menuCompilarSintacticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCompilarSintacticoActionPerformed
    String codigo = txtAreaCodigo.getText();
 AnalisisLexico analisisLexico = new AnalisisLexico();
 analisisLexico.darCodigo(codigo);
 analisisLexico.lexemas();
 AnalisisSintactico analisisSintactico = new AnalisisSintactico();
 analisisSintactico.tablaSimbolos = analisisLexico.tablaSimbolos;
 analisisSintactico.analizar();
  
boolean ban = false;
if(analisisSintactico.pilaErrores.pila.empty()){
    ban = true;
    txtAreaSalida.setText("Analis sintactico exitoso");
}
else{
    txtAreaSalida.setText(analisisSintactico.pilaErrores.imprimir());
}
ProcesoSemaforo objeto = new ProcesoSemaforo(gris,amarillo,verde_rojo,texto,ban);
objeto.start();
        
 //************************SEMAFOROO******************************+      
    try {
        this.GuardarDatosTSimbolos(analisisSintactico.tablaSimbolos);
        
    } catch (IOException ex) {
        Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
    }
    
 //******************LLENADO DE LA TABLA*********************
  tblSimbolos.setModel(metodos.listaTablaSimbolos());
    }//GEN-LAST:event_menuCompilarSintacticoActionPerformed

    private void abrirA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirA1ActionPerformed
      
AbrirPDF(ruta+"//pdf/a1.pdf");
    }//GEN-LAST:event_abrirA1ActionPerformed


    private void menuCompilarSemanticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCompilarSemanticoActionPerformed
        String codigo = txtAreaCodigo.getText();
 AnalisisLexico analisisLexico = new AnalisisLexico();
 analisisLexico.darCodigo(codigo);
 analisisLexico.lexemas();
 AnalisisSintactico analisisSintactico = new AnalisisSintactico();
 analisisSintactico.tablaSimbolos = analisisLexico.tablaSimbolos;
 analisisSintactico.pilaErrores = analisisLexico.pilaErrores;
 analisisSintactico.analizar();
 
 AnalisisSemantico analisisSemantico = new AnalisisSemantico();
 analisisSemantico.tablaSimbolos = analisisSintactico.tablaSimbolos;
 
 analisisSemantico.analizar();
  
boolean ban = false;
if(analisisSemantico.pilaErrores.pila.empty()){
    ban = true;
    txtAreaSalida.setText("Analis semantico exitoso");
}
else{
    txtAreaSalida.setText(analisisSemantico.pilaErrores.imprimir());
}
ProcesoSemaforo objeto = new ProcesoSemaforo(gris,amarillo,verde_rojo,texto,ban);
objeto.start();
        
 //************************SEMAFOROO******************************+      
    try {
        this.GuardarDatosTSimbolos(analisisSemantico.tablaSimbolos);
        
    } catch (IOException ex) {
        Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
    }
    
 //******************LLENADO DE LA TABLA*********************
  tblSimbolos.setModel(metodos.listaTablaSimbolos());
    }//GEN-LAST:event_menuCompilarSemanticoActionPerformed

    private void abrirA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirA3ActionPerformed
       AbrirPDF(ruta+"//pdf/a3.pdf");
    }//GEN-LAST:event_abrirA3ActionPerformed

    private void abrirA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirA4ActionPerformed
        AbrirPDF(ruta+"//pdf/a4.pdf");
    }//GEN-LAST:event_abrirA4ActionPerformed

    public void AbrirPDF(String archivo){
        try
{
Process p = Runtime.getRuntime().exec ("rundll32 SHELL32.DLL,ShellExec_RunDLL "+archivo);
}
catch (Exception evvv)
{
JOptionPane.showMessageDialog(null, "No se puede abrir el archivo de ayuda, probablemente fue borrado","ERROR",JOptionPane.ERROR_MESSAGE);
 
}
    }
   

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrirA1;
    private javax.swing.JMenuItem abrirA2;
    private javax.swing.JMenuItem abrirA3;
    private javax.swing.JMenuItem abrirA4;
    private javax.swing.JButton amarillo;
    private javax.swing.JButton gris;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JMenuItem menuAbrir;
    private javax.swing.JMenuItem menuCompilarLexico;
    private javax.swing.JMenuItem menuCompilarSemantico;
    private javax.swing.JMenuItem menuCompilarSintactico;
    private javax.swing.JMenuItem menuCompilarTodos;
    private javax.swing.JMenuItem menuGuardar;
    private javax.swing.JMenuItem menuNuevo;
    private javax.swing.JPanel pnlSalida;
    private javax.swing.JPanel pnlTabla;
    private javax.swing.JTable tblSimbolos;
    private javax.swing.JTextField texto;
    private javax.swing.JTextArea txtAreaCodigo;
    private javax.swing.JTextArea txtAreaSalida;
    private javax.swing.JButton verde_rojo;
    // End of variables declaration//GEN-END:variables
}
