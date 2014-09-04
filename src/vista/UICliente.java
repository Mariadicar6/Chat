
package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class UICliente extends javax.swing.JFrame {
    // Declaracion de variables para el Socket
    Socket socket = null;
    BufferedReader lector = null;
    PrintWriter escritor = null;

    
    public UICliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        modificarInterfaz();
    }
    
    
    public void modificarInterfaz(){
        this.getContentPane().setBackground(new java.awt.Color(230,250,250));
        txtMensaje.requestFocus();
        txaChat.setBackground(new java.awt.Color(245,245,245));
        btnEnviar.setBackground(Color.BLACK);
        btnEnviar.setForeground(Color.WHITE);
        btnEnviar.setFocusable(false);
        txaChat.setFocusable(true);
        txaChat.setEditable(false);
        
        
        Thread principal = new Thread(new Runnable(){
            public void run(){
                try{
                    socket = new Socket("localhost", 9000);
                    leer();
                    escribir();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        
        );
        principal.start();
    }
    
    
        public void leer(){
        Thread leerHilo = new Thread(new Runnable() {

            public void run(){
                try{
                    lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while(true){
                    String msjRecibido = lector.readLine();
                    txaChat.append("Servidor:  " + msjRecibido + "\n");
                }
        }catch(Exception ex){
            ex.printStackTrace();
        }
            }
        });
        leerHilo.start();
    }
    
    
    public void escribir(){
        Thread escribirHilo = new Thread(new Runnable(){
           public void run(){
               try{
                escritor = new PrintWriter(socket.getOutputStream(), true);
                btnEnviar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String msjEnviado = txtMensaje.getText();
                    escritor.println(msjEnviado);
                    txaChat.append("Cliente:  " + msjEnviado + "\n");
                    txtMensaje.setText("");
                }
                }     
                );
                }catch(Exception ex){
                    ex.printStackTrace();
                }
           } 
        });
        escribirHilo.start();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImgServidor = new javax.swing.JLabel();
        lblImgCliente = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaChat = new javax.swing.JTextArea();
        txtMensaje = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        lblCliente = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mArchivo = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat <Cliente>");
        setPreferredSize(new java.awt.Dimension(410, 490));

        lblImgServidor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImgServidor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img02.jpg"))); // NOI18N
        lblImgServidor.setMaximumSize(new java.awt.Dimension(287, 383));
        lblImgServidor.setMinimumSize(new java.awt.Dimension(287, 383));

        lblImgCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImgCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/img01.jpg"))); // NOI18N

        txaChat.setEditable(false);
        txaChat.setColumns(20);
        txaChat.setRows(5);
        txaChat.setBorder(null);
        jScrollPane2.setViewportView(txaChat);
        txaChat.getAccessibleContext().setAccessibleName("");

        txtMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMensajeActionPerformed(evt);
            }
        });

        btnEnviar.setText("Enviar");

        lblCliente.setText("NombreCliente");

        mArchivo.setText("Archivo");
        mArchivo.add(jSeparator1);

        miSalir.setText("Salir");
        mArchivo.add(miSalir);

        jMenuBar1.add(mArchivo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImgCliente)
                    .addComponent(lblImgServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCliente))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImgServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblImgCliente))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMensajeActionPerformed
        btnEnviar.doClick();
    }//GEN-LAST:event_txtMensajeActionPerformed

    
    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(UICliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UICliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UICliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UICliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UICliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblImgCliente;
    private javax.swing.JLabel lblImgServidor;
    private javax.swing.JMenu mArchivo;
    private javax.swing.JMenuItem miSalir;
    public javax.swing.JTextArea txaChat;
    private javax.swing.JTextField txtMensaje;
    // End of variables declaration//GEN-END:variables
}
