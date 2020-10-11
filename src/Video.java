public class Video {
    private static int id=10000;
    private final int videoID = id;
    private String title;
    public boolean flag;
    public String borrower;
    public String borrowerID;
    public String borrowingDate;

    public Video(String t, String b, String i, String d){
        id++;
        this.title=t;
        //System.out.println("length: "+b.length());
        if(b.length()==0){
            this.flag=false;
            this.borrower="";
            this.borrowerID="";
            this.borrowingDate="";
        }
        else{
            this.flag=true;
            this.borrower=b;
            this.borrowerID=i;
            this.borrowingDate=d;
        }
    }

    //public void setVideoID(int videoID) {
        //this.videoID = videoID;
    //}

    public int getVideoID() {
        return videoID;
    }

    public String getTitle() {
        return title;
    }
}
