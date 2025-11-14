/* This is a stub for the Library class */


import java.util.Hashtable;
/**
 *  * The Library class represents a collection that that stores the books and their status using  Hashtable.
* it is storing each book's title and author (concatenated together as one `String`, as the `key`, 
* it is also using the boolean value to record whether or not the book is available (`true`) or currently checked out (`false`) in correspondance to it's key(title)
 */
public class Library extends Building implements LibraryRequirements{
  private Hashtable<String, Boolean> collection;

    public Library(String name, String Address, int nFloors) {
      super(name, Address, nFloors);
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

  }
  /** 
  * removes the title of the book and returns the title we removed.
 *
 * @param title
 */
  public String removeTitle(String title){
    this.collection.remove(title);
    return title;

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
    if (this.collection.get(title)==true){
      return true;
    }
    else{
      return false;
    }
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
    }
  
  }