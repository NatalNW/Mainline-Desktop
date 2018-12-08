package software.views;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import software.classes.ConexaoSQL;
import software.classes.JSlack;
import software.classes.arquivoLog;
import software.oshi.Ativo;

public class BemVindo extends javax.swing.JFrame {

    private int i = 0;
    private final Ativo ativo = new Ativo();
    private final JSlack jslack = new JSlack();
    private ConexaoSQL insertRede = new ConexaoSQL();
    private ConexaoSQL insertCpu = new ConexaoSQL();
    private ConexaoSQL insertHD = new ConexaoSQL();
    private ConexaoSQL insertRam = new ConexaoSQL();
    private arquivoLog arq = new arquivoLog();
    private final String quebraLinha = System.getProperty("line.separator");

    public BemVindo() {
        this.ram = () -> {
            while (true) {
                try {
                    insertRam.insertRam();
                } catch (InterruptedException | IOException ex) {
                    Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex);
                    try {
                        arq.escreverLog(quebraLinha + arq.getData() + " " + arq.getHora() + " ram " + ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }

        };
        this.hd = () -> {
            while (true) {
                try {
                    insertHD.insertHD();
                } catch (InterruptedException | IOException ex) {
                    Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex);
                    try {
                        arq.escreverLog(quebraLinha + arq.getData() + " " + arq.getHora() + " hd " + ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        };
        this.cpu = () -> {
            while (true) {
                try {
                    insertCpu.insertCpu();
                } catch (InterruptedException | IOException ex) {
                    Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex);
                    try {
                        arq.escreverLog(quebraLinha + arq.getData() + " " + arq.getHora() + " cpu " + ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        };
        this.rede = () -> {
            while (true) {
                try {
                    insertRede.insertRede();
                } catch (InterruptedException | IOException ex) {
                    Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex);
                    try {
                        arq.escreverLog(quebraLinha + arq.getData() + " " + arq.getHora() + " rede " + ex);
                    } catch (IOException ex1) {
                        Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        };
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlBemVindo = new javax.swing.JLabel();
        jlAviso = new javax.swing.JLabel();
        btnCapDados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setSize(new java.awt.Dimension(350, 300));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 300));

        jlBemVindo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jlBemVindo.setText("Bem vindo, Natanael");

        jlAviso.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jlAviso.setText("Clque no botão \"iniciar\", para coletar os dados de seu ativo");

        btnCapDados.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnCapDados.setText("Iniciar");
        btnCapDados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapDados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCapDados.addActionListener((java.awt.event.ActionEvent evt) -> {
            try {
                btnCapDadosActionPerformed(evt);
            } catch (IOException ex) {
                Logger.getLogger(BemVindo.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(btnCapDados, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlBemVindo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlAviso)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jlBemVindo)
                .addGap(48, 48, 48)
                .addComponent(jlAviso)
                .addGap(61, 61, 61)
                .addComponent(btnCapDados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCapDadosActionPerformed(java.awt.event.ActionEvent evt)  throws IOException {//GEN-FIRST:event_btnCapDadosActionPerformed
        if (i % 2 == 0) {
            jlAviso.setText("Capturando dados... ID deste Ativo: " + ativo.getAtivoID());
            btnCapDados.setText("Fechar");
            jslack.capturaIniciada(ativo.getAtivoID());
            new Thread(ram).start();
            new Thread(cpu).start();
            new Thread(hd).start();
            new Thread(rede).start();
            arq.escreverLog(quebraLinha + arq.getData() + " " + arq.getHora() + " Captura de dados iniciada. ID deste Ativo:" + ativo.getAtivoID());
            i++;
        } else {
            jslack.fimCaptura();
            arq.escreverLog(quebraLinha + arq.getData() + " " + arq.getHora() + " Fim da captura de dados.");
            System.exit(0); // fecha a aplicação com saida 0(sem erros)
        }
    }//GEN-LAST:event_btnCapDadosActionPerformed

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BemVindo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new BemVindo().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapDados;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlAviso;
    public javax.swing.JLabel jlBemVindo;
    // End of variables declaration//GEN-END:variables

    private final Runnable ram;
    private final Runnable cpu;
    private final Runnable hd;
    private final Runnable rede;
}
