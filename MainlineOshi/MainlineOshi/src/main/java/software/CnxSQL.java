package software;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CnxSQL {
    
// Variaveis de Cnx
    String url = String.format("jdbc:sqlserver://lol-2018.database.windows.net:1433;database=ADS 2018;user=jessicasantos@lol-2018;password=Corinthians11;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
    Connection cnx = null;
    Statement stm = null;
    
    private String nome;
    private String senha;
    
    public boolean autenticaUsuario(String nome, String senha) {

        this.nome = nome;
        this.senha = senha;
        
        
                
        try {
            //abre conexão
            cnx = DriverManager.getConnection(url);
            stm = cnx.createStatement();
            //faz select
            String select = "SELECT * FROM  usuario";
            ResultSet rs = stm.executeQuery(select);
            // Validação de login
            if (rs.next()) {
                //retorna nome && senha
                if (rs.getString("nome").equals(this.nome) && rs.getString("senha").equals(this.senha)) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
