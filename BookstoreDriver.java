/**
 * Project 1, ITSC 1213 
 * @author Jackson Trogdon
 */
 
import java.util.ArrayList;
import java.util.Scanner;
public class BookstoreDriver {

    public static void main(String[] args) {
    
        ArrayList<Double> cart = new ArrayList<Double>();

        Bookstore store = new Bookstore();

   
        Scanner sc = new Scanner(System. in);

        int num = 0;

        while (num != 9) {

            System.out.println(
                "Please select from the following menu of options, by typing a number:"
            );
            System.out.println("\t 1. Add a Book to your Cart");
            System.out.println("\t 2. Add a CD to your Cart");
            System.out.println("\t 3. Add a DVD to your Cart");
            System.out.println("\t 4. Make a Purchase");
            System.out.println("\t 5. Sell a Book");
            System.out.println("\t 6. Sell a CD");
            System.out.println("\t 7. Sell a DVD");
            System.out.println("\t 8. Become a Premium Member");
            System.out.println("\t 9. Exit");

            num = sc.nextInt();

            
            switch (num) {
                case 1:

                    System.out.println(
                        "Please select a book you would like to purchase by the corresonding number."
                    );
                    store.bookStock();
                    int number = sc.nextInt();
                    if(store.bookList.size() != 0) {
                    cart.add(store.bookList.get(number - 1).getCost());
                    System.out.println(
                        store.printBook(number) + " has been added to your cart!"
                    );
                    store.removeBookList(number);
                   } else {
                        System.out.println("Sorry there are no more avaliable books");
                    }
                    break;

                case 2:
                
                    System.out.println(
                        "Please select a CD you would like to purchase by the corresonding number."
                    );
                    store.cdStock();
                    number = sc.nextInt();
                    if(store.cdList.size() != 0) { 
                    cart.add(store.cdList.get(number - 1).getCost());
                    System.out.println(
                        store.printCD(number) + " has been added to your cart!"
                    );
                    store.removeCDList(number);
                    } else {
                        System.out.println("Sorry there are no more avaliable CD's");
                    }
                    break;

                case 3:
               
                    System.out.println(
                        "Please select a DVD you would like to purchase by the corresonding number."
                    );
                    store.dvdStock();
                    number = sc.nextInt();
                    if(store.dvdList.size() != 0 ) {
                    cart.add(store.dvdList.get(number - 1).getCost());
                    System.out.println(
                        store.printDVD(number) + " has been added to your cart!"
                    );
                     store.removeDVDList(number);
                    } else {
                        System.out.println("Sorry there are no more DVD's avaliable");
                    }
                    break;

                case 4:
                    double sum = 0.00;
                    for(int i = 0; i < cart.size(); i++) {
                        sum = sum + cart.get(i);
                    }
                     System.out.println("Are you a Premium Member or a Member");

                    System.out.println("\t 1. Premium Member");
                    System.out.println("\t 2. Regular Member");
                    int which = sc.nextInt();
                    if(which == 1){
                        System.out.println("Which Premium Member are you?");
                        store.premiumMemberStock();
                        num = sc.nextInt();
                        double discount = sum * 0.10;
                        double discounted = sum - discount;
                        System.out.println("Congrats " + store.printPremiumMember(num) + " on making a purchase, you recieved a 10% discount for being a Premium Member. " + "Your cost with discount is: $" + discounted + "0");
                    }
                    if(which == 2){
                        System.out.println("Which Regular Member are you?");
                        store.memberStock();
                        num = sc.nextInt();
                        System.out.println("Congrats " + store.printMember(num) + " on making a purchase! Your total is: $" + sum + "0");
                    }
                    break;

                case 5:
                 
                    System.out.println("Enter the name of the book you would like to sell");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.println("Enter the author of the book you are selling");
                    String author = sc.nextLine();
                    System.out.println("Enter the the price you would like to sell your book for");
                    double cost = sc.nextDouble();
                    System.out.println(
                        "Enter the number of books of the specific book you are selling"
                    );
                    int stock = sc.nextInt();
                    System.out.println("Enter the id of the book");
                    int id = sc.nextInt();
                    store.addBook(name, author, cost, stock, id);
                      System.out.println("Your Book has been added to the inventory");
                    break;

                case 6:
               
                    System.out.println("Enter the arist of the CD you would like to sell");
                    sc.nextLine();
                    String artist = sc.nextLine();
                    System.out.println("Enter the name of the CD you are selling");
                    name = sc.nextLine();
                    System.out.println("Enter the the price you would like to sell your CD for");
                    cost = sc.nextDouble();
                    System.out.println(
                        "Enter the number of CD's of the specific CD you are selling"
                    );
                    stock = sc.nextInt();
                    System.out.println("Enter the id of the CD");
                    id = sc.nextInt();
                    store.addCD(artist, name, cost, stock, id);
                      System.out.println("Your CD has been added to the inventory");
                    break;

                case 7:
                
                    System.out.println("Enter the name of the DVD you would like to sell");
                    sc.nextLine();
                    name = sc.nextLine();
                    System.out.println("Enter the genre of the DVD you are selling");
                    String genre = sc.nextLine();
                    System.out.println("Enter the the price you would like to sell your DVD for");
                    cost = sc.nextDouble();
                    System.out.println(
                        "Enter the number of DVD's of the specific DVD you are selling"
                    );
                    stock = sc.nextInt();
                    System.out.println("Enter the id of the DVD");
                    id = sc.nextInt();
                    store.addDVD(name, genre, cost, stock, id);
                    System.out.println("Your DVD has been added to the inventory");
                    break;

                case 8:
          
                    System.out.println("Enter your first and last name");
                    sc.nextLine();
                    name = sc.nextLine();
                    System.out.println("Please pay $7.00 to become a Premium Member");
                    double due = sc.nextDouble();
                    System.out.println("Enter true to confirm your Premium Member Status");
                    boolean hasPaid = sc.nextBoolean();
                    System.out.println("Enter the number of items you have purchased" + ", " + " Here is the number of items you purchased: " + cart.size());
                    int purchasedItems = sc.nextInt();
                    store.addPremiumMember(name, due, hasPaid, purchasedItems);
                    System.out.println("Congratulations you are an official Premium Member!");
                    break;

                case 9:
                    System.exit(0);
                    break;

                default:
                    System.out.println(
                        "Sorry, but you need to enter a 1, 2, 3, 4, 5, 6, 7, 8, or 9"
                    );


            }


        }

    }

}