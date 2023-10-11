
package br.edu.unicesumar.core.dao.conexao;

import java.sql.Connection;
import  java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;


public class ConexaoJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/mapa";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    
    public static Connection conn;
    
    public static Connection getConexao(){
        try {
            if(conn == null){
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                return conn;
            } else {
                return conn;
            }
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Houve um erro ao tentar conectar ao banco de dados");
            return null;
        }
        
    }
    
}
