
package formulito;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.io.*;

public class seguridad extends JFrame{
 
    
    public void SLetras(JTextField a){
    a.addKeyListener(new KeyAdapter(){
        public void keyTyped(KeyEvent e){
        char c= e.getKeyChar();
        int k=(int)e.getKeyChar();
        if(Character.isDigit(c)){
        getToolkit().beep();
        JOptionPane.showMessageDialog(null, "Only letters", "Error amiguito", JOptionPane.ERROR_MESSAGE);
        e.consume();
        }
        }
    });
    }
    
     public void SNumeros(JTextField a){
    a.addKeyListener(new KeyAdapter(){
        public void keyTyped(KeyEvent e){
        char c= e.getKeyChar();
        int k=(int)e.getKeyChar();
        if(Character.isAlphabetic(c)){ 
        getToolkit().beep();
        JOptionPane.showMessageDialog(null, "Ingrese solo numeros ", "Mensaje error", JOptionPane.ERROR_MESSAGE);
        e.consume();
        }
        if(k==32){
        getToolkit().beep();
        JOptionPane.showMessageDialog(null, "No ingrese espacios ", "Mensaje error", JOptionPane.ERROR_MESSAGE);
        e.consume();
        }
        }
    });
    }
     public void SEspacios(JTextField a){
    a.addKeyListener(new KeyAdapter(){
        public void keyTyped(KeyEvent e){
        int k=(int)e.getKeyChar();
        if(k==32){
        getToolkit().beep();
        JOptionPane.showMessageDialog(null, "No ingrese espacios ", "Mensaje error", JOptionPane.ERROR_MESSAGE);
        e.consume();
        }
        }
    });
    }
     
     public void SPunto(JTextField a){
    a.addKeyListener(new KeyAdapter(){
        public void keyTyped(KeyEvent e){
        int k=(int)e.getKeyChar();
        if(k==46){
        getToolkit().beep();
        JOptionPane.showMessageDialog(null, "Ingrese solo numeros enteros ", "Mensaje error", JOptionPane.ERROR_MESSAGE);
        e.consume();
        }
        }
    });
    }
     
    public void NNegativo(JTextField a){
    a.addKeyListener(new KeyAdapter(){
        public void keyTyped(KeyEvent e){
        int k=(int)e.getKeyChar();
        if(k==45){
        getToolkit().beep();
        JOptionPane.showMessageDialog(null, "Ingrese solo numeros positivos ", "Mensaje error", JOptionPane.ERROR_MESSAGE);
        e.consume();
        }
        }
    });
    }
     
     
}
