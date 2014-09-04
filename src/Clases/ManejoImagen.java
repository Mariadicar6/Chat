
package Clases;

import Modelo.Conexion.Conexion;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;


public class ManejoImagen {
    Conexion con;
    private Image data;
    //Usuario usuario;
    //LoginComand lcomand;
    //DaoUsuarioImpl usuario;
    
    
    public ManejoImagen(){
        con = new Conexion();
    }
    
    
    // Metodo que convierte bytes a una imágen con extensión .jpeg
    private Image convertirImagen(byte[] bytes) throws IOException{
        ByteArrayInputStream bytesImg = new ByteArrayInputStream(bytes);
        Iterator readers = ImageIO.getImageReadersByFormatName("jpeg");
        ImageReader lectorImg = (ImageReader) readers.next();
        Object origen = bytesImg;
        ImageInputStream iis = ImageIO.createImageInputStream(origen);
        lectorImg.setInput(iis, true);
        ImageReadParam parm = lectorImg.getDefaultReadParam();
        return lectorImg.read(0, parm);
    }
    
    
    // Metodo para recuperar imagen de la BD
    public Image recuperarImagen(Integer codigo){
        try{
            
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT Imagen_U FROM Usuario WHERE Codigo_U = ?");
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            int i = 0;
            
            
            while(rs.next()){
                byte[] b = rs.getBytes("Imagen_U");
                data = convertirImagen(b);
                i++;
            }
            
            rs.close();
        }catch(IOException | SQLException ex){
            Logger.getLogger(Clases.ManejoImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
    
}
