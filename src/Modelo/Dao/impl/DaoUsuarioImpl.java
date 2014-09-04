package Modelo.Dao.impl;


import Modelo.Conexion.Conexion;
import Modelo.Dao.DaoUsuario;
import Modelo.Dto.Contacto;
import Modelo.Dto.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class DaoUsuarioImpl implements DaoUsuario{
    
    Conexion db;

    public DaoUsuarioImpl() {
    db=new Conexion();
    }
    
    
    @Override
     public Usuario Login(String user, String password){
         String sql="SELECT * FROM Usuario WHERE Nombre_U = ? AND Contraseña_U = ?";
         
         Usuario usuario=null;
         Connection cn=db.getConnection();
         
         if (cn != null) {
             
         
         try {
             PreparedStatement st=cn.prepareStatement(sql);
             st.setString(1, user);
             st.setString(2, password);
             
             ResultSet rs=st.executeQuery();
             
             if (rs.next()) {
                 usuario=new Usuario();
                 usuario.setCodigo(rs.getInt(1));
                 usuario.setNombre(rs.getString(2));
                 usuario.setContrasena(rs.getString(3));
                 usuario.setIp(rs.getString(4));
                 usuario.setNick(rs.getString(6));
                 usuario.setMsjPersonal(rs.getString(7));
                 
                 
             String sql2="SELECT * FROM Contacto WHERE C_Id=?";
                 try {
                     List lcontactos=new LinkedList();
                     PreparedStatement st2=cn.prepareStatement(sql2);
                     st2.setInt(1, usuario.getCodigo());
                     ResultSet rs2=st2.executeQuery();
                     while(rs2.next()){
                         Contacto contacto=new Contacto();
                         contacto.setCodigo(rs2.getInt(1));
                         contacto.setNombre(rs2.getString(2));
                         contacto.setIp(rs2.getString(3));
                         contacto.setNick(rs2.getString(6));
                         contacto.setMsjPersonal(rs2.getString(7)) ;
                         lcontactos.add(contacto);
                    }
                     
                     
                    usuario.setLcontacto(lcontactos);
                     
                 } catch (SQLException e) {
                     System.out.println(e);
                 }
                         
             }
             
         } catch (SQLException e) {
             System.out.println("Error 1");
         }
         }
         return usuario;
         
     }
     
     
     
    @Override
     public boolean guardarMensaje(String msj, Integer codigo){
         boolean v = false;
         String sql = "UPDATE Usuario SET MsjPersonal_U = ? WHERE Codigo_U = ?";
         
         Connection con = db.getConnection();
         
         if(con != null){
             try{
                 PreparedStatement pstm = con.prepareStatement(sql);
                 pstm.setString(1, msj);
                 pstm.setInt(2, codigo);
                 
                 int c = pstm.executeUpdate();
                 
                 if(c > 0){
                     v = true;
                 }
                 
             }catch(SQLException ex){
                 System.out.println(ex);
             }
         }
         
         return v;
     }
    
    @Override
    public boolean eliminarc(Integer C_Id, Integer Codigo){
         boolean v = false;
         
         String sql=" Delete from Contacto where C_Id=? and Codigo=? ";
         Connection cn=db.getConnection();
         
         if (cn != null) {
             
             try {
                 PreparedStatement st=cn.prepareStatement(sql);
                 st.setInt(1, C_Id);
                 st.setInt(2, Codigo);
                 
                 int c=st.executeUpdate();
                 
                 if (c > 0) {
                     v=true;
                 }
                 
                 
             } catch (SQLException e) {
                 System.out.println("Exception" +e);
             }
             
         }
         
         
         return v;
         
         
         
     }
    
}
