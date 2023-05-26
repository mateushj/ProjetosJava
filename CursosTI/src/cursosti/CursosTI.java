package cursosti;

import Model.Alunos;
import Model.Cursos;
import Model.Pagamentos;
import Model.Professores;
import javax.swing.JOptionPane;



public class CursosTI {

    
    public static void main(String[] args) {
  
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
    }
    
}
