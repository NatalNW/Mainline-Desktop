package software;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CnxSQL {

    private GetDados gd = new GetDados(); // Istancia Classe GetDados
    UsuarioAndAtivo ua = new UsuarioAndAtivo(); // Istancia Classe UsuarioAndAtivo

    // Variaveis de Cnx
    private String url = String.format("jdbc:sqlserver://lol-2018.database.windows.net:1433;database=ADS 2018;user=jessicasantos@lol-2018;password=Corinthians11;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
    private Connection cnx = null;
    private Statement stm = null;
        
    public boolean autenticaUsuario(String email, String senha, int ativoID) { // Metodo q faz autenticação de login q entraos valores email, senha e id do ativo como parametros;

        try {
            // Abre conexão
            cnx = DriverManager.getConnection(url); // Tenta estabelecer uma conexão com a URL do banco de dados fornecido. O DriverManager tenta selecionar um driver apropriado do conjunto de drivers JDBC registrados;
            stm = cnx.createStatement(); // Cria um objeto Statement para enviar instruções SQL para o banco de dados;
            // Instrução ao Banco 
            String select = "SELECT * FROM usuario, ativo WHERE usuario.idUser = ativo.idUser";
            ResultSet rs = stm.executeQuery(select); // Executa a instrução SQL fornecida;

            if (rs.next()) {
                //String IDativo = Integer.toString(rs.getInt("idAtivo"));
                // Add valores as variaveis de usuario na classe UsuarioAndAtivo;
                ua.setIdUser(rs.getInt("idUser"));
                ua.setNome(rs.getString("nome"));
                ua.setIdAtivo(rs.getInt("idAtivo"));
                ua.setNomeAtivo(rs.getString("nomeAtivo"));
                // Validação de login
                if ((rs.getString("email").equals(email) && rs.getString("senha").equals(senha)) && (ua.getIdAtivo() == (ativoID))) {
                    return true;
                    //if true, usuario existe e ativo já cadastrado;
                }
                cnx.close(); // Fecha conexão;
            }

        } catch (SQLException ex) {
            // retorna um log de erros
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;   
    }
    
    private int idAtivo = ua.getIdAtivo();
    
    public void insertRam() { // Faz INSERT do uso atual da Ram do respectivo ativo;
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
    
    public void insertHD() {// Faz INSERT do uso atual da HD do respectivo ativo;
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
    
    public void insertCPU() {// Faz INSERT do uso atual da CPU do respectivo ativo;
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
