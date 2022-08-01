//H

import java.util.*;

public class otherSorts {

  /**
  *Swaps two given elements on an ArrayList.
  *Requires the index of the two elements to be swapped as well as the ArrayList itself
  */
  public void swap(ArrayList<Integer> arr, int a, int b) { //Swap method for convenience
    Integer temp = arr.get(a);
    arr.set(a, arr.get(b));
    arr.set(b, temp);
  }
  
  private int comparisons;
  private int swaps;

  public int getComparisons(){ //Accessor Method
    return comparisons;
  }
  
  public int getSwaps(){ //Accessor Method
    return swaps;
  }


  //Quicksort implementation
  
  public void quickSort(ArrayList<Integer> arr, int min, int max) {
    if (min < max) { //Ever on and on, it continues circling...
      int pivot = partition(arr, min, max); //Calls partition() to get a Pivot point
      quickSort(arr, min, pivot-1); //See below comment (Recursively calls itself to sort before the pivot)
      quickSort(arr, pivot+1, max); //See above comment (Recursively calls itself to sort after the pivot)
    }
  }

  public int partition(ArrayList<Integer> arr, int min, int max) { //breaks array into parts to divide and conquer
    //randPartition(arr, min, max); //Random Partition. Unused
    int pivot = arr.get(max); //Sets Pivot to rightmost specified element
    int h = min - 1; //Index of the smaller element
    for (int i = min; i < max; i++) { //Iterates through list from indices min to max
      comparisons++;
      if (arr.get(i).compareTo(pivot) < 0) { //Checks if element at i is less than the pivot point
        h++; //Increments the smaller element, as to keep the list sorted
        swap(arr, h, i); //Swaps the two if so
        swaps++;
      }
    }
    swap(arr, h + 1, max); //Swaps the Pivot and 1 element after the smaller element
    return h + 1;
  }

  public void revQuickSort(ArrayList<Integer> arr, int min, int max) { //Reverse Quicksort (Does the exact same thing as regular sort, but inverts it after)
    if (min < max) { 
      int pivot = partition(arr, min, max); //Calls partition() to get a Pivot point
      quickSort(arr, min, pivot-1); //So I'm back here once again (Recursively calls itself to sort before the pivot)
      quickSort(arr, pivot+1, max); //So I'm back here once again (Recursively calls itself to sort after the pivot)
    }
    for (int i = 0; i < arr.size()/2; i++) { //Decided to get lazy and just invert the array manually afterwards
      swaps++;
      swap(arr, i, arr.size()-i-1);
    }
  }

  //Bogosort implementation

  public boolean sortCheck(ArrayList<Integer> arr) { //Checks if Array is sorted
    for (int i = 1; i < arr.size(); i++) { //Iterates through the Array
      comparisons++;
      if (arr.get(i).compareTo(arr.get(i-1)) < 0) { //Checks if each element is greater than the last
        return false; //With nothing but a boolean to tell me if it is; if it was.
      }
    }
    return true; //Uncertainty
  }

  public void bogoSort(ArrayList<Integer> arr) { //Bogosort/Stupidsort
    comparisons = 0;
    System.out.println("Do you enjoy going through hell?"); //Fluff print statement. Please don't hold it against me
    while (sortCheck(arr) == false) { //While array is unsorted...
      for (int i = 0; i < arr.size(); i++) {
        swap(arr, i, (int)(Math.random() * i)); //Swap two random elements
        swaps++;
        System.out.println(arr);
        if (swaps == 100000000) { //More flavour text since Bogosort can get really boring
          System.out.println("The program hasn't crashed. It's just taking a really long time...");
        } else if (swaps == 500000000) {
          System.out.println("Remember that you did this to yourself.");
        } else if (swaps == 1000000000) {
          System.out.println(". . .");
        } else if (swaps == 2147483647 || comparisons == 2147483647) {
          System.out.println("Really, I'm surprised it hasn't crashed yet"); 
        }
      } //End for loop
    } //End while loop
  }//End bogoSort
}//End Class
//But still everything's the same and it all just fades to black...