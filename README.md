# Ticketing Service

Results of the application

********************
 Welcome to our Travelservice 
******************** 
Select the option, 1 or 2 :
 1. Available Seats
 2. Book Seats"

1
Total Seats Available 20
********************
 Welcome to our Travelservice 
******************** 
Select the option, 1 or 2 :
 1. Available Seats
 2. Book Seats"
2
Please Enter your email?
satish@gmail.com
 Please Enter number of seats?

5
We have kept requested number of seats on hold.
You have selected 5. Press 'y' to continue 'n' to exit?
n
Thank you, visit again..
********************
 Welcome to our Travelservice 
******************** 
Select the option, 1 or 2 :
 1. Available Seats
 2. Book Seats"

 
 
 /*
 I used Patterns like Builder and Factory to create objects ,Through it's not nedded for this application
 
 in the futer  we nay nedd to extend the applications in such scenario's we could use this patterns to solve 
 
 recurring problems . i designed one singleton object using double checked licking .There diffrent ways to devlop getinstance method
 
 depends on hoe many users are using the object . i choose the principle of coding to interface when ever possible . so that when we
 
  add new classes in the future we don't have to change multiple class files .
  
  The code flows like this .
  
  1.we show banner like this
     
    ********************
     Welcome to our Travelservice 
     ******************** 
     Select the option, 1 or 2 :
     1. Available Seats
     2. Book Seats"
     
   if they enter 1 we show them available seats if they enter 2 we ask them thier mail and number of seats .If the number seats asked are less than seats availble we will hold seats otherwise we will show message saying the number of requested seats are not availbale
     
  then we show them how many number of seats they selected and show them the below banner
  
     You have selected 5. Press 'y' to continue 'n' to exit?
      n
     Thank you, visit again..
       ********************
        Welcome to our Travelservice 
        ******************** 
      Select the option, 1 or 2 :
         1. Available Seats
          2. Book Seats"
          
  if they wish to continue they could do so . 
  
 
 */
 
 
 