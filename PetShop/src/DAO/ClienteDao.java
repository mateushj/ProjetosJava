/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.FabricaConexao;
import Model.Clientes;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class ClienteDao {

    public void inserirAp(Clientes c) {
        //String para inserir dados na tabela do Banco
        String sql = "INSERT INTO clientes (nome,cpf,email,telefone,data_Nascimento,endereco_id)" + " VALUES (?,?,?,?,?,?)";

        Connection conexao = null;
        PreparedStatement pstmt = null;

        //Estabelece conexão com o Banco e define os valores que serão inseridos na tabela
        try {
            conexao = FabricaConexao.criaConexao();
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, c.getNome());
            pstmt.setString(2, c.getCpf());
            pstmt.setString(3, c.getEmail());
            pstmt.setString(4, c.getTelefone());
            pstmt.setString(5, c.getDataNascimento());
            pstmt.setString(6, c.getEndereco_id());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Dados Gravados com Sucesso!!!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gravar dados "+ e.getMessage());
        }
    }

    public void alterarC(Clientes c) {
        //String para atualizar dados na tabela do Banco
        String sql = "UPDATE clientes SET nome=?,cpf=?,email=?,telefone=?,data_Nascimento=?,endereco_id=?" + "WHERE id=?";

        Connection conexao = null;
        PreparedStatement pstmt = null;

        //Estabelece conexão com o Banco e define os valores que serão atualizados na tabela
        try {
            conexao = FabricaConexao.criaConexao();
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, c.getNome());
            pstmt.setString(2, c.getCpf());
            pstmt.setString(3, c.getEmail());
            pstmt.setString(4, c.getTelefone());
            pstmt.setString(5, c.getDataNascimento());
            pstmt.setString(6, c.getEndereco_id());
            pstmt.setInt(7, c.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso!!!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao alterar dados "+ e.getMessage());
        }
    }

    public void deletar(Clientes co) {
        //String para deletar dados na tabela do Banco
        String sql = "Delete from clientes where id = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;
        
        //Estabelece conexão com o Banco e define o id para deletar os dados na tabela
        try {
            conexao = FabricaConexao.criaConexao();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, co.getId());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Dados Apagados com Sucesso!!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar dados "+ e.getMessage());
        }
    }

    public List<Clientes> ler() {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Clientes> cliente = new ArrayList<>();

        try {
            //Estabelece conexão com o Banco
            Connection conexao = FabricaConexao.criaConexao();
            //String para consultar dados na tabela do Banco
            pstmt = conexao.prepareStatement("Select * from clientes");
            rs = pstmt.executeQuery();
            //Percorre toda tabela e vai salvando os dados um por um no ArrayList
            while (rs.next()) {
                Clientes c = new Clientes();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                c.setDataNascimento(rs.getString("data_Nascimento"));
                c.setEndereco_id(rs.getString("endereco_id"));
                cliente.add(c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cliente;

    }
    
    public List<Clientes> ler2(String desc){
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Clientes> cliente = new ArrayList<>();

        try {
            //Estabelece conexão com o Banco
            Connection conexao = FabricaConexao.criaConexao();
            //String para consultar dados na tabela do Banco que recebe condição para retorno dos dados
            pstmt = conexao.prepareStatement("Select * from clientes where nome LIKE ?");
            //recebe a condição estabelecida para consulta
            pstmt.setString(1, "%"+desc+"%");
            rs = pstmt.executeQuery();
            //Percorre toda tabela e vai salvando os dados um por um no ArrayList
            while (rs.next()) {
                Clientes c = new Clientes();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                c.setDataNascimento(rs.getString("data_Nascimento"));
                c.setEndereco_id(rs.getString("endereco_id"));
                cliente.add(c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }
}
