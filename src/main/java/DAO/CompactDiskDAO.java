package DAO;

import Model.CompactDisk;
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
public class CompactDiskDAO {

    private static AtomicInteger atomicInteger = new AtomicInteger();

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
        }catch (IllegalArgumentException ex){
            System.out.println("Please insert the correct format");
            return null;
        }catch (Exception ex){
            System.out.println("unexpected error occur contact the adm");
            return null;
        }
    }

    public static void increaseStockQuantity(Integer id, Integer quantity, List<CompactDisk> compactDiskList) {
        for (CompactDisk disk: compactDiskList){
            if(disk.getId().equals(id))
                disk.setStockQuantity(disk.getStockQuantity()+quantity);
        }
    }

    public static void listCds(List<CompactDisk> compactDiskList) {
        Collections.sort(compactDiskList);
        System.out.println(" --- CDs list --- ");
        for (CompactDisk disk: compactDiskList) {
            System.out.println(disk);
        }
    }

    public static void lowerStockQuantity(Integer id, Integer quantity, List<CompactDisk> compactDiskList) throws StockNotAvailableException {
        for (CompactDisk compactDisk:compactDiskList) {
            if(compactDisk.getId().equals(id)){
                if(compactDisk.getStockQuantity() < quantity)
                    throw new StockNotAvailableException();
                else
                    compactDisk.setStockQuantity(compactDisk.getStockQuantity() - quantity);
            }
        }
    }
}
