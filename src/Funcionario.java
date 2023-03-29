public abstract class Funcionario {
    private String nome;
    private int anoContratacao;
    private int mesContratacao;

    public Funcionario(String nome, int anoContratacao, int mesContratacao) {
        this.nome = nome;
        this.anoContratacao = anoContratacao;
        this.mesContratacao = mesContratacao;
    }

    public abstract double obterSalario(int mes, int ano);
    public abstract double obterSalarioTotal(int mes, int ano);
    public int getAnoContratacao() {
        return anoContratacao;
    }

    public void setAnoContratacao(int anoContratacao) {
        this.anoContratacao = anoContratacao;
    }

    public int getMesContratacao() {
        return mesContratacao;
    }

    public void setMesContratacao(int mesContratacao) {
        this.mesContratacao = mesContratacao;
    }

    public String  getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
