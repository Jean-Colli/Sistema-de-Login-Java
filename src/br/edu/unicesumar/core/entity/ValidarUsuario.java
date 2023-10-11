package br.edu.unicesumar.core.entity;

import br.edu.unicesumar.core.dao.UsuarioDAO;

public class ValidarUsuario {
    public boolean usuarioComAcesso(Usuario user){
        UsuarioDAO userDAO = new UsuarioDAO();
        
        Usuario acesso = userDAO.validarUsuario(user);
        
        if(acesso.getLogin()!= null){
            return true;
        }else {
            return false;
        }
       
    }
}
