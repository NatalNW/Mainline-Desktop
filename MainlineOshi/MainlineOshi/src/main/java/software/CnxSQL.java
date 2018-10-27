package software;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CnxSQL {

    private GetDados gd = new GetDados();
    UsuarioAndAtivo ua = new UsuarioAndAtivo();

    // Variaveis de Cnx
    private String url = String.format("jdbc:sqlserver://lol-2018.database.windows.net:1433;database=ADS 2018;user=jessicasantos@lol-2018;password=Corinthians11;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
    private Connection cnx = null;
    private Statement stm = null;

    public boolean autenticaUsuario(String email, String senha, int ativoID) {

        try {
            //abre conexão
            cnx = DriverManager.getConnection(url);
            stm = cnx.createStatement();
            //faz select
            String select = "SELECT * FROM usuario, ativo WHERE usuario.idUser = ativo.idUser";
            ResultSet rs = stm.executeQuery(select);

            if (rs.next()) {
                //String IDativo = Integer.toString(rs.getInt("idAtivo"));
                ua.setIdUser(rs.getInt("idUser"));
                ua.setNome(rs.getString("nome"));
                ua.setIdAtivo(rs.getInt("idAtivo"));
                ua.setNomeAtivo(rs.getString("nomeAtivo"));
                // Validação de login
                if ((rs.getString("email").equals(email) && rs.getString("senha").equals(senha)) && (ua.getIdAtivo() == (ativoID))) {
                    return true;
                    //if true, usuario existe e ativo já cadastrado
                }
                cnx.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;   
    }
    
    private int idAtivo = ua.getIdAtivo();
    
    public void insertRam() {
        double ram = gd.getConsumoRam();
        try {
            cnx = DriverManager.getConnection(url);
            stm = cnx.createStatement();
            String insert = "INSERT INTO infoRam VALUES (" + ram + ", "+idAtivo+")";
            stm.executeUpdate(insert);

            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertHD() {
        double hd = gd.getConsumoHD();
        try {
            cnx = DriverManager.getConnection(url);
            stm = cnx.createStatement();
            String insert = "INSERT INTO infoHD VALUES (" + hd + ", "+idAtivo+")";
            stm.executeUpdate(insert);

            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertCPU() {
        double cpu = gd.getConsumoCPU();
        try {
            cnx = DriverManager.getConnection(url);
            stm = cnx.createStatement();
            String insert = "INSERT INTO infoRam VALUES (" + cpu + ", "+idAtivo+")";
            stm.executeUpdate(insert);

            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
