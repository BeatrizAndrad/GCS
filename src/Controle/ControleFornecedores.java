/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ModeloFornecedores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ControleFornecedores {
    ConectaBanco conn = new ConectaBanco();
    ModeloFornecedores mod = new ModeloFornecedores();
    
    public void Salvar (ModeloFornecedores mod){
        conn.conexao();
        try {
            PreparedStatement pst = conn.conn.prepareStatement("insert into fornecedores (nome_fornecedor,cnpj_fornecedor) values (?,?)");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getCNPJ());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na inserção do fornecedor!\nERRO" +ex);
        }
        conn.desconecta();
        
    }
    
    public void Excluir (ModeloFornecedores mod){
        conn.conexao();
        try {
            PreparedStatement pst = conn.conn.prepareStatement("delete from fornecedores where id_fornecedor =?");
            pst.setInt(1, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão do fornecedor!\nERRO" +ex);
        }
        conn.desconecta();
    }
    
    public void Alterar (ModeloFornecedores mod){
        conn.conexao();
        try {
            PreparedStatement pst = conn.conn.prepareStatement("update fornecedores set nome_fornecedor=?, cnpj_fornecedor=? where id_fornecedor=?");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getCNPJ());
            pst.setInt(3, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar o fornecedor!\nERRO" +ex);
        }
        
    }
    
    public ModeloFornecedores Primeiro (){
        conn.conexao();
        try {
            conn.executaSQL("select * from fornecedores"); 
            conn.rs.first();
            mod.setId(conn.rs.getInt("id_fornecedor"));
            mod.setNome(conn.rs.getString("nome_fornecedor"));
            mod.setCNPJ(conn.rs.getString("cnpj_fornecedor"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o primeiro\nERRO:"+ex);
        }
        
        return mod;
        

}
    public ModeloFornecedores Ultimo (){
          conn.conexao();
        try {
            conn.executaSQL("select * from fornecedores"); 
            conn.rs.last();
            mod.setId(conn.rs.getInt("id_fornecedor"));
            mod.setNome(conn.rs.getString("nome_fornecedor"));
            mod.setCNPJ(conn.rs.getString("cnpj_fornecedor"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o ultimo\nERRO:"+ex);
        }
        
        return mod;
        
    }
    
    public ModeloFornecedores Anterior (){
        conn.conexao();
        try {
            //conn.executaSQL("select * from fornecedores"); 
            conn.rs.previous();
            mod.setId(conn.rs.getInt("id_fornecedor"));
            mod.setNome(conn.rs.getString("nome_fornecedor"));
            mod.setCNPJ(conn.rs.getString("cnpj_fornecedor"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o anterior\nERRO:"+ex);
        }
        
        return mod;
    }
    
    public ModeloFornecedores Proximo (){
        conn.conexao();
        try {
            //conn.executaSQL("select * from fornecedores"); 
            conn.rs.next();
            mod.setId(conn.rs.getInt("id_fornecedor"));
            mod.setNome(conn.rs.getString("nome_fornecedor"));
            mod.setCNPJ(conn.rs.getString("cnpj_fornecedor"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o próximo\nERRO:"+ex);
        }
        
        return mod;
    }
}