
package clinicaodontologica;

import java.util.Scanner;


public class ClinicaOdontologica 
{    
    public static void main(String[] args) {
        menu();
    }
    
    public static void menu() {
        
        System.out.println("Quem é vc?");
        System.out.println("1 - Secretaria");
        System.out.println("2 - Dentista");
        Scanner leia = new Scanner(System.in);
        String sIndividuo = leia.nextLine();
        int individuo = Integer.valueOf(sIndividuo);
        
        if (individuo != 1 && individuo != 2) {
            System.out.println("Opção Inválida!");
            return;
        }
        System.out.println("Escolha o que voce deseja fazer:");
        System.out.println("1 - Gerenciar pacientes");
        System.out.println("2 - Gerenciar consultas");
        System.out.println("3 - Gerenciar Orçamento");

        String sOpcao = leia.nextLine();
        int opcao = Integer.valueOf(sOpcao);

        switch(opcao) {
            case 1:
                System.out.println("Escolha uma opção:\n"
                        + "1- Novo Cadastro\n"
                        + "2- Atualizar Cadastros\n"
                        + "3- Visualizar Cadastros\n"
                        + "4- Excluir Cadastro");

                String opcaos = leia.nextLine();
                int cadastros = Integer.valueOf(opcaos);
                if (cadastros == 1) {
                    Paciente cadastrar = new Paciente();
                    System.out.println("Digite o nome do paciente");
                    cadastrar.setNome(leia.nextLine());

                    System.out.println("Digite telefone do paciente");
                    cadastrar.setTelefone(leia.nextLine());

                    System.out.println("endereço do paciente");
                    cadastrar.setEndereco(leia.nextLine());

                    cadastrar.incluir();
                    System.out.println("Paciente Cadastrado!\n");
                }

                if (cadastros == 2) {
                    System.out.println("Qual o nome do paciente?");
                    String valor = leia.nextLine();
                    Paciente paciente = new Paciente(valor);
                    if (paciente.getNome() == null) {
                        System.out.println("Paciente não encontrado");
                        break;
                    }

                    System.out.println("Caso não queira alterar o valor dê somente um enter");
                    System.out.printf("Nome? (%s)\n", paciente.getNome());
                    valor = leia.nextLine();
                    if (!valor.equals("")) {
                        paciente.setNome(valor);
                    }

                    System.out.printf("Telefone? (%s)\n", paciente.getTelefone());
                    valor = leia.nextLine();
                    if (!valor.equals("")) {
                        paciente.setTelefone(valor);
                    }

                    System.out.printf("Endereco? (%s)\n", paciente.getEndereco());
                    valor = leia.nextLine();
                    if (!valor.equals("")) {
                        paciente.setEndereco(valor);
                    }

                    paciente.alterar();
                }

                if (cadastros == 3){
                    System.out.println("Qual o nome do paciente?");
                    String nome = leia.nextLine();
                    Paciente paciente = new Paciente(nome);
                    if (paciente.getNome() == null) {
                        System.out.println("Paciente não encontrado");
                        break;
                    }

                    System.out.println("\n ===== Paciente Encontrado ====="
                        +"\n nome: "+paciente.getNome()
                        +"\n endereco: "+paciente.getEndereco()
                        +"\n telefone: "+paciente.getTelefone()
                    );
                }

                if (cadastros == 4){
                    System.out.println("Qual o nome do paciente?");
                    String nome = leia.nextLine();
                    Paciente paciente = new Paciente(nome);
                    if (paciente.getNome() == null) {
                        System.out.println("Paciente não encontrado");
                        break;
                    }
                    paciente.excluir();
                }
                break;
            case 2:
                System.out.println("Escolha uma opção:\n"
                        + "1- Marcar consulta\n"
                        + "2- Atualizar Consulta\n"
                        + "3- Visualizar Consulta\n"
                        + "4- Excluir Consulta");

                String opcaos2 = leia.nextLine();
                int cadastros2 = Integer.valueOf(opcaos2);
                if(cadastros2 == 1){
                    String data = null;
                    Consulta cadastro = new Consulta(data);
                    System.out.println("Digite a data da consulta");
                    cadastro.setData(leia.nextLine());
                    System.out.println("Alguma observação?");
                    cadastro.setDetalhe(leia.nextLine());
                    cadastro.incluir();
                    System.out.println("Consulta Cadastrado!\n");
                }

                if(cadastros2 == 2){
                    System.out.println("Qual a data ?");
                    String data = leia.nextLine();
                    Consulta consulta = new Consulta(data);
                    if (consulta.getData() == null) {
                        System.out.println("Paciente não encontrado");
                        break;
                    }

                    System.out.println("Caso não queira alterar o valor dê somente um enter");
                    System.out.printf("Data? (%s)\n", consulta.getData());
                    data = leia.nextLine();
                    if (!data.equals("")) {
                        consulta.setData(data);
                    }

                    System.out.printf("Detalhe? (%s)\n", consulta.getDetalhe());
                    data = leia.nextLine();
                    if (!data.equals("")) {
                        consulta.setDetalhe(data);
                    }

                    consulta.alterar();
                }

                if(cadastros2 == 3){
                    System.out.println("Qual a data da consulta?");
                    String data = leia.nextLine();
                    Consulta consulta = new Consulta(data);
                    if (consulta.getData() == null) {
                        System.out.println("Consulta não encontrada");
                        break;
                    }

                    System.out.println("\n ===== Consulta Encontrada ====="
                        +"\n data: "+consulta.getData()
                        +"\n detalhe: "+consulta.getDetalhe()
                    );
                }

                if(cadastros2 == 4){
                    System.out.println("Qual a data da consulta?");
                    String data = leia.nextLine();
                    Consulta cadastro = new Consulta(data);
                    cadastro.excluir();
                }
                break;
            case 3:
                System.out.println("Escolha uma opção:\n"
                        + "1- Novo Orçamento\n"
                        + "2- Alterar Orçamentos\n"
                        + "3- Visualizar Orçamentos\n"
                        + "4- Excluir Orçamentos\n"
                        + "5- Gerar boleto");

                String opcaos3 = leia.nextLine();
                int cadastros3 = Integer.valueOf(opcaos3);
                if (cadastros3 == 1) {
                    Orcamento orcamento = new Orcamento();

                    System.out.println("Digite a data de consulta do paciente");
                    orcamento.setData(leia.nextLine());

                    System.out.println("Digite o tipo do orçamento");
                    orcamento.setTipo(leia.nextLine());

                    System.out.println("Valor da consulta");
                    orcamento.setValor(Float.valueOf(leia.nextLine()));

                    System.out.println("Observações: ");
                    orcamento.setDetalhes(leia.nextLine());

                    orcamento.incluir();
                }

                if (cadastros3 == 2) {
                    System.out.println("Qual a data ?");
                    String data = leia.nextLine();
                    Orcamento orcamento = new Orcamento(data);
                    if (orcamento.getData() == null) {
                        System.out.println("Orcamento não encontrado");
                        break;
                    }

                    System.out.println("Caso não queira alterar o valor dê somente um enter");
                    System.out.printf("Data? (%s)\n", orcamento.getData());
                    data = leia.nextLine();
                    if (!data.equals("")) {
                        orcamento.setData(data);
                    }

                    System.out.printf("Tipo? (%s)\n", orcamento.getTipo());
                    data = leia.nextLine();
                    if (!data.equals("")) {
                        orcamento.setTipo(data);
                    }

                    System.out.printf("Valor? (%.2f)\n", orcamento.getValor());
                    data = leia.nextLine();
                    if (!data.equals("")) {
                        orcamento.setValor(Float.valueOf(data));
                    }

                    System.out.printf("Detalhes? (%s)\n", orcamento.getDetalhes());
                    data = leia.nextLine();
                    if (!data.equals("")) {
                        orcamento.setDetalhes(data);
                    }

                    orcamento.alterar();
                }

                if(cadastros3 == 3) {
                    System.out.println("Qual a data da consulta?");
                    String data = leia.nextLine();
                    Orcamento orcamento = new Orcamento(data);
                    if (orcamento.getData() == null) {
                        System.out.println("Consulta não encontrada");
                        break;
                    }

                    System.out.println("\n ===== Orçamento Encontrada ====="
                            + "\n data: " + orcamento.getData()
                            + "\n tipo: " + orcamento.getTipo()
                            + "\n valor: " + orcamento.getValor()
                            + "\n detalhe: " + orcamento.getDetalhes()
                    );
                }

                if (cadastros3 == 4) {
                    System.out.println("Digite a data do orcamento");
                    Orcamento orcamen = new Orcamento(leia.nextLine());
                    orcamen.excluir();
                }

                if (cadastros3 == 5) {
                    System.out.println("Digite a data do orcamento");
                    Orcamento orcamen = new Orcamento(leia.nextLine());
                    if (orcamen.getData() == null) {
                        System.out.println("Orçamento não encontrado");
                        break;
                    }

                    orcamen.gerarBoleto();
                }
                break;
        }
        
    }
      
}
