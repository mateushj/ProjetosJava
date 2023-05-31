/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package petshop;

import View.Login;
import View.Principal;
import java.text.ParseException;
import java.sql.SQLException;

/**
 *
 * @author LABORATÓRIO
 */
public class PetShop {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws SQLException, ParseException {
        Principal p = new Principal();
        p.setVisible(true);
//        Login l = new Login();
//        l.setVisible(true);
    }
    
}
