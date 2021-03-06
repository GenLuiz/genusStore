package Model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by e077272 on 3/12/2018.
 */
public abstract class Media implements Comparable<Media>{

    private Integer id;
    private String title;
    private String genre;
    private Date releaseDate;
    private Date createdDate;
    private BigDecimal price;
    private Integer stockQuantity;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }
    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return "ID: "+ this.getId() +
                " Title: " + this.getTitle() +
                " Price: " +this.getPrice()+
                " Quantity in Stock: "+ this.getStockQuantity()+
                " Release date: " + new SimpleDateFormat("dd/MM/yyyy").format(this.getReleaseDate())+
                " Created date: " + new SimpleDateFormat("dd/MM/yyyy").format(this.getCreatedDate());
    }

    public int compareTo(Media o) {
        return this.getTitle().compareTo(o.getTitle());
    }
}
