/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.FabricaConexao;
import Model.Produtos;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDao {
    public void inserirAp(Produtos p)
    {
        //String para inserir dados na tabela do Banco
        String sql = "INSERT INTO produtos (descricao,preco_Unitario,preco_Venda,estoque,validade)" + " VALUES (?,?,?,?,?)";
        
        Connection conexao = null;
        PreparedStatement pstmt = null;
        
        //Estabelece conexão com o Banco e define os valores que serão inseridos na tabela
        try{
            conexao = FabricaConexao.criaConexao();
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1,p.getDescricao());
            pstmt.setDouble(2,p.getPrecoCompra());
            pstmt.setDouble(3,p.getPrecoVenda());
            pstmt.setInt(4, p.getQuantidade());
            pstmt.setString(5,p.getValidade());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Dados Gravados com Sucesso!!!");
        }catch( Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao Gravar dados "+ e.getMessage());
        }
    }
     public void alterarC(Produtos p) {
         //String para atualizar dados na tabela do Banco
        String sql = "UPDATE produtos SET descricao=?,preco_Unitario=?,preco_Venda=?,estoque=?,validade=?" + "WHERE id=?";

        Connection conexao = null;
        PreparedStatement pstmt = null;

        //Estabelece conexão com o Banco e define os valores que serão atualizados na tabela
        try {
            conexao = FabricaConexao.criaConexao();
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1,p.getDescricao());
            pstmt.setDouble(2,p.getPrecoCompra());
            pstmt.setDouble(3,p.getPrecoVenda());
            pstmt.setInt(4, p.getQuantidade());
            pstmt.setString(5,p.getValidade());
            pstmt.setInt(6, p.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso!!!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao alterar dados "+ e.getMessage());
        }
    }

    public void deletar(Produtos p) {
        //String para deletar dados na tabela do Banco
        String sql = "Delete from produtos where id = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;
        
        //Estabelece conexão com o Banco e define o id para deletar os dados na tabela
        try {
            conexao = FabricaConexao.criaConexao();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, p.getId());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Dados Apagados com Sucesso!!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar dados "+ e.getMessage());
        }
    }

    public List<Produtos> ler() {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Produtos> produto = new ArrayList<>();

        try {
            //Estabelece conexão com o Banco
            Connection conexao = FabricaConexao.criaConexao();
            //String para consultar dados na tabela do Banco
            pstmt = conexao.prepareStatement("Select * from produtos");
            rs = pstmt.executeQuery();
            //Percorre toda tabela e vai salvando os dados um por um no ArrayList
            while (rs.next()) {
                Produtos p = new Produtos();
                p.setId(rs.getInt("id"));
                p.setDescricao(rs.getString("descricao"));
                p.setPrecoCompra(rs.getDouble("preco_Unitario"));
                p.setPrecoVenda(rs.getDouble("preco_Venda"));
                p.setQuantidade(rs.getInt("estoque"));
                p.setValidade(rs.getString("validade"));
                produto.add(p);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return produto;

    }
    
    public List<Produtos> ler2(String desc){
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Produtos> produto = new ArrayList<>();

        try {
            //Estabelece conexão com o Banco
            Connection conexao = FabricaConexao.criaConexao();
            //String para consultar dados na tabela do Banco que recebe condição para retorno dos dados
            pstmt = conexao.prepareStatement("Select * from produtos where descricao LIKE ?");
            //recebe a condição estabelecida para consulta
            pstmt.setString(1, "%"+desc+"%");
            rs = pstmt.executeQuery();
            //Percorre toda tabela e vai salvando os dados um por um no ArrayList
            while (rs.next()) {
                Produtos p = new Produtos();
                p.setId(rs.getInt("id"));
                p.setDescricao(rs.getString("descricao"));
                p.setPrecoCompra(rs.getDouble("preco_Unitario"));
                p.setPrecoVenda(rs.getDouble("preco_Venda"));
                p.setQuantidade(rs.getInt("estoque"));
                p.setValidade(rs.getString("validade"));
                produto.add(p);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return produto;
    }
}
