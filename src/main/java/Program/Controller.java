package Program;

import Model.Book;
import Model.CompactDisk;
import Model.Game;
import Model.Media;

import java.math.BigDecimal;
import java.util.*;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by e077272 on 3/12/2018.
 */
public class Controller {

    protected static List<Book> bookList = new ArrayList<Book>();
    protected static List<CompactDisk> compactDiskList = new ArrayList<CompactDisk>();
    protected static List<Game> gameList = new ArrayList<Game>();

    protected static AtomicInteger atomicInteger = new AtomicInteger();

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
        CompactDisk newCd = new CompactDisk();
        Scanner scanner;
        try {
            Date nowDate = new Date();
            newCd.setCreatedDate(nowDate);

            newCd.setId(atomicInteger.getAndIncrement());

            System.out.println("Disk Title:");
            scanner = new Scanner(System.in);
            newCd.setTitle(scanner.next());

            System.out.println("Disk Genre:");
            scanner = new Scanner(System.in);
            newCd.setGenre(scanner.next());

            System.out.println("Disk Release Date: dd/MM/yyyy");
            scanner = new Scanner(System.in);
            Date releaseDate = new Date(scanner.next());
            newCd.setReleaseDate(releaseDate);

            System.out.println("Disk Price:");
            scanner = new Scanner(System.in);
            BigDecimal price = new BigDecimal(scanner.next());
            newCd.setPrice(price);

            System.out.println("Artist:");
            scanner = new Scanner(System.in);
            newCd.setArtist(scanner.next());

            System.out.println("Number of tracks:");
            scanner = new Scanner(System.in);
            Integer tracks = new Integer(scanner.next());
            newCd.setNumberOfTracks(tracks);

            System.out.println("Total Time: in minutes!");
            scanner = new Scanner(System.in);
            BigDecimal totalTime = new BigDecimal(scanner.next());
            newCd.setTotalTime(totalTime);

            System.out.println("Quantity in stock:");
            scanner = new Scanner(System.in);
            Integer quantity = new Integer(scanner.next());
            newCd.setStockQuantity(quantity);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void addGame() {
        Game newGame = new Game();
        Scanner scanner;
        try {
            Date nowDate = new Date();
            newGame.setCreatedDate(nowDate);

            newGame.setId(atomicInteger.getAndIncrement());

            System.out.println("Game Title:");
            scanner = new Scanner(System.in);
            newGame.setTitle(scanner.next());

            System.out.println("Game Genre:");
            scanner = new Scanner(System.in);
            newGame.setGenre(scanner.next());

            System.out.println("Game Release Date: dd/MM/yyyy");
            scanner = new Scanner(System.in);
            Date releaseDate = new Date(scanner.next());
            newGame.setReleaseDate(releaseDate);

            System.out.println("Game Price:");
            scanner = new Scanner(System.in);
            BigDecimal price = new BigDecimal(scanner.next());
            newGame.setPrice(price);

            System.out.println("Publisher:");
            scanner = new Scanner(System.in);
            newGame.setPublisher(scanner.next());

            System.out.println("Plataform:");
            scanner = new Scanner(System.in);
            newGame.setPlataform(scanner.next());

            System.out.println("Rating:");
            scanner = new Scanner(System.in);
            newGame.setRating(scanner.next());

            System.out.println("Quantity in stock:");
            scanner = new Scanner(System.in);
            Integer quantity = new Integer(scanner.next());
            newGame.setStockQuantity(quantity);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void addBook() {
        Book newBook = new Book();
        Scanner scanner;
        try {
            Date nowDate = new Date();
            newBook.setCreatedDate(nowDate);

            newBook.setId(atomicInteger.getAndIncrement());

            System.out.println("Book Title:");
            scanner = new Scanner(System.in);
            newBook.setTitle(scanner.next());

            System.out.println("Book Genre:");
            scanner = new Scanner(System.in);
            newBook.setGenre(scanner.next());

            System.out.println("Book Description:");
            scanner = new Scanner(System.in);
            newBook.setDescription(scanner.next());

            System.out.println("Book Author:");
            scanner = new Scanner(System.in);
            newBook.setAuthor(scanner.next());

            System.out.println("Book Press Name:");
            scanner = new Scanner(System.in);
            newBook.setPressName(scanner.next());

            System.out.println("Book Edition:");
            scanner = new Scanner(System.in);
            newBook.setEdition(scanner.next());

            System.out.println("Book City:");
            scanner = new Scanner(System.in);
            newBook.setCity(scanner.next());

            System.out.println("Book release date: dd/MM/yyyy");
            scanner = new Scanner(System.in);
            Date releaseDate = new Date(scanner.next());
            newBook.setReleaseDate(releaseDate);

            System.out.println("Book price:");
            scanner = new Scanner(System.in);
            BigDecimal price = new BigDecimal(scanner.next());
            newBook.setPrice(price);

            System.out.println("Quantity in stock:");
            scanner = new Scanner(System.in);
            Integer quantity = new Integer(scanner.next());
            newBook.setStockQuantity(quantity);

            bookList.add(newBook);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
