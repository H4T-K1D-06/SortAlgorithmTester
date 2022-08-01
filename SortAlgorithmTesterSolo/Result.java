/////// Nathan's Class

public class Result { // Declaring Class called Result 

  private int comparisons; 
  private int swaps;
  private int searchIndex;
  
  
  public Result(int comparisons, int swaps, int searchIndex) {
  this.comparisons = comparisons;
  this.swaps = swaps;
  this.searchIndex = searchIndex;
  }
  
  public int getComparisons(){
    return comparisons; // Returns Comparisons 
  }

  public int getSwaps(){
    return swaps; // Return Swaps 
  }

  public int getSearchIndex(){
    return searchIndex; // Returns searchIndex 
  }

  public String toString(){
    return "The number of comparisons is: " + comparisons + "\nThe number of swaps is : " + swaps + "\nSearch result at index : " + searchIndex;   // Returns comparisons, swaps, and search index -- using toString -- FOR Searches
  }

  public String getSortInfo(){
    return "The number of comparisons is: " + comparisons + "\nThe number of swaps is : " + swaps; // Returns comparisons and swaps -- FOR SORTS
  }

  }
