

package conexionchat;


import Modelo.Dao.DaoUsuario;
import Modelo.Dao.impl.DaoUsuarioImpl;
import Modelo.Dto.Usuario;


public class ConexionChat {


    public static void main(String[] args) {
       
        DaoUsuario dusuario=new DaoUsuarioImpl();
        
        Usuario user=dusuario.Login("Patricia", "1234");
        System.out.println(user.getLcontacto().get(1));
    
    }
    
}
