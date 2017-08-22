/**
 * @author: Bueno y Cuevas
 * Grupo: 5IM8
 *  
*/

package formulito;

import formulito.Conexion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Interfaz extends JFrame implements ActionListener {
    
    JTextField TNombreUsuario, TApellidoP, TApellidoM, TEscuela;  //declaracion de interfaces, todas estas son las variables que se convertiran en componenetes de la interfaz
    JLabel LNombreUsuario, LApellidoP, LApellidoM, LEscuela, Buenas;
    JButton BotonGuardar; 
    
    seguridad val = new seguridad();  //llama a la clase de validacion donde se implementan todos los metodos correpondientes a comprobar lo que se ingresa
    public Interfaz(){
        InicializarVentana();   //constructor donde se inicializa los componentes
        InicializarComponentes();// se llaman a los metodos que inicializaran los componentes 
    }
    
    public void InicializarVentana(){
        setTitle("FORMULARIO");
        setSize(600, 300);
        setLocationRelativeTo(null);          // Inicializamos la ventana que fungira como el frame principal
        setLayout(null);
        setResizable(false);
        setBackground(new Color(0,0,0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
    
    public void InicializarComponentes(){
       
       // creacion e inicializacion de los componentes 
       
        TNombreUsuario = new JTextField();
        TApellidoP = new JTextField();
        TApellidoM = new JTextField();
        TEscuela = new JTextField();
        
        Buenas = new JLabel("Buenas noches ");
        LNombreUsuario = new JLabel(" nombre: ");
        LApellidoP = new JLabel("Apellido paterno");
        LApellidoM = new JLabel("Apellido materno");
        LEscuela = new JLabel("Escuela");
        
        BotonGuardar = new JButton("Guardar");
        // se agregan los componentes a la ventana principal
        setLayout(new BorderLayout());
        add(Buenas, BorderLayout.NORTH);
        add(UbicacionCentro(), BorderLayout.CENTER);
        add(BotonGuardar, BorderLayout.SOUTH);
   
        //creacion del evento que escuchara las acciones delboton guardar
        BotonGuardar.addActionListener(this);
        //establecimiento de las validaciones de usuario 
        val.SLetras(TNombreUsuario);
        val.SLetras(TApellidoP); 
        val.SLetras(TApellidoM);
        val.SLetras(TEscuela);
        
    }
    
    private JPanel UbicacionCentro(){
        // creacion de un panel que contendra los comoponentes 
        // se agregan los compenentes
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.add(LNombreUsuario);
        centro.add(TNombreUsuario);
        centro.add(LApellidoP);
        centro.add(TApellidoP);
        centro.add(LApellidoM);
        centro.add(TApellidoM);
        centro.add(LEscuela);
        centro.add(TEscuela);
        return centro;
    }  
    //metodo que realiza las acciones
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == BotonGuardar){
            //verifica que se este dando click al boton guardar
            Conexion ObjetoConexion = new Conexion();
            ObjetoConexion.getConexion(); // se llama a la conexion con base de datos
            String Nombre = TNombreUsuario.getText();
            String APP = TApellidoP.getText();
            String APM = TApellidoM.getText();
            String Escuela = TEscuela.getText();
            // se obtienen todos los textos en los jtextfield
            
            //se envian los metodos ala clase dela conexion donde seran llevados al query donde se implementaran 
            ObjetoConexion.SubirDatos(Nombre, APP, APM, Escuela);
        }
    }        
}