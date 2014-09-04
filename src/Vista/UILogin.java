
package Vista;

import Controlador.LoginComand;
import Modelo.Dto.Usuario;
import com.l2fprod.gui.plaf.skin.SkinLookAndFeel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.setDefaultLookAndFeelDecorated;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;


public class UILogin extends javax.swing.JFrame {


    Usuario usuario = null;
    LoginComand lcomand = null;
    
    
    public UILogin() {
        initComponents();
        lcomand =new LoginComand();
        this.setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImageReflect1 = new org.edisoncor.gui.panel.PanelImageReflect();
        txtUsuario = new org.edisoncor.gui.textField.TextFieldRoundBackground();
        txtContrasena = new org.edisoncor.gui.passwordField.PasswordFieldRoundBackground();
        btnInicar = new org.edisoncor.gui.button.ButtonRound();
        labelMetric2 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric3 = new org.edisoncor.gui.label.LabelMetric();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelImageReflect1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/chat5.png"))); // NOI18N

        txtUsuario.setDescripcion("Ingrese el usuario aquí");
        txtUsuario.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        txtContrasena.setDescripcion("Ingrese la contraseña aquí");
        txtContrasena.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        txtContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContrasenaActionPerformed(evt);
            }
        });

        btnInicar.setBackground(new java.awt.Color(0, 102, 204));
        btnInicar.setText("Iniciar Sesion");
        btnInicar.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        btnInicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicarActionPerformed(evt);
            }
        });

        labelMetric2.setText("Contraseña");
        labelMetric2.setDistanciaDeSombra(2);
        labelMetric2.setFont(new java.awt.Font("Microsoft Tai Le", 1, 18)); // NOI18N

        labelMetric3.setText("Usuario");
        labelMetric3.setDistanciaDeSombra(2);
        labelMetric3.setFont(new java.awt.Font("Microsoft Tai Le", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelImageReflect1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInicar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(labelMetric2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnInicar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(panelImageReflect1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicarActionPerformed
       
       String user = txtUsuario.getText();
       String password = String.valueOf(txtContrasena.getText());
       
       usuario = lcomand.login(user, password);
       
       
       
        if (usuario!=null) {
            setVisible(false);
            UIContacto uicontacto=new UIContacto(usuario);
            uicontacto.setVisible(true);
            
            
        }else{
            Icon error = new ImageIcon(getClass().getResource("/imagenes/error.png"));
       
            JTextArea txaTexto = new JTextArea(0,27);
            Font formato = new Font("Microsoft Tai Le", Font.BOLD, 16);
            String texto = "El usuario no existe. Verifique usuario y contraseña";
       
            txaTexto.setText(texto);
            txaTexto.setFont(formato);
            txaTexto.setEditable(false);
            txaTexto.setBackground(new Color(188,210,238));
            JOptionPane.showMessageDialog(this, txaTexto, "Error de inicio de sesion", JOptionPane.ERROR_MESSAGE, error);
            
            txtUsuario.setText("");
            txtContrasena.setText("");
        }
        
       
        
    }//GEN-LAST:event_btnInicarActionPerformed

    private void txtContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContrasenaActionPerformed
        btnInicar.doClick();
    }//GEN-LAST:event_txtContrasenaActionPerformed


    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
           try{      
              setDefaultLookAndFeelDecorated(true);
              SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("temas/coronaHthemepack.zip"));
              UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
            //  UIManager.setLookAndFeel(new UpperEssentialLookAndFeel());
         }
         catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
         }
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                //    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(UILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(UILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(UILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(UILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UILogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public org.edisoncor.gui.button.ButtonRound btnInicar;
    private org.edisoncor.gui.label.LabelMetric labelMetric2;
    private org.edisoncor.gui.label.LabelMetric labelMetric3;
    private org.edisoncor.gui.panel.PanelImageReflect panelImageReflect1;
    private org.edisoncor.gui.passwordField.PasswordFieldRoundBackground txtContrasena;
    private org.edisoncor.gui.textField.TextFieldRoundBackground txtUsuario;
    // End of variables declaration//GEN-END:variables
}
