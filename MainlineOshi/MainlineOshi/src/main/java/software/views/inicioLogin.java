package software.views;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import software.classes.CnxSQL;
import software.classes.Usuario;

public class inicioLogin extends javax.swing.JFrame {

    private final CnxSQL cnxSql = new CnxSQL();
    private final BemVindo bv = new BemVindo();
    private final Usuario user = new Usuario();

    public inicioLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanelFundo = new javax.swing.JPanel();
        txtEmail = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jLabelSenha = new javax.swing.JLabel();
        btnLogar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanelFundo.setBackground(new java.awt.Color(255, 255, 255));

        txtEmail.setBackground(new java.awt.Color(242, 242, 242));
        txtEmail.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtEmail.setText("teste@teste.com");
        txtEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6));

        jLabelEmail.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelEmail.setText("Emil");

        txtSenha.setBackground(new java.awt.Color(242, 242, 242));
        txtSenha.setText("teste123");
        txtSenha.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6));

        jLabelSenha.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelSenha.setText("Senha");

        btnLogar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnLogar.setText("Logar");
        btnLogar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogarActionPerformed(evt);
            }
        });

        /*
        jLabel1.setIcon(new ImageIcon("Path/To/Your/Image.png"))
    );
    */
    jLabel1.setIcon(new ImageIcon(System.getProperty("user.dir")+"\\classes\\software\\img\\M_transparente.png"));
    jLabel1.setText("jLabel1");

    javax.swing.GroupLayout jPanelFundoLayout = new javax.swing.GroupLayout(jPanelFundo);
    jPanelFundo.setLayout(jPanelFundoLayout);
    jPanelFundoLayout.setHorizontalGroup(
        jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFundoLayout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(btnLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(174, 174, 174))
        .addGroup(jPanelFundoLayout.createSequentialGroup()
            .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelFundoLayout.createSequentialGroup()
                    .addGap(217, 217, 217)
                    .addComponent(jLabelEmail))
                .addGroup(jPanelFundoLayout.createSequentialGroup()
                    .addGap(215, 215, 215)
                    .addComponent(jLabelSenha))
                .addGroup(jPanelFundoLayout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addGroup(jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(100, Short.MAX_VALUE))
    );
    jPanelFundoLayout.setVerticalGroup(
        jPanelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelFundoLayout.createSequentialGroup()
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabelEmail)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(35, 35, 35)
            .addComponent(jLabelSenha)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(67, 67, 67)
            .addComponent(btnLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(89, Short.MAX_VALUE))
    );

    btnLogar.getAccessibleContext().setAccessibleName("");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogarActionPerformed
        try {
            if (cnxSql.autenticaUsuario(txtEmail.getText(), txtSenha.getText())) {// Autenticação de login;
                bv.jlBemVindo.setText("Bem vindo, " + user.getNome());
                bv.setVisible(true);// Mostra ou oculta esta janela instaciada, dependendo do valor de parâmetro booleano;
                dispose();// Fecha a tela anterior aberta(inicioLogin) e libera memoria para o SO;
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou/e senha inválidos...", "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            Logger.getLogger(inicioLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLogarActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(inicioLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inicioLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inicioLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inicioLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new inicioLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JPanel jPanelFundo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
