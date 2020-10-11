import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main (String[] args) throws FileNotFoundException {
        Library lib=new Library("src\\TestCase.txt");
        while(true){
            System.out.println("1. Add new Video to the System\n2. Borrow Video\n3. Modify Video record\n4. Delete Video record\n5. Search Video\n6. Show Detailed Report\n7. Save the overall Report\n8. Exit");
            Scanner sc=new Scanner(System.in);
            System.out.println("Select an option with mentioned value:");
            try{
                int x=sc.nextInt();
                sc.nextLine();
                switch(x){
                    case 1:
                        lib.addVideo();
                        break;
                    case 2:
                        lib.borrowVideo();
                        break;
                    case 3:
                        lib.modifyVideo();
                        break;
                    case 4:
                        lib.deleteVideo();
                        break;
                    case 5:
                        lib.searchVideo();
                        break;
                    case 6:
                        lib.detailedReport();
                        break;
                    case 7:
                        lib.save("src\\TestCase.txt");
                        break;
                    case 8:
                        sc.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Wrong Input");
                        break;
                }

            }catch (Exception e){
                System.out.println("Invalid Input!!");
            }
            System.out.println();
            System.out.println("Enter any thing to continue: ");
            sc.nextLine();
            for(int i=0; i<10; i++){
                System.out.println();
            }
        }
    }
}
