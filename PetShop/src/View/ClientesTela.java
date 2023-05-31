/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DAO.ClienteDao;
import Model.Clientes;
import java.awt.Toolkit;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LABORATÓRIO
 */
public class ClientesTela extends javax.swing.JFrame {

    /**
     * Creates new form Clientes
     */
    
    public ClientesTela() throws Exception {
        initComponents();
        setSize(700, 600);// Define resolução tela
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); //impede de fechar com X
        setLocationRelativeTo(null); //Define a posição como centro da tela
        setTitle("Cadastrar clientes");// Titulo da tela
        setResizable(false); //Impede de redimensionar tela
        jTFIdCliente.setEnabled(false); //Desabilita campo Id
        jBDeletar.setEnabled(false);//Desabilita campo deletar
        jBAlterar.setEnabled(false); //Desabilita campo alterar
        jTFIdEndereco.setEnabled(false); //Desabilita campo id endereço
        jBcadAnimal.setEnabled(false);//Desabilita campo cadastrar Animal
        URL caminhoImagem = this.getClass().getClassLoader().getResource("./images/project/icon-petshop-100.png"); //localiza o icone
        setIconImage(Toolkit.getDefaultToolkit().getImage(caminhoImagem));//define o icone
        preencherTabela();//Preenche tabela com os dados retornados do banco
    }

    public void preencherTabela() {
        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
        modelo.setNumRows(0);
        ClienteDao cDAO = new ClienteDao();
        for (Clientes c : cDAO.ler()) {
            modelo.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getCpf(),
                c.getEmail(),
                c.getTelefone(),
                c.getDataNascimento(),
                c.getEndereco_id()
            });
        }
    }

    public void preencherTabelaPesquisar(String desc) {
        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
        modelo.setNumRows(0);
        ClienteDao cDAO = new ClienteDao();
        for (Clientes c : cDAO.ler2(desc)) {
            modelo.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getCpf(),
                c.getEmail(),
                c.getTelefone(),
                c.getDataNascimento(),
                c.getEndereco_id()
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
        jTFIdEndereco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jBAlterar = new javax.swing.JButton();
        jBDeletar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTFIdCliente = new javax.swing.JTextField();
        jBLimpar = new javax.swing.JButton();
        jBPesquisar = new javax.swing.JButton();
        jTFPesquisar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jBEndereco = new javax.swing.JButton();
        jBcadAnimal = new javax.swing.JButton();

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
        jTFNome.setBounds(30, 40, 210, 22);
        getContentPane().add(jTFCpf);
        jTFCpf.setBounds(30, 100, 150, 22);
        getContentPane().add(jTFEmail);
        jTFEmail.setBounds(30, 160, 200, 22);
        getContentPane().add(jTFData);
        jTFData.setBounds(190, 100, 120, 22);
        getContentPane().add(jTFTelefone);
        jTFTelefone.setBounds(320, 100, 150, 22);

        jLabel1.setText("Nome");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 20, 140, 16);

        jLabel2.setText("Cpf");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 80, 140, 16);

        jLabel3.setText("Email");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 140, 130, 16);

        jLabel4.setText("Data Nascimento");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(190, 80, 110, 16);

        jLabel5.setText("Telefone");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(320, 80, 60, 16);

        jBGravar.setText("Gravar");
        jBGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGravarActionPerformed(evt);
            }
        });
        getContentPane().add(jBGravar);
        jBGravar.setBounds(120, 250, 80, 40);

        jBSair.setText("Sair");
        jBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSairActionPerformed(evt);
            }
        });
        getContentPane().add(jBSair);
        jBSair.setBounds(600, 250, 80, 40);

        jTFIdEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFIdEnderecoActionPerformed(evt);
            }
        });
        getContentPane().add(jTFIdEndereco);
        jTFIdEndereco.setBounds(280, 160, 71, 22);

        jLabel6.setText("ID Endereço");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(280, 140, 70, 16);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Cpf", "Email", "Telefone", "Nascimento", "Endereço id"
            }
        ));
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

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 300, 668, 250);

        jBAlterar.setText("Alterar");
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(jBAlterar);
        jBAlterar.setBounds(210, 250, 80, 40);

        jBDeletar.setText("Deletar");
        jBDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(jBDeletar);
        jBDeletar.setBounds(300, 250, 80, 40);

        jLabel7.setText("Id Cliente");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(270, 20, 70, 16);

        jTFIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFIdClienteActionPerformed(evt);
            }
        });
        getContentPane().add(jTFIdCliente);
        jTFIdCliente.setBounds(270, 40, 64, 22);

        jBLimpar.setText("Limpar");
        jBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimparActionPerformed(evt);
            }
        });
        getContentPane().add(jBLimpar);
        jBLimpar.setBounds(390, 250, 80, 40);

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

        jBEndereco.setText("Endereço");
        jBEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEnderecoActionPerformed(evt);
            }
        });
        getContentPane().add(jBEndereco);
        jBEndereco.setBounds(370, 150, 95, 40);

        jBcadAnimal.setText("<html><center>Cadastrar<br>Animal</center></html>");
        jBcadAnimal.setToolTipText("animais");
        jBcadAnimal.setActionCommand("Cadastrar Animais");
        jBcadAnimal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBcadAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcadAnimalActionPerformed(evt);
            }
        });
        getContentPane().add(jBcadAnimal);
        jBcadAnimal.setBounds(500, 250, 95, 40);
        jBcadAnimal.getAccessibleContext().setAccessibleName("Cadastrar");

        setBounds(0, 0, 703, 621);
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
        String email = jTFEmail.getText().trim();
        String telefone = jTFTelefone.getText().trim();
        String dataNascimento = jTFData.getText().trim();
        String endereco = jTFIdEndereco.getText().trim();
        if ("".equals(endereco) || "".equals(email) || "".equals(nome) || "".equals(cpf) || "".equals(telefone) || "".equals(dataNascimento)) {
            JOptionPane.showMessageDialog(null, "E necessário preencher todos os campos para continuar");
        } else {
            Clientes cliente = new Clientes();
            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setEmail(email);
            cliente.setTelefone(telefone);
            cliente.setDataNascimento(dataNascimento);
            cliente.setEndereco_id(endereco);
            ClienteDao dao = new ClienteDao();
            dao.inserirAp(cliente);
            preencherTabela();
        }
    }//GEN-LAST:event_jBGravarActionPerformed

    private void jTFIdEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFIdEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFIdEnderecoActionPerformed

    //Ao clicar em um dos campos da tabela preenche os campos do programa
    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        jTFIdCliente.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString());
        jTFNome.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString());
        jTFCpf.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString());
        jTFEmail.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString());
        jTFTelefone.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString());
        jTFData.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 5).toString());
        jTFIdEndereco.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 6).toString());
        jBAlterar.setEnabled(true);
        jBDeletar.setEnabled(true);
        jBcadAnimal.setEnabled(true);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTFIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFIdClienteActionPerformed

    }//GEN-LAST:event_jTFIdClienteActionPerformed

    //Pega os dados digitados, verica se todos os campos estão preenchidos se sim atualiza no banco
    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        int Id = Integer.parseInt(jTFIdCliente.getText().trim());
        String nome = jTFNome.getText().trim();
        String cpf = jTFCpf.getText().trim();
        String email = jTFEmail.getText().trim();
        String telefone = jTFTelefone.getText().trim();
        String dataNascimento = jTFData.getText().trim();
        String endereco = jTFIdEndereco.getText().trim();

        if ("".equals(endereco) || "".equals(email) || "".equals(nome) || "".equals(cpf) || "".equals(telefone) || "".equals(dataNascimento)) {
            JOptionPane.showMessageDialog(null, "E necessário preencher todos os campos para continuar");
        } else {
            Clientes cliente = new Clientes();
            cliente.setId(Id);
            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setEmail(email);
            cliente.setTelefone(telefone);
            cliente.setDataNascimento(dataNascimento);
            cliente.setEndereco_id(endereco);
            ClienteDao dao = new ClienteDao();
            dao.alterarC(cliente);
            preencherTabela();
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    //Pega o id slecionado deleta no banco
    private void jBDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeletarActionPerformed
        int id = Integer.parseInt(jTFIdCliente.getText().trim());
        String nome = jTFNome.getText().trim();
        String cpf = jTFCpf.getText().trim();
        String email = jTFEmail.getText().trim();
        String telefone = jTFTelefone.getText().trim();
        String dataNascimento = jTFData.getText().trim();
        String endereco = jTFIdEndereco.getText().trim();

        Clientes cliente = new Clientes();
        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setDataNascimento(dataNascimento);
        cliente.setEndereco_id(endereco);
        ClienteDao dao = new ClienteDao();
        dao.deletar(cliente);
        preencherTabela();

    }//GEN-LAST:event_jBDeletarActionPerformed

    //Limpa todos os campos do programa
    private void jBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparActionPerformed
        jTFIdCliente.setText("");
        jTFNome.setText("");
        jTFCpf.setText("");
        jTFData.setText("");
        jTFEmail.setText("");
        jTFIdEndereco.setText("");
        jTFTelefone.setText("");
        jTFPesquisar.setText("");
        preencherTabela();
        jBAlterar.setEnabled(false);
        jBDeletar.setEnabled(false);
        jBcadAnimal.setEnabled(false);
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

    private void jBEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEnderecoActionPerformed
        EnderecosTela et = new EnderecosTela(this, true);
        et.setVisible(true);
        
        jTFIdEndereco.setText(String.valueOf(et.getValorId()));
    }//GEN-LAST:event_jBEnderecoActionPerformed

    private void jBcadAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcadAnimalActionPerformed
        try {
            AnimaisTela at = new AnimaisTela();
            at.setVisible(true);
            at.setjCBIdTutor(Integer.parseInt(this.jTFIdCliente.getText().trim()));
            at.setTitle("Cadastrar animais"); 
        } catch (Exception ex) {
            Logger.getLogger(ClientesTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBcadAnimalActionPerformed
  
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
            java.util.logging.Logger.getLogger(ClientesTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientesTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientesTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientesTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ClientesTela().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(ClientesTela.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JButton jBcadAnimal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFCpf;
    private javax.swing.JTextField jTFData;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFIdCliente;
    private javax.swing.JTextField jTFIdEndereco;
    private javax.swing.JTextField jTFNome;
    private javax.swing.JTextField jTFPesquisar;
    private javax.swing.JTextField jTFTelefone;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
