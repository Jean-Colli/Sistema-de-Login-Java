package br.edu.unicesumar.core.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import br.edu.unicesumar.core.entity.Usuario;
import br.edu.unicesumar.core.dao.conexao.ConexaoJDBC;



public class UsuarioDAO {
    public void inserir (Usuario user){
        String sql = "insert into usuario(nome, login, senha, email) values (?,?,?,?)";
        
        PreparedStatement ps = null;
        
        try {
            ps = ConexaoJDBC.getConexao().prepareStatement(sql);
            ps.setString(1, user.getNome());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getSenha());
            ps.setString(4, user.getEmail());
            
            ps.execute();
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try{
                ps.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    public Usuario validarUsuario(Usuario user){
        Usuario userValidado = new Usuario();
        
        String sql = "SELECT id, nome, login, senha , email from usuario where login = ? and senha = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            ps = ConexaoJDBC.getConexao().prepareCall(sql);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getSenha());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                userValidado.setNome(rs.getString("NOME"));
                userValidado.setLogin(rs.getString("LOGIN"));
                userValidado.setSenha(rs.getString("SENHA"));
                userValidado.setEmail(rs.getString("EMAIL"));   
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                rs.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        
        return userValidado;
    }
}
