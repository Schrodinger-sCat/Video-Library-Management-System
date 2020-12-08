# Video Library Management
It is a file-based video management system where videos can be added, updated or deleted and there is also customer management and borrowing system.

# Main Functionalities

### Main Interface

![alt text](https://github.com/Schrodinger-sCat/CSE220_Project/blob/master/screenshots/1.PNG)
Pic 1: Main Interface

### 1. Add New Video to the System
Librarian can add a new video with the title. The id will be generated automatically so that it remains unique from other ids. We handled this by using a static variable which is incremented with every node of each video. Initially the borrower, borrowing date, borrower’s id will be blank. We can set those later.

![alt text](https://github.com/Schrodinger-sCat/CSE220_Project/blob/master/screenshots/2.png)
Pic 2: Add new video

### 2. Borrow Video
In this option we can borrow with Borrower’s ID and name. But it works only which videos are available at that moment. If any video is already borrowed, we can’t use the borrow option for that certain video.

![alt text](https://github.com/Schrodinger-sCat/CSE220_Project/blob/master/screenshots/3.png)
Pic 3: Successfully Borrow

![alt text](https://github.com/Schrodinger-sCat/CSE220_Project/blob/master/screenshots/4.png)
Pic 4: Already Borrowed

### 3. Modify Video record
With this option we can modify any record. Usually we can modify the Borrower’s name, Borrower’s ID, Borrowing date and availability. ID and name of the videos are protected from this option for security issues.

![alt text](https://github.com/Schrodinger-sCat/CSE220_Project/blob/master/screenshots/5.png)
Pic 5: Modifying records

### 4. Delete Video record
This option helps one to delete any video from the record. Initially it is removed from the ArrayList. Not from out main file.

![alt text](https://github.com/Schrodinger-sCat/CSE220_Project/blob/master/screenshots/6.png)
Pic 6: Deleting records


### 5. Search Video
We can search any record by using Video ID, Video Title, borrower’s ID, borrower’s name.
 
![alt text](https://github.com/Schrodinger-sCat/CSE220_Project/blob/master/screenshots/7.png)
Pic 7: Searching Records
 
![alt text](https://github.com/Schrodinger-sCat/CSE220_Project/blob/master/screenshots/8.png)
Pic 8: Searching records

### 6. Show Detailed record
We can see the full records of videos with this option. It gives the total records of videos, Borrowers, borrowing date and availability.

![alt text](https://github.com/Schrodinger-sCat/CSE220_Project/blob/master/screenshots/9.png)
Pic 9: Showing the report

### 7. Save the latest record
During the whole process we’ve modified our record many times. But all those modifications were made in our program’s ArrayList. This option allows us to save these latest changes in our main file so that it can be used later.

![alt text](https://github.com/Schrodinger-sCat/CSE220_Project/blob/master/screenshots/10.png)
Pic 10: Text File where the records are saved

### 8. Exit
This option is for quitting the program. It should be mentioned that using exit before saving the record will lose the latest changes made in the record. 
