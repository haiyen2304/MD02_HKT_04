package ra.run;

import ra.menu.CatalogMenu;
import ra.menu.ProductMenu;
import ra.share.Share;

import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){

            System.out.println("┏━━━━━━━━BASIC-MENU━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                           ┃                             ┃                          ┃");
            System.out.println("┃   1. Catalog Management   ┃    2.Product Management     ┃          3.Exit          ┃");
            System.out.println("┃                           ┃                             ┃                          ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

            int choice= Share.inputNumber(sc,"Enter your choice: ","You must enter a number, please try again");
            switch (choice){
                case 1:
                    System.out.println("(1). Category Management ");
                    CatalogMenu.showCatalogMenu(sc);
                    break;

                case 2:
                    System.out.println("(2).Product Management");
                    ProductMenu.showProductMenu(sc);
                    break;


                case 3:
                    System.out.println("(3).Exit ");
                    System.exit(0);

                default:
                    System.out.println("You must choice option 1 -> 3");
            }
        }
    }
}
