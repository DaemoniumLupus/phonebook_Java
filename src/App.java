import java.util.Scanner;

public class App {
    static String commandList = """ 
        Add name - add
        Add one number for name - add1
        Add some numbers for name - add0
        Search name - seaname
        Search number - seanum""";
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
            

            switch (command) {
                case "add":
                    System.out.print("Enter name:");
                    strName = in.nextLine();
                    book.Add(strName);
                    break;
                case "add1":
                    System.out.print("Enter name:");
                    strName = in.nextLine();
                    
                    System.out.print("Enter number:");
                    strNum = in.nextLine();
                    
                    book.Add(strName,strNum);
                    break;
                case "add0":
                    System.out.print("Enter name:");
                    strName = in.nextLine();
                    
                    System.out.print("Enter number:");
                    strNum = in.nextLine();
                    
                    book.Add(strName,strNum);
                    break;

            
                default:
                    break;
            }

            System.out.println(book.All());
        }while(!(command.equals("q")));
        in.close();
    }
}
