/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursosti;

//import javax.swing.JOptionPane;

import Model.Alunos;
import Model.Cursos;
import Model.Pagamentos;
import Model.Professores;
import javax.swing.JOptionPane;



public class CursosTI {

    
    public static void main(String[] args) {
       /*
        
        Alunos objetoAluno = new Alunos();
          objetoAluno.setIdAluno(11);
          objetoAluno.setNome("José Maria");
          objetoAluno.setCpf("123.123.123-00");
          objetoAluno.setEmail("jose@gmail.com");
          objetoAluno.setTelefone("(31)97534-4390");
          String nome = objetoAluno.getNome();
          
          objetoAluno.imprimir();
//  objetoAluno.idAluno = 1;
      System.out.println("---------------------------------------\n");
       /*System.out.println("O id do Aluno é: " +objetoAluno.getIdAluno()+
               "\n"+"O nome do Aluno é: "+objetoAluno.getNome()+
               "\n"+ "O cpf do aluno é: "+objetoAluno.getCpf()+
       "\n"+"o tekefone do aluno é: "+ objetoAluno.getTelefone()+
               "\n"+"O email do aluno é: "+objetoAluno.getEmail());/*
      
      /* JOptionPane.showMessageDialog(null, "O id do Aluno é: " +objetoAluno.getIdAluno()+
               "\n"+"O nome do Aluno é: "+objetoAluno.getNome()+
               "\n"+ "O cpf do aluno é: "+objetoAluno.getCpf()+
       "\n"+"o telefone do aluno é: "+ objetoAluno.getTelefone()+
               "\n"+"O email do aluno é: "+objetoAluno.getEmail());*/
     /* Professores objetoProfessor = new Professores();
          objetoProfessor.setIdProfessor(01);
          objetoProfessor.setNome("João Batista");
          objetoProfessor.setCpf("123.123.123-00");
          objetoProfessor.setEmail("joão@gmail.com");
          objetoProfessor.setTelefone("(31)97534-4390");
          objetoProfessor.imprimir();
          System.out.println("---------------------------------------\n");
                  
     Pagamentos objetoPagamento = new Pagamentos();
         objetoPagamento.setIdPagamento(99);
         objetoPagamento.setValor(52.50);
         objetoPagamento.setDesconto(00.00);
         objetoPagamento.setDataPagamento("29/08/2022");
         objetoPagamento.setDescricao("Forma de pagamento PIX");
         objetoPagamento.imprimir();
         
         System.out.println("---------------------------------------\n");
     
         Cursos objetoCursos = new Cursos();
         objetoCursos.setIdCursos(99);
         objetoCursos.setValor(52.50);
         objetoCursos.setDuracao("52 horas");
         objetoCursos.setModulo("4 Modulos");
         objetoCursos.setDescricao("Curso com conceitos básicos de orientação objeto");
         objetoCursos.imprimir();
         */
     
     
         Alunos aluno1 = new Alunos();
         aluno1.setIdAluno(100);
         aluno1.setNome("Teclaudio Screen");
         
         Pagamentos pg1 = new Pagamentos();
         pg1.setId_aluno(aluno1.getIdAluno());
         pg1.setNome_Aluno(aluno1.getNome());
         pg1.setDescricao("Pagamento de mensalidades 5");
         pg1.setDesconto(10);
         pg1.setIdPagamento(1);
         pg1.setValor(500);
         pg1.imprimir();
         
         Alunos aluno2 = new Alunos();
         aluno2.setIdAluno(200);
         aluno2.setNome("Joãozinho");
         aluno2.setCpf("123456789123");
         aluno2.setEmail("joazinho@email.com");
         aluno2.setTelefone("31 80029222");
         
         Cursos curso1 = new Cursos();
         curso1.setIdCursos(001);
         curso1.setDescricao("Curso de orientação obejeto");
         curso1.setDuracao("25 Meses");
         
         
         Pagamentos pg2 = new Pagamentos();
         pg2.setId_aluno(aluno2.getIdAluno());
         pg2.setNome_Aluno(aluno2.getNome());
         pg2.setCpf_aluno(aluno2.getCpf());
         pg2.setId_cursos(curso1.getIdCursos());
         pg2.setDesc_cursos(curso1.getDescricao());
         pg2.setDur_cursos(curso1.getDuracao());
         pg2.setDescricao("pagamento de mensalidades 8");
         pg2.setDesconto(15);
         pg2.setIdPagamento(2);
         pg2.setValor(449);
         pg2.imprimir();
         
         
         
         
                 
         //JOptionPane.showMessageDialog(null,pg1.getId_aluno()+"\n"+pg1.getNome_Aluno());
    }
    
}
