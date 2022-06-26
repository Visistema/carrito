/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreraautos;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Carrera extends Thread {
    private JLabel eti;
    private final JframeAuto f;
    
    public Carrera(JLabel eti, JframeAuto f){
        this.eti=eti;
        this.f=f;
        //El constructor recibe a las etiquetas y el Jframe
    }
    @Override
    public void run(){
        int c1=0, c2=0, c3=0;//Se decalarn variables de tipo entero para ir almacenando el avance de cada etiqueta o coche
        while (true) {
                try {
                    Thread.sleep((int)(Math.random()*100));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
                }
                c1=f.getlbl1().getLocation().x;//Cuando se crea un JFrame como este, el padre es nulo, por lo que es la pantalla. Es por eso que aquí, las funciones getLocation()devuelve la posición de su marco en relación con su Jframe.
                c2=f.getlbl2().getLocation().x;
                c3=f.getlbl3().getLocation().x;
                if(c1<f.getlbl_barrera().getLocation().x-10&&c2<f.getlbl_barrera().getLocation().x-10&&c3<f.getlbl_barrera().getLocation().x-10){ 
                    eti.setLocation(eti.getLocation().x+10,eti.getLocation().y);//permite el avance de las etiquetas cada 10 pixeles y va guardando la posición en la que se queda por cada iteración del ciclo
                    f.getContentPane().repaint();//Actualiza la vista del panel
                    
            }else{
                break;//cuando alguna de las etiquetas llega a la posición de la meta el ciclo se rompe
                }
        }
        if (eti.getLocation().x>=f.getlbl_barrera().getLocation().x-10){
            if(c1>c2&&c1>c3){
                f.getlbl_barrera().setBorder(BorderFactory.createLineBorder(Color.green,8));
                JOptionPane.showMessageDialog(null, "Gano 1");
            }else if(c2>c1&&c2>c3){
                f.getlbl_barrera().setBorder(BorderFactory.createLineBorder(Color.magenta,8));
                JOptionPane.showMessageDialog(null, "Gano 2");
            }else if(c3>c1&&c3>c2){
                f.getlbl_barrera().setBorder(BorderFactory.createLineBorder(Color.blue,8));
                JOptionPane.showMessageDialog(null, "Gano 3");
            }else{
                f.getlbl_barrera().setBorder(BorderFactory.createLineBorder(Color.yellow,8));
                JOptionPane.showMessageDialog(null, "Empate");
            }
        f.getlbl_barrera().setBorder(BorderFactory.createLineBorder(Color.red,8));    
        }
        
}
}