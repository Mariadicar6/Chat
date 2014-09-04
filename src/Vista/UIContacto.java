
package Vista;

import Clases.ManejoImagen;
import Controlador.LoginComand;
import Controlador.UserComand;
import Modelo.Conexion.Conexion;
import Modelo.Dto.Usuario;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.edisoncor.gui.list.ListSelector;


public class UIContacto extends javax.swing.JFrame {

    Usuario usuario = null;
    UserComand uComand ;
    ManejoImagen img = new ManejoImagen();
    Conexion con;
    FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de imagen", "jpg");
    String rutaImg;
    UserComand ucomand;
    LoginComand lcomand;
    
    public UIContacto(Usuario usuario) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.usuario=usuario;
        uComand = new UserComand();
        ucomand = new UserComand();
        lcomand = new LoginComand();
        rutaImg = "";
        Cargarcontactos();
        
    }
    

    

    public void Cargarcontactos(){
        
         lblUsuario.setText(usuario.getNick() + "  <" + usuario.getNombre() + ">");
         txtMsjPersonal.setText(usuario.getMsjPersonal());
         usuario = lcomand.login(usuario.getNombre(), usuario.getContrasena());
         
         listContactos.setModel(new javax.swing.AbstractListModel() {
            
            @Override
            public int getSize() { 
                return usuario.getLcontacto().size(); 
            }
            
            
            @Override
            public Object getElementAt(int i) { 
                return usuario.getLcontacto().get(i).getNick(); 
            }
            
        });
         
        
         setImagen();
        
    }
   
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        pnlImagenU = new org.edisoncor.gui.panel.PanelImage();
        jScrollPane2 = new javax.swing.JScrollPane();
        listContactos = new org.edisoncor.gui.list.ListSelector();
        txtMsjPersonal = new org.edisoncor.gui.textField.TextFieldRoundBackground();
        btnImagen = new org.edisoncor.gui.button.ButtonColoredAction();
        jMenuBar1 = new javax.swing.JMenuBar();
        mArchivo = new javax.swing.JMenu();
        miNuevo = new javax.swing.JMenuItem();
        miEliminar = new javax.swing.JMenuItem();
        miCerrar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat");

        lblUsuario.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lblUsuario.setText("Usuario");

        pnlImagenU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/chat4.png"))); // NOI18N
        pnlImagenU.setPreferredSize(new java.awt.Dimension(60, 60));

        javax.swing.GroupLayout pnlImagenULayout = new javax.swing.GroupLayout(pnlImagenU);
        pnlImagenU.setLayout(pnlImagenULayout);
        pnlImagenULayout.setHorizontalGroup(
            pnlImagenULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        pnlImagenULayout.setVerticalGroup(
            pnlImagenULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        listContactos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listContactos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listContactosMouseClicked(evt);
            }
        });
        listContactos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                listContactosMouseMoved(evt);
            }
        });
        jScrollPane2.setViewportView(listContactos);

        txtMsjPersonal.setEditable(false);
        txtMsjPersonal.setDescripcion("< Escriba su mensaje personal >");
        txtMsjPersonal.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtMsjPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMsjPersonalMouseClicked(evt);
            }
        });
        txtMsjPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMsjPersonalActionPerformed(evt);
            }
        });

        btnImagen.setText("...");
        btnImagen.setToolTipText("Subir imagen");
        btnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenActionPerformed(evt);
            }
        });

        mArchivo.setText("Archivo");

        miNuevo.setText("Nuevo contacto");
        miNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNuevoActionPerformed(evt);
            }
        });
        mArchivo.add(miNuevo);

        miEliminar.setText("Eliminar contacto");
        miEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEliminarActionPerformed(evt);
            }
        });
        mArchivo.add(miEliminar);

        miCerrar.setText("Cerrar sesion");
        miCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCerrarActionPerformed(evt);
            }
        });
        mArchivo.add(miCerrar);
        mArchivo.add(jSeparator1);

        miSalir.setText("Salir");
        miSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSalirActionPerformed(evt);
            }
        });
        mArchivo.add(miSalir);

        jMenuBar1.add(mArchivo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlImagenU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario)
                    .addComponent(txtMsjPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMsjPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlImagenU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miSalirActionPerformed

    private void listContactosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listContactosMouseClicked
        if(evt.getClickCount() == 2){
            new UIChat().setVisible(true);
        }
    }//GEN-LAST:event_listContactosMouseClicked

    private void txtMsjPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMsjPersonalMouseClicked
        txtMsjPersonal.setEditable(true);
    }//GEN-LAST:event_txtMsjPersonalMouseClicked

    
    private void txtMsjPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMsjPersonalActionPerformed
        String msj=txtMsjPersonal.getText();
            boolean b =uComand.setMensaje(msj, usuario.getCodigo());
            if ( b) {
                System.out.println("Se actualizo el msj personal en la BD");
                txtMsjPersonal.setEditable(false);
            }
    }//GEN-LAST:event_txtMsjPersonalActionPerformed

    
    private void miCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCerrarActionPerformed
        dispose();
        new UILogin().setVisible(true);
    }//GEN-LAST:event_miCerrarActionPerformed

    
    
    // Método para mostrar el ToolTipText
    private void listContactosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listContactosMouseMoved
        listContactos =  (ListSelector) evt.getSource();
            ListModel m = listContactos.getModel();
            
            int index = listContactos.locationToIndex(evt.getPoint());
            
            if (index > -1) {
                String text = usuario.getLcontacto().get(index).getNombre(); 
                listContactos.setToolTipText(text);
            }
    }//GEN-LAST:event_listContactosMouseMoved

    
    
    
    // Método para listar consultas que retornan valores
    public ResultSet Listar(String texto){
        try{
            con = new Conexion();
            Connection db = con.getConnection();
            
            PreparedStatement pstm = db.prepareStatement(texto);
            ResultSet tabla = pstm.executeQuery();
            return tabla;
            
        }catch(SQLException ex){
            System.out.println(ex);
            return null;
        }
    }
    
    
    
    public void setImagen(){
        String consulta = "usp_fotoExiste " + usuario.getCodigo();
        ResultSet rs = Listar(consulta);
        int rpta;
        
        try{
            while(rs.next()){
                rpta = rs.getInt(1);
                
                if(rpta == 1){
                    cargarFoto(usuario.getCodigo());
                }else{
                    System.out.println("No hay imagen en la BD");
                }
            }
             
        }catch(SQLException ex){
            System.out.println(ex);
        }
        
        
    }
    
    
    
    
    
    
    // Método para cargar la foto de la BD
    public void cargarFoto(Integer codigo){
        
        Image dtImagen = img.recuperarImagen(usuario.getCodigo());
        ImageIcon icon = new ImageIcon(dtImagen);
        Image imagen = icon.getImage();
        
        if(imagen == null){
            JOptionPane.showMessageDialog(null, "No tiene imagen", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else{
            pnlImagenU.setIcon(new ImageIcon(imagen));
            pnlImagenU.repaint();
        }
    }
    
    
    
    
    private void btnImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenActionPerformed
        JFileChooser fc = new JFileChooser();
            fc.setFileFilter(filtro);
            
            int i = fc.showOpenDialog(this);
            
            if(i == JFileChooser.APPROVE_OPTION){
                String archivo = fc.getSelectedFile().getPath();
                String rutaArchivo = fc.getSelectedFile().toString();
                pnlImagenU.setIcon(new ImageIcon(archivo));
                
                String sentencia = "UPDATE Usuario SET Imagen_U = (SELECT BulkColumn FROM OPENROWSET(BULK '"
                                                + rutaArchivo + "', SINGLE_BLOB) Imagen) WHERE Codigo_U = ?" ;
                
                try{
                    Connection db = con.getConnection();
                    PreparedStatement pstm = db.prepareStatement(sentencia);
                    pstm.setInt(1, usuario.getCodigo());
                    
                    int retorno = pstm.executeUpdate();
                    
                    if(retorno > 0){
                        System.out.println("Se actualizo imagen en la BD");
                    }else{
                        System.out.println("Error al actualizar imagen");
                    }
                }catch(SQLException ex){
                    System.out.println(ex);
                }
            }
    }//GEN-LAST:event_btnImagenActionPerformed

    
    
    
    
    
    private void miEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEliminarActionPerformed
        
       Icon  interrogacion = new ImageIcon(getClass().getResource("/imagenes/interrogacion.png"));
       Icon error = new ImageIcon(getClass().getResource("/imagenes/error.png"));
       
       JTextArea txaTexto = new JTextArea(0,15);
       Font formato = new Font("Microsoft Tai Le", Font.BOLD, 16);
       String texto = "¿Desea eliminar este contacto?";
       
       txaTexto.setText(texto);
       txaTexto.setFont(formato);
       txaTexto.setEditable(false);
       txaTexto.setBackground(new Color(188,210,238));
       
       int index = listContactos.getSelectedIndex();
       int codigo_contacto = -1;
       
       if(index != -1){
           int opcion = JOptionPane.showOptionDialog(listContactos, txaTexto, "Confirmacion",
                                                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
                                                                    interrogacion, new Object[]{"    Si    ", "    No    "}, null);
           
           if(opcion == 0){
               codigo_contacto = usuario.getLcontacto().get(index).getCodigo();
               
               boolean b = ucomand.eliminarContacto(usuario.getCodigo(),codigo_contacto);
            
                if (b) {
                    System.out.println("Se elimino contacto");
                    Cargarcontactos();
                    repaint();
                }
            
                }else{
                    System.out.println("No se elimino ningun contacto");
                }
           }else{
                txaTexto.setText("Debe seleccionar un contacto");
                JOptionPane.showMessageDialog(null, txaTexto, "Error", JOptionPane.ERROR_MESSAGE, error);
       }

    }//GEN-LAST:event_miEliminarActionPerformed

    
    
    
    
    private void miNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNuevoActionPerformed
        new UIBuscar().setVisible(true);
    }//GEN-LAST:event_miNuevoActionPerformed


//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//          try{      
//              JFrame.setDefaultLookAndFeelDecorated(true);
//              SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("C:\\Users\\MaríadelosÁngeles\\Documents\\NetBeansProjects\\Conexionbd\\temas/coronaHthemepack.zip"));
//              UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
//            //UIManager.setLookAndFeel(new UpperEssentialLookAndFeel());
//         }
//         catch(Exception e){
//         JOptionPane.showMessageDialog(null, e);
//         }
////        try {
////            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
////                if ("Nimbus".equals(info.getName())) {
////                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
////                    break;
////                }
////            }
////        } catch (ClassNotFoundException ex) {
////            java.util.logging.Logger.getLogger(UIContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (InstantiationException ex) {
////            java.util.logging.Logger.getLogger(UIContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (IllegalAccessException ex) {
////            java.util.logging.Logger.getLogger(UIContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
////            java.util.logging.Logger.getLogger(UIContacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        }
//        //</editor-fold>


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public org.edisoncor.gui.button.ButtonColoredAction btnImagen;
    public javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JPopupMenu.Separator jSeparator1;
    public javax.swing.JLabel lblUsuario;
    public org.edisoncor.gui.list.ListSelector listContactos;
    public javax.swing.JMenu mArchivo;
    public javax.swing.JMenuItem miCerrar;
    public javax.swing.JMenuItem miEliminar;
    public javax.swing.JMenuItem miNuevo;
    public javax.swing.JMenuItem miSalir;
    public org.edisoncor.gui.panel.PanelImage pnlImagenU;
    public org.edisoncor.gui.textField.TextFieldRoundBackground txtMsjPersonal;
    // End of variables declaration//GEN-END:variables
}
