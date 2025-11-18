/* This is a stub for the Library class */


import java.util.Hashtable;
import javax.management.RuntimeErrorException;
/**
 *  * The Library class represents a collection that that stores the books and their status using  Hashtable.
* it is storing each book's title and author (concatenated together as one `String`, as the `key`, 
* it is also using the boolean value to record whether or not the book is available (`true`) or currently checked out (`false`) in correspondance to it's key(title)
 */
public class Library extends Building implements LibraryRequirements{
  private Hashtable<String, Boolean> collection;
  boolean hasElevator;
  /**
   * Oveloaded Library constructor with name and address
   * @param name
   * @param Address
   */
  public Library(String name, String Address){
    super(name, Address);

  }
/** 
 * constructor
 * @param name
 * @param Address
 * @param nFLoors
 */
    public Library(String name, String Address, int nFloors) {
      super(name, Address, nFloors);
      this.collection= new Hashtable<String,Boolean>();
      System.out.println("You have built a library: 📖");
    }
    // overloading the constructor to check if there is elevator access
    /** 
     * Overloaded constructor
     * @param hasElevator
     */
    public Library(boolean hasElevator){
      this.hasElevator=hasElevator;

    }
    /** 
     * the constructor
     * @param name
     * @param Address
     * @param nFLoor
     * @param hasElevator
     */
  public Library(String name, String Address, int nFloors, boolean hasElevator) {
      super(name, Address, nFloors);
      this.hasElevator=hasElevator;
      this.collection= new Hashtable<String,Boolean>();

      System.out.println("You have built a library: 📖");
    }  
/**
 * adds the title of the book that serves as the key.
 *
 * @param title
 */
  public void addTitle(String title){
    this.collection.put(title, true);
    System.out.println("the Title "+ title + " has been added");

  }
  /** 
  * removes the title of the book and returns the title we removed.
 *
 * @param title
 */
  public String removeTitle(String title){
    if (this.collection.containsKey(title)){
      if (isAvailable(title)){
          
     this.collection.remove(title);
    System.out.println("the book titled "+title+" is now removed");
    return title;

  }
  else{
    throw new RuntimeException(" unavaillable book can not be removed");
  }

      }
      else{
        throw new RuntimeException("The book that doesn't belong to the library can not be removed");
      }
    }
    
  /** 
  * Checks out the  of the book and updates its status using the boolean.
 * makes the status of the book to be false
 * @param title
 */
  public void checkOut(String title){
    this.collection.put(title, false);
    

  }
   /** 
  * Checks out multiple books of the same title and updates their status using the boolean.
 * makes the status of the book to be false
 * @param title
 * @param quantity
 */
public void checkOut(String title, int quantity){
  if (quantity<1){
    throw new RuntimeException("Quantity must be at least 1.");
  }
  for (int i=0; i<quantity; i++){
    this.collection.put(title, false);
  }
}

    
   /** 
  * Checks in the  of the book and updates its status using the boolean.
 * makes the status of the book to be true
 * @param title
 */
  public void returnBook(String title){
    this.collection.put(title, true);

  }
     /** 
  * Checks if the collection contains the title of the book and returns true if the book is in the collection and false if otherwise.
 *
 * @param title
 * @return true if the book is in the collection and false otherwise
 */
  public boolean containsTitle(String title){
    if (this.collection.containsKey(title)){
      return true;
    }
    else{
      return false;
    }
  }
     /** 
  * Checks if the specific title(book) is available in the collection returns true if the book is in the collection and false if otherwise.
 *
 * @param title
 * @return true if the specific title(book) is available in the collection and false otherwise
 */
  public boolean isAvailable(String title){
    if(this.collection.get(title)==true){
        return true;
      }  
    
    else{
      return false;
    }
  }
  //overloaded function2
  /**
   * Checks if two different books are availlable in the collection
   * @param title
   * @return status
   */
  
  /*public boolean isAvailable(String title1,String title2){// Theoretically This is working in my mind. I am not sure of why it's failing codewise that is why I chose to leave them as a comment.
    if (this.collection.get(title1)){
        if (this.collection.get(title2)){
    
      return true;
      }  
    }
   
    
    else{
      System.out.println( " one or both books are not available. Check one by one instead");
      return false;
    }
  } */
 /**
  * Moves to non adjascent floor only when the there is an elevator in the bulding
  * @param floor#
  */
 public void goToFloor(int n){
  if (hasElevator==true){
    super.goToFloor(n);
  }
  else{
    throw new RuntimeException("The "+ this.name+ " does not have an elevator.");
  }
}
/**
* allows movements across the floors if the library has the elevator overloaded.
* @param destination floor number 
* @param house elevator status( function call)
*/
public void goToFloor(int n, boolean hasElevator){
  if (hasElevator==true){
    super.goToFloor(n);
  }
  else{
    throw new RuntimeException("The "+ this.name+ " does not have an elevator.");
  }
}
 @Override
 public void showOptions() {
    
      super.showOptions();
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n+ + exit() \\n" + " + removeTitle() \n" + " + addTitle()\n" +"  checkOutBook()\n+returnBook()");
    }
 

     /** 
  * Prints the collection and the status
 *
 * No parameter
 */
public void printCollection(){
    for (String title: this.collection.keySet()){
      System.out.println(title+" "+"status"+" "+this.collection.get(title));

    }
  }
  
    public static void main(String[] args) {
      Library myLibrary= new Library("Neilson", "Nelson Dr 102", 4);
      Library myLibraryandElevator= new Library(true);
      myLibrary.showOptions();
      myLibrary.enter();  
      myLibrary.goUp();
      myLibraryandElevator.goToFloor(3);
      
    }
  } 