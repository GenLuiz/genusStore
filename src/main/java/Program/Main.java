package Program;

import static Controller.Controller.goToSelectedMenu;
import static Controller.Controller.showMainMenu;

/**
 * Created by e077272 on 3/12/2018.
 */
public class Main {

    public static void main(String[] args) {
        boolean using = true;
        do {
            String option = showMainMenu().toUpperCase();
            if(!option.equals("E"))
                goToSelectedMenu(option);
            else
                using = false;
        }while(using);
    }
}
