
import java.util.Scanner;

public class App {
    static String commandList = """ 
        Add name - add
        Add one number for name - add1
        Add some numbers for name - add0
        Search name - seaname
        Search number - seanum
        All name --> [numbers] - all""";
    public static void main(String[] args) throws Exception {
        Phonebook book = new Phonebook();

        String command = new String();

        Scanner in = new Scanner(System.in);

        String strName = new String();
        String strNum = new String();

        do{
            System.out.println(commandList);
            System.out.print("Enter command: ");
            command = in.nextLine();
            System.out.print("\033[H\033[2J");

            switch (command) {
                case "add":
                    System.out.print("Add name\nEnter name:");
                    strName = in.nextLine();
                    book.Add(strName);
                    break;
                case "add1":
                    System.out.print("Add number for name\nEnter name:");
                    strName = in.nextLine();
                    
                    System.out.print("Enter number:");
                    strNum = in.nextLine();
                    
                    book.Add(strName,strNum);
                    break;
                case "add0":
                    System.out.print("Add numbers for name\nEnter name:");
                    strName = in.nextLine();
                    
                    System.out.print("Enter numbers in one line with space:");
                    strNum = in.nextLine();
                    String[] arrNums = strNum.split(" ");
                    
                    book.Add(strName,arrNums);
                    break;
                case "seaname":
                    System.out.print("Search name\nEnter name:");
                    strName = in.nextLine();
                    System.out.println(book.Search(strName)); 
                    break;
                case "seanum":
                    System.out.print("Search number\nEnter number:");
                    strNum = in.nextLine();
                    System.out.println(book.Search(strNum,true)); 
                    break;
                case "all":
                    System.out.println(book.All());
                    break;
                default:
                    break;
            }
            
        }while(!(command.equals("q")));
        in.close();
    }
}
