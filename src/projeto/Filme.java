package projeto;

public class Filme {

    private String titulo;
    private String genero;
    private int ano;
    private String duracao;
    private boolean disponivel;

    public Filme(String titulo, String genero, int ano, String duracao) {
        this.titulo = titulo;
        this.genero = genero;
        this.ano = ano;
        this.duracao = duracao;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean verificarDisponibilidade() {
        return disponivel;
    }

    @Override
    public String toString() {
        return "Título: " + titulo
                + " | Gênero: " + genero
                + " | Ano: " + ano
                + " | Duração: " + duracao
                + " | Disponível: " + disponivel;
    }
}