package MyException;

/**
 * Created by e077272 on 3/15/2018.
 */
public class StockNotAvailableException extends Exception{

    public StockNotAvailableException(String message){super(message);}
    public StockNotAvailableException(){super("Stock is lower than quantity entered");}
}
