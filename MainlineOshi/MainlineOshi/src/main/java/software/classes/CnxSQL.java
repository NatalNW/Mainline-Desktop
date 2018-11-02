package software.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CnxSQL {

    private GetDados gd = new GetDados();
    private UsuarioAndAtivo ua = new UsuarioAndAtivo();

    // Variaveis de Cnx
    private String url = String.format("jdbc:sqlserver://lol-2018.database.windows.net:1433;database=ADS 2018;user=jessicasantos@lol-2018;password=Corinthians11;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
    private Connection cnx = null;
    private Statement stm = null;

    public boolean autenticaUsuario(String email, String senha) {

        try {
            //abre conexão
            cnx = DriverManager.getConnection(url);// A classe DriverManager tentará carregar as classes de driver referenciadas na propriedade de sistema "jdbc.drivers". Isso permite que um usuário personalize os drivers JDBC usados por seus aplicativos;
            stm = cnx.createStatement();// Cria um objeto Statement para enviar instruções SQL para o BD;

            //faz select
            String select = "SELECT * FROM usuario";

            ResultSet rs = stm.executeQuery(select);// Executa a instrução SQL fornecida, que retorna um objeto ResultSet;

            if (rs.next()) { // Le os dados no BD;
                ua.setIdUser(rs.getInt("idUser"));
                ua.setNome(rs.getString("nome"));

                if (rs.getString("email").equals(email) && rs.getString("senha").equals(senha)) {
                    return true; // if email e senha fornecidos pelo usuario existirem no BD, retorna true;
                }

                cnx.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    private String idAtivo = gd.getAtivoID(); // id do Ativo

    public void insertRam() {
        double ram = gd.getConsumoRam();
        try {
            cnx = DriverManager.getConnection(url);
            stm = cnx.createStatement();
            String insert = "INSERT INTO infoRam VALUES (" + ram + ", " + idAtivo + ")";
            stm.executeUpdate(insert);// Executa a instrução SQL fornecida, que pode ser uma instrução INSERT, UPDATE ou DELETE;

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
            String insert = "INSERT INTO infoHD VALUES (" + hd + ", " + idAtivo + ")";
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
            String insert = "INSERT INTO infoRam VALUES (" + cpu + ", " + idAtivo + ")";
            stm.executeUpdate(insert);

            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
