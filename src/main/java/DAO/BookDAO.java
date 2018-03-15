package DAO;

import Model.Book;
import MyException.StockNotAvailableException;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by e077272 on 3/14/2018.
 */
public class BookDAO {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static Book addNewBook(){
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

            System.out.println("Book price: currency format xx.xx");
            scanner = new Scanner(System.in);
            BigDecimal price = new BigDecimal(scanner.next());
            newBook.setPrice(price);

            System.out.println("Quantity in stock: Only Natural numbers");
            scanner = new Scanner(System.in);
            Integer quantity = new Integer(scanner.next());
            newBook.setStockQuantity(quantity);
            return newBook;
        }catch (IllegalArgumentException ex){
            System.out.println("Please insert the correct format");
            return null;
        }catch (Exception ex){
            System.out.println("unexpected error occur contact the adm");
            return null;
        }
    }

    public static void increaseStockQuantity(Integer id, Integer quantity, List<Book> bookList) {
        for(Book book:bookList) {
            if(book.getId().equals(id))
                book.setStockQuantity(book.getStockQuantity()+quantity);
        }
    }

    public static void listBooks(List<Book> bookList) {
        Collections.sort(bookList);
        System.out.println(" --- Books list --- ");
        for (Book book: bookList) {
            System.out.println(book);
        }
    }

    public static void lowerStockQuantity(Integer id, Integer quantity, List<Book> bookList) throws StockNotAvailableException {
        for(Book book:bookList){
            if(book.getId().equals(id)){
                if(book.getStockQuantity() < quantity)
                    throw new StockNotAvailableException();
                else
                    book.setStockQuantity(book.getStockQuantity() - quantity);
            }
        }
    }
}
