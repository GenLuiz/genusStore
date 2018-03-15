package DAO;

import Model.Game;
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
public class GameDAO {

    private static AtomicInteger atomicInteger = new AtomicInteger();

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
        }catch (IllegalArgumentException ex){
            System.out.println("Please insert the correct format");
            return null;
        }catch (Exception ex){
            System.out.println("unexpected error occur contact the adm");
            return null;
        }
    }

    public static void increaseStockQuantity(Integer id, Integer quantity, List<Game> gameList) {
        for(Game game: gameList){
            if(game.getId().equals(id))
                game.setStockQuantity(game.getStockQuantity()+quantity);
        }
    }

    public static void listGames(List<Game> gameList) {
        Collections.sort(gameList);
        System.out.println(" --- Games list --- ");
        for (Game game: gameList) {
            System.out.println(game);
        }
    }

    public static void lowerStockQuantity(Integer id, Integer quantity, List<Game> gameList)throws StockNotAvailableException {
        for (Game game:gameList) {
            if(game.getId().equals(id)){
                if(game.getStockQuantity() < quantity)
                    throw new StockNotAvailableException();
                else
                    game.setStockQuantity(game.getStockQuantity() - quantity);
            }
        }
    }
}
