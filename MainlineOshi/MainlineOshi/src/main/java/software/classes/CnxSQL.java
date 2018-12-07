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
import software.oshi.Ativo;
import software.oshi.Cpu;
import software.oshi.HD;
import software.oshi.Ram;
import software.oshi.Rede;

public class CnxSQL {

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
    private Date dataHoraAtual = new Date();
    private String data2 = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
    private String hora2 = new SimpleDateFormat(" HH:mm:ss").format(dataHoraAtual);

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
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
            arq.escreverLog(quebraLinha + data2 + hora2 + " " + ex);
        }

        return false;
    }

    public void verificaAtivo() throws IOException {// Verifica se ativo já existe no BD;
        try {
            arq.escreverLog(quebraLinha + data2 + hora2 + " Verificando Ativo");
            cnx = DriverManager.getConnection(url);
            stm = cnx.createStatement();
            String select = "SELECT * FROM ativo WHERE idAtivo = '" + idAtivo + "'";
            ResultSet rs = stm.executeQuery(select);
            if (rs.next()) {
                arq.escreverLog(quebraLinha + data2 + hora2 + " Ativo já existe no banco!");
            } else {
                String insert = "INSERT INTO ativo (idAtivo, SO, TempoAtividade) VALUES ('" + idAtivo + "', " + ativo.getSO() + ")";
                stm.executeUpdate(insert);// Executa a instrução SQL fornecida, que pode ser uma instrução INSERT, UPDATE ou DELETE;
                arq.escreverLog(quebraLinha + data2 + hora2 + " Novo Ativo inserido no banco!");
            }

            stm.close();
            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
            arq.escreverLog(quebraLinha + data2 + hora2 + " " + ex);
        }
    }

    public void insertCpu() throws InterruptedException, IOException {
        try {
            cnx = DriverManager.getConnection(url);
            stm = cnx.createStatement();
            String insert = "INSERT INTO infoCpu (infoCPU, dia, hora, idAtivo, Interrupcoes, VersaoCpu, Threads, Processos, TempoAtividade) VALUES (" + cpu.getConsumoCPU() + ", '" + data2 + "', '" + hora2 + "', '" + idAtivo + "'," + cpu.getInterrupcoes() + ", '" + cpu.getVersaoCpu() + "', " + cpu.getNumeroDeThreads() + ", " + cpu.getNumeroDeProcessos() + ", " + cpu.getTempoDeAtividade() + ")";
            stm.executeUpdate(insert);
            arq.escreverLog(quebraLinha + data2 + hora2 + " captando dados do componente Cpu com sucesso!");

            stm.close();
            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
            arq.escreverLog(quebraLinha + data2 + hora2 + " " + ex);
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
            String insert = "INSERT INTO infoRam (infoRam, dia, hora, idAtivo, MemoriaTotal, MemoriaDisponivel, MemoriaUsada) VALUES (" + ram.getConsumoRam() + ", '" + data2 + "', '" + hora2 + "', '" + idAtivo + "'," + ram.getMemoriaTotal() + ", " + ram.getMemoriaDiponivel() + ", " + ram.getMemoriaUsada() + ")";
            stm.executeUpdate(insert);
            arq.escreverLog(quebraLinha + data2 + hora2 + " captando dados do componente Ram com sucesso!");

            stm.close();
            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
            arq.escreverLog(quebraLinha + data2 + hora2 + " " + ex);
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
            String insert = "INSERT INTO infoHD (infoHD, dia, hora, idAtivo, EspacoTotal, EspacoDisponivel, EspacoUsado) VALUES (" + hd.getConsumoHD() + ", '" + data2 + "', '" + hora2 + "', '" + idAtivo + "'," + hd.getEspacoTotal() + "," + hd.getEspacoDisponivel() + "," + hd.getEspacoUsado() + ")";
            stm.executeUpdate(insert);
            arq.escreverLog(quebraLinha + data2 + hora2 + " captando dados do componente HD com sucesso!");

            stm.close();
            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
            arq.escreverLog(quebraLinha + data2 + hora2 + " " + ex);
        }
        if (hd.getConsumoHD() > 80) {
            jslack.alertaComponente("HD");
            arq.escreverLog("Alerta: O uso do componente HD está em estado crítico.");
        }
        Thread.sleep(600000);
    }

    public void insertRede() throws InterruptedException, IOException {
        try {
            cnx = DriverManager.getConnection(url);
            stm = cnx.createStatement();
            String insert = "INSERT INTO infoRede (upload, download, dia, hora, idAtivo, DominioRede, NomeRede) VALUES (" + rede.getUpload() + "," + rede.getDownload() + ", '" + data2 + "', '" + hora2 + "','" + idAtivo + "','" + rede.getDominioRede() + "','" + rede.getNomeRede() + "')";
            stm.executeUpdate(insert);
            arq.escreverLog(quebraLinha + data2 + hora2 + " captando informações de rede");

            stm.close();
            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(CnxSQL.class.getName()).log(Level.SEVERE, null, ex);
            arq.escreverLog(quebraLinha + data2 + hora2 + " " + ex);
        }
        Thread.sleep(10000);
    }
}
