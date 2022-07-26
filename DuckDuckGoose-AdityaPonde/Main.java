import java.util.*;

class Main 
{
  public static void main(String[] args) 
  {
    //Scanner to scan for the user's decision to play the game
    Scanner x = new Scanner(System.in);
    String userPlay = "";
    //Loop runs until the user enters "n"
    while (!userPlay.equals("n"))
    {
      // Asking user to play the game or not 
      System.out.println("\nDo you want to play Duck Duck Goose(y/n): \n");
      //changing input to lowercase
      userPlay = x.nextLine().toLowerCase();
      //if user enters "y" new instance of the Circular Linked List class is initialized 
      //new scanner 
      //new random for random assignment of user's position
      if (userPlay.equals("y"))
      {
      CircularLinkedList cll = new CircularLinkedList();
      Scanner scan = new Scanner(System.in);
      Scanner stringScan = new Scanner(System.in);
      Random random = new Random();
// Nummber of total players
      System.out.println("\nEnter the number of people you wanna play with?\n");
      //scans user's input for the number of players 
      int userPeople = scan.nextInt();
      //test case to check for more than 1 player
      while (userPeople == 1)
      {
        System.out.println("\nYou need more than one person to play with...");
        System.out.println("Enter the number of people you wanna play with?\n");
        userPeople = scan.nextInt();
      }
      //inputting the players from 1-user specified total
      for(int i = 1; i <= userPeople; i++)
      {
        cll.insertLast(i);
      }
      //predetermined winner before user enters their position or its randomly assigned
      //calculating the total with the ddG method in the CircularLinkedList class
      int winner = cll.ddG(); 
      //asking the user weather they want to pick their position
      System.out.print("Would you like to pick your position? (y/n): \n");
      //changes user input to y or n
      String userDec = stringScan.nextLine().toLowerCase();
      //testcase for the user to only input y or n
      while(!userDec.equals("y") && !userDec.equals("n"))
      {
        
        System.out.println("\nWould you like to pick your position? (y/n): ");
        System.out.println("Please enter y or n: \n");
        userDec = stringScan.nextLine().toLowerCase();
      }
      int userPos;
      //user enters y and chooses their position 
      if (userDec.equals("y"))
      {
        System.out.print("\nEnter a number between (1 - " + userPeople + "): \n");
        userPos = scan.nextInt();
        while (userPos < 1 || userPos > userPeople)
        {
          System.out.println("PLEASE enter a number between (1 - " + userPeople + "): \n");
          userPos = scan.nextInt();

        }
      }
      //else tey are assigned a random position

      else 
      {
        userPos = (int)(Math.random()*(userPeople-1+1)+1);
        System.out.println("\nYour number is: " + userPos);
      }
    //checking if the user won the game
    if (winner == userPos)
    {
        System.out.println("\nYOU ARE THE WINNER!!!");
    }
    // else the user lost
    else
    {
      System.out.println("\nYOU ARE THE LOSER!!!");
      System.out.println("\n#" + winner + " Won the game!");

    }
    //if user enters n for playing the game
    }
    else if (userPlay.equals("n"))
    {
      System.out.println("BYEEEE!!!");
      break;
    }
   
   }

  }
  
}