
package Modelo.Dto;

import java.awt.Image;
import java.util.List;


public class Usuario {

    private Integer Codigo;
    private String Nombre;
    private String Contrasena;
    private String Ip;
    private Image Imagen;
    private String Nick;
    private String MsjPersonal;
    private List<Contacto> lcontacto;   // Lista de contactos de este usuario
    
    

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


    public String getContrasena() {
        return Contrasena;
    }


    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
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


    public List<Contacto> getLcontacto() {
        return lcontacto;
    }


    public void setLcontacto(List lcontacto) {
        this.lcontacto = lcontacto;
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
