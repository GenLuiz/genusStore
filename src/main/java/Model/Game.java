package Model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by e077272 on 3/12/2018.
 */
public class Game extends Media {

    private String publisher;
    private String plataform;
    private String rating;

    public Game() {
    }

    public Game(Integer id, String title, String genre, Date releaseDate, Date createdDate, BigDecimal price, Integer stockQuantity, String publisher, String plataform, String rating) {
        super(id, title, genre, releaseDate, createdDate, price, stockQuantity);
        this.publisher = publisher;
        this.plataform = plataform;
        this.rating = rating;
    }

    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPlataform() {
        return plataform;
    }
    public void setPlataform(String plataform) {
        this.plataform = plataform;
    }

    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
