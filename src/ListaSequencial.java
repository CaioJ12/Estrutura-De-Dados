import java.util.Scanner;

public class ListaSequencial {
    Scanner scanner;

    // array alunos para inserir os elementos
    Alunos[] elementos;
    int tamanho;
    int capacidade;

    // construindo "ListaSequencial"
    public ListaSequencial(Scanner scanner,int capacidade){
        this.scanner = scanner;
        this.capacidade = capacidade;
        this.elementos = new Alunos[capacidade];
        this.tamanho = 0;
    }

    //Avaliação de tamanho
    public boolean estaVazio(){
        return (tamanho == 0);
    }
    public boolean estaCheio(){
        return (tamanho == capacidade);
    }

    //Função adicionar alunos
    public void adicionarAlunos(Scanner scanner){
        do {
            if (estaCheio()){
                System.out.println("Capacidade máxima de alunos atingida.");
                return;
            }

            System.out.println("Digite o RGM do aluno: ");
            String rgm = scanner.nextLine();

            System.out.println("Digite o nome do aluno: ");
            String nome = scanner.nextLine();

            System.out.println("Digite o curso do aluno: ");
            String curso = scanner.nextLine();

            Alunos novoAluno = new Alunos(rgm, nome, curso);

            elementos[tamanho] = novoAluno;

            // Adicionar disciplinas ao aluno
            String maisDisciplina;
            do {
                System.out.println("Digite o nome da disciplina: ");
                String nomeDisciplina = scanner.nextLine();
                if (novoAluno.disciplinas == null) {
                    novoAluno.disciplinas = new ListaEncadeada();
                }
                novoAluno.disciplinas.inserir(nomeDisciplina);
                System.out.print("Deseja adicionar mais disciplinas[S/N]: ");
                maisDisciplina = scanner.nextLine();
            } while (maisDisciplina.equalsIgnoreCase("S"));
            tamanho++;
        }while (continuarOperacao("Deseja Adicionar mais Alunos[S/N]: "));
    }

    // Buscar Aluno pelo RGM
    public void buscarAluno(Scanner scanner){
        do {
            System.out.print("Digite o RGM do aluno a ser buscado: ");
            String rgmBusca = scanner.nextLine();
            boolean encontrado = false;
            for (int i = 0; i < tamanho; i++){
                if (elementos[i].rgm.equals(rgmBusca)) {
                    System.out.println("Aluno encontrado:");
                    System.out.println("--------");
                    System.out.println("Nome: " + elementos[i].nome);
                    System.out.println("RGM: " + elementos[i].rgm);
                    System.out.println("Disciplinas:");
                    if (elementos[i].disciplinas != null) {
                        Disciplinas disciplinaAtual = elementos[i].disciplinas.primeiro;
                        while (disciplinaAtual != null) {
                            System.out.println("- " + disciplinaAtual.nome);
                            disciplinaAtual = disciplinaAtual.proxima;
                        }
                        System.out.println("--------");
                    } else {
                        System.out.println("Este aluno não possui disciplinas cadastradas.");
                    }
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Aluno não encontrado.");
            }
        }while (continuarOperacao("Deseja Buscar mais por mais Alunos[S/N]: "));
    }

    // Remoção de Alunos
    public void removerAlunos(Scanner scanner){
        do {
            if (estaVazio()){
                System.out.println("A lista está Vazia.");
                return;
            }
            System.out.print("Digite o RGM do aluno a ser removido: ");
            String rgmRemover = scanner.nextLine();

            boolean removido = false;
            for (int i = 0; i < tamanho; i++) {
                if (elementos[i].rgm.equals(rgmRemover)) {
                    // Deslocar os alunos para remover o aluno encontrado
                    for (int j = i; j < tamanho - 1; j++) {
                        elementos[j] = elementos[j + 1];
                    }
                    tamanho--;
                    removido = true;
                    break;
                }
            }

            if (removido) {
                System.out.println("Aluno removido com sucesso.");
            } else {
                System.out.println("Aluno não encontrado.");
            }
        }while (continuarOperacao("Deseja Remover mais Alunos[S/N]: "));
    }

    //Funções "exibirAlunos" para exibir alunos
    public void exibirAlunos(){
        System.out.println("Lista de Alunos:");
        for (int i = 0; i < tamanho; i++) {
            System.out.println("--------");
            System.out.println("  RGM: " + elementos[i].rgm);
            System.out.println("  Nome: " + elementos[i].nome);
            System.out.println("  Curso: " + elementos[i].curso);
            System.out.println("  Disciplinas:");
            if (elementos[i].disciplinas != null) {
                Disciplinas disciplinaAtual = elementos[i].disciplinas.primeiro;
                while (disciplinaAtual != null) {
                    System.out.println("  - " + disciplinaAtual.nome);
                    disciplinaAtual = disciplinaAtual.proxima;
                }
                System.out.println("--------");
            } else {
                System.out.println("  Nenhuma disciplina cadastrada para este aluno.");
            }
        }
    }

    //Função "continuarOperação" para validar resposta dentro do código dentro de um processo de loop (exibriAlunos, excluirAlunos e etc...)"
    public boolean continuarOperacao(String mensagem) {
        while (true) {
            System.out.println(mensagem);
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("S")) {
                System.out.println("Certo, passando pergunta");
                return true;
            } else if (resposta.equalsIgnoreCase("N")) {
                System.out.println("Certo, encerrando processo");
                return false;
            } else {
                System.out.println("Resposta inválida, tente novamente");
            }
        }
    }

}
