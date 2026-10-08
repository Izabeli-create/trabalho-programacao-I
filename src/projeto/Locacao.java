package projeto;

public class Locacao {

    private String dataLocacao;
    private String dataDevolucao;
    private double valor;

    private Cliente cliente;
    private Filme filme;

    public Locacao(String dataLocacao, double valor, Cliente cliente, Filme filme) {
        this.dataLocacao = dataLocacao;
        this.valor = valor;
        this.cliente = cliente;
        this.filme = filme;
        this.dataDevolucao = "";
    }

    public String getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Filme getFilme() {
        return filme;
    }

    public double calcularValor() {
        return valor;
    }

    public void registrarDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
        filme.setDisponivel(true);
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome()
                + " | Filme: " + filme.getTitulo()
                + " | Data da locação: " + dataLocacao
                + " | Data da devolução: " + dataDevolucao
                + " | Valor: R$ " + valor;
    }
}