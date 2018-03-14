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
