

package Controlador;

import Modelo.Dao.DaoUsuario;
import Modelo.Dao.impl.DaoUsuarioImpl;
import Modelo.Dto.Usuario;



public class LoginComand {
    
        public Usuario login(String user, String password){
        
            DaoUsuario dusuario = new DaoUsuarioImpl();
            Usuario usuario=dusuario.Login(user, password);
        
            return usuario;
        
        }
        

}
