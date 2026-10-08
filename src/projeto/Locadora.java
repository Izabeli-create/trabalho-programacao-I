package projeto;

import java.util.ArrayList;

public class Locadora {

    private String nome;
    private String endereco;

    private ArrayList<Cliente> clientes;
    private ArrayList<Filme> filmes;
    private ArrayList<Locacao> locacoes;

    public Locadora(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;

        clientes = new ArrayList<>();
        filmes = new ArrayList<>();
        locacoes = new ArrayList<>();
    }


    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void listarClientes() {

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public boolean atualizarCliente(String cpf, String telefone, String email) {

        for (Cliente cliente : clientes) {

            if (cliente.getCpf().equals(cpf)) {

                cliente.setTelefone(telefone);
                cliente.setEmail(email);

                return true;
            }
        }

        return false;
    }

    public boolean removerCliente(String cpf) {

        for (Cliente cliente : clientes) {

            if (cliente.getCpf().equals(cpf)) {
                clientes.remove(cliente);
                return true;
            }
        }

        return false;
    }



    public void cadastrarFilme(Filme filme) {
        filmes.add(filme);
        System.out.println("Filme cadastrado com sucesso!");
    }

    public void listarFilmes() {

        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }

        for (Filme filme : filmes) {
            System.out.println(filme);
        }
    }

    public boolean atualizarFilme(String titulo, String genero, int ano, String duracao) {

        for (Filme filme : filmes) {

            if (filme.getTitulo().equalsIgnoreCase(titulo)) {

                filme.setGenero(genero);
                filme.setAno(ano);
                filme.setDuracao(duracao);

                return true;
            }
        }

        return false;
    }

    public boolean removerFilme(String titulo) {

        for (Filme filme : filmes) {

            if (filme.getTitulo().equalsIgnoreCase(titulo)) {
                filmes.remove(filme);
                return true;
            }
        }

        return false;
    }

    public void realizarLocacao(
            String cpf,
            String titulo,
            String dataLocacao,
            double valor) {

        Cliente clienteEncontrado = null;
        Filme filmeEncontrado = null;

        for (Cliente cliente : clientes) {

            if (cliente.getCpf().equals(cpf)) {
                clienteEncontrado = cliente;
                break;
            }
        }

        for (Filme filme : filmes) {

            if (filme.getTitulo().equalsIgnoreCase(titulo)) {
                filmeEncontrado = filme;
                break;
            }
        }

        if (clienteEncontrado == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        if (filmeEncontrado == null) {
            System.out.println("Filme não encontrado.");
            return;
        }

        if (!filmeEncontrado.verificarDisponibilidade()) {
            System.out.println("Filme não está disponível.");
            return;
        }

        Locacao locacao = new Locacao(
                dataLocacao,
                valor,
                clienteEncontrado,
                filmeEncontrado
        );

        locacoes.add(locacao);

        filmeEncontrado.setDisponivel(false);

        System.out.println("Locação realizada com sucesso!");
    }

    public void devolverFilme(String titulo, String dataDevolucao) {

        for (Locacao locacao : locacoes) {

            if (locacao.getFilme().getTitulo().equalsIgnoreCase(titulo)
                    && locacao.getDataDevolucao().equals("")) {

                locacao.registrarDevolucao(dataDevolucao);

                System.out.println("Filme devolvido com sucesso!");
                return;
            }
        }

        System.out.println("Locação não encontrada.");
    }

    public void listarLocacoes() {

        if (locacoes.isEmpty()) {
            System.out.println("Nenhuma locação realizada.");
            return;
        }

        for (Locacao locacao : locacoes) {
            System.out.println(locacao);
        }
    }
}