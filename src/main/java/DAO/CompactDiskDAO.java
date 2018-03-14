package DAO;

import Model.CompactDisk;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by e077272 on 3/14/2018.
 */
public class CompactDiskDAO {

    protected static AtomicInteger atomicInteger = new AtomicInteger();

    public static CompactDisk addNewCompactDisk(){
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
            return newCd;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static void increaseStockQuantity(Integer id, Integer quantity, List<CompactDisk> compactDiskList) {
        for (CompactDisk disk: compactDiskList){
            if(disk.getId().equals(id))
                disk.setStockQuantity(disk.getStockQuantity()+ quantity);
        }
    }
}
