/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.FabricaConexao;
import Model.Fornecedores;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FornecedoresDao {
    public void inserirAp(Fornecedores f)
    {
        //String para inserir dados na tabela do Banco
        String sql = "INSERT INTO fornecedores (razao_Social,cnpj,insc_Estadual,telefone,email,endereco_id)" + " VALUES (?,?,?,?,?,?)";
        
        Connection conexao = null;
        PreparedStatement pstmt = null;
      
        //Estabelece conexão com o Banco e define os valores que serão inseridos na tabela
        try{
            conexao = FabricaConexao.criaConexao();
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1,f.getNome());
            pstmt.setString(2,f.getCnpj());
            pstmt.setString(3,f.getInscEst());
            pstmt.setString(4,f.getTelefone());
            pstmt.setString(5,f.getEmail());
            pstmt.setString(6,f.getEnderecoId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Dados Gravados com Sucesso!!!");
        }catch( Exception e){
            e.printStackTrace();
        }
    }
    
     public void alterar(Fornecedores f) {
         //String para atualizar dados na tabela do Banco
        String sql = "UPDATE fornecedores SET razao_social=?,cnpj=?,insc_Estadual=?,telefone=?,email=?,endereco_id=?" + "WHERE id=?";

        Connection conexao = null;
        PreparedStatement pstmt = null;

        //Estabelece conexão com o Banco e define os valores que serão atualizados na tabela
        try {
            conexao = FabricaConexao.criaConexao();
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1,f.getNome());
            pstmt.setString(2,f.getCnpj());
            pstmt.setString(3,f.getInscEst());
            pstmt.setString(4,f.getTelefone());
            pstmt.setString(5,f.getEmail());
            pstmt.setString(6,f.getEnderecoId());
            pstmt.setInt(7,f.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso!!!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao alterar dados "+ e.getMessage());
        }
    }

    public void deletar(Fornecedores f) {
        //String para deletar dados na tabela do Banco
        String sql = "Delete from fornecedores where id = ?";
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
            JOptionPane.showMessageDialog(null, "Erro ao apagar dados "+ e.getMessage());
        }
    }

    public List<Fornecedores> ler() {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Fornecedores> fornecedor = new ArrayList<>();

        try {
            //Estabelece conexão com o Banco
            Connection conexao = FabricaConexao.criaConexao();
            //String para consultar dados na tabela do Banco
            pstmt = conexao.prepareStatement("Select * from fornecedores");
            rs = pstmt.executeQuery();
            //Percorre toda tabela e vai salvando os dados um por um no ArrayList
            while (rs.next()) {
                Fornecedores f = new Fornecedores();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("razao_social"));
                f.setCnpj(rs.getString("cnpj"));
                f.setEmail(rs.getString("email"));
                f.setTelefone(rs.getString("telefone"));
                f.setInscEst(rs.getString("insc_Estadual"));
                f.setEnderecoId(rs.getString("endereco_id"));
                fornecedor.add(f);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return fornecedor;

    }
    
    public List<Fornecedores> ler2(String desc){
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Fornecedores> fornecedor = new ArrayList<>();

        try {
            //Estabelece conexão com o Banco
            Connection conexao = FabricaConexao.criaConexao();
            //String para consultar dados na tabela do Banco que recebe condição para retorno dos dados
            pstmt = conexao.prepareStatement("Select * from fornecedores where razao_social LIKE ?");
            //recebe a condição estabelecida para consulta
            pstmt.setString(1, "%"+desc+"%");
            rs = pstmt.executeQuery();
            //Percorre toda tabela e vai salvando os dados um por um no ArrayList
            while (rs.next()) {
                Fornecedores f = new Fornecedores();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("razao_social"));
                f.setCnpj(rs.getString("cnpj"));
                f.setEmail(rs.getString("email"));
                f.setTelefone(rs.getString("telefone"));
                f.setInscEst(rs.getString("insc_Estadual"));
                f.setEnderecoId(rs.getString("endereco_id"));
                fornecedor.add(f);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return fornecedor;
    }
}
