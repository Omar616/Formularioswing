
package formulito;
import java.sql.*;
public class Conexion {
         //Inicializar variable statement
        static Statement stm = null; 
//        Aqui se realiza la conexion a la base de datos, no se usa jsp
        public static Connection getConexion(){
            Connection cn = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                cn = DriverManager.getConnection("jdbc:mysql://localhost/escuela", "root", "n0m3l0");
                stm = cn.createStatement();
                System.out.print("Conexion Satisfactoria");
            }
            catch (Exception e){
                System.out.print("Error de conexion: "+e);
            }
            return cn;
        } 
        //crear un metodo que recibira parametros String para guardarlos en la base
        public void SubirDatos(String Nombre, String appat, String apmat, String escu){
            try{//codigo query donde insertara dentro de la tabla alumnos que se encuentra creada en la base
                stm.executeUpdate("INSERT INTO alumnos (nombre, paterno, materno, escuela) VALUES (" + 
                    "'" + Nombre + "', '" + appat + "', '" + apmat + "', '" + escu + "');");
            }catch(SQLException error)
            {
                System.out.println(error.toString());
            }
        }      
}
