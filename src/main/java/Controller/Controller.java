package Controller;

import DAO.BookDAO;
import DAO.CompactDiskDAO;
import DAO.GameDAO;
import Model.Book;
import Model.CompactDisk;
import Model.Game;
import MyException.StockNotAvailableException;

import java.util.*;

/**
 * Created by e077272 on 3/12/2018.
 */
public class Controller {

    private static List<Book> bookList = new ArrayList<Book>();
    private static List<CompactDisk> compactDiskList = new ArrayList<CompactDisk>();
    private static List<Game> gameList = new ArrayList<Game>();

    public static String showMainMenu(){
        System.out.println("Hello, welcome to Genus Store which operation you would like to do?\n");
        System.out.println(" - (A)dd new product");
        System.out.println(" - (I)ncrease same product");
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
            case 'S':
                sellProductMenu();
                break;
            default:
                System.out.println(" --- Invalid option --- ");
                break;
        }
    }

    private static void listGames() {
        GameDAO.listGames(gameList);
    }

    private static void listCds() {
        CompactDiskDAO.listCds(compactDiskList);
    }

    private static void listBooks() {
        BookDAO.listBooks(bookList);
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

    private static void increaseCompactDisk() {
        System.out.println("Choose which CD (by id) you want to add:");
        listCds();
        Integer id = insertId();
        Integer quantity = insertQuantity(false);
        CompactDiskDAO.increaseStockQuantity(id, quantity, compactDiskList);
    }

    private static void increaseGame() {
        System.out.println("Choose which Game (by id) you want to add:");
        listGames();
        Integer id = insertId();
        Integer quantity = insertQuantity(false);
        GameDAO.increaseStockQuantity(id, quantity, gameList);
    }

    private static void increaseBook() {
        System.out.println("Choose which Book (by id) you want to add:");
        listBooks();
        Integer id = insertId();
        Integer quantity = insertQuantity(false);
        BookDAO.increaseStockQuantity(id,quantity, bookList);
    }

    private static Integer insertQuantity(Boolean isSelling) {
        if(isSelling)
            System.out.println("Now type how much you are selling:");
        else
            System.out.println("Now type how much itens are entering in stock:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static Integer insertId() {
        System.out.println("Type the Id number then ENTER!: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
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

    private static void sellProductMenu() {
        System.out.println("You are in the sell a product menu," +
                "choose what kind of media you want to sell\n");
        showProductOptions();
        Scanner scanner = new Scanner(System.in);
        goToSellSelectedMedia(scanner.next().toUpperCase());
    }

    private static void goToSellSelectedMedia(String option) {
        char selected = option.charAt(0);
        switch (selected){
            case 'B':
                sellBook();
                break;
            case 'G':
                sellGame();
                break;
            case 'C':
                sellCompactDisk();
                break;
            default:
                System.out.println(" --- Invalid option --- ");
    }
}

    private static void sellCompactDisk() {
        System.out.println("Choose which CD (by id) you want to sell:");
        listCds();
        Integer id = insertId();
        Integer quantity = insertQuantity(true);
        try {
            CompactDiskDAO.lowerStockQuantity(id, quantity, compactDiskList);
        }catch (StockNotAvailableException ex){
            System.out.println(ex);
        }
    }

    private static void sellGame() {
        System.out.println("Choose which Game (by id) you want to sell:");
        listGames();
        Integer id = insertId();
        Integer quantity = insertQuantity(true);
        try {
            GameDAO.lowerStockQuantity(id, quantity, gameList);
        }catch (StockNotAvailableException ex){
            System.out.println(ex);
        }
    }

    private static void sellBook() {
        System.out.println("Choose which book (by id) you want to sell:");
        listBooks();
        Integer id = insertId();
        Integer quantity = insertQuantity(true);
        try {
            BookDAO.lowerStockQuantity(id, quantity, bookList);
        } catch (StockNotAvailableException ex){
            System.out.println(ex);
        }
    }
}
