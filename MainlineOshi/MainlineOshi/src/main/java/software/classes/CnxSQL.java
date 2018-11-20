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

public class CnxSQL {

    private final JSlack jslack = new JSlack();
    private final DadosOshi oshi = new DadosOshi();
    private final Usuario user = new Usuario();
    private final String idAtivo = oshi.getAtivoID(); // id do Ativo
    public arquivoLog arq = new arquivoLog();
    String quebraLinha = System.getProperty("line.separator");
    Date dataHoraAtual = new Date();
    String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
    String hora = new SimpleDateFormat(" HH:mm:ss").format(dataHoraAtual);

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
                arq.escreverlog(quebraLinha + data + hora + " Usuário já existe no banco!");
                return true; // if email e senha fornecidos pelo usuario existirem no BD, retorna true;
                //}
            }
            cnx.close();

        } catch (SQLException ex) {
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
            arq.escreverlog(quebraLinha + data + hora + " Erro na execução! Usuário ou senha inválidos. método: autenticaUsuario.");
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
                arq.escreverlog(quebraLinha + data + hora + " ID já existe no banco!");
            } else {
                String insert = "INSERT INTO ativo (idAtivo) VALUES ('" + idAtivo + "')";
                stm.executeUpdate(insert);// Executa a instrução SQL fornecida, que pode ser uma instrução INSERT, UPDATE ou DELETE;
                arq.escreverlog(quebraLinha + data + hora + " Novo ID inserido no banco!");
            }

            cnx.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Erro!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
            arq.escreverlog(quebraLinha + data + hora + " Erro na execução! Possivelmente não foi possível verificar ID. método: verificaAtivoID.");
        }
    }

    public void insertComponente(String tabela, String coluna, String nomeComponente, float valorComponente, long sleep) throws InterruptedException, IOException {
        try {
            cnx = DriverManager.getConnection(url);
            stm = cnx.createStatement();
            String insert = "INSERT INTO " + tabela + " (" + coluna + ", idAtivo) VALUES (" + valorComponente + ", '" + idAtivo + "')";
            stm.executeUpdate(insert);
            arq.escreverlog(quebraLinha + data + hora + " captando dados do componente com sucesso!");
            cnx.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "CnxSQL Componente " + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
            arq.escreverlog(quebraLinha + data + hora + " Erro na execução! Falha ao iniciar captura de dados. método: insertComponente.");
        }
        if (valorComponente > 80) {
            jslack.alertaComponente(nomeComponente);
            arq.escreverlog("Alerta: O uso do componente está em estado crítico.");
        }
        Thread.sleep(sleep);
    }

    public void insertRede() throws InterruptedException, IOException {
        float download = oshi.getDownload();
        float upload = oshi.getUpload();
        try {
            cnx = DriverManager.getConnection(url);
            stm = cnx.createStatement();
            String insert = "INSERT INTO infoRede (upload, download, idAtivo) VALUES (" + upload + "," + download + ",'" + idAtivo + "')";
            stm.executeUpdate(insert);
            arq.escreverlog(quebraLinha + data + hora + " captando informações de rede");
            cnx.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "CnxSQL Rede " + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
            arq.escreverlog(quebraLinha + data + hora + " Erro na execução! Falha ao captar informações de rede. método: insertRede.");
        }
        Thread.sleep(20000);
    }
}
