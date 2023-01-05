package Maven.nttdatacenters_jdbc_CLS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) 
    {
        //Conexión con la base de datos
    	
    	conexionBD();
    }

	private static void conexionBD()  {
		try {
			//Se establece la conexión a la base de datos
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Se abre la conexión a la Base de datos
			final Connection connection = DriverManager.getConnection("jdbc:mysql://"+"localhost"+":"+"3306"+"/nttdata_fpdual_2","root","");
			
			//Consulta
			final Statement sentencia = connection.createStatement();
			final String query = "SELECT name as playerName FROM FPD_SOCCER_PLAYER";
			final ResultSet queryResult = sentencia.executeQuery(query);
			
			//Se itera
			StringBuilder info = new StringBuilder();
			while(queryResult.next()) {
				info.append("Nombre: ");
				info.append(queryResult.getString("playerName"));
				info.append(" // ");
				
			}
			
			System.out.println(info.toString());
			
			//Se cierra la conexión
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
    		System.out.println("Conexión realizada con éxito.");
		}
		
	}
}
