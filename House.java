
import java.util.jar.Attributes;
import java.util.ArrayList;
/**
 * The House class represents a building where students live.
 * It extends the Building class and implements HouseRequirements  and tracks residents and dining facilities.
 */
//public House extends Building and implements HouseRequirements
public class House extends Building implements HouseRequirements{
  protected ArrayList<Student> residents;
  protected boolean hasDiningRoom;
  protected boolean hasElevator;
  // constructor
public House(String name, String Address, int nFloors, boolean hasDiningRoom, boolean hasElevator){
  super(name, Address, nFloors);
  this.residents=new ArrayList<Student>();
  this.hasDiningRoom=hasDiningRoom;
  this.hasElevator=hasElevator;
  System.out.println("You have built a house: 🏠");
}
/**
* Checks if the house has a dining room.
* @return true if there is a dining room and false otherwise
*/
public boolean hasDiningRoom()
{
  return this.hasDiningRoom;
}
/**
* Checks if the house has an elevator.
* @return true if there is an elevator in the house and false otherwise
*/
public boolean hasElevator()
{
  return this.hasDiningRoom;
}
/**
* allows movements across the floors if the house has the elevator.
* @param destination floor number 
* @param house elevator status( function call)
*/
public void goToFloor(int n, boolean hasElevator){
  if (hasElevator==true){
    super.goToFloor(n);
  }
  else{
    throw new RuntimeException("This house does not have an elevator.");
  }
}
/**
* Returns the number of residents in the house.
* @return the number of residents
*/
public int nResidents(){
return this.residents.size();
}
// Adding and removing students from the buildings
/**
* Adds a new student to the house.
* @param s student who is moving in
*/
public void moveIn(Student s){
  this.residents.add(s);
};
/**
* Checks if the house has residents in and if student is a resident of a specific house and throws exceptions if house has no residents and/or that students is not in that house.
* @param s student who is being checked
* @return returns true only if the students is in that house which means that house is not empty at that time. Otherwise it throws the exception
*/
public boolean isResident(Student s) {
  if (residents.isEmpty()) {
    throw new RuntimeException("House is empty");
  }

  if (this.residents.contains(s)) {
    return true;
  } else {
    throw new RuntimeException(s + " is not in this house");
  }
}
// removing students from the house
/**
* removes a student s from the house and returns the students who moved out conditioning from isResidents and throws the exception if that condition fails otherwise it retuns the removed student.
* @param s student who is moving in
* @return s the student who moved out 
*/
public Student moveOut(Student s){
  if (isResident(s)){
    this.residents.remove(s);
    return s;
  }
   else {
    throw new RuntimeException(s + " is not in this house");
  }
}
/** Method helps in getting the options for house accessibility 
 * 
 * 
*/
public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }



/* This is a stub for the House class */
  public static void main(String[] args) {
    House myHouse= new House("Cutter","10 Prospect Street",3,true,true);
  }

}