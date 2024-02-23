class Ator extends Pessoa {
    private String nacionalidade;

    public Ator(String nome, int idade, String nacionalidade) {
        super(nome, idade);
        this.nacionalidade = nacionalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public void apresentar() {
        System.out.println("Ator: " + nome + " Nacionalidade: " + nacionalidade + " Idade: " + idade + " anos.");
    }
}
