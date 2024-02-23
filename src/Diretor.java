class Diretor extends Pessoa {
    private int anosExperiencia;

    public Diretor(String nome, int idade, int anosExperiencia) {
        super(nome, idade);
        this.anosExperiencia = anosExperiencia;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    @Override
    public void apresentar() {
        System.out.println("Diretor: " + nome + " Anos de Experiencia: " + anosExperiencia + " anos Idade: " + idade + " anos.");
    }
}
