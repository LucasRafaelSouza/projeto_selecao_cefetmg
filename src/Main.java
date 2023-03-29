
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //definição dos métodos requisitados
    static double retornaSalarioTotal (ArrayList<Funcionario> lista, int mes, int ano){
        double salario = 0;
        for(Funcionario funcionario: lista){
            System.out.println(funcionario.getNome());
            System.out.println(funcionario.obterSalarioTotal(mes,ano));
            salario += funcionario.obterSalarioTotal(mes,ano);
        }

        return salario;
    }

    static double retornaSalario (ArrayList<Funcionario> lista, int mes, int ano){
        double salario = 0;
        for(Funcionario funcionario: lista){

            salario += funcionario.obterSalario(mes,ano);
        }

        return salario;
    }

    static double retornaBeneficio(ArrayList<Funcionario> lista, int mes, int ano){
        double salario = 0;
        for(Funcionario funcionario: lista){
            if(!(funcionario instanceof Gerente)){

            salario += funcionario.obterSalarioTotal(mes,ano) -  funcionario.obterSalario(mes,ano);
            }
        }
        return salario;
    }

    static Funcionario retornaMaiorValor (ArrayList<Funcionario> lista, int mes, int ano){
        double maiorValor = 0;
        Funcionario nome = null;
        for(Funcionario funcionario: lista){
            if(funcionario.obterSalarioTotal(mes,ano) >= maiorValor){
                maiorValor = funcionario.obterSalarioTotal(mes,ano);
                nome =  funcionario;
            }

        }

        return nome;
    }

    static Funcionario retornaMaiorBeneficio(ArrayList<Funcionario> lista, int mes, int ano){
        double maiorBeneficio = 0, beneficio;
        Funcionario nome = null ;
        for(Funcionario funcionario: lista){
            if(!(funcionario instanceof Gerente)){ //por não possuir beneficios
                beneficio = funcionario.obterSalarioTotal(mes,ano) -  funcionario.obterSalario(mes,ano);
                if(beneficio >= maiorBeneficio){
                    maiorBeneficio =  beneficio;
                    nome = funcionario;
                }
            }
        }
        return nome;
    }

    static Funcionario retornaMaiorVenda(ArrayList<Funcionario> lista, int mes, int ano){
        double maiorVenda = 0, venda;
        Funcionario nome = null;
        for(Funcionario funcionario: lista){
            if(funcionario instanceof Vendedor){ //verificação para garantir que apenas vendedores sejam considerados
                venda = funcionario.obterSalarioTotal(mes,ano) -  funcionario.obterSalario(mes,ano);
                if(venda >= maiorVenda){
                    maiorVenda =  venda;
                    nome = funcionario;
                }
            }
        }
        return nome;
    }


    public static void main(String[] args) {

        Secretario func1 =  new Secretario("Jorge Carvalho",2018,1);
        Secretario func2 =  new Secretario("Maria Souza",2015,12);

        Vendedor func3 =  new Vendedor("Ana Silva",2021,12);
        Vendedor func4 =  new Vendedor("Joao Mendes",2021,12);

        Gerente func5 =  new Gerente("Juliana Alves",2017,7);
        Gerente func6 =  new Gerente("Bento Albino",2014,3);

        ArrayList <Funcionario> lista = new ArrayList<Funcionario>();
        lista.add(func3); lista.add(func1); lista.add(func2);
        lista.add(func4); lista.add(func5); lista.add(func6);



        Scanner ler = new Scanner(System.in);
        int ano, mes;

        while(true){
            System.out.printf("\tSelecione um dos numeros indicados para utilizar a funcionalidade desejada.\n" +
                    "1 -> Retorna o valor total pago aos funcionarios\n2 -> Retorna o valor pago somente em salarios aos funcionarios\n" +
                    "3 -> Retorna o valor pago em beneficios as funcionarios\n4 -> Retorna o funcionario que recebeu o maior valor total\n" +
                    "5 -> Retorna o funcionario que recebeu o maior valor em beneficios\n6 -> Retorna o vendedor que realizou a maior venda\n" +
                    "7 -> finalizar\n-->");
            int n = ler.nextInt();

            switch (n) {

                case 1:
                    System.out.println("Digite o mes desejado:");
                    mes = ler.nextInt();
                    System.out.println("Digite o ano desejado:");
                    ano = ler.nextInt();
                    System.out.printf("\nO valor total pago aos funcionarios em %d/%d foi: %,.2f\n\n",mes,ano,retornaSalarioTotal(lista,mes,ano));
                    break;
                case 2:
                    System.out.println("Digite o mes desejado:");
                    mes = ler.nextInt();
                    System.out.println("Digite o ano desejado:");
                    ano = ler.nextInt();
                    System.out.printf("\nO valor pago somente em salarios aos funcionarios em %d/%d foi: %,.2f\n\n",mes,ano,retornaSalario(lista,mes,ano));
                    break;
                case 3:
                    System.out.println("Digite o mes desejado:");
                    mes = ler.nextInt();
                    System.out.println("Digite o ano desejado:");
                    ano = ler.nextInt();
                    System.out.printf("\nO valor pago em beneficios aos funcionarios em %d/%d foi: %,.2f\n\n",mes,ano,retornaBeneficio(lista,mes,ano));
                    break;
                case 4:
                    System.out.println("Digite o mes desejado:");
                    mes = ler.nextInt();
                    System.out.println("Digite o ano desejado:");
                    ano = ler.nextInt();
                    System.out.printf("\n%s foi o funcionario(a) que recebeu o maior valor total nesta data %d/%d\n\n",retornaMaiorValor(lista,mes,ano).getNome(),mes,ano);
                    break;
                case 5:
                    System.out.println("Digite o mes desejado:");
                    mes = ler.nextInt();
                    System.out.println("Digite o ano desejado:");
                    ano = ler.nextInt();
                    System.out.printf("\n%s foi o funcionario(a) que recebeu o maior valor em beneficios nesta data %d/%d\n\n",retornaMaiorBeneficio(lista,mes,ano).getNome(),mes,ano);
                    break;
                case 6:
                    System.out.println("Digite o mes desejado:");
                    mes = ler.nextInt();
                    System.out.println("Digite o ano desejado:");
                    ano = ler.nextInt();
                    if((ano<2021)||(ano==2021 && mes<12)||(ano>2022)||(ano == 2022 && mes > 4)){
                        System.out.println("Nenhum vendedor(a) esta registrado nesta data, ou nenhuma venda foi realizada nesta data.");
                    }
                    else {
                        System.out.printf("\n%s foi o vendedor(a) que efetuou a maior venda nesta data %d/%d\n\n", retornaMaiorVenda(lista, mes, ano).getNome(), mes, ano);
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Comando nao identificado.");
                    break;

            }
        }
    }
}