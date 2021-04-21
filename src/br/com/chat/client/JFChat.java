/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chat.client;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollBar;
import javax.swing.SwingWorker;

/**
 *
 * @author pedro
 */
public class JFChat extends javax.swing.JFrame {

    public Cliente cliente;

    /**
     * Creates new form JFChat
     *
     * @param cliente
     * @throws java.io.IOException
     */
    public JFChat(Cliente cliente) throws IOException {
        initComponents();
        
        this.cliente = cliente;
        this.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelActions = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelChat = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Informe a mensagem:");

        jTextField1.setText("Anonimo");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Apelido");

        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Chat");

        javax.swing.GroupLayout jPanelActionsLayout = new javax.swing.GroupLayout(jPanelActions);
        jPanelActions.setLayout(jPanelActionsLayout);
        jPanelActionsLayout.setHorizontalGroup(
            jPanelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActionsLayout.createSequentialGroup()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
            .addGroup(jPanelActionsLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jTextField1)
            .addGroup(jPanelActionsLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );
        jPanelActionsLayout.setVerticalGroup(
            jPanelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelActionsLayout.createSequentialGroup()
                .addGroup(jPanelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelActionsLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(jPanelActionsLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jTextField2))
                .addContainerGap())
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanelChat.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanelChat.setName(""); // NOI18N
        jPanelChat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jPanelChat.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, -1, -1));

        jScrollPane1.setViewportView(jPanelChat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanelActions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelActions, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private int eixoY = 10;

    private void start() {
        SwingWorker worker = new SwingWorker() {
            @Override
            protected Void doInBackground() throws Exception {
                // Simulate doing something useful.
                while (true) {
                  String msg = cliente.escutar();
                    if (msg == null) continue;
                    if (msg.trim().equals("")) continue;
                    
                    String[] apelido = msg.split(":", 2);
                    
                    adicionarPainelMsgRecebida(apelido[0], apelido[1]);
                }
            }
        };

        worker.execute();
    }

    private void adicionarEspacamento() {
        javax.swing.JPanel jPanelDivisor = new javax.swing.JPanel();
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanelDivisor);

        jPanelDivisor.setLayout(jPanel1Layout);
        
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 430, Short.MAX_VALUE)
        );
        
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanelChat.add(jPanelDivisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, eixoY - 10, 430, 10));

        jScrollPane1.setViewportView(jPanelChat);
        
        JScrollBar bar = jScrollPane1.getVerticalScrollBar();
        bar.setValue(bar.getMaximum());
    }

    public void adicionarPainelMsgRecebida(String apelido, String mensagem) {
        javax.swing.JLabel jLabelChat = new javax.swing.JLabel();
        javax.swing.JLabel jLabelChatMsg = new javax.swing.JLabel();
        javax.swing.JPanel jPanelChatMsg = new javax.swing.JPanel();

        jPanelChatMsg.setBackground(new java.awt.Color(204, 204, 204));
        jPanelChatMsg.setPreferredSize(new java.awt.Dimension(290, 60));

        jLabelChat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelChat.setForeground(new java.awt.Color(0, 153, 153));
        jLabelChat.setText(apelido);

        jLabelChatMsg.setText(mensagem);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanelChatMsg);
        jPanelChatMsg.setLayout(jPanel1Layout);

        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabelChat)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jLabelChatMsg, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                                .addContainerGap())
        );

        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelChat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelChatMsg)
                                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanelChat.add(jPanelChatMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, eixoY, 290, -1));

        jScrollPane1.setViewportView(jPanelChat);

        eixoY += 70;

        this.adicionarEspacamento();
    }

    private void adicionarPainelMsgEnviada(String apelido, String mensagem) throws IOException {

        cliente.enviar(apelido + ":" + mensagem);

        javax.swing.JLabel jLabelChat = new javax.swing.JLabel();
        javax.swing.JLabel jLabelChatMsg = new javax.swing.JLabel();
        javax.swing.JPanel jPanelChatMsg = new javax.swing.JPanel();

        jPanelChatMsg.setBackground(new java.awt.Color(204, 204, 204));
        jPanelChatMsg.setPreferredSize(new java.awt.Dimension(290, 60));

        jLabelChat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelChat.setForeground(new java.awt.Color(255, 102, 51));
        jLabelChat.setText("Você");

        jLabelChatMsg.setText(mensagem);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanelChatMsg);
        jPanelChatMsg.setLayout(jPanel2Layout);

        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabelChat)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jLabelChatMsg, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                                .addContainerGap())
        );

        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelChat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelChatMsg)
                                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanelChat.add(jPanelChatMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, eixoY, Short.MAX_VALUE, -1));

        jScrollPane1.setViewportView(jPanelChat);
        
        eixoY += 70;
        
        this.adicionarEspacamento();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            String msg = jTextField2.getText();
            
            if (msg.trim().equals(""))
                return;
            
            String apelido = jTextField1.getText();
            
            apelido = apelido.trim().equals("") ? "Anonimo" : apelido;
            
            this.adicionarPainelMsgEnviada(apelido, msg);
            
            jTextField1.setText(apelido);
            jTextField2.setText("");
            
        } catch (IOException ex) {
            Logger.getLogger(JFChat.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("clicked");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                JFChat chat = new JFChat(new Cliente(61000));

                chat.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(JFChat.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelActions;
    private javax.swing.JPanel jPanelChat;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}