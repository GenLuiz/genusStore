package Model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by e077272 on 3/12/2018.
 */
public class CompactDisk extends Media {

    private String artist;
    private Integer numberOfTracks;
    private BigDecimal totalTime;

    public CompactDisk() {
    }

    public CompactDisk(Integer id, String title, String genre, Date releaseDate, Date createdDate, BigDecimal price, Integer stockQuantity, String artist, Integer numberOfTracks, BigDecimal totalTime) {
        super(id, title, genre, releaseDate, createdDate, price, stockQuantity);
        this.artist = artist;
        this.numberOfTracks = numberOfTracks;
        this.totalTime = totalTime;
    }

    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getNumberOfTracks() {
        return numberOfTracks;
    }
    public void setNumberOfTracks(Integer numberOfTracks) {
        this.numberOfTracks = numberOfTracks;
    }

    public BigDecimal getTotalTime() {
        return totalTime;
    }
    public void setTotalTime(BigDecimal totalTime) {
        this.totalTime = totalTime;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
