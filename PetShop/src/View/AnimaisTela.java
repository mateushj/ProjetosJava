/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DAO.AnimaisDao;
import DAO.ClienteDao;
import Model.Animais;
import Model.Clientes;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LABORATÓRIO
 */
public class AnimaisTela extends javax.swing.JFrame {

    /**
     * Creates new form AnimaisTela
     *
     * @throws java.lang.Exception
     */
    public AnimaisTela() throws Exception {
        initComponents();
        setSize(700, 580); // Define resolução tela
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); //impede de fechar com X
        setLocationRelativeTo(null); //Define a posição como centro da tela
        setTitle("Cadastrar Animais"); // Titulo da tela
        setResizable(false); //Impede de redimensionar tela
        jTFId.setEnabled(false); //Desabilita campo Id
        jBDeletar.setEnabled(false);//Desabilita campo deletar
        jBAlterar.setEnabled(false); //Desabilita campo alterar
        jCBNomeTutor.setEnabled(false);//Desabilita campo nome tutor
        URL caminhoImagem = this.getClass().getClassLoader().getResource("./images/project/icon-petshop-100.png"); //localiza o icone
        setIconImage(Toolkit.getDefaultToolkit().getImage(caminhoImagem));//define o icone
        preencherTabela(); //Preenche tabela com os dados retornados do banco
        preencherComboBox();//Preenche os combobox com os dados retornados do banco

    }

    private void preencherTabela() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        AnimaisDao aDAO = new AnimaisDao();

        try {
            for (Animais a : aDAO.lerAnimal()) {
                modelo.addRow(new Object[]{
                    a.getId(),
                    a.getNome(),
                    a.getRaca(),
                    a.getSexo(),
                    a.getDataNascimento(),
                    a.getTutor()
                });
            }
        } catch (Exception ex) {
            Logger.getLogger(AnimaisTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preencherTabelaPesquisar(String desc) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        AnimaisDao aDAO = new AnimaisDao();
        for (Animais a : aDAO.lerAnimal2(desc)) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getNome(),
                a.getRaca(),
                a.getSexo(),
                a.getDataNascimento(),
                a.getTutor()
            });
        }
    }

    private void preencherComboBox() {

        ClienteDao cDAO = new ClienteDao();
        List<String> nomeClientes = new ArrayList<>();
        List<Integer> idClientes = new ArrayList<>();
        idClientes.add(null);
        nomeClientes.add("");
        for (Clientes c : cDAO.ler()) {
            idClientes.add(c.getId());
            nomeClientes.add(c.getNome());
        }
        DefaultComboBoxModel modeloListNome = new DefaultComboBoxModel(nomeClientes.toArray());
        DefaultComboBoxModel modeloListId = new DefaultComboBoxModel(idClientes.toArray());
        jCBNomeTutor.setModel(modeloListNome);
        jCBIdTutor.setModel(modeloListId);
    }

    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jTFRaca = new javax.swing.JTextField();
        jTFId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTFNascimento = new javax.swing.JTextField();
        jBSair = new javax.swing.JButton();
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
        jCBSexo = new javax.swing.JComboBox<>();
        jCBNomeTutor = new javax.swing.JComboBox<>();
        jCBIdTutor = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLNomeTutor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Nome");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 40, 33, 16);

        jLabel2.setText("Raça");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 100, 70, 16);

        jLabel3.setText("Id");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(340, 40, 40, 16);

        jTFNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNomeActionPerformed(evt);
            }
        });
        getContentPane().add(jTFNome);
        jTFNome.setBounds(30, 60, 140, 22);
        getContentPane().add(jTFRaca);
        jTFRaca.setBounds(30, 120, 140, 22);
        getContentPane().add(jTFId);
        jTFId.setBounds(340, 60, 40, 22);

        jLabel4.setText("Data Nascimento");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(190, 40, 110, 16);
        getContentPane().add(jTFNascimento);
        jTFNascimento.setBounds(190, 60, 90, 22);

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
                "Id", "Nome", "Raca", "Sexo", "Data Nascimento", "Tutor"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 230, 668, 300);

        jLabel5.setText("Sexo");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(190, 100, 40, 16);

        jLabel6.setText("Id Tutor");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(420, 100, 60, 16);

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

        jCBSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "F", "M" }));
        getContentPane().add(jCBSexo);
        jCBSexo.setBounds(190, 120, 40, 22);

        jCBNomeTutor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBNomeTutorItemStateChanged(evt);
            }
        });
        jCBNomeTutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCBNomeTutorMouseClicked(evt);
            }
        });
        getContentPane().add(jCBNomeTutor);
        jCBNomeTutor.setBounds(240, 120, 170, 22);

        jCBIdTutor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBIdTutorItemStateChanged(evt);
            }
        });
        getContentPane().add(jCBIdTutor);
        jCBIdTutor.setBounds(420, 120, 60, 22);

        jLabel8.setText("Nome Tutor");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(240, 100, 170, 16);
        getContentPane().add(jLNomeTutor);
        jLNomeTutor.setBounds(500, 120, 150, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNomeActionPerformed

    //Ao clicar em um dos campos da tabela preenche os campos do programa 
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jTFId.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        jTFNome.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        jTFRaca.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        jCBSexo.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
        jTFNascimento.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
        jCBIdTutor.setSelectedItem(Integer.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString()));
        jBAlterar.setEnabled(true);
        jBDeletar.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    //Limpa todos os campos do programa
    private void jBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparActionPerformed
        jTFId.setText("");
        jTFNascimento.setText("");
        jTFNome.setText("");
        jTFRaca.setText("");
        jTFPesquisar.setText("");
        jCBSexo.setSelectedItem("");
        jCBIdTutor.setSelectedItem(null);
        preencherTabela();
        jBAlterar.setEnabled(false);
        jBDeletar.setEnabled(false);
    }//GEN-LAST:event_jBLimparActionPerformed

    
    //fecha a tela
    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
        this.dispose();
        if("Cadastrar Animais".equals(getTitle())){
        Principal p = new Principal();
        p.setVisible(true);
        }
    }//GEN-LAST:event_jBSairActionPerformed

    //Pega os dados digitados, verica se todos os campos estão preenchidos se sim salva no banco
    private void jBGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGravarActionPerformed
        String nome = jTFNome.getText().trim();
        String raca = jTFRaca.getText().trim();
        String dataNascimento = jTFNascimento.getText().trim();
        String sexo = jCBSexo.getSelectedItem().toString().trim();
        var verificaTutor = jCBIdTutor.getSelectedItem();

        if ("".equals(sexo) || "".equals(nome) || "".equals(raca) || "".equals(dataNascimento) || verificaTutor == null) {
            JOptionPane.showMessageDialog(null, "E necessário preencher todos os campos para continuar");
        } else {
            int tutor = Integer.parseInt(jCBIdTutor.getSelectedItem().toString().trim());
            Animais animal = new Animais();
            animal.setNome(nome);
            animal.setRaca(raca);
            animal.setSexo(sexo);
            animal.setTutor(tutor);
            animal.setDataNascimento(dataNascimento);
            AnimaisDao dao = new AnimaisDao();
            dao.inserirAp(animal);
            try {
                preencherTabela();
            } catch (Exception ex) {
                Logger.getLogger(AnimaisTela.class.getName()).log(Level.SEVERE, null, ex);
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
        String nome = jTFNome.getText().trim();
        String raca = jTFRaca.getText().trim();
        String sexo = jCBSexo.getSelectedItem().toString().trim();
        String dataNascimento = jTFNascimento.getText().trim();
        var verificaTutor = jCBIdTutor.getSelectedItem();

        if ("".equals(sexo) || "".equals(nome) || "".equals(raca) || "".equals(dataNascimento) || verificaTutor == null) {
            JOptionPane.showMessageDialog(null, "E necessário preencher todos os campos para continuar");
        } else {
            int tutor = Integer.parseInt(jCBIdTutor.getSelectedItem().toString().trim());
            Animais animal = new Animais();
            animal.setNome(nome);
            animal.setRaca(raca);
            animal.setDataNascimento(dataNascimento);
            animal.setSexo(sexo);
            animal.setTutor(tutor);
            animal.setId(Id);
            AnimaisDao dao = new AnimaisDao();
            dao.alterarC(animal);
            preencherTabela();
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    private void jCBNomeTutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBNomeTutorMouseClicked

    }//GEN-LAST:event_jCBNomeTutorMouseClicked

    private void jCBNomeTutorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBNomeTutorItemStateChanged

    }//GEN-LAST:event_jCBNomeTutorItemStateChanged

    //relaciona os campos Nome tutor e id tutor
    private void jCBIdTutorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBIdTutorItemStateChanged
        jCBNomeTutor.setSelectedIndex(jCBIdTutor.getSelectedIndex());
    }//GEN-LAST:event_jCBIdTutorItemStateChanged

    //Pega o id slecionado deleta no banco
    private void jBDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeletarActionPerformed
        int id = Integer.parseInt(jTFId.getText().trim());
        Animais a = new Animais();
        a.setId(id);
        AnimaisDao Dao = new AnimaisDao();
        Dao.deletar(a);
        preencherTabela();
    }//GEN-LAST:event_jBDeletarActionPerformed

    public void setjCBIdTutor(int jCBIdTutor) {
        this.jCBIdTutor.setSelectedItem(jCBIdTutor);
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
            java.util.logging.Logger.getLogger(AnimaisTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnimaisTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnimaisTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnimaisTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
    private javax.swing.JComboBox<String> jCBIdTutor;
    private javax.swing.JComboBox<String> jCBNomeTutor;
    private javax.swing.JComboBox<String> jCBSexo;
    private javax.swing.JLabel jLNomeTutor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFId;
    private javax.swing.JTextField jTFNascimento;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFPesquisar;
    private javax.swing.JTextField jTFRaca;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
