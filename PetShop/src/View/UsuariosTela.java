/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DAO.UsuariosDao;
import Model.Usuarios;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateus
 */
public class UsuariosTela extends javax.swing.JFrame {

    /**
     * Creates new form UsuariosTela
     */
    public UsuariosTela() {
        initComponents();
        setSize(620, 480);// Define resolução tela
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); //impede de fechar com X
        setLocationRelativeTo(null); //Define a posição como centro da tela
        setTitle("Cadastrar Usuario");// Titulo da tela
        setResizable(false); //Impede de redimensionar tela
        URL caminhoImagem = this.getClass().getClassLoader().getResource("./images/project/icon-petshop-100.png"); //localiza o icone
        setIconImage(Toolkit.getDefaultToolkit().getImage(caminhoImagem));//define o icone
        jTFId.setEnabled(false); //Desabilita campo Id
        jBDeletar.setEnabled(false);//Desabilita campo deletar
        jBAtualizar.setEnabled(false); //Desabilita campo alterar
        preencherTabela();//Preenche tabela com os dados retornados do banco
    }

    public void preencherTabela() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        UsuariosDao uDAO = new UsuariosDao();
        for (Usuarios u : uDAO.ler()) {
            modelo.addRow(new Object[]{
                u.getId(),
                u.getLogin(),
                u.getPerfil()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jBSair = new javax.swing.JButton();
        jTFUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPFSenha = new javax.swing.JPasswordField();
        jBCadastrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jRBSim = new javax.swing.JRadioButton();
        jRBNao = new javax.swing.JRadioButton();
        jBAtualizar = new javax.swing.JButton();
        jBDeletar = new javax.swing.JButton();
        jBLimpar = new javax.swing.JButton();
        jTFId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jBSair.setText("Sair");
        jBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSairActionPerformed(evt);
            }
        });
        getContentPane().add(jBSair);
        jBSair.setBounds(520, 190, 72, 40);
        getContentPane().add(jTFUsuario);
        jTFUsuario.setBounds(50, 30, 150, 22);

        jLabel1.setText("Usuário");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 10, 150, 16);

        jLabel2.setText("Senha");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 70, 150, 16);
        getContentPane().add(jPFSenha);
        jPFSenha.setBounds(50, 90, 150, 22);

        jBCadastrar.setText("Cadastrar");
        jBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(jBCadastrar);
        jBCadastrar.setBounds(30, 190, 95, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Usuario", "Perfil"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 240, 585, 190);
        jScrollPane1.getAccessibleContext().setAccessibleName("");

        jLabel3.setText("Perfil Administrador");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 120, 150, 16);

        buttonGroup1.add(jRBSim);
        jRBSim.setText("Sim");
        getContentPane().add(jRBSim);
        jRBSim.setBounds(50, 140, 60, 21);

        buttonGroup1.add(jRBNao);
        jRBNao.setText("Não");
        getContentPane().add(jRBNao);
        jRBNao.setBounds(110, 140, 90, 21);

        jBAtualizar.setText("Atualizar");
        jBAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jBAtualizar);
        jBAtualizar.setBounds(130, 190, 95, 40);

        jBDeletar.setText("Deletar");
        jBDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(jBDeletar);
        jBDeletar.setBounds(230, 190, 95, 40);

        jBLimpar.setText("Limpar");
        jBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jBLimpar);
        jBLimpar.setBounds(330, 190, 95, 40);
        getContentPane().add(jTFId);
        jTFId.setBounds(280, 30, 30, 22);

        jLabel4.setText("Id");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(280, 10, 10, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Pega os dados digitados, verica se todos os campos estão preenchidos se sim salva no banco
    private void jBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarActionPerformed
        String usuario = jTFUsuario.getText().trim();
        String senha = jPFSenha.getText().trim();
        String perfil = "p1";
        if (jRBSim.isSelected()) {
            perfil = "admin";
        }

        if ("".equals(usuario) || "".equals(senha)) {
            JOptionPane.showMessageDialog(null, "E necessário preencher todos os campos para continuar");
        } else {
            Usuarios user = new Usuarios();
            user.setLogin(usuario);
            user.setSenha(senha);
            user.setPerfil(perfil);

            UsuariosDao dao = new UsuariosDao();
            dao.inserirAp(user);
            preencherTabela();
        }
    }//GEN-LAST:event_jBCadastrarActionPerformed

    //Pega os dados digitados, verica se todos os campos estão preenchidos se sim atualiza no banco
    private void jBAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtualizarActionPerformed
        int id = Integer.parseInt(jTFId.getText().trim());
        String usuario = jTFUsuario.getText().trim();
        String senha = jPFSenha.getText().trim();
        String perfil = "p1";
        if (jRBSim.isSelected()) {
            perfil = "admin";
        }

        if ("".equals(usuario) || "".equals(senha)) {
            JOptionPane.showMessageDialog(null, "E necessário preencher todos os campos para continuar");
        } else {
            Usuarios user = new Usuarios();
            user.setId(id);
            user.setLogin(usuario);
            user.setSenha(senha);
            user.setPerfil(perfil);
            UsuariosDao dao = new UsuariosDao();
            dao.alterar(user);
            preencherTabela();
        }
    }//GEN-LAST:event_jBAtualizarActionPerformed

    //Ao clicar em um dos campos da tabela preenche os campos do programa
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jTFId.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        jTFUsuario.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        if ("admin".equals(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString())) {
            jRBSim.setSelected(true);
        } else {
            jRBNao.setSelected(true);
        }
        jBAtualizar.setEnabled(true);
        jBDeletar.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    //Pega o id slecionado deleta no banco
    private void jBDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeletarActionPerformed
        int id = Integer.parseInt(jTFId.getText().trim());
        Usuarios user = new Usuarios();
        user.setId(id);
        UsuariosDao Dao = new UsuariosDao();
        Dao.deletar(user);
        preencherTabela();
    }//GEN-LAST:event_jBDeletarActionPerformed

    //Limpa todos os campos do programa
    private void jBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparActionPerformed
        jTFId.setText("");
        jTFUsuario.setText("");
        jPFSenha.setText("");
        jRBNao.setSelected(rootPaneCheckingEnabled);
        jRBSim.setSelected(false);
        preencherTabela();
        jBAtualizar.setEnabled(false);
        jBDeletar.setEnabled(false);
    }//GEN-LAST:event_jBLimparActionPerformed

    //fecha a tela
    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
        Principal p = new Principal();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBSairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UsuariosTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuariosTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuariosTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuariosTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuariosTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBAtualizar;
    private javax.swing.JButton jBCadastrar;
    private javax.swing.JButton jBDeletar;
    private javax.swing.JButton jBLimpar;
    private javax.swing.JButton jBSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPFSenha;
    private javax.swing.JRadioButton jRBNao;
    private javax.swing.JRadioButton jRBSim;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFId;
    private javax.swing.JTextField jTFUsuario;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
