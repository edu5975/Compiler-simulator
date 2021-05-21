package interfacelaii.GUI;


import java.awt.Color;
import static java.lang.Thread.sleep;
import javax.swing.*;


public class ProcesoSemaforo implements Runnable {
    
    JButton gris;
    JButton amarillo;
    JButton verde_rojo;
    JTextField texto;
    Boolean analisis,bandera;
    
    int contador=0,temp=0,temp2=0,temp3=0,temp4=0;
    
    public ProcesoSemaforo(JButton entrada1,JButton entrada2,JButton entrada3,JTextField entrada4,Boolean analisis){
       bandera=true;
       this.gris=entrada1;
       this.amarillo=entrada2;
       this.verde_rojo=entrada3;
       this.texto=entrada4;
       this.analisis=analisis;
    
    }

    
    
    @Override
    public void run() {
         
        while(bandera==true){
            
            contador++;
             
            if(contador>=1 && contador<=60){
                temp++;
                texto.setText(""+temp);
            }
            if(contador==1){
                gris.setBackground(Color.gray);
                amarillo.setBackground(Color.WHITE);
                verde_rojo.setBackground(Color.WHITE);
            }
            
          
            if(contador>=60 && contador<=63){
                
                temp2++;
                texto.setText(""+temp2);
            }
            if(contador==60){
              gris.setBackground(Color.gray);
              amarillo.setBackground(Color.yellow);
              verde_rojo.setBackground(Color.WHITE);  
            }
            
            
            if(contador>=63 && contador<=93){
                temp3++;
                texto.setText(""+temp3);
            }
            if(contador==63 && analisis==true){
              gris.setBackground(Color.gray);
              amarillo.setBackground(Color.YELLOW);
              verde_rojo.setBackground(Color.green);  
              bandera=false;
            }
            else if(contador==63 && analisis==false){
              gris.setBackground(Color.gray);
              amarillo.setBackground(Color.YELLOW);
              verde_rojo.setBackground(Color.RED);  
              bandera=false;
            }
            
            
            if(contador==95){
                contador=0;
                temp=0;
                temp2=0;
                temp3=0;
                temp4=0;
            }
            
            try {
                sleep(5);
            } catch (Exception e) {
            }
            
        }
        
    }
    
    public void start() {
        new Thread(this).start();
    }  
}
