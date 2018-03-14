package Model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by e077272 on 3/12/2018.
 */
public class Book extends Media {

    private String description;
    private String author;
    private String pressName;
    private String edition;
    private String city;

    public Book() {
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPressName() {
        return pressName;
    }
    public void setPressName(String pressName) {
        this.pressName = pressName;
    }

    public String getEdition() {
        return edition;
    }
    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
