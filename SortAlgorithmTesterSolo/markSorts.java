import java.util.*;

class markSorts extends Sorter {

  /**
  *Swaps two given elements on an ArrayList.
  *Requires the index of the two elements to be swapped as well as the ArrayList itself
  *
  *@param arr ArrayList to be operated on
  *@param a   Index of first element
  *@param b   Index of second element
  */
  public void swap(ArrayList<Integer> arr, int a, int b) { //Swap method for convenience
    Integer temp = arr.get(a);
    arr.set(a, arr.get(b));
    arr.set(b, temp);
  }

  
  /**
  *Checks if Array is in order by checking if an element is greater than the one before it
  *Returns false if array is not sorted
  *Returns true if it is
  *
  * @param arr ArrayList to be sorted
  * @return    Boolean determining state of ArrayList
  */
  public boolean sortCheck(ArrayList<Integer> arr) { //Checks if Array is sorted
    for (int i = 1; i < arr.size(); i++) { //Iterates through the Array
      if (arr.get(i).compareTo(arr.get(i-1)) < 0) { //Checks if each element is greater than the last
        return false;
      }
      comparisons++; //I suppose it has to count
    }
    return true;
  }

  //----
  
  private int comparisons = 0; //Comparison counter  
  private int swaps = 0; //Swap counter
  private String algType = ""; //Algorithm Type

  public int getComparisons(){ //Accessor Method for Comparison Counter
    return comparisons;
  }

  public int getSwaps(){ //Accessor Method for Swap Counter
    return swaps;
  }

  public String getType(){ //Accessor Method for Type of Array
    return algType;
  }

  public String getData(){ //Puts everything together in a single printable string
    return "\nAlgorithm: " + algType + "\nNumber of comparisons: " + comparisons + "\nNumber of swaps: " + swaps;
  }

  /**
  * Performs a Linear Search
  * Iterates through each element in the given array
  * Until the first of the element is found and returns its index
  * Returns the -1 if the element is not found
  *
  * @param arr Array to be searched
  * @param a   Number to be searched for
  * @return    Index of found number
  */
  public int linearSearch(ArrayList<Integer> arr, int a){ //Linear Search
    algType = "Linear Search";
    for (int i = 0; i < arr.size(); i++) {//Iterates through every element in the array
      comparisons++; //Adds 1 to Comparison Counter
      if (arr.get(i).compareTo(a) == 0) { //Checks if the value matches the specified.
        return i; //Returns the index of the first found matching element
      }
    }
    return -1; //Returns -1 if no match is found
  }

  /**
  * Performs a Binary Search
  * Cuts the array in half, determines where the element is
  * Uses that side and repeats until found
  * There
  * 
  * @param arr Array to be searched
  * @param h   Number to be searched for
  * @return    Index of found number
  */

  public int binarySearch(ArrayList<Integer> arr, int h){ //Binary Search

    int min = 0; //Creates a minimum and sets it to the start of the array.
    int max = arr.size() - 1; //Creates a maximum and sets it to the end.
    algType = "Binary Search";
    
    while (true) {
      int half = (min + max) / 2; //Averages the minimum and maximum. First search point. Resets it on subsequent loops
      comparisons++;
      if (arr.get(half).compareTo(h) == 0) { //If by some miracle, the halfway point is the correct number
        return half;
      } else if (min >= max) { //If the minimum is the same as the maximum. AKA, the search number isn't there.
        return -1;
      } else if (arr.get(half).compareTo(h) < 0) { //Checks if the queried number is greater than the current midpoint
        min = half++; //Moves to the right side of the partition
      } else {
        max = half--; //Moves to the left side of the partition
      }
    }
  }

  /**
  * Performs an Insertion Sort
  * You know, at least it's functional
  *
  * @param arr ArrayList to be sorted
  */

  public void insertionSort(ArrayList<Integer> arr){ //Insertion Sort
    algType = "Insertion Sort";
    for (int i = 1; i < arr.size(); i++) { //Iterates through the array
      Integer num = arr.get(i); //Number to be moved
      int j = i-1; //Sets j to number immediately before i
      while ((j > -1) && ((arr.get(j).compareTo(num)) > 0)) { //Checks every element behind i and comapares the two
        arr.set(j+1, arr.get(j)); //Shifts everything over
        j--; //Iterates backwards from i
        swaps++; //Swapcount is weird for this one. 
        }
      arr.set(j+1, num); //Puts element at i in the right spot
      comparisons++; //So is comparison count
    }
  }

  /**
  * Performs a Selection Sort
  * I've forgotten how to sort. I've forgotten if I can.
  * (Used to be) INCREDIBLY BROKEN
  * This time you're not hurting me. This time I will take a stand
  * Standing lonely in the night with Google by my side.
  * It has been fixed
  *
  * @param arr ArrayList to be sorted
  */
  public void selectionSort(ArrayList<Integer> arr){ //Selection Sort
    algType = "Selection Sort";
    for (int i = 0; i < arr.size(); i++) { //Iterates through the Array
      for (int j = i + 1; j < arr.size(); j++){ //Iterates through the array again, starting at 1 after position i
        comparisons++;
        if (arr.get(i).compareTo(arr.get(j)) > 0){ //If element at i is greater than the element at j...
          swap(arr, i, j); //Swap i and j
          swaps++;
        }
      }
    }
  }

  /**
  * Performs a bubble sort
  *
  * @param arr ArrayList to be sorted
  */

  public void bubbleSort(ArrayList<Integer> arr){ //Bubble Sort
    algType = "Bubble Sort";
    while (sortCheck(arr) == false) { //White array is not sorted...
      for (int i = 1; i < arr.size(); i++) { //Iterate through the array
        comparisons++;
        if (arr.get(i).compareTo(arr.get(i-1)) < 0) { //Compare each element to the last. If it's NOT in order...
          swap(arr, i, i-1); //Swap!
          swaps++;
        }
      }
    }
  }
} //End Class

/*
* Maybe it's a dream, maybe nothing else is real...
*/