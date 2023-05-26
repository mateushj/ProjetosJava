/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DAO.FuncionariosDao;
import Model.Funcionarios;
import java.awt.Toolkit;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FuncionariosTela extends javax.swing.JFrame {

    public FuncionariosTela() throws Exception {
        initComponents();
        setSize(700, 600);// Define resolução tela
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); //impede de fechar com X
        setLocationRelativeTo(null); //Define a posição como centro da tela
        setTitle("Cadastrar Funcionarios");// Titulo da tela
        setResizable(false); //Impede de redimensionar tela
        jTFId.setEnabled(false); //Desabilita campo Id
        jBDeletar.setEnabled(false);//Desabilita campo deletar
        jBAlterar.setEnabled(false); //Desabilita campo alterar
        URL caminhoImagem = this.getClass().getClassLoader().getResource("./images/project/icon-petshop-100.png"); //localiza o icone
        setIconImage(Toolkit.getDefaultToolkit().getImage(caminhoImagem));//define o icone
        preencherTabela();//Preenche tabela com os dados retornados do banco
    }

    public void preencherTabela() {
        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
        modelo.setNumRows(0);
        FuncionariosDao fDAO = new FuncionariosDao();
        for (Funcionarios f : fDAO.ler()) {
            modelo.addRow(new Object[]{
                f.getId(),
                f.getNome(),
                f.getCpf(),
                f.getRg(),
                f.getEmail(),
                f.getTelefone(),
                f.getDataNascimento(),
                f.getCargo(),
                f.getSalario(),
                f.getEnderecoId()
            });
        }
    }

    public void preencherTabelaPesquisar(String desc) {
        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
        modelo.setNumRows(0);
        FuncionariosDao fDAO = new FuncionariosDao();
        for (Funcionarios f : fDAO.ler2(desc)) {
            modelo.addRow(new Object[]{
                f.getId(),
                f.getNome(),
                f.getCpf(),
                f.getRg(),
                f.getEmail(),
                f.getTelefone(),
                f.getDataNascimento(),
                f.getCargo(),
                f.getSalario(),
                f.getEnderecoId()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTFNome = new javax.swing.JTextField();
        jTFCpf = new javax.swing.JTextField();
        jTFEmail = new javax.swing.JTextField();
        jTFData = new javax.swing.JTextField();
        jTFTelefone = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jBGravar = new javax.swing.JButton();
        jBSair = new javax.swing.JButton();
        jTFRg = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jBAlterar = new javax.swing.JButton();
        jBDeletar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTFId = new javax.swing.JTextField();
        jBLimpar = new javax.swing.JButton();
        jBPesquisar = new javax.swing.JButton();
        jTFPesquisar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTFCargo = new javax.swing.JTextField();
        jTFSalario = new javax.swing.JTextField();
        jTFEndereçoId = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jBEndereco = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        getContentPane().setLayout(null);

        jTFNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNomeActionPerformed(evt);
            }
        });
        getContentPane().add(jTFNome);
        jTFNome.setBounds(30, 30, 210, 22);
        getContentPane().add(jTFCpf);
        jTFCpf.setBounds(30, 90, 150, 22);
        getContentPane().add(jTFEmail);
        jTFEmail.setBounds(30, 150, 200, 22);
        getContentPane().add(jTFData);
        jTFData.setBounds(30, 210, 120, 22);
        getContentPane().add(jTFTelefone);
        jTFTelefone.setBounds(250, 150, 150, 22);

        jLabel1.setText("Nome");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 10, 140, 16);

        jLabel2.setText("Cpf");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 70, 140, 16);

        jLabel3.setText("Email");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 130, 130, 16);

        jLabel4.setText("Data_nascimento");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 190, 110, 16);

        jLabel5.setText("Telefone");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(250, 130, 60, 16);

        jBGravar.setText("Gravar");
        jBGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGravarActionPerformed(evt);
            }
        });
        getContentPane().add(jBGravar);
        jBGravar.setBounds(190, 250, 80, 40);

        jBSair.setText("Sair");
        jBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSairActionPerformed(evt);
            }
        });
        getContentPane().add(jBSair);
        jBSair.setBounds(560, 250, 80, 40);

        jTFRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFRgActionPerformed(evt);
            }
        });
        getContentPane().add(jTFRg);
        jTFRg.setBounds(210, 90, 140, 22);

        jLabel6.setText("Rg");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(210, 70, 70, 16);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Cpf", "Rg", "Email", "Telefone", "Nascimento", "Cargo", "Sálario", "End. Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTable2MouseExited(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTable2.getColumnModel().getColumn(8).setPreferredWidth(40);
            jTable2.getColumnModel().getColumn(9).setPreferredWidth(20);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 300, 668, 250);

        jBAlterar.setText("Alterar");
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(jBAlterar);
        jBAlterar.setBounds(280, 250, 80, 40);

        jBDeletar.setText("Deletar");
        jBDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(jBDeletar);
        jBDeletar.setBounds(370, 250, 80, 40);

        jLabel7.setText("ID");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(280, 10, 70, 16);

        jTFId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFIdActionPerformed(evt);
            }
        });
        getContentPane().add(jTFId);
        jTFId.setBounds(280, 30, 30, 22);

        jBLimpar.setText("Limpar");
        jBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jBLimpar);
        jBLimpar.setBounds(460, 250, 80, 40);

        jBPesquisar.setText("Pesquisar");
        jBPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jBPesquisar.setIconTextGap(0);
        jBPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(jBPesquisar);
        jBPesquisar.setBounds(570, 20, 95, 40);
        getContentPane().add(jTFPesquisar);
        jTFPesquisar.setBounds(410, 30, 140, 22);

        jLabel8.setText("Pesquisar");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(410, 10, 130, 16);

        jLabel9.setText("Cargo");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(170, 190, 110, 16);

        jLabel10.setText("Sálario");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(330, 190, 43, 16);
        getContentPane().add(jTFCargo);
        jTFCargo.setBounds(170, 210, 140, 22);
        getContentPane().add(jTFSalario);
        jTFSalario.setBounds(330, 210, 70, 22);
        getContentPane().add(jTFEndereçoId);
        jTFEndereçoId.setBounds(420, 150, 64, 22);

        jLabel11.setText("ID Endereço");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(420, 130, 70, 16);

        jBEndereco.setText("Endereço");
        getContentPane().add(jBEndereco);
        jBEndereco.setBounds(510, 140, 95, 40);

        setBounds(0, 0, 697, 594);
    }// </editor-fold>//GEN-END:initComponents

    private void jTFNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNomeActionPerformed

    //fecha a tela
    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
        this.dispose();
        Principal p = new Principal();
        p.setVisible(true);
    }//GEN-LAST:event_jBSairActionPerformed

    //Pega os dados digitados, verica se todos os campos estão preenchidos se sim salva no banco
    private void jBGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGravarActionPerformed

        String nome = jTFNome.getText().trim();
        String cpf = jTFCpf.getText().trim();
        String rg = jTFRg.getText().trim();
        String email = jTFEmail.getText().trim();
        String telefone = jTFTelefone.getText().trim();
        String dataNascimento = jTFData.getText().trim();
        String cargo = jTFCargo.getText().trim();
        String enderecoId = jTFEndereçoId.getText().trim();
        String salario = jTFSalario.getText().trim();
        if ("".equals(rg) || "".equals(email) || "".equals(nome) || "".equals(cpf) || "".equals(telefone)
                || "".equals(dataNascimento) || "".equals(cargo) || "".equals(salario) || "".equals(enderecoId)) {
            JOptionPane.showMessageDialog(null, "E necessário preencher todos os campos para continuar");
        } else {
            Funcionarios funcionario = new Funcionarios();
            funcionario.setNome(nome);
            funcionario.setCpf(cpf);
            funcionario.setEmail(email);
            funcionario.setTelefone(telefone);
            funcionario.setDataNascimento(dataNascimento);
            funcionario.setRg(rg);
            funcionario.setCargo(cargo);
            funcionario.setSalario(salario);
            funcionario.setEnderecoId(enderecoId);
            FuncionariosDao dao = new FuncionariosDao();
            dao.inserirAp(funcionario);
            preencherTabela();
        }
    }//GEN-LAST:event_jBGravarActionPerformed

    private void jTFRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFRgActionPerformed

    //Ao clicar em um dos campos da tabela preenche os campos do programa
    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        jTFId.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString());
        jTFNome.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString());
        jTFCpf.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString());
        jTFRg.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString());
        jTFEmail.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString());
        jTFTelefone.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 5).toString());
        jTFData.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 6).toString());
        jTFCargo.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 7).toString());
        jTFSalario.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 8).toString());
        jTFEndereçoId.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 9).toString());
        jBAlterar.setEnabled(true);
        jBDeletar.setEnabled(true);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTFIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFIdActionPerformed

    }//GEN-LAST:event_jTFIdActionPerformed

    //Pega os dados digitados, verica se todos os campos estão preenchidos se sim atualiza no banco
    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        int Id = Integer.parseInt(jTFId.getText().trim());
        String nome = jTFNome.getText().trim();
        String cpf = jTFCpf.getText().trim();
        String rg = jTFRg.getText().trim();
        String email = jTFEmail.getText().trim();
        String telefone = jTFTelefone.getText().trim();
        String dataNascimento = jTFData.getText().trim();
        String cargo = jTFCargo.getText().trim();
        String enderecoId = jTFEndereçoId.getText().trim();
        String salario = jTFSalario.getText().trim();
        if ("".equals(rg) || "".equals(email) || "".equals(nome) || "".equals(cpf) || "".equals(telefone)
                || "".equals(dataNascimento) || "".equals(cargo) || "".equals(salario) || "".equals(enderecoId)) {
            JOptionPane.showMessageDialog(null, "E necessário preencher todos os campos para continuar");
        } else {
            Funcionarios funcionario = new Funcionarios();
            funcionario.setNome(nome);
            funcionario.setCpf(cpf);
            funcionario.setEmail(email);
            funcionario.setTelefone(telefone);
            funcionario.setDataNascimento(dataNascimento);
            funcionario.setRg(rg);
            funcionario.setCargo(cargo);
            funcionario.setSalario(salario);
            funcionario.setEnderecoId(enderecoId);
            funcionario.setId(Id);
            FuncionariosDao dao = new FuncionariosDao();
            dao.alterar(funcionario);
            preencherTabela();
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    //Pega o id slecionado deleta no banco
    private void jBDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeletarActionPerformed
        int id = Integer.parseInt(jTFId.getText().trim());

        Funcionarios funcionario = new Funcionarios();
        funcionario.setId(id);

        FuncionariosDao dao = new FuncionariosDao();
        dao.deletar(funcionario);
        preencherTabela();

    }//GEN-LAST:event_jBDeletarActionPerformed

    //Limpa todos os campos do programa
    private void jBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparActionPerformed
        jTFId.setText("");
        jTFNome.setText("");
        jTFCpf.setText("");
        jTFData.setText("");
        jTFEmail.setText("");
        jTFRg.setText("");
        jTFTelefone.setText("");
        jTFPesquisar.setText("");
        jTFCargo.setText("");
        jTFSalario.setText("");
        jTFEndereçoId.setText("");
        preencherTabela();
        jBAlterar.setEnabled(false);
        jBDeletar.setEnabled(false);
    }//GEN-LAST:event_jBLimparActionPerformed

    //Preenche tabela realizando pesquisa com dados informados
    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        preencherTabelaPesquisar(jTFPesquisar.getText());
    }//GEN-LAST:event_jBPesquisarActionPerformed

    private void jTable2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseExited

    private void jTable2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseEntered

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
            java.util.logging.Logger.getLogger(FuncionariosTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuncionariosTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuncionariosTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuncionariosTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FuncionariosTela().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(FuncionariosTela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBDeletar;
    private javax.swing.JButton jBEndereco;
    private javax.swing.JButton jBGravar;
    private javax.swing.JButton jBLimpar;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JButton jBSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFCargo;
    private javax.swing.JTextField jTFCpf;
    private javax.swing.JTextField jTFData;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFEndereçoId;
    private javax.swing.JTextField jTFId;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFPesquisar;
    private javax.swing.JTextField jTFRg;
    private javax.swing.JTextField jTFSalario;
    private javax.swing.JTextField jTFTelefone;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
