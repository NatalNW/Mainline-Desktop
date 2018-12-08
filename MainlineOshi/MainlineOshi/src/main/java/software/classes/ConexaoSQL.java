package software.classes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import software.oshi.Ativo;
import software.oshi.Cpu;
import software.oshi.HD;
import software.oshi.Ram;
import software.oshi.Rede;

public class ConexaoSQL {

    private final JSlack jslack = new JSlack();
    private final Usuario user = new Usuario();
    private final Ativo ativo = new Ativo();
    private final Rede rede = new Rede();
    private final HD hd = new HD();
    private final Cpu cpu = new Cpu();
    private final Ram ram = new Ram();
    private final String idAtivo = ativo.getAtivoID();

    private final arquivoLog arq = new arquivoLog();
    private final String quebraLinha = System.getProperty("line.separator");

    // Variaveis de Cnx
    private final String url = String.format("jdbc:sqlserver://lol-2018.database.windows.net:1433;database=ADS 2018;user=jessicasantos@lol-2018;password=Corinthians11;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
    private Connection cnx = null;
    private Statement stm = null;

    public boolean autenticaUsuario(String email, String senha) throws IOException {
        try {
            // Abre conexão
            cnx = DriverManager.getConnection(url);// A classe DriverManager tentará carregar as classes de driver referenciadas na propriedade de sistema "jdbc.drivers". Isso permite que um usuário personalize os drivers JDBC usados por seus aplicativos;
            stm = cnx.createStatement();// Cria um objeto Statement para enviar instruções SQL para o BD;
            //String select = "SELECT * FROM usuario";
            String select = "SELECT * FROM usuario WHERE email = '" + email + "' and senha = '" + senha + "'";// Faz select
            ResultSet rs = stm.executeQuery(select);// Executa a instrução SQL fornecida, que retorna um objeto ResultSet;

            if (rs.next()) { // Le os dados no BD;
                user.setNome(rs.getString("nome"));
                verificaAtivo();
                jslack.usuarioLogado(user.getNome());
                return true; // if email e senha fornecidos pelo usuario existirem no BD, retorna true;
            }

            stm.close();
            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            arq.escreverLog(quebraLinha + arq.getData() +" "+ arq.getHora() + " " + ex);
        }

        return false;
    }

    public void verificaAtivo() throws IOException {// Verifica se ativo já existe no BD;
        try {
            arq.escreverLog(quebraLinha + arq.getData() +" "+ arq.getHora() + " Verificando Ativo");
            cnx = DriverManager.getConnection(url);
            stm = cnx.createStatement();
            String select = "SELECT * FROM ativo WHERE idAtivo = '" + idAtivo + "'";
            ResultSet rs = stm.executeQuery(select);
            if (rs.next()) {
                arq.escreverLog(quebraLinha + arq.getData() +" "+ arq.getHora() + " Ativo já existe no banco!");
            } else {
                String insert = "INSERT INTO ativo (idAtivo, SO) VALUES ('" + idAtivo + "', '" + ativo.getSO() + "')";
                stm.executeUpdate(insert);// Executa a instrução SQL fornecida, que pode ser uma instrução INSERT, UPDATE ou DELETE;
                arq.escreverLog(quebraLinha + arq.getData() +" "+ arq.getHora() + " Novo Ativo inserido no banco!");
            }

            stm.close();
            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            arq.escreverLog(quebraLinha + arq.getData() +" "+ arq.getHora() + " " + ex);
        }
    }

    public void insertCpu() throws InterruptedException, IOException {
        try {
            cnx = DriverManager.getConnection(url);
            stm = cnx.createStatement();
            String insert = "INSERT INTO infoCpu (infoCPU, dia, hora, idAtivo, Interrupcoes, VersaoCpu, Threads, Processos, TempoAtividade) VALUES (" + cpu.getConsumoCPU() + ", '" + arq.getData() + "', '" + arq.getHora() + "', '" + idAtivo + "'," + cpu.getInterrupcoes() + ", '" + cpu.getVersaoCpu() + "', " + cpu.getNumeroDeThreads() + ", " + cpu.getNumeroDeProcessos() + ", '" + cpu.getTempoDeAtividade() + "')";
            stm.executeUpdate(insert);
            arq.escreverLog(quebraLinha + arq.getData() +" "+ arq.getHora() + " captando dados do componente Cpu com sucesso!");

            stm.close();
            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            arq.escreverLog(quebraLinha + arq.getData() +" "+ arq.getHora() + " insertCpu " + ex);
        }
        if (cpu.getConsumoCPU() > 80) {
            jslack.alertaComponente("Cpu");
            arq.escreverLog("Alerta: O uso do componente Cpu está em estado crítico.");
        }
        Thread.sleep(10000);
    }

    public void insertRam() throws InterruptedException, IOException {
        try {
            cnx = DriverManager.getConnection(url);
            stm = cnx.createStatement();
            String insert = "INSERT INTO infoRam (infoRam, dia, hora, idAtivo, MemoriaTotal, MemoriaDisponivel, MemoriaUsada) VALUES (" + ram.getConsumoRam() + ", '" + arq.getData() + "', '" + arq.getHora() + "', '" + idAtivo + "','" + ram.getMemoriaTotal() + "', '" + ram.getMemoriaDiponivel() + "', '" + ram.getMemoriaUsada() + "')";
            stm.executeUpdate(insert);
            arq.escreverLog(quebraLinha + arq.getData() +" "+ arq.getHora() + " captando dados do componente Ram com sucesso!");

            stm.close();
            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            arq.escreverLog(quebraLinha + arq.getData() +" "+ arq.getHora() + " insertRam " + ex);
        }
        if (ram.getConsumoRam() > 80) {
            jslack.alertaComponente("Ram");
            arq.escreverLog("Alerta: O uso do componente Ram está em estado crítico.");
        }
        Thread.sleep(10000);
    }

    public void insertHD() throws InterruptedException, IOException {
        try {
            cnx = DriverManager.getConnection(url);
            stm = cnx.createStatement();
            String insert = "INSERT INTO infoHD (infoHD, dia, hora, idAtivo, EspacoTotal, EspacoDisponivel, EspacoUsado) VALUES (" + hd.getConsumoHD() + ", '" + arq.getData() + "', '" + arq.getHora() + "', '" + idAtivo + "','" + hd.getEspacoTotal() + "','" + hd.getEspacoDisponivel() + "','" + hd.getEspacoUsado() + "')";
            stm.executeUpdate(insert);
            arq.escreverLog(quebraLinha + arq.getData() +" "+ arq.getHora() + " captando dados do componente HD com sucesso!");

            stm.close();
            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            arq.escreverLog(quebraLinha + arq.getData() +" "+ arq.getHora() + " insertHD " + ex);
        }
        if (hd.getConsumoHD() > 80) {
            jslack.alertaComponente("HD");
            arq.escreverLog("Alerta: O uso do componente HD está em estado crítico.");
        }
        Thread.sleep(60000);
    }

    public void insertRede() throws InterruptedException, IOException {
        try {
            cnx = DriverManager.getConnection(url);
            stm = cnx.createStatement();
            String insert = "INSERT INTO infoRede (upload, download, dia, hora, idAtivo, DominioRede, NomeRede) VALUES (" + rede.getUpload() + "," + rede.getDownload() + ", '" + arq.getData() + "', '" + arq.getHora() + "','" + idAtivo + "','" + rede.getDominioRede() + "','" + rede.getNomeRede() + "')";
            stm.executeUpdate(insert);
            arq.escreverLog(quebraLinha + arq.getData() +" "+ arq.getHora() + " captando informações de rede");

            stm.close();
            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoSQL.class.getName()).log(Level.SEVERE, null, ex);
            arq.escreverLog(quebraLinha + arq.getData() +" "+ arq.getHora() + " insertRede " + ex);
        }
        Thread.sleep(10000);
    }
}
