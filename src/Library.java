import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Library implements Library_Interface {
    public ArrayList<Video> list= new ArrayList<>();
    public Library(String s) {
        try{
            File f=new File(s);
            Scanner sc=new Scanner(f);
            while(sc.hasNextLine()) {
                String st = sc.nextLine();
                String[] str = st.split(",");
                if(str.length==1){
                    Video v=new Video(str[0], "", "", "");
                    list.add(v);
                }
                else if(str.length==4){
                    Video v=new Video(str[0], str[1], str[2], str[3]);
                    list.add(v);
                }
                else{
                    System.out.println("One record is invalid in the file!");
                }
            }
        }catch(Exception e){
            System.out.println("File not found!");
        }
    }


    @Override
    public void addVideo() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter title of the video:");
        String st=sc.nextLine();
        list.add(new Video(st,"", "", ""));
    }

    @Override
    public void borrowVideo() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the ID of a video:");
        boolean b=true;
        try{
            int x=sc.nextInt();
            sc.nextLine();
            for (Video video : list) {
                if (video.getVideoID() == x) {
                    //String st = list.get(i).getTitle();
                    if (video.flag) {
                        System.out.println("This video is already been borrowed");
                    } else {
                        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                        Date today = new Date();
                        Date todayWithZeroTime = formatter.parse(formatter.format(today));
                        String date = formatter.format(todayWithZeroTime);
                        //System.out.println("Today's Date: "+date);
                        System.out.println("Enter Borrower's ID: ");
                        String bid = sc.nextLine();
                        System.out.println("Enter Borrower's name: ");
                        String bName = sc.nextLine();
                        int s=bid.length()+bName.length();
                        if((bid.length()==0||bName.length()==0)&&s>0){
                            System.out.println("You have to fill up all the fields!");
                            b=false;
                            break;
                        }
                        video.borrowerID = bid;
                        video.borrower = bName;
                        video.borrowingDate = date;
                        video.flag = true;
                        System.out.println(bName + " Successfully borrowed " + video.getTitle() + " today.");
                    }
                    b = false;
                    break;
                }
            }
            if(b){
                System.out.println("Video ID is not found!");
            }
        }catch(Exception e){
            System.out.println("Invalid Input");
        }
    }

    @Override
    public void modifyVideo() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the ID of a video:");
        boolean b=true;
        try{
            int x=sc.nextInt();
            sc.nextLine();
            for (Video video : list) {
                if (video.getVideoID() == x) {
                    System.out.println("Enter new Borrower's ID: ");
                    String bid = sc.nextLine();
                    System.out.println("Enter new Borrower's name: ");
                    String bName = sc.nextLine();
                    System.out.println("Enter new Borrowing Date(dd-MMM-YYYY): ");
                    String date=sc.nextLine();
                    int s=bid.length()+bName.length()+date.length();
                    if((bid.length()==0||bName.length()==0||date.length()==0)&&s>0){
                        System.out.println("Either all the field should be filled up or all the filed could be blank.");
                        b=false;
                        break;
                    }
                    video.borrowerID = bid;
                    video.borrower = bName;
                    video.borrowingDate = date;
                    video.flag= s > 0;
                    System.out.println("Record for "+video.getTitle()+" is successfully modified.");
                    b=false;
                }
            }
            if(b){
                System.out.println("Video is not found!");
            }
        }catch (Exception e){
            System.out.println("Invalid Input!");
        }

    }

    @Override
    public void deleteVideo() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the ID of a video which you want to delete:");
        boolean b=true;
        try{
            int x=sc.nextInt();
            sc.nextLine();
            for(int i=0; i<list.size(); i++){
                if(list.get(i).getVideoID()==x) {
                    String st = list.get(i).getTitle();
                    list.remove(i);
                    System.out.println("Successfully Deleted: " + st);
                    b = false;
                    break;
                }
            }
            if(b){
                System.out.println("ID not found!");
            }
        }catch(Exception e){
            System.out.println("Invalid Input");
        }
    }

    @Override
    public void searchVideo() {
        System.out.println("1. Search by Video ID\n2. Search by Video Title\n3. Search by Borrower ID\n4. Search by Borrower's name");
        System.out.println("Select an option by entering mentioned value");
        Scanner sc=new Scanner(System.in);
        try{
            int x=sc.nextInt();
            sc.nextLine();
            System.out.println();
            switch(x){
                case 1:
                    System.out.println("Enter the video ID: ");
                    int y=sc.nextInt();
                    sc.nextLine();
                    boolean b=true;
                    System.out.println("Video ID                  Video Title                  Borrower ID                  Borrower                  Borrowing Date                  Status");
                    System.out.println("________                  ___________                  ___________                  ________                  ______________                  ______");
                    for(Video video:list){
                        if(video.getVideoID()==y){
                            System.out.print(video.getVideoID());
                            String l = video.getVideoID() + "";
                            for (int space = 0; space < 26 - l.length(); space++) {
                                System.out.print(" ");
                            }
                            System.out.print(video.getTitle());
                            for (int space = 0; space < 29 - video.getTitle().length(); space++) {
                                System.out.print(" ");
                            }
                            System.out.print(video.borrowerID);
                            for (int space = 0; space < 29 - video.borrowerID.length(); space++) {
                                System.out.print(" ");
                            }
                            System.out.print(video.borrower);
                            for (int space = 0; space < 26 - video.borrower.length(); space++) {
                                System.out.print(" ");
                            }
                            System.out.print(video.borrowingDate);
                            for (int space = 0; space < 32 - video.borrowingDate.length(); space++) {
                                System.out.print(" ");
                            }
                            //System.out.println(list.get(i).flag);
                            if (video.flag) {
                                System.out.println("Not Available");
                            } else {
                                System.out.println("Available");
                            }
                            b=false;
                        }
                    }
                    if(b){
                        System.out.println("No match found!");
                    }
                    break;
                case 2:
                    System.out.println("Enter the video Title: ");
                    String s=sc.nextLine();
                    boolean b1=true;
                    System.out.println("Video ID                  Video Title                  Borrower ID                  Borrower                  Borrowing Date                  Status");
                    System.out.println("________                  ___________                  ___________                  ________                  ______________                  ______");
                    for(Video video:list){
                        if(video.getTitle().equals(s)){
                            System.out.print(video.getVideoID());
                            String l = video.getVideoID() + "";
                            for (int space = 0; space < 26 - l.length(); space++) {
                                System.out.print(" ");
                            }
                            System.out.print(video.getTitle());
                            for (int space = 0; space < 29 - video.getTitle().length(); space++) {
                                System.out.print(" ");
                            }
                            System.out.print(video.borrowerID);
                            for (int space = 0; space < 29 - video.borrowerID.length(); space++) {
                                System.out.print(" ");
                            }
                            System.out.print(video.borrower);
                            for (int space = 0; space < 26 - video.borrower.length(); space++) {
                                System.out.print(" ");
                            }
                            System.out.print(video.borrowingDate);
                            for (int space = 0; space < 32 - video.borrowingDate.length(); space++) {
                                System.out.print(" ");
                            }
                            //System.out.println(list.get(i).flag);
                            if (video.flag) {
                                System.out.println("Not Available");
                            } else {
                                System.out.println("Available");
                            }
                            b1=false;
                        }
                    }
                    if(b1){
                        System.out.println("No match found!");
                    }
                    break;
                case 3:
                    System.out.println("Enter the Borrower ID: ");
                    String bID=sc.nextLine();
                    boolean b2=true;
                    System.out.println("Video ID                  Video Title                  Borrower ID                  Borrower                  Borrowing Date                  Status");
                    System.out.println("________                  ___________                  ___________                  ________                  ______________                  ______");
                    for(Video video:list){
                        if(video.borrowerID.equals(bID)){
                            System.out.print(video.getVideoID());
                            String l = video.getVideoID() + "";
                            for (int space = 0; space < 26 - l.length(); space++) {
                                System.out.print(" ");
                            }
                            System.out.print(video.getTitle());
                            for (int space = 0; space < 29 - video.getTitle().length(); space++) {
                                System.out.print(" ");
                            }
                            System.out.print(video.borrowerID);
                            for (int space = 0; space < 29 - video.borrowerID.length(); space++) {
                                System.out.print(" ");
                            }
                            System.out.print(video.borrower);
                            for (int space = 0; space < 26 - video.borrower.length(); space++) {
                                System.out.print(" ");
                            }
                            System.out.print(video.borrowingDate);
                            for (int space = 0; space < 32 - video.borrowingDate.length(); space++) {
                                System.out.print(" ");
                            }
                            //System.out.println(list.get(i).flag);
                            if (video.flag) {
                                System.out.println("Not Available");
                            } else {
                                System.out.println("Available");
                            }
                            b2=false;
                        }
                    }
                    if(b2){
                        System.out.println("No match found!");
                    }
                    break;
                case 4:
                    System.out.println("Enter the Borrower's name: ");
                    String bName=sc.nextLine();
                    boolean b3=true;
                    System.out.println("Video ID                  Video Title                  Borrower ID                  Borrower                  Borrowing Date                  Status");
                    System.out.println("________                  ___________                  ___________                  ________                  ______________                  ______");
                    for(Video video:list){
                        if(video.borrower.equals(bName)){
                            System.out.print(video.getVideoID());
                            String l = video.getVideoID() + "";
                            for (int space = 0; space < 26 - l.length(); space++) {
                                System.out.print(" ");
                            }
                            System.out.print(video.getTitle());
                            for (int space = 0; space < 29 - video.getTitle().length(); space++) {
                                System.out.print(" ");
                            }
                            System.out.print(video.borrowerID);
                            for (int space = 0; space < 29 - video.borrowerID.length(); space++) {
                                System.out.print(" ");
                            }
                            System.out.print(video.borrower);
                            for (int space = 0; space < 26 - video.borrower.length(); space++) {
                                System.out.print(" ");
                            }
                            System.out.print(video.borrowingDate);
                            for (int space = 0; space < 32 - video.borrowingDate.length(); space++) {
                                System.out.print(" ");
                            }
                            //System.out.println(list.get(i).flag);
                            if (video.flag) {
                                System.out.println("Not Available");
                            } else {
                                System.out.println("Available");
                            }
                            b3=false;
                        }
                    }
                    if(b3){
                        System.out.println("No match found!");
                    }
                    break;
                default:
                    System.out.println("Invalid Input!");
                    break;
            }
        }catch(Exception e){
            System.out.println("Wrong Input!");
        }
    }

    @Override
    public void detailedReport() {
        System.out.println("Video ID                  Video Title                  Borrower ID                  Borrower                  Borrowing Date                  Status");
        System.out.println("________                  ___________                  ___________                  ________                  ______________                  ______");
        System.out.println();
        for (Video video : list) {
            System.out.print(video.getVideoID());
            String l = video.getVideoID() + "";
            for (int space = 0; space < 26 - l.length(); space++) {
                System.out.print(" ");
            }
            System.out.print(video.getTitle());
            for (int space = 0; space < 29 - video.getTitle().length(); space++) {
                System.out.print(" ");
            }
            System.out.print(video.borrowerID);
            for (int space = 0; space < 29 - video.borrowerID.length(); space++) {
                System.out.print(" ");
            }
            System.out.print(video.borrower);
            for (int space = 0; space < 26 - video.borrower.length(); space++) {
                System.out.print(" ");
            }
            System.out.print(video.borrowingDate);
            for (int space = 0; space < 32 - video.borrowingDate.length(); space++) {
                System.out.print(" ");
            }
            //System.out.println(list.get(i).flag);
            if (video.flag) {
                System.out.println("Not Available");
            } else {
                System.out.println("Available");
            }
        }
    }

    @Override
    public void save(String s) {
        try {
            FileWriter myWriter = new FileWriter(s);
            for(Video video:list){
                myWriter.write(video.getTitle());
                if(video.borrower.length()>0) myWriter.write(","+video.borrower+","+video.borrowerID+","+video.borrowingDate);
                myWriter.write("\n");
            }
            myWriter.close();
            System.out.println("Successfully saved to the file!");
        } catch (IOException e) {
            System.out.println("File not Found!!");
        }
    }
}
