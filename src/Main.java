/*
* Autores: Anderson Bezerra da Rocha
*          Denise Pires de Souza
*          Marcos Antônio Custódio
* */

public class Main {
    public static void main(String[] args) {

        //Declaração das variáveis

        String nome;
        String tipoVeiculo = "";
        int opcaoTipo;
        String servico = "";
        int opcaoServico;
        double valorASerPago = 0;
        int qtdVeiculoTipo1 = 0;
        int qtdVeiculoTipo2 = 0;
        int qtdVeiculoTipo3 = 0;
        int qtdServicoTipo1 = 0;
        int qtdServicoTipo2 = 0;
        int qtdServicoTipo3 = 0;
        String tipoVeiculoComMaiorQuantidade = "";
        String servicoComMaiorQuantidade = "";
        double valorTotalArrecadado = 0;

        //Entrada da quantidade de atendimentos que serão processados

        int qtdAtendimentos = Integer.parseInt(IO.readln("Informe a quantidade de atendimentos que serão processados: "));

        //Estrutura de repetição for para auxiliar na entrada dos dados dos usuários do sistema

        for (int i = 1; i <= qtdAtendimentos; i++) {
            System.out.printf("Informe o nome do %dº cliente: ", i);
            nome = IO.readln();

            //Estrutura de repetição do-while para receber e validar o tipo de veículo

            do {
                System.out.println("Informe o tipo do veículo, escolhendo uma das opções abaixo: ");
                System.out.println("1 - Pequeno (populares)");
                System.out.println("2 - Médio (SUV e picape)");
                System.out.println("3 - Grande (van e micro-ônibus)");

                opcaoTipo = Integer.parseInt(IO.readln());
                switch (opcaoTipo) {
                    case 1:
                        tipoVeiculo = "Pequeno";
                        qtdVeiculoTipo1++;
                        break;
                    case 2:
                        tipoVeiculo = "Médio";
                        qtdVeiculoTipo2++;
                        break;
                    case 3:
                        tipoVeiculo = "Grande";
                        qtdVeiculoTipo3++;
                        break;
                    default:
                        System.out.println("Opção inválida! Escolha novamente:");
                }
            } while (opcaoTipo < 1 || opcaoTipo > 3);

            //Estrutura de repetição do-while para receber e validar o tipo de serviço

            do {
                System.out.println("Informe o serviço a ser realizado, escolhendo uma das opções abaixo: ");
                System.out.println("1 - Lavação externa");
                System.out.println("2 - Lavação externa + interna");
                System.out.println("3 - Lavação externa + interna + cera");

                opcaoServico = Integer.parseInt(IO.readln());
                switch (opcaoServico) {
                    case 1:
                        servico = "Lavação externa";
                        qtdServicoTipo1++;
                        break;
                    case 2:
                        servico = "Lavação externa + interna";
                        qtdServicoTipo2++;
                        break;
                    case 3:
                        servico = "Lavação externa + interna + cera";
                        qtdServicoTipo3++;
                        break;
                    default:
                        System.out.println("Opção inválida! Escolha novamente:");
                }
            } while (opcaoServico < 1 || opcaoServico > 3);

            //Utilização de if-else para calcular o valor do serviço escolhido por cada cliente

            if (opcaoTipo == 1 && opcaoServico == 1) {
                valorASerPago = 80;
            } else if (opcaoTipo == 1 && opcaoServico == 2) {
                valorASerPago = 100;
            } else if (opcaoTipo == 1 && opcaoServico == 3) {
                valorASerPago = 120;
            } else if (opcaoTipo == 2 && opcaoServico == 1) {
                valorASerPago = 100;
            } else if (opcaoTipo == 2 && opcaoServico == 2) {
                valorASerPago = 120;
            } else if (opcaoTipo == 2 && opcaoServico == 3) {
                valorASerPago = 140;
            } else if (opcaoTipo == 3 && opcaoServico == 1) {
                valorASerPago = 120;
            } else if (opcaoTipo == 3 && opcaoServico == 2) {
                valorASerPago = 140;
            } else if (opcaoTipo == 3 && opcaoServico == 3) {
                valorASerPago = 160;
            }

            //Cálculo do valor total arrecadado de todos os atendimentos

            valorTotalArrecadado += valorASerPago;

            //Imprime na tela os dados de cada cliente, junto com os serviços utilizados por cada um

            System.out.printf("Cliente: %s%nTipo de veículo: %s%nServiço contratado: %s%nValor a ser pago: R$ %.2f%n%n", nome, tipoVeiculo, servico, valorASerPago);
        }

        //Imprime na tela os percentuais dos atendimentos pelo tipo do veículo

        System.out.println("##################################################\n");
        System.out.printf("Percentuais dos atendimentos pelo tipo do veículo:%nVeículo tipo 1: %.2f%s%nVeículo tipo 2: %.2f%s%nVeículo tipo 3: %.2f%s%n",
                ((double) qtdVeiculoTipo1 / qtdAtendimentos) * 100, "%", ((double) qtdVeiculoTipo2 / qtdAtendimentos) * 100, "%", ((double) qtdVeiculoTipo3 / qtdAtendimentos) * 100, "%");
        System.out.println("\n##################################################");

        //Imprime na tela os percentuais dos atendimentos pelo serviço

        System.out.println("##################################################\n");
        System.out.printf("Percentuais dos atendimentos pelo serviço:%nLavação externa: %.2f%s%nLavação externa + interna: %.2f%s%nLavação externa + interna + cera: %.2f%s%n",
                ((double) qtdServicoTipo1 / qtdAtendimentos) * 100, "%", ((double) qtdServicoTipo2 / qtdAtendimentos) * 100, "%", ((double) qtdServicoTipo3 / qtdAtendimentos) * 100, "%");
        System.out.println("\n##################################################");

        //Imprime na tela o valor total arrecadado

        System.out.println("##################################################\n");
        System.out.printf("Valor total arrecadado: R$ %.2f%n", valorTotalArrecadado);
        System.out.println("\n##################################################");

        //Compara e imprime na tela qual(is) o(s) tipo(s) do veículo foi(foram) o(s) mais atendido(s)

        if (qtdVeiculoTipo1 > qtdVeiculoTipo2 && qtdVeiculoTipo1 > qtdVeiculoTipo3) {
            tipoVeiculoComMaiorQuantidade = "Tipo 1";
        } else if (qtdVeiculoTipo2 > qtdVeiculoTipo1 && qtdVeiculoTipo2 > qtdVeiculoTipo3) {
            tipoVeiculoComMaiorQuantidade = "Tipo 2";
        } else if (qtdVeiculoTipo3 > qtdVeiculoTipo1 && qtdVeiculoTipo3 > qtdVeiculoTipo2) {
            tipoVeiculoComMaiorQuantidade = "Tipo 3";
        }else if (qtdVeiculoTipo1 == qtdVeiculoTipo2 && qtdVeiculoTipo1 == qtdVeiculoTipo3) {
            tipoVeiculoComMaiorQuantidade = "Tipo 1, Tipo 2 e Tipo 3";
        } else if (qtdVeiculoTipo1 == qtdVeiculoTipo2) {
            tipoVeiculoComMaiorQuantidade = "Tipo 1 e Tipo 2";
        }else if (qtdVeiculoTipo1 == qtdVeiculoTipo3) {
            tipoVeiculoComMaiorQuantidade = "Tipo 1 e Tipo 3";
        }else if (qtdVeiculoTipo2 == qtdVeiculoTipo3) {
            tipoVeiculoComMaiorQuantidade = "Tipo 2 e Tipo 3";
        }
        System.out.println("##################################################\n");
        System.out.printf("Tipo(s) de veículo(s) mais atendido(s): %s%n", tipoVeiculoComMaiorQuantidade);
        System.out.println("\n##################################################");

        //Compara e imprime na tela qual(is) o(s) serviço(s) foi(foram) o(s) mais atendido(s)

        if (qtdServicoTipo1 > qtdServicoTipo2 && qtdServicoTipo1 > qtdServicoTipo3) {
            servicoComMaiorQuantidade = "Lavação externa";
        } else if (qtdServicoTipo2 > qtdServicoTipo1 && qtdServicoTipo2 > qtdServicoTipo3) {
            servicoComMaiorQuantidade = "Lavação externa + interna";
        } else if (qtdServicoTipo3 > qtdServicoTipo1 && qtdServicoTipo3 > qtdServicoTipo2) {
            servicoComMaiorQuantidade = "Lavação externa + interna + cera";
        }else if (qtdServicoTipo1 == qtdServicoTipo2 && qtdServicoTipo1 == qtdServicoTipo3) {
            servicoComMaiorQuantidade = "Lavação externa, Lavação externa + interna e Lavação externa + interna + cera";
        }else if (qtdServicoTipo1 == qtdServicoTipo2) {
            servicoComMaiorQuantidade = "Lavação externa e Lavação externa + interna";
        }else if (qtdServicoTipo1 == qtdServicoTipo3) {
            servicoComMaiorQuantidade = "Lavação externa e Lavação externa + interna + cera";
        }else if (qtdServicoTipo2 == qtdServicoTipo3) {
            servicoComMaiorQuantidade = "Lavação externa + interna e Lavação externa + interna + cera";
        }

        System.out.println("##################################################\n");
        System.out.printf("Tipo(s) de serviço(s) mais utilizado(s): %s%n", servicoComMaiorQuantidade);
        System.out.println("\n##################################################");
    }
}
