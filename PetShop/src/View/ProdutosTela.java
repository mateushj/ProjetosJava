/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DAO.ProdutosDao;
import Model.Produtos;
import java.awt.Toolkit;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProdutosTela extends javax.swing.JFrame {

    public ProdutosTela() throws Exception {
        initComponents();
        setSize(700, 580); // Define resolução tela
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); //impede de fechar com X
        setLocationRelativeTo(null); //Define a posição como centro da tela
        setTitle("Cadastrar Animais"); // Titulo da tela
        setResizable(false); //Impede de redimensionar tela
        jTFId.setEnabled(false); //Desabilita campo Id
        jBDeletar.setEnabled(false);//Desabilita campo deletar
        jBAlterar.setEnabled(false); //Desabilita campo alterar
        URL caminhoImagem = this.getClass().getClassLoader().getResource("./images/project/icon-petshop-100.png"); //localiza o icone
        setIconImage(Toolkit.getDefaultToolkit().getImage(caminhoImagem));//define o icone
        preencherTabela(); //Preenche tabela com os dados retornados do banco

    }

    private void preencherTabela() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        ProdutosDao pDAO = new ProdutosDao();

        try {
            for (Produtos p : pDAO.ler()) {
                modelo.addRow(new Object[]{
                    p.getId(),
                    p.getDescricao(),
                    p.getQuantidade(),
                    p.getValidade(),
                    p.getPrecoCompra(),
                    p.getPrecoVenda()
                });
            }
        } catch (Exception ex) {
            Logger.getLogger(ProdutosTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void preencherTabelaPesquisar(String desc) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        ProdutosDao pDAO = new ProdutosDao();
        for (Produtos p : pDAO.ler2(desc)) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getDescricao(),
                p.getQuantidade(),
                p.getValidade(),
                p.getPrecoCompra(),
                p.getPrecoVenda()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFDescricao = new javax.swing.JTextField();
        jTFValidade = new javax.swing.JTextField();
        jTFId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTFQuantidade = new javax.swing.JTextField();
        jBSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jBGravar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBDeletar = new javax.swing.JButton();
        jBLimpar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jBPesquisar = new javax.swing.JButton();
        jTFPesquisar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTFPrecoCompra = new javax.swing.JTextField();
        jTFPrecoVenda = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Descrição");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 40, 130, 16);

        jLabel2.setText("Validade");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 100, 70, 16);

        jLabel3.setText("Id");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(350, 40, 40, 16);

        jTFDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFDescricaoActionPerformed(evt);
            }
        });
        getContentPane().add(jTFDescricao);
        jTFDescricao.setBounds(30, 60, 190, 22);
        getContentPane().add(jTFValidade);
        jTFValidade.setBounds(30, 120, 140, 22);
        getContentPane().add(jTFId);
        jTFId.setBounds(350, 60, 30, 22);

        jLabel4.setText("Qauntidade");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(250, 40, 70, 16);
        getContentPane().add(jTFQuantidade);
        jTFQuantidade.setBounds(250, 60, 70, 22);

        jBSair.setText("Sair");
        jBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSairActionPerformed(evt);
            }
        });
        getContentPane().add(jBSair);
        jBSair.setBounds(590, 180, 80, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descrição", "Qtd.", "Validade", "P. Compra", "P. Venda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 230, 668, 300);

        jLabel5.setText("Preço Compra");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(200, 100, 80, 16);

        jBGravar.setText("Gravar");
        jBGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGravarActionPerformed(evt);
            }
        });
        getContentPane().add(jBGravar);
        jBGravar.setBounds(210, 180, 80, 40);

        jBAlterar.setText("Alterar");
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(jBAlterar);
        jBAlterar.setBounds(300, 180, 80, 40);

        jBDeletar.setText("Deletar");
        jBDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(jBDeletar);
        jBDeletar.setBounds(390, 180, 80, 40);

        jBLimpar.setText("Limpar");
        jBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jBLimpar);
        jBLimpar.setBounds(480, 180, 80, 40);

        jLabel7.setText("Pesquisar");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(430, 10, 130, 16);

        jBPesquisar.setText("Pesquisar");
        jBPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(jBPesquisar);
        jBPesquisar.setBounds(570, 20, 95, 40);
        getContentPane().add(jTFPesquisar);
        jTFPesquisar.setBounds(430, 30, 130, 22);

        jLabel8.setText("Preço Venda");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(300, 100, 80, 16);
        getContentPane().add(jTFPrecoCompra);
        jTFPrecoCompra.setBounds(200, 120, 80, 22);
        getContentPane().add(jTFPrecoVenda);
        jTFPrecoVenda.setBounds(300, 120, 80, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFDescricaoActionPerformed

    //Ao clicar em um dos campos da tabela preenche os campos do programa 
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jTFId.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        jTFDescricao.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        jTFQuantidade.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        jTFValidade.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
        jTFPrecoCompra.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
        jTFPrecoVenda.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
        jBAlterar.setEnabled(true);
        jBDeletar.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    //Limpa todos os campos do programa
    private void jBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparActionPerformed
        jTFId.setText("");
        jTFQuantidade.setText("");
        jTFDescricao.setText("");
        jTFValidade.setText("");
        jTFPesquisar.setText("");
        jTFPrecoCompra.setText("");
        jTFPrecoVenda.setText("");

        preencherTabela();
        jBAlterar.setEnabled(false);
        jBDeletar.setEnabled(false);
    }//GEN-LAST:event_jBLimparActionPerformed

    //fecha a tela
    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
        this.dispose();
        Principal p = new Principal();
        p.setVisible(true);
    }//GEN-LAST:event_jBSairActionPerformed

    //Pega os dados digitados, verica se todos os campos estão preenchidos se sim salva no banco
    private void jBGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGravarActionPerformed
        String descricao = jTFDescricao.getText().trim();
        String validade = jTFValidade.getText().trim();
        String quantidade = jTFQuantidade.getText().trim();
        String precoCompra = jTFPrecoCompra.getText().trim();
        String precoVenda = jTFPrecoVenda.getText().trim();

        if ("".equals(descricao) || "".equals(validade) || "".equals(quantidade) || "".equals(precoCompra) || "".equals(precoVenda)) {
            JOptionPane.showMessageDialog(null, "E necessário preencher todos os campos para continuar");
        } else {
            Produtos produto = new Produtos();
            produto.setDescricao(descricao);
            produto.setValidade(validade);
            produto.setQuantidade(Integer.parseInt(quantidade));
            produto.setPrecoCompra(Double.parseDouble(precoCompra));
            produto.setPrecoVenda(Double.parseDouble(precoVenda));
            ProdutosDao dao = new ProdutosDao();
            dao.inserirAp(produto);
            try {
                preencherTabela();
            } catch (Exception ex) {
                Logger.getLogger(ProdutosTela.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBGravarActionPerformed

    //Preenche tabela realizando pesquisa com dados informados
    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        preencherTabelaPesquisar(jTFPesquisar.getText());
    }//GEN-LAST:event_jBPesquisarActionPerformed

    //Pega os dados digitados, verica se todos os campos estão preenchidos se sim atualiza no banco
    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        int Id = Integer.parseInt(jTFId.getText().trim());
        String descricao = jTFDescricao.getText().trim();
        String validade = jTFValidade.getText().trim();
        String quantidade = jTFQuantidade.getText().trim();
        String precoCompra = jTFPrecoCompra.getText().trim();
        String precoVenda = jTFPrecoVenda.getText().trim();

        if ("".equals(descricao) || "".equals(validade) || "".equals(quantidade) || "".equals(precoCompra) || "".equals(precoVenda)) {
            JOptionPane.showMessageDialog(null, "E necessário preencher todos os campos para continuar");
        } else {
            Produtos produto = new Produtos();
            produto.setId(Id);
            produto.setDescricao(descricao);
            produto.setValidade(validade);
            produto.setQuantidade(Integer.parseInt(quantidade));
            produto.setPrecoCompra(Double.parseDouble(precoCompra));
            produto.setPrecoVenda(Double.parseDouble(precoVenda));
            ProdutosDao dao = new ProdutosDao();
            dao.alterarC(produto);
            preencherTabela();
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    //Pega o id slecionado deleta no banco
    private void jBDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeletarActionPerformed
        int id = Integer.parseInt(jTFId.getText().trim());
        Produtos produto = new Produtos();
        produto.setId(id);
        ProdutosDao dao = new ProdutosDao();
        dao.deletar(produto);
        preencherTabela();
    }//GEN-LAST:event_jBDeletarActionPerformed

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
            java.util.logging.Logger.getLogger(ProdutosTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutosTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutosTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutosTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBDeletar;
    private javax.swing.JButton jBGravar;
    private javax.swing.JButton jBLimpar;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JButton jBSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFDescricao;
    private javax.swing.JTextField jTFId;
    private javax.swing.JTextField jTFPesquisar;
    private javax.swing.JTextField jTFPrecoCompra;
    private javax.swing.JTextField jTFPrecoVenda;
    private javax.swing.JTextField jTFQuantidade;
    private javax.swing.JTextField jTFValidade;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
