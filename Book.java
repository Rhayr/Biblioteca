public class Book {
    private String title;
    private String writer;
    private int yearPublication;
    private int pageNumbers;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }

    public int getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(int pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    public static void status() {
        System.out.println("Bem-vindo à Biblioteca Machado de Assis, escolha uma das opções abaixo:");
        System.out.println("1 - Cadastrar novo livro");
        System.out.println("2 - Listar livros");
        System.out.println("3 - Pesquisar livro");
        System.out.println("4 - Excluir livro");
        System.out.println("0 - Sair");
    }
}
