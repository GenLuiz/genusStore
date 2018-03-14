package DAO;

import Model.Game;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by e077272 on 3/14/2018.
 */
public class GameDAO {

    protected static AtomicInteger atomicInteger = new AtomicInteger();

    public static Game addNewGame(){
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
            return newGame;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static void increaseStockQuantity(Integer id, Integer quantity, List<Game> gameList) {
        for(Game game: gameList){
            if(game.getId().equals(id))
                game.setStockQuantity(game.getStockQuantity()+quantity);
        }
    }
}
