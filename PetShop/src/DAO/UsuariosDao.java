/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Usuarios;
import Controller.FabricaConexao;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mateus
 */
public class UsuariosDao {
    public void inserirAp(Usuarios u)
    {
        //String para inserir dados na tabela do Banco
        String sql = "INSERT INTO usuarios (email,senha,perfil)" + " VALUES (?,?,?)";
        
        Connection conexao = null;
        PreparedStatement pstmt = null;
        
        //Estabelece conexão com o Banco e define os valores que serão inseridos na tabela
        try{
            conexao = FabricaConexao.criaConexao();
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1,u.getLogin());
            pstmt.setString(2,u.getSenha());
            pstmt.setString(3,u.getPerfil());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Dados Gravados com Sucesso!!!");
        }catch( Exception e){
            e.printStackTrace();
        }
    }
    public void alterar(Usuarios u) {
        //String para atualizar dados na tabela do Banco
        String sql = "UPDATE usuarios SET email=?,senha=?,perfil=?" + "WHERE id=?";

        Connection conexao = null;
        PreparedStatement pstmt = null;

        //Estabelece conexão com o Banco e define os valores que serão atualizados na tabela
        try {
            conexao = FabricaConexao.criaConexao();
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, u.getLogin());
            pstmt.setString(2, u.getSenha());
            pstmt.setString(3, u.getPerfil());
            pstmt.setInt(4,u.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso!!!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao alterar dados "+ e.getMessage());
        }
    }

    public void deletar(Usuarios u) {
        //String para deletar dados na tabela do Banco
        String sql = "Delete from usuarios where id = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;
        
        //Estabelece conexão com o Banco e define o id para deletar os dados na tabela
        try {
            conexao = FabricaConexao.criaConexao();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, u.getId());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Dados Apagados com Sucesso!!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar dados "+ e.getMessage());
        }
    }

    public List<Usuarios> ler() {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Usuarios> usuario = new ArrayList<>();

        try {
            //Estabelece conexão com o Banco
            Connection conexao = FabricaConexao.criaConexao();
            //String para consultar dados na tabela do Banco
            pstmt = conexao.prepareStatement("Select * from usuarios");
            rs = pstmt.executeQuery();
            //Percorre toda tabela e vai salvando os dados um por um no ArrayList
            while (rs.next()) {
                Usuarios u = new Usuarios();
                u.setId(rs.getInt("id"));
                u.setLogin(rs.getString("email"));
                u.setPerfil(rs.getString("perfil"));
                usuario.add(u);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usuario;

    }
}
