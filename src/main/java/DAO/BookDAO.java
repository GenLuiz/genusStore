package DAO;

import Model.Book;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by e077272 on 3/14/2018.
 */
public class BookDAO {

    protected static AtomicInteger atomicInteger = new AtomicInteger();

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

            System.out.println("Book price:");
            scanner = new Scanner(System.in);
            BigDecimal price = new BigDecimal(scanner.next());
            newBook.setPrice(price);

            System.out.println("Quantity in stock:");
            scanner = new Scanner(System.in);
            Integer quantity = new Integer(scanner.next());
            newBook.setStockQuantity(quantity);
            return newBook;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static void increaseStockQuantity(Integer id, Integer quantity, List<Book> bookList) {
        for(Book book:bookList) {
            if(book.getId().equals(id))
                book.setStockQuantity(book.getStockQuantity()+quantity);
        }
    }
}
