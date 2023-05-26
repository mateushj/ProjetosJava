package Model;

/**
 *
 * @author Laboratório
 */
public class Professores {
  public int idProfessor;
  public String nome;
  public String cpf;
  public String email;
  public String telefone;

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
  
        public void imprimir(){
        System.out.println("O id do Professor é: " +getIdProfessor()+
               "\n"+"O nome do Professor é: "+getNome()+
               "\n"+ "O cpf do Professor é: "+getCpf()+
       "\n"+"o telefone do Professor é: "+getTelefone()+
               "\n"+"O email do professor é: "+getEmail());
    }
}
