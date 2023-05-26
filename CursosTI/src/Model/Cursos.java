package Model;


public class Cursos {
   public int idCursos;
   public String descricao;
   public double valor;
   public String duracao;
   public String modulo;

    public int getIdCursos() {
        return idCursos;
    }

    public void setIdCursos(int idCursos) {
        this.idCursos = idCursos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }
   
    public void imprimir(){
        System.out.println("O id do Curso é: " +getIdCursos()+
               "\n"+"O valor do Curso: "+getValor()+
               "\n"+ "Duração do curso: "+getDuracao()+
       "\n"+"Numero de Modulos: "+getModulo()+
               "\n"+"Descrição: "+getDescricao());
    }
}
