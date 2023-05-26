/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {
    //Define dados de acesso ao banco de dados
    private static final String user="root";
    private static final String senha="123456";
    private static final String url=
 "jdbc:mysql://localhost:3306/pet23?allowPublicKeyRetrieval=true&useSSL=false";
    
    //Estabelece acesso ao Banco de dados
    public static Connection criaConexao() throws Exception{
    
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conexao = 
    DriverManager.getConnection(url, user, senha);
    return conexao;
    }
}
