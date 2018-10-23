package software;

public class ColetaDados extends javax.swing.JFrame {

    
    
    
    public ColetaDados() {
        initComponents();
    }
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jlBemVindo = new javax.swing.JLabel();
        jParar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(480, 340));

        jlBemVindo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlBemVindo.setText("Seja bem vindo "++" !");

        jParar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jParar.setText("Parar");
        jParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPararActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jlBemVindo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jParar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jlBemVindo)
                .addGap(69, 69, 69)
                .addComponent(jParar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        
    private void jPararActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton jParar;
    private javax.swing.JLabel jlBemVindo;
    // End of variables declaration      
}
