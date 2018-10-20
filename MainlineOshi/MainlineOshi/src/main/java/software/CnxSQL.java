package software;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CnxSQL {

    public void metodo() {
        // Variaveis de Cnx
        String url = String.format("jdbc:sqlserver://lol-2018.database.windows.net:1433;database=ADS 2018;user=jessicasantos@lol-2018;password=Corinthians11;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        Connection cnx = null;
        // Variavel Comando sql
        String selectSql="select * from usuario";
        try {
            cnx=DriverManager.getConnection(url);
            Statement comandoSql = cnx.createStatement();
            ResultSet rs = comandoSql.executeQuery(selectSql);
            
            if(rs.next()){
                String nome = rs.getString("nome");
            }
            
        
        } catch (SQLException ex) {
            System.out.println("Deu ruim");
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
