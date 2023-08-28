import java.util.ArrayList;
import java.util.Scanner;

public class Bookstore {
    
    public static ArrayList<Product> inventory = new ArrayList<Product>();
    public static ArrayList<PremiumMember> members = new ArrayList<PremiumMember>();
    public static Scanner sc = new Scanner(System.in);

    private static void CreateInventory() {
        int pID, noOfProduct;
        String isBook, bISBN;
        Book book;
        CD cd;
        DVD dvd;

        System.out.println("Press Y if you want to store a book in the inventory");
        System.out.println("Press N if you want to store CD in the inventory");
        System.out.println("Press L if you want to store DVD in the inventory");

        isBook = sc.next();
        while(true){
            System.out.println("Please enter product id");
            pID = sc.nextInt();
            
            System.out.println("Please enter the number of product");
            noOfProduct = sc.nextInt();
            //If user chooses to store store book in inventory
            if(isBook.equalsIgnoreCase("Y")){ 
                //method to ignore if Y lowercase or upper
                System.out.println("Please enter the book ISBN number");
                bISBN = sc.next();
                book = new Book(pID, bISBN, noOfProduct);
                //adds book to inventory 
                inventory.add(book);
            }
            //If user chooses to store CD in inventory
            else if(isBook.equalsIgnoreCase("N"))
            //method to ignore if N lowercase or upper
            {    cd = new CD(pID, noOfProduct);
                inventory.add(cd);
            }
            //if user chooses to store DVDs in the inventory 
            dvd = new DVD(pID, noOfProduct);
            inventory.add(dvd);
        
        //add more items in the inentory 
        System.out.println("Press Y if you want to add another item in inventory");
        char ch = sc.next().charAt(0);
        if(ch != 'Y' || ch != 'y')   
        break;
    }
}
    private static void DistributeItem() {
        //method to distribute items 
        System.out.println("Enter product id to issue");
        int pID = sc.nextInt();
        int pCount;
        String premium = null,paymentMethod = null;
        double fee = 0;
        PremiumMember member;
        //uses the product ID to find the product
        if(findProduct(pID)){
            System.out.println("Enter number of item you want");
            pCount = sc.nextInt();
                
            if(CheckInventory(pID, pCount)){
                System.out.println("Plese enter the member ID");
                int id = sc.nextInt();

                System.out.println("Plese enter the members first Name");
                String firstName = sc.next();

                System.out.println("Plese enter the members last Name");
                String lastName = sc.next();

                System.out.println("Press Y if the member is Premium");
                member = new PremiumMember(id,firstName, lastName);

                if(premium.equalsIgnoreCase("Y")){
                    System.out.println("Enter monthly fee and payment method");
                    member.setFeeMonthly(fee);
                    member.setPaymentMethod(paymentMethod);
                }
                members.add(member);
            }
        }else{
            System.out.println("Item has not been found");
        }
    }        

    private static boolean CheckInventory(int pID, int pCount) {
        for(Product p:inventory){
            if(p.getProductID() == pID){
                if(p.getCount() >= pCount){
                    p.setCount(p.getCount() - pCount);
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean findProduct(int pID) {
        for(Product p:inventory){
            if(p.getProductID() == pID)
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //Makes an array of product
        CreateInventory();
        while(true){
            //distribute item from inventory
            DistributeItem();
            String check;
            System.out.println("If you want to distribute any more items then please press Y");
            check = sc.next();
            if(!check.equalsIgnoreCase("Y")){
                break;
            }
        }
    }
}
    
