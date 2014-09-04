
package Controlador;

import Modelo.Dao.DaoUsuario;
import Modelo.Dao.impl.DaoUsuarioImpl;


public class UserComand {
    
    public boolean setMensaje(String msj, Integer codigo){
        
        DaoUsuario dUsuario = new  DaoUsuarioImpl();
        return dUsuario.guardarMensaje(msj, codigo);
        
    }
    
    public boolean eliminarContacto(Integer C_Id, Integer Codigo){
        DaoUsuario dUsuario= new DaoUsuarioImpl();
        
        
        return dUsuario.eliminarc(C_Id,Codigo);
    }
}
