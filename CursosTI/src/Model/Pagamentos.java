package Model;


public class Pagamentos {
    public int idPagamento;
    public double valor;
    public double desconto;
    public String descricao;
    public String dataPagamento;
    public int id_aluno;
    public String nome_Aluno;
    public String cpf_aluno;
    public int id_cursos;
    public String desc_cursos;
    public String dur_cursos;

    public String getDur_cursos() {
        return dur_cursos;
    }

    public void setDur_cursos(String dur_cursos) {
        this.dur_cursos = dur_cursos;
    }
    

    public String getCpf_aluno() {
        return cpf_aluno;
    }

    public void setCpf_aluno(String cpf_aluno) {
        this.cpf_aluno = cpf_aluno;
    }

    public int getId_cursos() {
        return id_cursos;
    }

    public void setId_cursos(int id_cursos) {
        this.id_cursos = id_cursos;
    }

    public String getDesc_cursos() {
        return desc_cursos;
    }

    public void setDesc_cursos(String desc_cursos) {
        this.desc_cursos = desc_cursos;
    }


    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public String getNome_Aluno() {
        return nome_Aluno;
    }

    public void setNome_Aluno(String nome_Aluno) {
        this.nome_Aluno = nome_Aluno;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    
        public void imprimir(){
        System.out.println("Id Aluno: "+getId_aluno()
        +"\n"+
        "Nome do Aluno: "+getNome_Aluno()+
                "\n"+
                "Cpf do aluno: "+getCpf_aluno()+
                "\n"+
                "Id do curso: "+getId_cursos()+
                "\n"+
                "Descrição do curso: "+getDesc_cursos()+
                "\n"+
                 "Duração do curso: "+getDur_cursos()+
                "\n"+
                "Descrição do Pagamento: "+getDescricao()
                +"\n"+
                "id do pagamento: "+getIdPagamento()
                +"\n"+
                "Valor do Pagamento: "+getValor()
                +"\n"+
                "Desconto: "+getDesconto()+"%"+
                "\n"+
                "Valor do desconto: "+calculadesconto()+
                "\n"+
                "Valor total: "+valortotal()+
                "\n------------------------------------"
                );
            
            
            
            /*System.out.println("O id do Pagamento é: " +getIdPagamento()+
               "\n"+"O valor de pagamento: "+getValor()+
               "\n"+ "total de desconto: "+getDesconto()+
       "\n"+"Data Pagamento: "+getDataPagamento()+
               "\n"+"Descrição: "+getDescricao());
        */
    }
    public double calculadesconto(){
        double valordesc = (getValor()/100)*getDesconto();
        return valordesc;
    }
    public double valortotal()
    {
    double total = valor - calculadesconto();
    return total;
    }
}
