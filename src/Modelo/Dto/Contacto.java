
package Modelo.Dto;

import java.awt.Image;


public class Contacto {
    
    private Integer Codigo;
    private String Nombre;
    private String Ip;
    private Image Imagen;
    private String Nick;
    private String MsjPersonal;


    public Integer getCodigo() {
        return Codigo;
    }

 
    public void setCodigo(Integer Codigo) {
        this.Codigo = Codigo;
    }


    public String getNombre() {
        return Nombre;
    }


    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }


    public String getIp() {
        return Ip;
    }

 
    public void setIp(String Ip) {
        this.Ip = Ip;
    }

 
    public Image getImagen() {
        return Imagen;
    }

  
    public void setImagen(Image Imagen) {
        this.Imagen = Imagen;
    }

  
    public String getNick() {
        return Nick;
    }

 
    public void setNick(String Nick) {
        this.Nick = Nick;
    }


    public String getMsjPersonal() {
        return MsjPersonal;
    }

   
    public void setMsjPersonal(String MsjPersonal) {
        this.MsjPersonal = MsjPersonal;
    }
    
    
    
}
