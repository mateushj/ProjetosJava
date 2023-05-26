/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.FabricaConexao;
import Model.Animais;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java. sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AnimaisDao {
    public void inserirAp(Animais a)
    {
        //String para inserir dados na tabela do Banco
        String sql = "INSERT INTO animais (nome,sexo,raca,data_nascimento,tutor)" + " VALUES (?,?,?,?,?)";
        
        Connection conexao = null;
        PreparedStatement pstmt = null;
        
        //Estabelece conexão com o Banco e define os valores que serão inseridos na tabela
        try{
            conexao = FabricaConexao.criaConexao();
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1,a.getNome());
            pstmt.setString(2,a.getSexo());
            pstmt.setString(3,a.getRaca());
            pstmt.setString(4,a.getDataNascimento());
            pstmt.setInt(5,a.getTutor());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Dados Gravados com Sucesso!!!");
        }catch( Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gravar dados "+ e.getMessage());
        }
    }
    
    public void alterarC(Animais a) {
        //String para atualizar dados na tabela do Banco
        String sql = "UPDATE animais SET nome=?,sexo=?,raca=?,tutor=?,data_nascimento=?" + "WHERE id=?";

        Connection conexao = null;
        PreparedStatement pstmt = null;

        //Estabelece conexão com o Banco e define os valores que serão atualizados na tabela
        try {
            conexao = FabricaConexao.criaConexao();
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, a.getNome());
            pstmt.setString(2, a.getSexo());
            pstmt.setString(3, a.getRaca());
            pstmt.setString(5, a.getDataNascimento());
            pstmt.setInt(4, a.getTutor());
            pstmt.setInt(6, a.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso!!!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao alterar dados "+ e.getMessage());
        }
    }

    public void deletar(Animais a) {
        //String para deletar dados na tabela do Banco
        String sql = "Delete from animais where id = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;
        
        //Estabelece conexão com o Banco e define o id para deletar os dados na tabela
        try {
            conexao = FabricaConexao.criaConexao();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, a.getId());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Dados Apagados com Sucesso!!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar dados "+ e.getMessage());
        }
    }
    
    public List <Animais> lerAnimal()throws Exception{
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Animais> animal = new ArrayList<>();

        try {
            //Estabelece conexão com o Banco
            Connection conexao = FabricaConexao.criaConexao();
            //String para consultar dados na tabela do Banco
            pstmt = conexao.prepareStatement("Select * from animais");
            
            rs = pstmt.executeQuery();
            //Percorre toda tabela e vai salvando os dados um por um no ArrayList
            while (rs.next()) {
                Animais a = new Animais();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setRaca(rs.getString("raca"));
                a.setSexo(rs.getString("sexo"));
                a.setTutor(rs.getInt("tutor"));
                a.setDataNascimento(rs.getString("data_Nascimento"));
                animal.add(a);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return animal;
    }
    
    public List<Animais> lerAnimal2(String desc){
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Animais> animal = new ArrayList<>();

        try {
            //Estabelece conexão com o Banco
            Connection conexao = FabricaConexao.criaConexao();
            //String para consultar dados na tabela do Banco que recebe condição para retorno dos dados
            pstmt = conexao.prepareStatement("Select * from animais where nome LIKE ?");
            //recebe a condição estabelecida para consulta
            pstmt.setString(1, "%"+desc+"%");
            rs = pstmt.executeQuery();
            //Percorre toda tabela e vai salvando os dados um por um no ArrayList
            while (rs.next()) {
                Animais a = new Animais();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setRaca(rs.getString("raca"));
                a.setSexo(rs.getString("sexo"));
                a.setTutor(rs.getInt("tutor"));
                a.setDataNascimento(rs.getString("data_Nascimento"));
                animal.add(a);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return animal;
    }
}
