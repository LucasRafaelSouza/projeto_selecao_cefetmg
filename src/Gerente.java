public class Gerente extends Funcionario{
    private static double SALARIO_BASE = 20000;

    public Gerente(String nome, int anoContratacao, int mesContratacao) {
        super(nome, anoContratacao, mesContratacao);

    }

    @Override
    public double obterSalario(int mes, int ano) {
        double salario = 0;
        if(ano >= this.getAnoContratacao()) {
            salario = (ano - this.getAnoContratacao()) * 3000 + SALARIO_BASE;
            if (mes < this.getMesContratacao() && (ano - this.getAnoContratacao() != 0)) {
                salario -= 3000;
            }
            if((ano == this.getAnoContratacao())&&(mes < this.getMesContratacao())){
                salario = 0;
            }
        }
        return salario;
    }

    @Override
    public double obterSalarioTotal(int mes, int ano) {


        return this.obterSalario(mes,ano);
    }
}
