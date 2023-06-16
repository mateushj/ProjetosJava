/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.FabricaConexao;
import Model.Consultas;
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
public class ConsultasDao {
    
 public void inserir(Consultas c)
    {
        //String para inserir dados na tabela do Banco
        String sql = "INSERT INTO consultas (animal_id,funcionario_id,data_consulta,hora_consulta,retorno,prescricao,exame_id)" + " VALUES (?,?,?,?,?,?,?)";
        
        Connection conexao = null;
        PreparedStatement pstmt = null;
        
        //Estabelece conexão com o Banco e define os valores que serão inseridos na tabela
        try{
            conexao = FabricaConexao.criaConexao();
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1,c.getIdAnimal());
            pstmt.setInt(2,c.getIdFuncionario());
            pstmt.setString(3,c.getDataConsulta());
            pstmt.setString(4,c.getHoraConsulta());
            pstmt.setString(5,c.getRetorno());
            pstmt.setString(6,c.getPrescricao());
            pstmt.setInt(7,c.getIdExame());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Dados Gravados com Sucesso!!!");
        }catch( Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gravar dados "+ e.getMessage());
        }
    }
    
    public void alterar(Consultas c) {
        //String para atualizar dados na tabela do Banco
        String sql = "UPDATE consultas SET animal_id=?,funcionario_id=?,exame_id=?,data_consulta=?,hora_consulta=?,retorno=?,prescricao=?" + "WHERE id=?";

        Connection conexao = null;
        PreparedStatement pstmt = null;

        //Estabelece conexão com o Banco e define os valores que serão atualizados na tabela
        try {
            conexao = FabricaConexao.criaConexao();
            pstmt = conexao.prepareStatement(sql);
          pstmt.setInt(1,c.getIdAnimal());
            pstmt.setInt(2,c.getIdFuncionario());
            pstmt.setInt(3,c.getIdExame());
            pstmt.setString(4,c.getDataConsulta());
            pstmt.setString(5,c.getHoraConsulta());
            pstmt.setString(6,c.getRetorno());
            pstmt.setString(7,c.getPrescricao());
            pstmt.setInt(8,c.getId());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso!!!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao alterar dados "+ e.getMessage());
        }
    }

    public void deletar(Consultas c) {
        //String para deletar dados na tabela do Banco
        String sql = "Delete from consultas where id = ?";
        Connection conexao = null;
        PreparedStatement stmt = null;
        
        //Estabelece conexão com o Banco e define o id para deletar os dados na tabela
        try {
            conexao = FabricaConexao.criaConexao();
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, c.getId());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Dados Apagados com Sucesso!!!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar dados "+ e.getMessage());
        }
    }
    
    public List <Consultas> ler()throws Exception{
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Consultas> consulta = new ArrayList<>();

        try {
            //Estabelece conexão com o Banco
            Connection conexao = FabricaConexao.criaConexao();
            //String para consultar dados na tabela do Banco
            pstmt = conexao.prepareStatement("Select * from consultas");
            
            rs = pstmt.executeQuery();
            //Percorre toda tabela e vai salvando os dados um por um no ArrayList
            while (rs.next()) {
                Consultas c = new Consultas();
                c.setId(rs.getInt("id"));
                c.setIdAnimal(rs.getInt("animal_id"));
                c.setIdFuncionario(rs.getInt("funcionario_id"));
                c.setIdExame(rs.getInt("exame_id"));
                c.setDataConsulta(rs.getString("data_consulta"));
                c.setHoraConsulta(rs.getString("hora_consulta"));
                c.setPrescricao(rs.getString("prescricao"));
                c.setRetorno(rs.getString("retorno"));
                consulta.add(c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return consulta;
    }
    
    public List<Consultas> ler2(String desc){
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Consultas> consulta = new ArrayList<>();

        try {
            //Estabelece conexão com o Banco
            Connection conexao = FabricaConexao.criaConexao();
            //String para consultar dados na tabela do Banco que recebe condição para retorno dos dados
            pstmt = conexao.prepareStatement("Select * from consultas where data_consulta LIKE ?");
            //recebe a condição estabelecida para consulta
            pstmt.setString(1, "%"+desc+"%");
            rs = pstmt.executeQuery();
            //Percorre toda tabela e vai salvando os dados um por um no ArrayList
            while (rs.next()) {
                Consultas c = new Consultas();
                c.setId(rs.getInt("id"));
                c.setIdAnimal(rs.getInt("animal_id"));
                c.setIdFuncionario(rs.getInt("funcionario_id"));
                c.setIdExame(rs.getInt("exame_id"));
                c.setDataConsulta(rs.getString("data_consulta"));
                c.setHoraConsulta(rs.getString("hora_consulta"));
                c.setPrescricao(rs.getString("prescricao"));
                c.setRetorno(rs.getString("retorno"));
                consulta.add(c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return consulta;
    }
}

