public class Secretario extends Funcionario{
    private static double SALARIO_BASE = 7000.0;

    public Secretario(String nome, int anoContratacao, int mesContratacao) {
        super(nome, anoContratacao, mesContratacao);

    }

    @Override
    public double obterSalario(int mes, int ano) {
        double salario = 0;
        if(ano >= this.getAnoContratacao()) {
            salario = (ano - this.getAnoContratacao()) * 1000.0 + SALARIO_BASE;
            if (mes < this.getMesContratacao() && (ano - this.getAnoContratacao() != 0)) {
                salario -= 1000.0;
            }
            if((ano == this.getAnoContratacao())&&(mes < this.getMesContratacao())){
                salario = 0;
            }
        }
        return salario;
    }

    @Override
    public double obterSalarioTotal(int mes, int ano) {


        return this.obterSalario(mes,ano)*1.2;
    }
}
