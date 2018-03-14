package Controller;

import DAO.BookDAO;
import DAO.CompactDiskDAO;
import DAO.GameDAO;
import Model.Book;
import Model.CompactDisk;
import Model.Game;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by e077272 on 3/12/2018.
 */
public class Controller {

    protected static List<Book> bookList = new ArrayList<Book>();
    protected static List<CompactDisk> compactDiskList = new ArrayList<CompactDisk>();
    protected static List<Game> gameList = new ArrayList<Game>();

    public static String showMainMenu(){
        System.out.println("Hello, welcome to Genus Store which operation you would like to do?\n");
        System.out.println(" - (A)dd new product");
        System.out.println(" - (I)ncrease same product");
        System.out.println(" - (R)emove product");
        System.out.println(" - (S)ell product");
        System.out.println(" - List (G)ames");
        System.out.println(" - List (B)ooks");
        System.out.println(" - List (C)Ds");
        System.out.println(" - (E)xit\n");
        System.out.println("Hit the letter then ENTER!: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
    public static void goToSelectedMenu(String option){
        char selected = option.charAt(0);
        switch (selected){
            case 'A':
                addNewProductMenu();
                break;
            case 'B':
                listBooks();
                break;
            case 'C':
                listCds();
                break;
            case 'G':
                listGames();
                break;
            case 'I':
                increaseProductMenu();
                break;
            case 'R':
                removeProductMenu();
                break;
            case 'S':
                sellProductMenu();
                break;
            default:
                System.out.println(" --- Invalid option --- ");
                break;
        }
    }

    private static void sellProductMenu() {
    }

    private static void removeProductMenu() {
    }

    private static void listGames() {
        System.out.println(" --- Games list --- ");
        Collections.sort(gameList);
        System.out.println(gameList);
    }

    private static void listCds() {
        System.out.println(" --- CDs list --- ");
        Collections.sort(compactDiskList);
        System.out.println(compactDiskList);
    }

    private static void listBooks() {
        System.out.println(" --- Books list --- ");
        Collections.sort(bookList);
        System.out.println(bookList);
    }

    private static void increaseProductMenu() {
        System.out.println("You are in the increase a product menu," +
                "choose what kind of media you want to increase\n");
        showProductOptions();
        Scanner scanner = new Scanner(System.in);
        goToIncreaseSelectedMedia(scanner.next().toUpperCase());
    }

    private static void goToIncreaseSelectedMedia(String option) {
        char selected = option.charAt(0);
        switch (selected){
            case 'B':
                increaseBook();
                break;
            case 'G':
                increaseGame();
                break;
            case 'C':
                increaseCompactDisk();
                break;
            default:
                System.out.println(" --- Invalid option --- ");
        }
    }

    private static void addNewProductMenu() {
        System.out.flush();
        System.out.println("You are in the add a product menu," +
                "choose what kind of media you want to add\n");
        showProductOptions();
        Scanner scanner = new Scanner(System.in);
        goToAddSelectedMedia(scanner.next().toUpperCase());
    }

    private static void showProductOptions() {
        System.out.println(" - (B)ook");
        System.out.println(" - (G)ame");
        System.out.println(" - (C)D");
        System.out.println("Hit the letter then ENTER!: ");
    }

    private static void goToAddSelectedMedia(String option) {
        char selected = option.charAt(0);
        switch (selected){
            case 'B':
                addBook();
                break;
            case 'G':
                addGame();
                break;
            case 'C':
                addCompactDisk();
                break;
            default:
                System.out.println(" --- Invalid option --- ");
        }
    }

    private static void addCompactDisk() {
        CompactDisk newCd = CompactDiskDAO.addNewCompactDisk();
        compactDiskList.add(newCd);
    }

    private static void addGame() {
        Game newGame = GameDAO.addNewGame();
        gameList.add(newGame);
    }

    private static void addBook() {
       Book newBook = BookDAO.addNewBook();
       bookList.add(newBook);
    }

    private static void increaseCompactDisk() {
        System.out.println("Choose which CD (by id) you want to add:");
        listCds();
        System.out.println("Type the Id number then ENTER!: ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        System.out.println("Now type how much itens are entering in stock:");
        scanner = new Scanner(System.in);
        Integer quantity = scanner.nextInt();
        CompactDiskDAO.increaseStockQuantity(id, quantity, compactDiskList);
    }

    private static void increaseGame() {
        System.out.println("Choose which Game (by id) you want to add:");
        listGames();
        System.out.println("Type the Id number then ENTER!: ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        System.out.println("Now type how much itens are entering in stock:");
        scanner = new Scanner(System.in);
        Integer quantity = scanner.nextInt();
        GameDAO.increaseStockQuantity(id, quantity, gameList);
    }

    private static void increaseBook() {
        System.out.println("Choose which Book (by id) you want to add:");
        listBooks();
        System.out.println("Type the Id number then ENTER!: ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        System.out.println("Now type how much itens are entering in stock:");
        scanner = new Scanner(System.in);
        Integer quantity = scanner.nextInt();
        BookDAO.increaseStockQuantity(id,quantity, bookList);
    }
}
