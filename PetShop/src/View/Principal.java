/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        setResizable(false);//Impede de redimensionar tela
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//impede de fechar com X
        setLocationRelativeTo(null);//Define a posição como centro da tela
        setSize(400, 320);// Define resolução tela
        setTitle("Meu PetShop");// Titulo da tela
        URL caminhoImagem = this.getClass().getClassLoader().getResource("./images/project/icon-petshop-100.png"); //localiza o icone
        setIconImage(Toolkit.getDefaultToolkit().getImage(caminhoImagem));//define o icone
        imagemFundo(); //Inicializa a imagem de fundo
    }

    //Redimedisiona e localiza define a imagem de imagem de fundo 
    public void imagemFundo() {
        try {
            URL caminhoImagem = this.getClass().getClassLoader().getResource("./images/project/petshop-bemvindo-logo.png");
            ImageIcon imagem = new ImageIcon(caminhoImagem);
            Image img = imagem.getImage();
            Image imgScale = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imagemEscalada = new ImageIcon(imgScale);
            label.setIcon(imagemEscalada);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao localizar imagem de fundo " + e.getMessage());
        }
    }

    //Bloqueia os campos informados
    public void funcionario() {
        jMenuItemUsuarios.setEnabled(false);
        jMenuItemUsuarios.setVisible(false);
        jMenuItemFuncionarios.setEnabled(false);
        jMenuItemFuncionarios.setVisible(false);
        jMenuItemFornecedores.setVisible(false);
        jMenuItemFornecedores.setEnabled(false);
        jSeparator1.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBSair = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastros = new javax.swing.JMenu();
        jMenuItemUsuarios = new javax.swing.JMenuItem();
        jMenuItemFuncionarios = new javax.swing.JMenuItem();
        jMenuItemFornecedores = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemClientes = new javax.swing.JMenuItem();
        jMenuItemAnimais = new javax.swing.JMenuItem();
        jMenuItemProdutos = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        getContentPane().setLayout(null);

        jBSair.setText("Sair");
        jBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSairActionPerformed(evt);
            }
        });
        getContentPane().add(jBSair);
        jBSair.setBounds(300, 180, 72, 40);

        label.setText("jLabel1");
        getContentPane().add(label);
        label.setBounds(0, -70, 385, 385);

        jMenuCadastros.setText("Cadastros");
        jMenuCadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastrosActionPerformed(evt);
            }
        });

        jMenuItemUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/project/icon-usuários-20.png"))); // NOI18N
        jMenuItemUsuarios.setText("Usuarios");
        jMenuItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsuariosActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemUsuarios);

        jMenuItemFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/project/icons-funcionario-20.png"))); // NOI18N
        jMenuItemFuncionarios.setText("Funcionarios");
        jMenuItemFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFuncionariosActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemFuncionarios);

        jMenuItemFornecedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/project/icons-fornecedor-20.png"))); // NOI18N
        jMenuItemFornecedores.setText("Fornecedores");
        jMenuItemFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFornecedoresActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemFornecedores);
        jMenuCadastros.add(jSeparator1);

        jMenuItemClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/project/icons-cliente-20.png"))); // NOI18N
        jMenuItemClientes.setText("Clientes");
        jMenuItemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClientesActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemClientes);

        jMenuItemAnimais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/project/icons-animal-20.png"))); // NOI18N
        jMenuItemAnimais.setText("Animais");
        jMenuItemAnimais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAnimaisActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemAnimais);

        jMenuItemProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/project/icons-produto-20.png"))); // NOI18N
        jMenuItemProdutos.setText("Produtos");
        jMenuItemProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProdutosActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemProdutos);

        jMenuBar1.add(jMenuCadastros);

        jMenu2.setText("Serviços");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/project/venda-20.png"))); // NOI18N
        jMenuItem1.setText("Vendas");
        jMenu2.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/project/veterinarian-20.png"))); // NOI18N
        jMenuItem2.setText("Consultas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuCadastrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastrosActionPerformed

    }//GEN-LAST:event_jMenuCadastrosActionPerformed

    //fecha o programa
    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jBSairActionPerformed

    //Abre a tela Clientes
    private void jMenuItemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClientesActionPerformed
        ClientesTela cli = null;
        try {
            cli = new ClientesTela();
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        cli.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jMenuItemClientesActionPerformed

    //Abre a tela Animais
    private void jMenuItemAnimaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAnimaisActionPerformed
        AnimaisTela a = null;
        try {
            a = new AnimaisTela();
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        a.setVisible(true);
        setVisible(false);

    }//GEN-LAST:event_jMenuItemAnimaisActionPerformed

    //Abre a tela Usuarios
    private void jMenuItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsuariosActionPerformed
        UsuariosTela u = new UsuariosTela();
        u.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jMenuItemUsuariosActionPerformed

    //Abre a tela Funcionarios
    private void jMenuItemFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFuncionariosActionPerformed
        FuncionariosTela f = null;
        try {
            f = new FuncionariosTela();
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        f.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jMenuItemFuncionariosActionPerformed

    private void jMenuItemFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFornecedoresActionPerformed
        FornecedoresTela f = null;
        try {
            f = new FornecedoresTela();
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        f.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jMenuItemFornecedoresActionPerformed

    private void jMenuItemProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProdutosActionPerformed
        ProdutosTela p = null;
        try {
            p = new ProdutosTela();
            p.setVisible(true);
            setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemProdutosActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            ConsultasTela c = new ConsultasTela();
            c.setVisible(true);
            setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBSair;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemAnimais;
    private javax.swing.JMenuItem jMenuItemClientes;
    private javax.swing.JMenuItem jMenuItemFornecedores;
    private javax.swing.JMenuItem jMenuItemFuncionarios;
    private javax.swing.JMenuItem jMenuItemProdutos;
    private javax.swing.JMenuItem jMenuItemUsuarios;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}
