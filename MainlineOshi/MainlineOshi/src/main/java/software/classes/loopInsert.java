package software.classes;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class loopInsert {

    private final CnxSQL cnxSql = new CnxSQL();
    private final DadosOshi oshi = new DadosOshi();
    private final String idAtivo = oshi.getAtivoID();

    public void insertComponente(String tabela, String coluna, float componente, long sleep) throws InterruptedException {
        while (true) {
            try {
                cnxSql.cnx = DriverManager.getConnection(cnxSql.url);
                cnxSql.stm = cnxSql.cnx.createStatement();
                String insert = "INSERT INTO " + tabela + " (" + coluna + ", idAtivo) VALUES (" + componente + ", '" + idAtivo + "')";
                cnxSql.stm.executeUpdate(insert);

                cnxSql.cnx.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "loopInsert Componente " + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(loopInsert.class.getName()).log(Level.SEVERE, null, ex);
            }
            Thread.sleep(sleep);
        }
    }

    public void insertRede() throws InterruptedException {
        while (true) {
            float download = oshi.getDownload();
            float upload = oshi.getUpload();
            try {
                cnxSql.cnx = DriverManager.getConnection(cnxSql.url);
                cnxSql.stm = cnxSql.cnx.createStatement();
                String insert = "INSERT INTO infoRede (upload, download, idAtivo) VALUES (" + upload + "," + download + ",'" + idAtivo + "')";
                cnxSql.stm.executeUpdate(insert);

                cnxSql.cnx.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "loopInsert Rede " + ex, "Erro!", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(loopInsert.class.getName()).log(Level.SEVERE, null, ex);
            }
            Thread.sleep(20000);
        }
    }

}
