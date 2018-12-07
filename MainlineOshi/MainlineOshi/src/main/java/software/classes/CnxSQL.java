package software.classes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import software.classes.JSlack;
import software.classes.Usuario;
import software.classes.arquivoLog;
import software.oshi.Ativo;
import software.oshi.Rede;

public class CnxSQL {

    private final JSlack jslack = new JSlack();

    private final Usuario user = new Usuario();
    private final Ativo ativo = new Ativo();
    private final Rede rede = new Rede();
    private final String idAtivo = ativo.getAtivoID(); // id do Ativo

    private final arquivoLog arq = new arquivoLog();
    private final String quebraLinha = System.getProperty("line.separator");
    private Date dataHoraAtual = new Date();
    private String data2 = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
    private String hora2 = new SimpleDateFormat(" HH:mm:ss").format(dataHoraAtual);

    // Variaveis de Cnx
    protected final String url = String.format("jdbc:sqlserver://lol-2018.database.windows.net:1433;database=ADS 2018;user=jessicasantos@lol-2018;password=Corinthians11;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
    protected Connection cnx = null;
    protected Statement stm = null;

    public boolean autenticaUsuario(String email, String senha) throws IOException {
        try {
            // Abre conexão
            cnx = DriverManager.getConnection(url);// A classe DriverManager tentará carregar as classes de driver referenciadas na propriedade de sistema "jdbc.drivers". Isso permite que um usuário personalize os drivers JDBC usados por seus aplicativos;
            stm = cnx.createStatement();// Cria um objeto Statement para enviar instruções SQL para o BD;
            //String select = "SELECT * FROM usuario";
            String select = "SELECT * FROM usuario WHERE email = '" + email + "' and senha = '" + senha + "'";// Faz select
            ResultSet rs = stm.executeQuery(select);// Executa a instrução SQL fornecida, que retorna um objeto ResultSet;

            if (rs.next()) { // Le os dados no BD;
                // if (rs.getString("email").equals(email) && rs.getString("senha").equals(senha)) {
                user.setNome(rs.getString("nome"));
                jslack.usuarioLogado(user.getNome());
                verificaAtivoID();
                return true; // if email e senha fornecidos pelo usuario existirem no BD, retorna true;
                //}
            }
            
            stm.close();
            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
             arq.escreverLog(quebraLinha + data2 + hora2 + " " + ex);
        }

        return false;
    }

    public void verificaAtivoID() throws IOException {// Verifica se ativo já existe no BD;
        try {
            cnx = DriverManager.getConnection(url);
            stm = cnx.createStatement();
            String select = "SELECT * FROM ativo WHERE idAtivo = '" + idAtivo + "'";
            ResultSet rs = stm.executeQuery(select);
            if (rs.next()) {
                arq.escreverLog(quebraLinha + data2 + hora2 + " ID já existe no banco!");
            } else {
                String insert = "INSERT INTO ativo (idAtivo) VALUES ('" + idAtivo + "')";
                stm.executeUpdate(insert);// Executa a instrução SQL fornecida, que pode ser uma instrução INSERT, UPDATE ou DELETE;
                arq.escreverLog(quebraLinha + data2 + hora2 + " Novo ID inserido no banco!");
            }
            
            stm.close();
            cnx.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Erro!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
             arq.escreverLog(quebraLinha + data2 + hora2 + " " + ex);
        }
    }

    public void insertCpu(String tabela, String coluna, String nomeComponente, float valorComponente, long sleep) throws InterruptedException, IOException {
        try {
            cnx = DriverManager.getConnection(url);
            stm = cnx.createStatement();
            String insert = "INSERT INTO " + tabela + " (" + coluna + ", dia, hora, idAtivo) VALUES (" + valorComponente + ", '"+data2+"', '"+hora2+"', '" + idAtivo + "')";
            stm.executeUpdate(insert);
            arq.escreverLog(quebraLinha + data2 + hora2 + " captando dados do componente Cpu com sucesso!");
            
            stm.close();
            cnx.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "CnxSQL Componente " + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
             arq.escreverLog(quebraLinha + data2 + hora2 + " " + ex);
        }
        if (valorComponente > 80) {
            jslack.alertaComponente("Cpu");
            arq.escreverLog("Alerta: O uso do componente Cpu está em estado crítico.");
        }
        Thread.sleep(10000);
    }
    public void insertRam(String tabela, String coluna, String nomeComponente, float valorComponente, long sleep) throws InterruptedException, IOException {
        try {
            cnx = DriverManager.getConnection(url);
            stm = cnx.createStatement();
            String insert = "INSERT INTO " + tabela + " (" + coluna + ", dia, hora, idAtivo) VALUES (" + valorComponente + ", '"+data2+"', '"+hora2+"', '" + idAtivo + "')";
            stm.executeUpdate(insert);
            arq.escreverLog(quebraLinha + data2 + hora2 + " captando dados do componente Ram com sucesso!");
            
            stm.close();
            cnx.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "CnxSQL Componente " + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
             arq.escreverLog(quebraLinha + data2 + hora2 + " " + ex);
        }
        if (valorComponente > 80) {
            jslack.alertaComponente("Ram");
            arq.escreverLog("Alerta: O uso do componente Ram está em estado crítico.");
        }
        Thread.sleep(10000);
    }
    public void insertHD(String tabela, String coluna, String nomeComponente, float valorComponente, long sleep) throws InterruptedException, IOException {
        try {
            cnx = DriverManager.getConnection(url);
            stm = cnx.createStatement();
            String insert = "INSERT INTO " + tabela + " (" + coluna + ", dia, hora, idAtivo) VALUES (" + valorComponente + ", '"+data2+"', '"+hora2+"', '" + idAtivo + "')";
            stm.executeUpdate(insert);
            arq.escreverLog(quebraLinha + data2 + hora2 + " captando dados do componente HD com sucesso!");
            
            stm.close();
            cnx.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "CnxSQL Componente " + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
             arq.escreverLog(quebraLinha + data2 + hora2 + " " + ex);
        }
        if (valorComponente > 80) {
            jslack.alertaComponente("HD");
            arq.escreverLog("Alerta: O uso do componente HD está em estado crítico.");
        }
        Thread.sleep(600000);
    }
    public void insertAtivo(String tabela, String coluna, String nomeComponente, float valorComponente, long sleep) throws InterruptedException, IOException {
        try {
            cnx = DriverManager.getConnection(url);
            stm = cnx.createStatement();
            String insert = "INSERT INTO " + tabela + " (" + coluna + ", dia, hora, idAtivo) VALUES (" + valorComponente + ", '"+data2+"', '"+hora2+"', '" + idAtivo + "')";
            stm.executeUpdate(insert);
            arq.escreverLog(quebraLinha + data2 + hora2 + " captando dados do componente com sucesso!");
            
            stm.close();
            cnx.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "CnxSQL Componente " + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
             arq.escreverLog(quebraLinha + data2 + hora2 + " " + ex);
        }
    }

    public void insertRede() throws InterruptedException, IOException {
        float download = rede.getDownload();
        float upload = rede.getUpload();
        try {
            cnx = DriverManager.getConnection(url);
            stm = cnx.createStatement();
            String insert = "INSERT INTO infoRede (upload, download, dia, hora, idAtivo) VALUES (" + upload + "," + download + ", '"+data2+"', '"+hora2+"','" + idAtivo + "')";
            stm.executeUpdate(insert);
            arq.escreverLog(quebraLinha + data2 + hora2 + " captando informações de rede");
            
            stm.close();
            cnx.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "CnxSQL Rede " + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
             arq.escreverLog(quebraLinha + data2 + hora2 + " " + ex);
        }
        Thread.sleep(10000);
    }
}
