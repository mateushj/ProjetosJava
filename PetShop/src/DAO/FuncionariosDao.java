/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.FabricaConexao;
import Model.Funcionarios;
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
public class FuncionariosDao {

    public void inserirAp(Funcionarios f) {
        //String para inserir dados na tabela do Banco
        String sql = "INSERT INTO funcionarios (nome,cpf,email,telefone,rg,data_Nascimento,cargo,salario,endereco_id)" + " VALUES (?,?,?,?,?,?,?,?,?)";

        Connection conexao = null;
        PreparedStatement pstmt = null;

        //Estabelece conexão com o Banco e define os valores que serão inseridos na tabela
        try {
            conexao = FabricaConexao.criaConexao();
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, f.getNome());
            pstmt.setString(2, f.getCpf());
            pstmt.setString(3, f.getEmail());
            pstmt.setString(4, f.getTelefone());
            pstmt.setString(5, f.getRg());
            pstmt.setString(6, f.getDataNascimento());
            pstmt.setString(7, f.getCargo());
            pstmt.setString(8, f.getSalario());
            pstmt.setString(9, f.getEnderecoId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Dados Gravados com Sucesso!!!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gravar dados " + e.getMessage());
        }
    }

    public void alterar(Funcionarios f) {
        //String para atualizar dados na tabela do Banco
        String sql = "UPDATE funcionarios SET nome=?,cpf=?,email=?,telefone=?,rg=?,data_Nascimento=?,cargo=?,salario=?,endereco_id=?" + "WHERE id=?";

        Connection conexao = null;
        PreparedStatement pstmt = null;

        //Estabelece conexão com o Banco e define os valores que serão atualizados na tabela
        try {
            conexao = FabricaConexao.criaConexao();
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, f.getNome());
            pstmt.setString(2, f.getCpf());
            pstmt.setString(3, f.getEmail());
            pstmt.setString(4, f.getTelefone());
            pstmt.setString(5, f.getRg());
            pstmt.setString(6, f.getDataNascimento());
            pstmt.setString(7, f.getCargo());
            pstmt.setString(8, f.getSalario());
            pstmt.setString(9, f.getEnderecoId());
            pstmt.setInt(10, f.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso!!!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao alterar dados " + e.getMessage());
        }
    }

    public void deletar(Funcionarios f) {
        //String para deletar dados na tabela do Banco
        String sql = "Delete from funcionarios where id = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;
        
        //Estabelece conexão com o Banco e define o id para deletar os dados na tabela
        try {
            conexao = FabricaConexao.criaConexao();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, f.getId());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Dados Apagados com Sucesso!!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar dados " + e.getMessage());
        }
    }

    public List<Funcionarios> ler() {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Funcionarios> funcionario = new ArrayList<>();

        try {
            //Estabelece conexão com o Banco
            Connection conexao = FabricaConexao.criaConexao();
            //String para consultar dados na tabela do Banco
            pstmt = conexao.prepareStatement("Select * from funcionarios");
            rs = pstmt.executeQuery();
            //Percorre toda tabela e vai salvando os dados um por um no ArrayList
            while (rs.next()) {
                Funcionarios f = new Funcionarios();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setCpf(rs.getString("cpf"));
                f.setRg(rs.getString("rg"));
                f.setEmail(rs.getString("email"));
                f.setTelefone(rs.getString("telefone"));
                f.setDataNascimento(rs.getString("data_Nascimento"));
                f.setCargo(rs.getString("cargo"));
                f.setSalario(rs.getString("salario"));
                f.setEnderecoId(rs.getString("endereco_id"));
                funcionario.add(f);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return funcionario;

    }

    public List<Funcionarios> ler2(String desc) {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Funcionarios> funcionario = new ArrayList<>();

        try {
            //Estabelece conexão com o Banco
            Connection conexao = FabricaConexao.criaConexao();
            //String para consultar dados na tabela do Banco que recebe condição para retorno dos dados
            pstmt = conexao.prepareStatement("Select * from funcionarios where nome LIKE ?");
            //recebe a condição estabelecida para consulta
            pstmt.setString(1, "%"+desc+"%");
            rs = pstmt.executeQuery();
            //Percorre toda tabela e vai salvando os dados um por um no ArrayList
            while (rs.next()) {
                Funcionarios f = new Funcionarios();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setCpf(rs.getString("cpf"));
                f.setRg(rs.getString("rg"));
                f.setEmail(rs.getString("email"));
                f.setTelefone(rs.getString("telefone"));
                f.setDataNascimento(rs.getString("data_Nascimento"));
                f.setCargo(rs.getString("cargo"));
                f.setSalario(rs.getString("salario"));
                f.setEnderecoId(rs.getString("endereco_id"));
                funcionario.add(f);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return funcionario;
    }
}
