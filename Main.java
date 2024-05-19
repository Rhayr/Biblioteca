import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Library library = new Library();
        boolean running = true;

        while (running) {
            clearScreen();
            Book.status();
            int option = 0;
            boolean validEntry = false;
            
            while (!validEntry) {
                try {
                    System.out.print("Escolha uma opção: ");
                    option = Integer.parseInt(scan.nextLine());
                    validEntry = true;
                } catch (NumberFormatException e) {
                    System.out.println("Opção inválida. Por favor insira um número.");
                    proceed(scan);
                }   
            }

            switch (option) {
                case 1:
                    System.out.println("1 - Cadastrar livro:");
                    library.register(scan);
                    proceed(scan);
                    break;

                case 2:
                    System.out.println("2 - Listar livros:");
                    library.listBooks();
                    proceed(scan);
                    break;

                case 3:
                    System.out.println("3 - Pesquisar livro:");
                    System.out.print("Digite o título do livro: ");
                    String title = scan.nextLine();
                    library.searchBook(title);
                    proceed(scan);
                    break;

                case 4:
                    System.out.println("4 - Excluir livro");
                    System.out.print("Digite o título do livro: ");
                    String title2 = scan.nextLine();
                    library.excludeBook(title2);
                    proceed(scan);
                    break;

                case 0:
                    System.out.println("0 - Sair");
                    running = false;
                    proceed(scan);
                    break;
    
                default:
                    System.out.println("Opção inválida, tente novamente");
                    proceed(scan);
                    break;     
            }
        }
        scan.close(); 
    }

    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Ocorreu um erro ao tentar limpar a tela: " + e.getMessage());
        }
    }
    
    private static void proceed(Scanner scan) {
        System.out.println("Pressione ENTER para continuar.");
        scan.nextLine();
    }
}
