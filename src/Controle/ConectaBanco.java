/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ConectaBanco {
    
    public Statement stm;
    public ResultSet rs;
    private String driver = "org.postgresql.Driver";
    private String caminho = "jdbc:postgresql://localhost:5432/gcs";
    private String usuario = "postgres";
    private String senha = "1533";
    public Connection conn;
    
    public void conexao () {
        try {
            System.setProperty("jdbc.Drivers", driver);
            conn= DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null, "Conectado com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão!\n Error:" + ex.getMessage());
        } 
    }
    
    public void executaSQL (String sql) {
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Erro de ExecutaSQL!\n Error:" + ex.getMessage());
        }
    }
    public void desconecta () {
        try {
            conn.close();
            //JOptionPane.showMessageDialog(null, "Desconctado com sucesso!\n Error:" + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão!\n Error:" + ex.getMessage());
        }
    }

    public PreparedStatement executaSQL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
