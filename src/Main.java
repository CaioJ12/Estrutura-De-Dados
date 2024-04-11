import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // inicia objeto scanner de nome teclas
        Scanner teclas = new Scanner(System.in);
        // inicia um objeto "listaSequencial" e passa um parâmetro scanner
        ListaSequencial listaSequencial = new ListaSequencial(teclas,60);
        boolean saindo = false;

        //  loop do menu para verificar a validade da variável boolean
        do {
            exibirMenu(); // função que exibe menu
            String ops = teclas.nextLine();

            // recebendo dados do teclado e chamar a função equivalente
            switch (ops){
                case "1":
                    listaSequencial.adicionarAlunos(teclas);
                    listaSequencial.continuarOperacao("Voltar[S]");
                    break;
                case "2":
                    listaSequencial.buscarAluno(teclas);
                    listaSequencial.continuarOperacao("Voltar[S]");
                    break;
                case "3":
                    listaSequencial.exibirAlunos();
                    listaSequencial.continuarOperacao("Voltar[S]");
                    break;
                case "4":
                    listaSequencial.removerAlunos(teclas);
                    listaSequencial.continuarOperacao("Voltar[S]");
                    break;
                case "5":
                    saindo = confirmarSaida(teclas);
                    break;
                default:
                    System.out.println("\033[1;30;41mOpção Inválida Tente Novamente\033[m");
                    listaSequencial.continuarOperacao("Voltar[S]: ");
                    break;
            }
        }while (!saindo);
        teclas.close();

    }

    // Função de exibir menu
    private static void exibirMenu() {
        System.out.println("--------------------------");
        System.out.println("--- Cadastro de Alunos ---");
        System.out.println("--------------------------");
        System.out.println("[ 1 ] Inserir Alunos");
        System.out.println("[ 2 ] Buscar Alunos");
        System.out.println("[ 3 ] Mostrar Lista de Alunos");
        System.out.println("[ 4 ] Remover Alunos");
        System.out.println("[ 5 ] Sair");
        System.out.print("Informe sua Opção: ");
    }

    // Função de confirmar saidas
    private static boolean confirmarSaida(Scanner teclas) {
        System.out.print("Certeza que desejas sair [S/N]: ");
        String sair = teclas.nextLine().toUpperCase();
        if (sair.equalsIgnoreCase("S")) {
            System.out.println("Encerrando programa...");
            return true;
        } else if (sair.equalsIgnoreCase("N")) {
            System.out.println("Voltando ao programa...");
        } else {
            System.out.println("Opção Inválida! Voltando ao programa...");
        }
        return false;
    }

}