import java.util.ArrayList;
import java.util.List;

class Filme {
    private String titulo;
    private int ano;
    private double orcamento;
    private String descricao;
    private Diretor diretor;
    private List<Ator> elenco;

    public Filme(String titulo, int ano, String descricao, double orcamento) {
        this.titulo = titulo;
        this.ano = ano;
        this.descricao = descricao;
        this.orcamento = orcamento;
        this.elenco = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public double getOrcamento() { return orcamento; }

    public void setOrcamento(double orcamento) { this.orcamento = orcamento; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void adicionarAtor(Ator ator) {
        elenco.add(ator);
    }

    public void exibirElenco() {
        System.out.println("Elenco do filme '" + titulo + "':");

        for (Pessoa ator : elenco) {
            ator.apresentar();
        }

        if(diretor != null) {
            System.out.print("Diretor: ");

            diretor.apresentar();
        }
    }
}
