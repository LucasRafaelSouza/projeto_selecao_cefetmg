import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Vendedor extends Funcionario{
    //Usando hashmaps aninhados para armazenar o registo de vendas de cada vendedor
    private static Map<String, Map<String, Double>> REGISTRO_VENDAS = new HashMap<>();
    private static double SALARIO_BASE = 12000;

    public Vendedor(String nome, int anoContratacao, int mesContratacao) {
        super(nome, anoContratacao, mesContratacao);
        //o hashmap será acessado na forma: Nome --> data da venda --> valor da venda.
        Map<String, Double> dataVendasAna = new HashMap<>();
        Map<String, Double> dataVendasJoao = new HashMap<>();
        dataVendasAna.put("122021", 5200.0); dataVendasJoao.put("122021", 3400.0);
        dataVendasAna.put("012022", 5200.0); dataVendasJoao.put("012022", 7700.0);
        dataVendasAna.put("022022", 4200.0); dataVendasJoao.put("022022", 5000.0);
        dataVendasAna.put("032022", 5850.0); dataVendasJoao.put("032022", 5900.0);
        dataVendasAna.put("042022", 7000.0); dataVendasJoao.put("042022", 6500.0);

        REGISTRO_VENDAS.put("Ana Silva",dataVendasAna);
        REGISTRO_VENDAS.put("Joao Mendes",dataVendasJoao);
    }

    @Override
    public double obterSalario(int mes, int ano) {
        double salario = 0;
        if(ano >= this.getAnoContratacao()) {
            salario = (ano - this.getAnoContratacao()) * 1800 + SALARIO_BASE;
            if (mes < this.getMesContratacao() && (ano - this.getAnoContratacao() != 0)) {
                salario -= 1800;
            }
            if((ano == this.getAnoContratacao())&&(mes < this.getMesContratacao())){
                salario = 0;
            }
        }
        return salario;

    }

    @Override
    public double obterSalarioTotal(int mes, int ano) {
        double salario = obterSalario(mes,ano);
        if(REGISTRO_VENDAS.containsKey(this.getNome())){
            Set<String> chaves = REGISTRO_VENDAS.get(this.getNome()).keySet();
            for (String chave: chaves){
                //retirando o mes e o ano de cada chave
                int m = Integer.parseInt(chave.substring(0,2));
                int a = Integer.parseInt(chave.substring(2,6));
                if(a==ano && m == mes){
                    salario += REGISTRO_VENDAS.get(this.getNome()).get(chave)*0.3;
                    break;
                }
            }

        }
        return salario;
    }
}
