package software;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CnxSQL {
    
    GetDados gd = new GetDados();
    
    
    // Variaveis de Cnx
    String url = String.format("jdbc:sqlserver://lol-2018.database.windows.net:1433;database=ADS 2018;user=jessicasantos@lol-2018;password=Corinthians11;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
    Connection cnx = null;
    Statement stm = null;
    
    private int idUser;
    private String nome;
    
      public int getIdUser() {
        return idUser;
    }

    public String getNome() {
        return nome;
    }
    
    public boolean autenticaUsuario(String email, String senha) {
        
        
        try {
            //abre conexão
            cnx = DriverManager.getConnection(url);
            stm = cnx.createStatement();
            //faz select
            String select = "SELECT * FROM  usuario";
            ResultSet rs = stm.executeQuery(select);
            
            if (rs.next()) {
                
                this.idUser = rs.getInt("idUser");
                this.nome = rs.getString("nome");
                // Validação de login
                if (rs.getString("email").equals(email) && rs.getString("senha").equals(senha)) {
                    
                    return true;
                    //if true, retorna nome && senha
                }
                cnx.close(); 
            }

        } catch (SQLException ex) {
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
        
    }
    
    public void insetRam(){
        try {
            
            cnx = DriverManager.getConnection(url);
            stm = cnx.createStatement();
            String insert = "INSERT INTO ativo";
        } catch (SQLException ex) {
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
