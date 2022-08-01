import java.util.*; //Imports java util package

class Main { // Creating Class called Main to run all files

  /**
  *Generates a random number within a given range
  *A minimum and maximum bound must be given
  *Returns the random number
  */
  public static int rng(int min, int max) { //Generates a random number
    return (int) ((Math.random() * (max - min)) + min); // Returns the random number 
  }

  /**
  *Checks if Array is in order by checking if an element is greater than the one before it
  *Returns false if array is not sorted
  *Returns true if it is
  *
  * @param arr ArrayList to be sorted
  * @return    Boolean determining state of ArrayList
  */
  public static boolean sortCheck(ArrayList<Integer> arr) { //Checks if Array is sorted
    for (int i = 1; i < arr.size(); i++) { //Iterates through the Array
      if (arr.get(i).compareTo(arr.get(i-1)) < 0) { //Checks if each element is greater than the last
        return false;
      }
    }
    return true;
  }
  
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in); //Creates scanner
    ArrayList<Integer> nums = new ArrayList<Integer>();//Creates ArrayList
    Sorter m = new markSorts(); //Creates Sorter of Subclass markSorts
    otherSorts q = new otherSorts(); //Quicksort/Bogosort algorithm

    try {
      System.out.print("Please enter the Array Size: "); //Prompts user to pick array size
      int arrSize = scan.nextInt(); // Takes user input and adds it to arrSize 
      if (arrSize > 0) { // If user input is greater than 0 -- if loop continues, else -- throws an error.
        for (int i = 0; i < arrSize; i++) { //Fills array with Random Numbers
          nums.add(rng(1, 1000));
        }
      } else {
        throw new Exception("InvalidNumber"); //Throws an error if invalid.
      }
    } catch (Exception InvalidNumber) {//Prevents the program from crashing if the user enters an invalid number. Instead creates an Arraylist of Size 10. Will unfortunately still crash to a Mismatch Exception...
      System.out.println("ERROR: NOT A VALID NUMBER \nDefaulting to 10...");
      for (int i = 0; i < 10; i++) { //Fills array with Random Numbers
        nums.add(rng(1, 1000));
      }
    }

    System.out.println(nums); // Prints Nums
  
    
    
  /**
  * That being said, this simply asks the user if they want to sort the array beforehand
  * Not exactly a method, but presents the choice of a Forward Sort, Backwards Sort and randomized
  * Forward/Backwards sorted through QuickSort because I got bored. Hopefully it counts for the bonus
  * A fourth option exists, sorting the array through Bogosort because it inflicts large amounts of pain on the user
  */
    System.out.println("Pre-sort array?"); //Array Pre-Sorting
    System.out.print("[1] Leave Random\n[2] Sort with Quicksort\n[3] Reverse Sort\n<4> Sort with bogoSort\nYour choice: "); // Prints Choices for User Input
    int choice = scan.nextInt(); //Make your choice
      if (choice == 2) { //Sort
        q.quickSort(nums, 0, nums.size()-1);
        System.out.println("\nSorted via quickSort\nNumber of comparisons: " + q.getComparisons() + "\nNumber of swaps: " + q.getSwaps());
        System.out.println(nums); // Prints Nums
      } else if (choice == 3) { //Reverse Sort
        q.revQuickSort(nums, 0, nums.size()-1);
        System.out.println("\nSorted via quickSort (And lazily inverted after)\nNumber of comparisons: " + q.getComparisons() + "\nNumber of swaps: " + q.getSwaps()); // Prints number of comparisons and swaps sorted via -- QuickSort 
        System.out.println(nums); // Prints Nums 
      } else if (choice == 4) { //Bogosort
        q.bogoSort(nums);
        System.out.println("\nSorted via bogoSort\nNumber of comparisons: " + q.getComparisons() + "\nNumber of swaps: " + q.getSwaps()); // Prints number of compariosns and swaps sorted via -- BogoSort 
        System.out.println(nums); // Prints Nums 
      } else {
        System.out.println("\n" + nums); //Does nothing otherwise, leaving it random
      }
    
    try { //Catches misinputs
      choice = 0;
      while (choice != 1) {
        System.out.print("Choose an Algorithm Set:\n[1]\nYour choice: "); // Prints choices for user input 
        choice = scan.nextInt(); //Make your choice
        if (choice != 1) {
          System.out.println("Y̷̧̗͚͓̬̮̍̽̀͆̀̈̒͝o̸̦͙͋͒͗͋̓͑̓̒̏̽̕̚͝ư̴̞̩̻̦̄̊̃̉͝ ̸̨̳͈̙̳͎̠̬̤̹͔͎̤̏͜d̴͇̤͆̃̀͗̀̉̀̑̑͂̈́͝͝ỏ̵̭̜̊̇͋̓̔͝n̶̬̲̺̳̲̱̒̀͊̔̎̎͒'̴̨͎͎͍͖̣̪̻̣̟̗͋̑̀̽͊̌̊͘t̴̖̰̩́̐̅ ̸̬̟̪̪̰̓̾̌̄̎͒̽̃̓͑̔̔͘͠ḩ̵̠̤̝̬̌̆̀̏̐̏͆̐a̵̱̪̳͇̥̜̮͒͗̀̋̊̕v̵͖̞̉͐͗́̎̈́̽͋̔̒͛̄͑̚͝ȩ̶̧̙̻̯̜̟̣̓̆̍̅͐̓̈́̀̓̓̚̕͜ ̷͙̠̥̻̯͈͉̬̦̀̿̋̊͊̅̋̍̐͛͑̕ą̶̪̺͎̮̘̳̝̹͇͚̠̗̮͈͐̈̓̎̓̇͊̄̓̈́̚͝͝ ̵̼͈̣͙͙̳̞̳̩̲͓͔̥̯̽̿͌͋̈̾̑̆̅͘ç̵͕̥̠̘͔͛̽͂̇h̶͚̦̖͉̰͓̥̫̜̥̔̿́͒̔̍͌͘͝ö̴̢̲̳̯̼̯̘͚͉͕̀͗̈́̉̕ͅi̷̢̛̹͇̪͉̬̰̦̣̰̻͓̳̙̊̔̑͝ͅč̴̨̗̦̩̦̓͑̓̇̓̀̿͘͘͝e̴͍̐̅̂̀̽̐͌͊͝");
        }
      }



//---------------------------
      
      if (choice == 1) {
        System.out.print("\nNow choose.\n[1] Linear Search\n[2] Binary Search\n[3] Insertion Sort\n[4] Selection Sort\n[5] Bubble Sort\nYour choice: "); //Prompts user to choose algorithm
        choice = scan.nextInt(); //Make your choice

        if (choice == 1) { //Linear Search
          System.out.print("Enter a number to search for: "); // Prompts user to enter a number to search for 
          int search = scan.nextInt(); //Number being searched for
          int result = m.linearSearch(nums, search); //Index of first found
          if (result != -1) {
            System.out.println("\nNumber found at index " + result); // Prints number index
          } else {
            System.out.println("Number not found!"); //Prints more fluff if number isn't found
          }
          System.out.println(m.getData()); // Prints toString function
        } else if (choice == 2) { //Binary Search
          System.out.print("Enter a number to search for: "); // Prompts user to input a number to search for 
          int search = scan.nextInt(); //Number being searched for
          int result = m.binarySearch(nums, search); //Index of first found
          if (result != -1) {
            System.out.println("\nNumber found at index " + result); // Prints number index
          } else {
            System.out.println("Number not found!"); //Prints more fluff if number isn't found
          }
          /*if (sortCheck(nums) == false) {
            System.out.println("You probably forgot to sort it, didn't you?");
          } */
          System.out.println(m.getData()); // Prints toString function
        } else if (choice == 3) { //Insertion Sort
          System.out.println(nums);
          m.insertionSort(nums); //Calls the insertionSort() Method
          System.out.println("\nYou have been... Sequenced.\n"); //Fluff text
          System.out.println(nums); // Prints Nums
          System.out.println(m.getData()); // Prints toString function
        } else if (choice == 4) { //Selection Sort
          System.out.println(nums);
          m.selectionSort(nums);
          System.out.println("\nYou have been... Sequenced.\n"); //Fluff text
          System.out.println(nums); // Prints Nums
          System.out.println(m.getData()); // Prints toString function
        } else if (choice == 5) { //Bubble Sort
          System.out.println(nums);
          m.bubbleSort(nums);
          System.out.println("\nYou have been... Sequenced.\n"); //Fluff text
          System.out.println(nums); // Prints Nums
          System.out.println(m.getData()); // Prints toString function
        } else {
          throw new Exception("InvalidChoice");
        }
      }
    } catch (Exception e1) { //Catches invalid number choices. Could do a while loop, but lazy
      System.out.println("Y̷̧̗͚͓̬̮̍̽̀͆̀̈̒͝o̸̦͙͋͒͗͋̓͑̓̒̏̽̕̚͝ư̴̞̩̻̦̄̊̃̉͝ ̸̨̳͈̙̳͎̠̬̤̹͔͎̤̏͜d̴͇̤͆̃̀͗̀̉̀̑̑͂̈́͝͝ỏ̵̭̜̊̇͋̓̔͝n̶̬̲̺̳̲̱̒̀͊̔̎̎͒'̴̨͎͎͍͖̣̪̻̣̟̗͋̑̀̽͊̌̊͘t̴̖̰̩́̐̅ ̸̬̟̪̪̰̓̾̌̄̎͒̽̃̓͑̔̔͘͠ḩ̵̠̤̝̬̌̆̀̏̐̏͆̐a̵̱̪̳͇̥̜̮͒͗̀̋̊̕v̵͖̞̉͐͗́̎̈́̽͋̔̒͛̄͑̚͝ȩ̶̧̙̻̯̜̟̣̓̆̍̅͐̓̈́̀̓̓̚̕͜ ̷͙̠̥̻̯͈͉̬̦̀̿̋̊͊̅̋̍̐͛͑̕ą̶̪̺͎̮̘̳̝̹͇͚̠̗̮͈͐̈̓̎̓̇͊̄̓̈́̚͝͝ ̵̼͈̣͙͙̳̞̳̩̲͓͔̥̯̽̿͌͋̈̾̑̆̅͘ç̵͕̥̠̘͔͛̽͂̇h̶͚̦̖͉̰͓̥̫̜̥̔̿́͒̔̍͌͘͝ö̴̢̲̳̯̼̯̘͚͉͕̀͗̈́̉̕ͅi̷̢̛̹͇̪͉̬̰̦̣̰̻͓̳̙̊̔̑͝ͅč̴̨̗̦̩̦̓͑̓̇̓̀̿͘͘͝e̴͍̐̅̂̀̽̐͌͊͝");
    }
    
    
    /** 
    
    */

    


      
  }
}