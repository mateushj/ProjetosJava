/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.FabricaConexao;
import Model.Enderecos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mateus
 */
public class EnderecosDao {

    public void inserir(Enderecos end) {
        //String para inserir dados na tabela do Banco
        String sql = "INSERT INTO enderecos (numero,logradouro,estado,complemento,cidade,cep,bairro)" + " VALUES (?,?,?,?,?,?,?)";

        Connection conexao = null;
        PreparedStatement pstmt = null;

        //Estabelece conexão com o Banco e define os valores que serão inseridos na tabela
        try {
            conexao = FabricaConexao.criaConexao();
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, end.getNumero());
            pstmt.setString(2, end.getLogradouro());
            pstmt.setString(3, end.getEstado());
            pstmt.setString(4, end.getComplemento());
            pstmt.setString(5, end.getCidade());
            pstmt.setString(6, end.getCep());
            pstmt.setString(7, end.getBairro());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Dados Gravados com Sucesso!!!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gravar dados " + e.getMessage());
        }
    }

    public void alterar(Enderecos end) {
        //String para atualizar dados na tabela do Banco
        String sql = "UPDATE enderecos SET numero=?,logradouro=?,estado=?,complemento=?,cidade=?,cep=?,bairro=?" + "WHERE id=?";

        Connection conexao = null;
        PreparedStatement pstmt = null;

        //Estabelece conexão com o Banco e define os valores que serão atualizados na tabela
        try {
            conexao = FabricaConexao.criaConexao();
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, end.getNumero());
            pstmt.setString(2, end.getLogradouro());
            pstmt.setString(3, end.getEstado());
            pstmt.setString(4, end.getComplemento());
            pstmt.setString(5, end.getCidade());
            pstmt.setString(6, end.getCep());
            pstmt.setString(7, end.getBairro());
            pstmt.setInt(8, end.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso!!!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao alterar dados " + e.getMessage());
        }
    }

    public void deletar(Enderecos end) {
        //String para deletar dados na tabela do Banco
        String sql = "Delete from enderecos where id = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;

        //Estabelece conexão com o Banco e define o id para deletar os dados na tabela
        try {
            conexao = FabricaConexao.criaConexao();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, end.getId());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Dados Apagados com Sucesso!!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar dados " + e.getMessage());
        }
    }

    public List<Enderecos> ler() {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Enderecos> endereco = new ArrayList<>();

        try {
            //Estabelece conexão com o Banco
            Connection conexao = FabricaConexao.criaConexao();
            //String para consultar dados na tabela do Banco
            pstmt = conexao.prepareStatement("Select * from enderecos");
            rs = pstmt.executeQuery();
            //Percorre toda tabela e vai salvando os dados um por um no ArrayList
            while (rs.next()) {
                Enderecos end = new Enderecos();
                end.setId(rs.getInt("id"));
                end.setLogradouro(rs.getString("logradouro"));
                end.setNumero(rs.getInt("numero"));
                end.setEstado(rs.getString("estado"));
                end.setComplemento(rs.getString("complemento"));
                end.setCep(rs.getString("cep"));
                end.setCidade(rs.getString("cidade"));
                end.setBairro(rs.getString("bairro"));
                endereco.add(end);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return endereco;

    }

    public List<Enderecos> ler2(String desc) {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Enderecos> endereco = new ArrayList<>();

        try {
            //Estabelece conexão com o Banco
            Connection conexao = FabricaConexao.criaConexao();
            //String para consultar dados na tabela do Banco que recebe condição para retorno dos dados
            pstmt = conexao.prepareStatement("Select * from enderecos where logradouro LIKE ?");
            //recebe a condição estabelecida para consulta
            pstmt.setString(1, "%" + desc + "%");
            rs = pstmt.executeQuery();
            //Percorre toda tabela e vai salvando os dados um por um no ArrayList
            while (rs.next()) {
                Enderecos end = new Enderecos();
                end.setId(rs.getInt("id"));
                end.setLogradouro(rs.getString("logradouro"));
                end.setNumero(rs.getInt("numero"));
                end.setEstado(rs.getString("estado"));
                end.setComplemento(rs.getString("complemento"));
                end.setCep(rs.getString("cep"));
                end.setCidade(rs.getString("cidade"));
                end.setBairro(rs.getString("bairro"));
                endereco.add(end);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return endereco;
    }
}
