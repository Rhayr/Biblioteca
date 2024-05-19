import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> collection;

    public Library() {
        collection = new ArrayList<>();
    }

    public List<Book> getCollection() {
        return collection;
    }

    public void addBook(Book book) throws Exception {
        if (book == null) {
            throw new Exception("Objeto não pode ser nulo");
        }
        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            throw new Exception("O título é um campo obrigatório");
        }
        if (book.getWriter() == null || book.getWriter().isEmpty()) {
            throw new Exception("O autor é um campo obrigatório");
        }
        collection.add(book);
    }

    public void register(Scanner scan) {
        System.out.println("Digite o título:");
        String title = scan.nextLine();
        System.out.println("Digite o nome do autor:");
        String writer = scan.nextLine();

        int year = 0;
        boolean validYear = false;
        while (!validYear) {
            System.out.println("Digite o ano de publicação:");
            if (scan.hasNextInt()) {
                year = scan.nextInt();
                validYear = true;
            } else {
                System.out.println("Ano inválido. Por favor, insira um número inteiro.");
                scan.next();
            }
        }

        scan.nextLine();
        int pages = 0;
        boolean validPages = false;

        while (!validPages) {
            System.out.println("Digite o número de páginas:");
            if (scan.hasNextInt()) {
                pages = scan.nextInt();
                validPages = true;
            } else {
                System.out.println("Número de páginas inválido. Por favor, insira um número inteiro.");
                scan.next();
            }
        }
        scan.nextLine();

        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setWriter(writer);
        newBook.setYearPublication(year);
        newBook.setPageNumbers(pages);

        try {
            addBook(newBook);
            System.out.println(title + " cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listBooks() {
        List<Book> books = getCollection();
        if (books.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            System.out.println("Livros do Acervo:");
            for (Book book : books) {
                System.out.println(" - Título: " + book.getTitle());
                System.out.println(" - Autor: " + book.getWriter());
                System.out.println(" - Ano de publicação: " + book.getYearPublication());
                System.out.println(" - Número de Páginas: " + book.getPageNumbers());
            }
        }
    }

    public void searchBook(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : collection) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                foundBooks.add(book);
            }
        }
        if (foundBooks.isEmpty()) {
            System.out.println("Nenhum livro encontrado com o título: " + title);
        } else {
            System.out.println("Livros encontrados:");
            for (Book book : foundBooks) {
                System.out.println(" - Título: " + book.getTitle());
                System.out.println(" - Autor: " + book.getWriter());
                System.out.println(" - Ano de publicação: " + book.getYearPublication());
                System.out.println(" - Número de Páginas: " + book.getPageNumbers());
            }
        }
    }

    public void excludeBook(String title) {
        boolean deleteBook = false;
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getTitle().equalsIgnoreCase(title)) {
                collection.remove(i);
                deleteBook = true;
                break;
            }
        }
        if (deleteBook) {
            System.out.println("Livro removido com sucesso.");
        } else {
            System.out.println("Nenhum livro encontrado com esse título: " + title);
        }
    }
}
