# CSE220_Project
This is a project from my Data Structure course. It is a file-based video management system where videos can be added, updated or deleted and there is also customer management and borrowing system.


![alt text](https://github.com/Schrodinger-sCat/CSE220_Project/blob/master/screenshots/cover.PNG)

## Introduction

As Object Oriented Programming is suitable for managing a large system, we developed this Video Library System to manage a huge number of videos to maintain in a library. Though it is a large system in real life, we created this beta version using file-based system to fetch and store our data.

## Main Functionalities

#### Main Interface

![alt text](https://github.com/Schrodinger-sCat/CSE220_Project/blob/master/screenshots/1.PNG)
 Pic 1: Main Interface

1.	Add New Video to the System
Librarian can add a new video with the title. The id will be generated automatically so that it remains unique from other ids. We handled this by using a static variable which is incremented with every node of each video. Initially the borrower, borrowing date, borrower’s id will be blank. We can set those later.

![alt text](https://github.com/Schrodinger-sCat/CSE220_Project/blob/master/screenshots/2.png)
 Pic 2: Add new video

2.	Borrow Video
In this option we can borrow with Borrower’s ID and name. But it works only which videos are available at that moment. If any video is already borrowed, we can’t use the borrow option for that certain video.

![alt text](https://github.com/Schrodinger-sCat/CSE220_Project/blob/master/screenshots/3.png)
 Pic 3: Successfully Borrow

![alt text](https://github.com/Schrodinger-sCat/CSE220_Project/blob/master/screenshots/4.png)
 Pic 4: Already Borrowed

3.	Modify Video record
With this option we can modify any record. Usually we can modify the Borrower’s name, Borrower’s ID, Borrowing date and availability. ID and name of the videos are protected from this option for security issues.

![alt text](https://github.com/Schrodinger-sCat/CSE220_Project/blob/master/screenshots/5.png)
 Pic 5: Modifying records

4.	Delete Video record
This option helps one to delete any video from the record. Initially it is removed from the ArrayList. Not from out main file.

![alt text](https://github.com/Schrodinger-sCat/CSE220_Project/blob/master/screenshots/6.png)
Pic 6: Deleting records


5.	Search Video
We can search any record by using Video ID, Video Title, borrower’s ID, borrower’s name.
 
![alt text](https://github.com/Schrodinger-sCat/CSE220_Project/blob/master/screenshots/7.png)
Pic 7: Searching Records
 
![alt text](https://github.com/Schrodinger-sCat/CSE220_Project/blob/master/screenshots/8.png)
Pic 8: Searching records

6.	Show Detailed record
We can see the full records of videos with this option. It gives the total records of videos, Borrowers, borrowing date and availability.

![alt text](https://github.com/Schrodinger-sCat/CSE220_Project/blob/master/screenshots/9.png)
Pic 9: Showing the report

7.	Save the latest record
During the whole process we’ve modified our record many times. But all those modifications were made in our program’s ArrayList. This option allows us to save these latest changes in our main file so that it can be used later.

![alt text](https://github.com/Schrodinger-sCat/CSE220_Project/blob/master/screenshots/10.png)
Pic 10: Text File where the records are saved

8.	Exit
This option is for quitting the program. It should be mentioned that using exit before saving the record will lose the latest changes made in the record. 

Object Oriented Paradigms
1.	Reusability
In this project we tried our best to make the best use of object-oriented paradigms. We tried to make the whole structure more reusable by dividing tasks in methods. First, we divided the whole process in many methods and then we organized them like pieces of puzzle. Even in main method we just used all the methods in our switch case. Making object also enables one structure to fit in another class.
2.	Interface
Before starting the programming in full swing, we created the interface and set the abstractions. It made the project lot easier to understand. We could clearly see the whole structure and it helped to write code more efficiently. Later, we just overridden all the methods.
3.	Encapsulation
We used Getter and Setter methods to encapsulate our protected variables. It prevents sensitive variables from any unwanted change of value. 

Advanced Technical Aspects
Memory Management
In java we don’t need to use any kind of pointer. All we need to do is pass the address of any object to another variable. As a result, it gets easier in memory management side. Java Virtual Machine uses pointers implicitly, but we don’t have to use it explicitly. In Java we use the reference of an object rather than using pointers. This reference contains the pointer of the object. This extra level of abstraction makes Java more secure. In all our Objects we used references.
Garbage Collector 
This is the most unique feature we liked about java. We didn’t have to handle any unreferenced object/variable. Usually these unreferenced object/variables take memory and it makes the system inefficient. But in java, the Garbage collector automatically removes these unreferenced memories so that we can use system memory more efficiently. Even we didn’t have to create any destructor for the instances.
Java Byte-Code
	Another extraordinary feature of java is its byte-code compilation. Java-Byte code runs in Java Virtual Machine rather then running in physical machine. As a result, we can run our java program at any device which consists Java Runtime Environment. It enhances the mobility.
Conclusion
This was a medium project using basic java. This Video Library Management used only some few advantages of java. Still, it was one of the most instructive work. It gave a brief idea about how to use object-oriented programming in real life problem/development. It helped us to realize how large project gets easier by using object-oriented paradigm. It was a great experience about how a big project gets divided and then reassembled piece by piece both incrementally and iteratively using this Object-Oriented Technology.
