package software.views;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import software.classes.CnxSQL;
import software.classes.DadosOshi;
import software.classes.JSlack;
import software.classes.arquivoLog;

public class BemVindo extends javax.swing.JFrame {

    private int i = 0;
    private final JSlack jslack = new JSlack();
    private DadosOshi oshi = new DadosOshi();
    private final String idAtivo = oshi.getAtivoID();
    private CnxSQL insertRede = new CnxSQL();
    private CnxSQL insertCpu = new CnxSQL();
    private CnxSQL insertHD = new CnxSQL();
    private CnxSQL insertRam = new CnxSQL();
    public arquivoLog arq = new arquivoLog();
    private final String quebraLinha = System.getProperty("line.separator");
    private Date dataHoraAtual = new Date();
    private String data2 = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
    private String hora2 = new SimpleDateFormat(" HH:mm:ss").format(dataHoraAtual);

    public BemVindo() {
        this.ram = () -> {
            while (true) {
                try {

                    try {
                        insertRam.insertComponente("infoRam", "infoRam", "Ram", oshi.getConsumoRam(), 20000);
                    } catch (IOException ex) {
                        Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, "loop bv Ram", "Erro!", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex);
                    try {
                        arq.escreverLog(quebraLinha + data2 + hora2 + " " + ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        };
        this.hd = () -> {
            while (true) {
                try {

                    try {
                        insertHD.insertComponente("infoHD", "infoHD", "HD", oshi.getConsumoHD(), 600000);
                    } catch (IOException ex) {
                        Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, "loop bv hd", "Erro!", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex);
                    try {
                        arq.escreverLog(quebraLinha + data2 + hora2 + " " + ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        };
        this.cpu = () -> {
            while (true) {
                try {

                    try {
                        insertCpu.insertComponente("infoCpu", "infoCpu", "CPU", oshi.getConsumoCPU(), 20000);
                    } catch (IOException ex) {
                        Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, "loop bv cpu", "Erro!", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex);
                    try {
                        arq.escreverLog(quebraLinha + data2 + hora2 + " " + ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        };
        this.rede = () -> {
            while (true) {
                try {
                    try {
                        insertRede.insertRede();
                    } catch (IOException ex) {
                        Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, "loop bv Rede", "Erro!", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex);
                    try {
                        arq.escreverLog(quebraLinha + data2 + hora2 + " " + ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        };
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlBemVindo = new javax.swing.JLabel();
        jlAviso = new javax.swing.JLabel();
        btnCapDados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jlBemVindo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        //jlBemVindo.setText("Bem Vindo, Usuario");

        jlAviso.setText("Clque no botão iniciar para coletar os dados de seu ativo");

        btnCapDados.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnCapDados.setText("Iniciar");
        btnCapDados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapDados.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnCapDadosActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(26, Short.MAX_VALUE)
                                .addComponent(jlBemVindo)
                                .addGap(71, 71, 71))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(86, 86, 86)
                                                .addComponent(btnCapDados, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jlAviso)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jlBemVindo)
                                .addGap(33, 33, 33)
                                .addComponent(jlAviso)
                                .addGap(57, 57, 57)
                                .addComponent(btnCapDados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void btnCapDadosActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        if (i % 2 == 0) {
            jlAviso.setText("Captura de dados iniciada. ID deste Ativo: " + idAtivo);
            btnCapDados.setText("Fechar");
            jslack.capturaIniciada(idAtivo);
            new Thread(ram).start();
            new Thread(cpu).start();
            new Thread(hd).start();
            new Thread(rede).start();
            arq.escreverLog(quebraLinha + data2 + hora2 + " Captura de dados iniciada. ID deste Ativo:" + idAtivo);
            i++;
        } else {
            jslack.fimCaptura();
            arq.escreverLog(quebraLinha + data2 + hora2 + " Fim da captura de dados.");
            System.exit(0); // fecha a aplicação com saida 0(sem erros)
        }
    }

    public static void main() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BemVindo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BemVindo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BemVindo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BemVindo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new BemVindo().setVisible(true);
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCapDados;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlAviso;
    public javax.swing.JLabel jlBemVindo;
    // End of variables declaration

    private final Runnable ram;
    private final Runnable cpu;
    private final Runnable hd;
    private final Runnable rede;
}
