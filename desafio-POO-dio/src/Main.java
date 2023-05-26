
import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;
import java.time.LocalDate;

/**
 *
 * @author mateus
 */
public class Main {
    public static void main(String[] args){
                
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição curso Java");
        curso1.setCargaHoraria(8);
        
                Curso curso2 = new Curso();
        curso2.setTitulo("Curso Js");
        curso2.setDescricao("Descrição curso Js");
        curso2.setCargaHoraria(4);
        
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descrição Mentoria de Java");
        mentoria.setData(LocalDate.now());
        
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);
        
        Dev devMateus= new Dev();
        devMateus.setNome("Mateus");
        devMateus.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos Inscritos Mateus: "+ devMateus.getConteudosInscritos());
        devMateus.progredir();
        devMateus.progredir();
        System.out.println("Conteudos Inscritos Mateus: "+ devMateus.getConteudosInscritos());
        System.out.println("Conteudos Concluidos Mateus: "+ devMateus.getConteudosConcluidos());
        System.out.println("XP: "+ devMateus.calcularTotalXp());
        
        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos Inscritos João: "+ devJoao.getConteudosInscritos());
        devJoao.progredir();
        System.out.println("Conteudos Inscritos João: "+ devJoao.getConteudosInscritos());
        System.out.println("Conteudos Concluidos João: "+ devJoao.getConteudosConcluidos());
        System.out.println("XP: "+ devJoao.calcularTotalXp());
    }
    
}
