package projeto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Locadora locadora = new Locadora("MovieLoc", "Videira - SC");

        int opcao;

        do {
            System.out.println("\n===== MOVIELOC =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Atualizar cliente");
            System.out.println("4 - Remover cliente");
            System.out.println("5 - Cadastrar filme");
            System.out.println("6 - Listar filmes");
            System.out.println("7 - Atualizar filme");
            System.out.println("8 - Remover filme");
            System.out.println("9 - Realizar locação");
            System.out.println("10 - Devolver filme");
            System.out.println("11 - Listar locações");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    System.out.println("\n--- CADASTRAR CLIENTE ---");

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    Cliente cliente = new Cliente(nome, cpf, telefone, email);

                    locadora.cadastrarCliente(cliente);
                    break;

                case 2:
                    System.out.println("\n--- CLIENTES CADASTRADOS ---");
                    locadora.listarClientes();
                    break;

                case 3:
                    System.out.println("\n--- ATUALIZAR CLIENTE ---");

                    System.out.print("Digite o CPF do cliente: ");
                    String cpfAtualizar = scanner.nextLine();

                    System.out.print("Novo telefone: ");
                    String novoTelefone = scanner.nextLine();

                    System.out.print("Novo email: ");
                    String novoEmail = scanner.nextLine();

                    if (locadora.atualizarCliente(cpfAtualizar, novoTelefone, novoEmail)) {
                        System.out.println("Cliente atualizado com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- REMOVER CLIENTE ---");

                    System.out.print("Digite o CPF do cliente: ");
                    String cpfRemover = scanner.nextLine();

                    if (locadora.removerCliente(cpfRemover)) {
                        System.out.println("Cliente removido com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("\n--- CADASTRAR FILME ---");

                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Gênero: ");
                    String genero = scanner.nextLine();

                    System.out.print("Ano: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Duração: ");
                    String duracao = scanner.nextLine();

                    Filme filme = new Filme(titulo, genero, ano, duracao);

                    locadora.cadastrarFilme(filme);
                    break;

                case 6:
                    System.out.println("\n--- FILMES CADASTRADOS ---");
                    locadora.listarFilmes();
                    break;

                case 7:
                    System.out.println("\n--- ATUALIZAR FILME ---");

                    System.out.print("Digite o título do filme: ");
                    String tituloAtualizar = scanner.nextLine();

                    System.out.print("Novo gênero: ");
                    String novoGenero = scanner.nextLine();

                    System.out.print("Novo ano: ");
                    int novoAno = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nova duração: ");
                    String novaDuracao = scanner.nextLine();

                    if (locadora.atualizarFilme(
                            tituloAtualizar,
                            novoGenero,
                            novoAno,
                            novaDuracao)) {

                        System.out.println("Filme atualizado com sucesso!");

                    } else {
                        System.out.println("Filme não encontrado.");
                    }
                    break;

                case 8:
                    System.out.println("\n--- REMOVER FILME ---");

                    System.out.print("Digite o título do filme: ");
                    String tituloRemover = scanner.nextLine();

                    if (locadora.removerFilme(tituloRemover)) {
                        System.out.println("Filme removido com sucesso!");
                    } else {
                        System.out.println("Filme não encontrado.");
                    }
                    break;

                case 9:
                    System.out.println("\n--- REALIZAR LOCAÇÃO ---");

                    System.out.print("CPF do cliente: ");
                    String cpfLocacao = scanner.nextLine();

                    System.out.print("Título do filme: ");
                    String tituloLocacao = scanner.nextLine();

                    System.out.print("Data da locação: ");
                    String dataLocacao = scanner.nextLine();

                    System.out.print("Valor da locação: R$ ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();

                    locadora.realizarLocacao(
                            cpfLocacao,
                            tituloLocacao,
                            dataLocacao,
                            valor
                    );

                    break;

                case 10:
                    System.out.println("\n--- DEVOLVER FILME ---");

                    System.out.print("Título do filme: ");
                    String tituloDevolucao = scanner.nextLine();

                    System.out.print("Data da devolução: ");
                    String dataDevolucao = scanner.nextLine();

                    locadora.devolverFilme(
                            tituloDevolucao,
                            dataDevolucao
                    );

                    break;

                case 11:
                    System.out.println("\n--- LOCAÇÕES ---");
                    locadora.listarLocacoes();
                    break;

                case 0:
                    System.out.println("\nSaindo do MovieLoc...");
                    break;

                default:
                    System.out.println("\nOpção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}

