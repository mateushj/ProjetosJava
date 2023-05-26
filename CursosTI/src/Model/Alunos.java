package Model;

/**
 *
 * @author Laboratório
 */
public class Alunos {
    public int idAluno;
    public String nome;
    public String email;
    public String cpf;
    public String telefone;

    
            
    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void imprimir(){
        System.out.println("O id do Aluno é: " +getIdAluno()+
               "\n"+"O nome do Aluno é: "+getNome()+
               "\n"+ "O cpf do aluno é: "+getCpf()+
       "\n"+"o telefone do aluno é: "+getTelefone()+
               "\n"+"O email do aluno é: "+getEmail());
    }
}
