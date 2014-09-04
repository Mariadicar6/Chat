
package Modelo.Dao;

import Modelo.Dto.Usuario;


public interface DaoUsuario {
    
    public Usuario Login(String user, String password);
    public boolean guardarMensaje(String msj, Integer codigo);
    public boolean eliminarc(Integer C_Id, Integer Codigo);
    
    
}
