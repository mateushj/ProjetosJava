/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DAO.ConsultasDao;
import DAO.FuncionariosDao;
import Model.Consultas;
import Model.Funcionarios;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultasTela extends javax.swing.JFrame {
public static boolean telaAtiva = false;
    public ConsultasTela() throws Exception {
        initComponents();
        setSize(700, 580); // Define resolução tela
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); //impede de fechar com X
        setLocationRelativeTo(null); //Define a posição como centro da tela
        setTitle("Consultas"); // Titulo da tela
        setResizable(false); //Impede de redimensionar tela
        jTFId.setEnabled(false); //Desabilita campo Id
        jTFIdExame.setEnabled(false); //Desabilita campo Id exame
        jBDeletar.setEnabled(false);//Desabilita campo deletar
        jBAlterar.setEnabled(false); //Desabilita campo alterar
        jCBNomeFuncionario.setEnabled(false);//Desabilita campo nome tutor
        URL caminhoImagem = this.getClass().getClassLoader().getResource("./images/project/icon-petshop-100.png"); //localiza o icone
        setIconImage(Toolkit.getDefaultToolkit().getImage(caminhoImagem));//define o icone
        preencherTabela(); //Preenche tabela com os dados retornados do banco
        preencherComboBox();//Preenche os combobox com os dados retornados do banco

    }

    private void preencherTabela() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        ConsultasDao cDAO = new ConsultasDao();

        try {
            for (Consultas c : cDAO.ler()) {
                modelo.addRow(new Object[]{
                    c.getId(),
                    c.getIdAnimal(),
                    c.getIdFuncionario(),
                    c.getDataConsulta(),
                    c.getHoraConsulta(),
                    c.getRetorno(),
                    c.getPrescricao(),
                    c.getIdExame()
                });
            }
        } catch (Exception ex) {
            Logger.getLogger(ConsultasTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preencherTabelaPesquisar(String desc) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        ConsultasDao cDAO = new ConsultasDao();
        for (Consultas c : cDAO.ler2(desc)) {
            modelo.addRow(new Object[]{
                c.getId(),
                c.getIdAnimal(),
                c.getIdFuncionario(),
                c.getDataConsulta(),
                c.getHoraConsulta(),
                c.getRetorno(),
                c.getPrescricao(),
                c.getIdExame()
            });
        }
    }

    private void preencherComboBox() {

        FuncionariosDao fDAO = new FuncionariosDao();
        List<String> nomeFuncionario = new ArrayList<>();
        List<Integer> idFuncionario = new ArrayList<>();
        idFuncionario.add(null);
        nomeFuncionario.add("");
        for (Funcionarios f : fDAO.ler()) {
            idFuncionario.add(f.getId());
            nomeFuncionario.add(f.getNome());
        }
        DefaultComboBoxModel modeloListNome = new DefaultComboBoxModel(nomeFuncionario.toArray());
        DefaultComboBoxModel modeloListId = new DefaultComboBoxModel(idFuncionario.toArray());
        jCBNomeFuncionario.setModel(modeloListNome);
        jCBIdFuncionario.setModel(modeloListId);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFIdAnimal = new javax.swing.JTextField();
        jTFId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jBGravar = new javax.swing.JButton();
        jBAlterar = new javax.swing.JButton();
        jBDeletar = new javax.swing.JButton();
        jBLimpar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jBPesquisar = new javax.swing.JButton();
        jTFPesquisar = new javax.swing.JTextField();
        jCBNomeFuncionario = new javax.swing.JComboBox<>();
        jCBIdFuncionario = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTFIdExame = new javax.swing.JTextField();
        jBSair1 = new javax.swing.JButton();
        jBExame = new javax.swing.JButton();
        jTFRetorno = new javax.swing.JFormattedTextField();
        jTFHoraConsulta = new javax.swing.JFormattedTextField();
        jTFDataConsulta = new javax.swing.JFormattedTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jEPPrescricao = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Animal ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 40, 60, 16);

        jLabel2.setText("Data Consulta");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 100, 90, 16);

        jLabel3.setText("ID");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(390, 40, 20, 16);

        jTFIdAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFIdAnimalActionPerformed(evt);
            }
        });
        getContentPane().add(jTFIdAnimal);
        jTFIdAnimal.setBounds(30, 60, 60, 22);
        getContentPane().add(jTFId);
        jTFId.setBounds(390, 60, 20, 22);

        jLabel4.setText("Hora Consulta");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(130, 100, 90, 16);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Id Animal", "Id Funcionario", "Data cons.", "Hora Cons.", "Retorno", "Prescrição", "Id Exame"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
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
        jScrollPane1.setBounds(10, 320, 668, 210);

        jLabel5.setText("Retorno");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(220, 100, 50, 16);

        jLabel6.setText("ID Funcionario");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(280, 40, 80, 16);

        jBGravar.setText("Gravar");
        jBGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGravarActionPerformed(evt);
            }
        });
        getContentPane().add(jBGravar);
        jBGravar.setBounds(210, 270, 80, 40);

        jBAlterar.setText("Alterar");
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(jBAlterar);
        jBAlterar.setBounds(300, 270, 80, 40);

        jBDeletar.setText("Deletar");
        jBDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(jBDeletar);
        jBDeletar.setBounds(390, 270, 80, 40);

        jBLimpar.setText("Limpar");
        jBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jBLimpar);
        jBLimpar.setBounds(480, 270, 80, 40);

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

        jCBNomeFuncionario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBNomeFuncionarioItemStateChanged(evt);
            }
        });
        jCBNomeFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCBNomeFuncionarioMouseClicked(evt);
            }
        });
        getContentPane().add(jCBNomeFuncionario);
        jCBNomeFuncionario.setBounds(100, 60, 170, 22);

        jCBIdFuncionario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBIdFuncionarioItemStateChanged(evt);
            }
        });
        getContentPane().add(jCBIdFuncionario);
        jCBIdFuncionario.setBounds(280, 60, 80, 22);

        jLabel8.setText("Nome Funcionario");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(100, 40, 170, 16);

        jLabel9.setText("Prescrição");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 160, 70, 16);

        jLabel10.setText("Exame ID");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(310, 100, 60, 16);
        getContentPane().add(jTFIdExame);
        jTFIdExame.setBounds(310, 120, 50, 22);

        jBSair1.setText("Sair");
        jBSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSair1ActionPerformed(evt);
            }
        });
        getContentPane().add(jBSair1);
        jBSair1.setBounds(590, 270, 80, 40);

        jBExame.setText("Exame");
        jBExame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExameActionPerformed(evt);
            }
        });
        getContentPane().add(jBExame);
        jBExame.setBounds(370, 110, 80, 40);

        try {
            jTFRetorno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(jTFRetorno);
        jTFRetorno.setBounds(220, 120, 80, 22);

        try {
            jTFHoraConsulta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTFHoraConsulta.setText("  :  :  ");
        getContentPane().add(jTFHoraConsulta);
        jTFHoraConsulta.setBounds(130, 120, 80, 22);

        try {
            jTFDataConsulta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(jTFDataConsulta);
        jTFDataConsulta.setBounds(30, 120, 90, 22);

        jScrollPane3.setViewportView(jEPPrescricao);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(30, 180, 270, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFIdAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFIdAnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFIdAnimalActionPerformed

    //Ao clicar em um dos campos da tabela preenche os campos do programa 
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jTFId.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        jTFIdAnimal.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        jCBIdFuncionario.setSelectedItem(Integer.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString()));
        jTFDataConsulta.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString().replaceAll("-", ""));
        jTFHoraConsulta.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
        jTFRetorno.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString().replaceAll("-", ""));
        jEPPrescricao.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
        jTFIdExame.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString());
        
        jBAlterar.setEnabled(true);
        jBDeletar.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    //Limpa todos os campos do programa
    private void jBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparActionPerformed
        jTFId.setText("");
        jTFHoraConsulta.setText("");
        jTFIdAnimal.setText("");
        jTFDataConsulta.setText("");
        jTFPesquisar.setText("");
        jTFRetorno.setText("");
        jEPPrescricao.setText("");
        jTFIdExame.setText("");
        jCBIdFuncionario.setSelectedItem(null);
        preencherTabela();
        jBAlterar.setEnabled(false);
        jBDeletar.setEnabled(false);
    }//GEN-LAST:event_jBLimparActionPerformed

    //Pega os dados digitados, verica se todos os campos estão preenchidos se sim salva no banco
    private void jBGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGravarActionPerformed
        String idAnimal = jTFIdAnimal.getText().trim();
        String dataConsulta = jTFDataConsulta.getText().trim();
        String horaConsulta = jTFHoraConsulta.getText().trim();
        String retorno = jTFRetorno.getText().trim();
        String prescricao = jEPPrescricao.getText().trim();
        String idExame = jTFIdExame.getText().trim();
        String idFuncionario = jCBIdFuncionario.getSelectedItem().toString().trim();
        
        if("".equals(idExame)) idExame = "0";
        if ("".equals(idAnimal) || "".equals(dataConsulta) || "".equals(horaConsulta) || "".equals(idFuncionario)) {
            JOptionPane.showMessageDialog(null, "E necessário preencher os campos obrigatorios para continuar");
        } else {
            Consultas c = new Consultas();
            c.setIdAnimal(Integer.parseInt(idAnimal));
            c.setIdFuncionario(Integer.parseInt(idFuncionario));
            c.setIdExame(Integer.parseInt(idExame));
            c.setDataConsulta(dataConsulta);
            c.setHoraConsulta(horaConsulta);
            c.setRetorno(retorno);
            c.setPrescricao(prescricao);
            ConsultasDao dao = new ConsultasDao();
            dao.inserir(c);
            try {
                preencherTabela();
            } catch (Exception ex) {
                Logger.getLogger(ConsultasTela.class.getName()).log(Level.SEVERE, null, ex);
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
        String idAnimal = jTFIdAnimal.getText().trim();
        String dataConsulta = jTFDataConsulta.getText().trim();
        String horaConsulta = jTFHoraConsulta.getText().trim();
        String retorno = jTFRetorno.getText().trim();
        String prescricao = jEPPrescricao.getText().trim();
        String idExame = jTFIdExame.getText().trim();
        String idFuncionario = jCBIdFuncionario.getSelectedItem().toString().trim();
        
        if("".equals(idExame)) idExame = "0";
        if ("".equals(idAnimal) || "".equals(dataConsulta) || "".equals(horaConsulta) || "".equals(idFuncionario)) {
            JOptionPane.showMessageDialog(null, "E necessário preencher os campos obrigatorios para continuar");
        } else {
            Consultas c = new Consultas();
            c.setIdAnimal(Integer.parseInt(idAnimal));
            c.setIdFuncionario(Integer.parseInt(idFuncionario));
            c.setIdExame(Integer.parseInt(idExame));
            c.setDataConsulta(dataConsulta);
            c.setHoraConsulta(horaConsulta);
            c.setRetorno(retorno);
            c.setPrescricao(prescricao);
            c.setId(Id);
            ConsultasDao dao = new ConsultasDao();
            dao.alterar(c);
            preencherTabela();
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jCBNomeFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBNomeFuncionarioMouseClicked

    }//GEN-LAST:event_jCBNomeFuncionarioMouseClicked

    private void jCBNomeFuncionarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBNomeFuncionarioItemStateChanged

    }//GEN-LAST:event_jCBNomeFuncionarioItemStateChanged

    //relaciona os campos Nome tutor e id tutor
    private void jCBIdFuncionarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBIdFuncionarioItemStateChanged
        jCBNomeFuncionario.setSelectedIndex(jCBIdFuncionario.getSelectedIndex());
    }//GEN-LAST:event_jCBIdFuncionarioItemStateChanged

    //Pega o id slecionado deleta no banco
    private void jBDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeletarActionPerformed
        int id = Integer.parseInt(jTFId.getText().trim());
        Consultas c = new Consultas();
        c.setId(id);
        ConsultasDao dao = new ConsultasDao();
        dao.deletar(c);
        preencherTabela();
    }//GEN-LAST:event_jBDeletarActionPerformed

    private void jBSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSair1ActionPerformed
        this.dispose();
        telaAtiva = false;
        if("Consultas".equals(getTitle())){
        Principal p = new Principal();
        p.setVisible(true);
        }
    }//GEN-LAST:event_jBSair1ActionPerformed

    private void jBExameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBExameActionPerformed

    public void setjTFIdAnimal(String jTFIdAnimal) {
        this.jTFIdAnimal.setText(jTFIdAnimal);
    }
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
            java.util.logging.Logger.getLogger(ConsultasTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultasTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultasTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultasTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton jBExame;
    private javax.swing.JButton jBGravar;
    private javax.swing.JButton jBLimpar;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JButton jBSair1;
    private javax.swing.JComboBox<String> jCBIdFuncionario;
    private javax.swing.JComboBox<String> jCBNomeFuncionario;
    private javax.swing.JEditorPane jEPPrescricao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JFormattedTextField jTFDataConsulta;
    private javax.swing.JFormattedTextField jTFHoraConsulta;
    private javax.swing.JTextField jTFId;
    private javax.swing.JTextField jTFIdAnimal;
    private javax.swing.JTextField jTFIdExame;
    private javax.swing.JTextField jTFPesquisar;
    private javax.swing.JFormattedTextField jTFRetorno;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
