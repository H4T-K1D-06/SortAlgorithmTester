import java.util.*;

public abstract class Sorter{ //Superclass

  //Accessor methods
  public abstract int getComparisons();
  public abstract int getSwaps();
  public abstract String getType();
  public abstract String getData(); //Bundles up everything else as a pseudo-'toString.'
  
  //Takes in an ArrayList and a number to be searched for. Returns the index of the found element. Should return -1 if not found.
  public abstract int linearSearch(ArrayList<Integer> arr, int a);
  public abstract int binarySearch(ArrayList<Integer> arr, int a);

  //Takes in an ArrayList. Statistics accessible through accessor methods. Sort names self-explanatory
  public abstract void insertionSort(ArrayList<Integer> arr);
  public abstract void selectionSort(ArrayList<Integer> arr);
  public abstract void bubbleSort(ArrayList<Integer> arr);

} //End Class