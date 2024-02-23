import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Ator> atores = new ArrayList<>();
    private static List<Diretor> diretores = new ArrayList<>();
    private static List<Filme> filmes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;



            do {

                System.out.println("\nMENU:");
                System.out.println("1 - Cadastrar Ator");
                System.out.println("2 - Cadastrar Diretor");
                System.out.println("3 - Cadastrar Filme");
                System.out.println("4 - Associar Ator a Filme");
                System.out.println("5 - Associar Diretor a Filme");
                System.out.println("6 - Pesquisar Filme");
                System.out.println("7 - Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        cadastrarAtor(scanner);
                        break;
                    case 2:
                        cadastrarDiretor(scanner);
                        break;
                    case 3:
                        cadastrarFilme(scanner);
                        break;
                    case 4:
                        associarAtorAFilme(scanner);
                        break;
                    case 5:
                        associarDiretorAFilme(scanner);
                        break;
                    case 6:
                        pesquisarFilme(scanner);
                        break;
                    case 7:
                        System.out.println("Você saiu!");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } while (opcao != 7);


    }




    private static void cadastrarAtor(Scanner scanner) {
        System.out.print("Nome do ator: ");
        String nome = scanner.nextLine();
        int idade;
        while (true) {
            System.out.print("Idade do ator: ");
            if (scanner.hasNextInt()) {
                idade = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Por favor, insira um número para a idade.");
                scanner.nextLine();
            }
        }
        System.out.print("Nacionalidade do ator: ");
        String nacionalidade = scanner.nextLine();

        Ator ator = new Ator(nome, idade, nacionalidade);
        atores.add(ator);
        System.out.println("Ator cadastrado com sucesso.");
    }


    private static void cadastrarDiretor(Scanner scanner) {
        System.out.print("Nome do diretor: ");
        String nome = scanner.nextLine();
        int idade;
        while (true) {
            System.out.print("Idade do diretor: ");
            if (scanner.hasNextInt()) {
                idade = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Por favor, insira um número para a idade.");
                scanner.nextLine();
            }
        }

        int anosExperiencia;
        while (true) {
            System.out.print("Anos de experiência do diretor: ");
            if (scanner.hasNextInt()) {
                anosExperiencia = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Por favor, insira um número para os anos de experiência.");
                scanner.nextLine();
            }
        }

        Diretor diretor = new Diretor(nome, idade, anosExperiencia);
        diretores.add(diretor);
        System.out.println("Diretor cadastrado com sucesso.");
    }

    private static void cadastrarFilme(Scanner scanner) {
        System.out.print("Título do filme: ");
        String titulo = scanner.nextLine();

        int ano;
        while (true) {
            System.out.print("Ano do filme: ");
            if (scanner.hasNextInt()) {
                ano = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Por favor, insira um número para o ano do filme.");
                scanner.nextLine();
            }
        }

        System.out.print("Descrição do filme: ");
        String descricao = scanner.nextLine();

        double orcamento;
        while (true) {
            System.out.print("Orçamento do filme: ");
            if (scanner.hasNextDouble()) {
                orcamento = scanner.nextDouble();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Por favor, insira um número para o orçamento do filme.");
                scanner.nextLine();
            }
        }

        Filme filme = new Filme(titulo, ano, descricao, orcamento);
        filmes.add(filme);
        System.out.println("Filme cadastrado com sucesso.");
    }

    private static void associarAtorAFilme(Scanner scanner) {
        System.out.println("Selecione o filme:");
        listarFilmes();
        int indiceFilme = obterIndiceValido(scanner, filmes.size());
        if (indiceFilme == -1) return;
        Filme filme = filmes.get(indiceFilme);

        System.out.println("Selecione o ator:");
        listarAtores();
        int indiceAtor = obterIndiceValido(scanner, atores.size());
        if (indiceAtor == -1) return;
        Ator ator = atores.get(indiceAtor);

        filme.adicionarAtor(ator);
        System.out.println("Ator associado ao filme com sucesso.");
    }

    private static void associarDiretorAFilme(Scanner scanner) {
        System.out.println("Selecione o filme:");
        listarFilmes();
        int indiceFilme = obterIndiceValido(scanner, filmes.size());
        if (indiceFilme == -1) return;
        Filme filme = filmes.get(indiceFilme);

        System.out.println("Selecione o diretor:");
        listarDiretores();
        int indiceDiretor = obterIndiceValido(scanner, diretores.size());
        if (indiceDiretor == -1) return;
        Diretor diretor = diretores.get(indiceDiretor);

        filme.setDiretor(diretor);
        System.out.println("Diretor associado ao filme com sucesso.");
    }

    private static void pesquisarFilme(Scanner scanner) {
        System.out.print("Digite o título do filme: ");
        String titulo = scanner.nextLine().toLowerCase();

        for (Filme filme : filmes) {
            if (filme.getTitulo().toLowerCase().contains(titulo)) {
                filme.exibirElenco();
                return;
            }
        }
        System.out.println("Filme não encontrado.");
    }

    private static void listarAtores() {
        System.out.println("Lista de Atores:");
        for (int i = 0; i < atores.size(); i++) {
            System.out.println((i + 1) + " - " + atores.get(i).getNome());
        }
    }

    private static void listarDiretores() {
        System.out.println("Lista de Diretores:");
        for (int i = 0; i < diretores.size(); i++) {
            System.out.println((i + 1) + " - " + diretores.get(i).getNome());
        }
    }

    private static void listarFilmes() {
        System.out.println("Lista de Filmes:");
        for (int i = 0; i < filmes.size(); i++) {
            System.out.println((i + 1) + " - " + filmes.get(i).getTitulo());
        }
    }

    private static int obterIndiceValido(Scanner scanner, int tamanhoLista) {
        while (true) {
            int indice;
            if (scanner.hasNextInt()) {
                indice = scanner.nextInt();
                scanner.nextLine();
                if (indice < 1 || indice > tamanhoLista) {
                    System.out.println("Opção inválida.");
                } else {
                    return indice - 1;
                }
            } else {
                System.out.println("Por favor, insira um número para selecionar uma opção válida.");
                scanner.nextLine();
            }
        }
    }
}

