/* This is a stub for the Cafe class */
/**
 * The Cafe class represents a coffee shop that sells coffee to students/customers.
* it needs to keep track of its inventory, which in this simplified world is just three ingredients and the cups to put them in
 */
public class Cafe extends Building implements CafeRequirements {
    // cafe unique attributes
    private int nCoffeeOunces; 
    private int nSugarPackets;
    private int nCreams; 
    private int nCups;
    /** constructor with only the name
     * @param name
     */
    public Cafe(String name){
        super(name);
    }
    /** constructor overload with both name and the address
     * @param name
     * @param address
     */
    public Cafe(String name, String Address){
        super(name, Address);
    }
    /**
     * Overloaded constructor with the name, address, # floors and the has elevator confirmation
     * @param name
     * @param Address
     * @param nFloors
     * @param hasElevator
     */
    public Cafe(String name, String Address, int nFloors, boolean hasElevator){
        super(name, Address, nFloors);
        this.hasElevator=hasElevator;
    }

    public Cafe(String name, String Address, int nFloors){
        super(name, Address, nFloors);
        this.nCoffeeOunces=50;
        this.nSugarPackets=100;
        this.nCreams=20;
        this.nCups=60;
        System.out.println("You have built a cafe: ☕");
    }
/**
 * Sells a cup of coffee and updates inventory when necessary.
 *
 * @param size the size of the coffee in ounces
 * @param nSugarPackets number of sugar packets requested
 * @param nCreams number of cream requested
 */
public void sellCoffee(int size, int nSugarPackets, int nCreams){
    if ((nCoffeeOunces<size)|| (nSugarPackets>this.nSugarPackets)||(nCreams>this.nCreams)||(this.nCups<1)){
        restock(size*2,nSugarPackets*2, nCreams*2, nCups*2); // not sure if this is a good logic but inorder to make sure that we have enough supplies, let's restock everything as twice as what was ordered when we noticed that we ran out of stock.
    }
    this.nCoffeeOunces-=size;
    this.nSugarPackets-=nSugarPackets;
    this.nCreams-=nCreams;
    this.nCups-=1;
}
/**
 *  updates inventory when necessary by .
 *
 * @param nCoffeeOunces the number of coffee ounces
 * @param nSugarPackets number of sugar packets to be added
 * @param nCreams number of cream to be added
 * @param nCups number of cups to be added
 */
private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
    this.nCoffeeOunces+=nCoffeeOunces;
    this.nSugarPackets+=nSugarPackets;
    this.nCreams+=nCreams;
    this.nCups+=nCups;
}
/**
 * Overring the show options
 * no parameter
 */
public void showOptions(){
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)+ sellCoffee(size,# sugarPacks,# Creams, # cups)");
}

    
    public static void main(String[] args) {
        Cafe myCafe= new Cafe("Campus Center Cafe","100 Elm street",2,true);
        myCafe.showOptions();
        myCafe.goToFloor(5);
        myCafe.activeFloor=1;
        myCafe.sellCoffee(12,3,2);
        

    }
    
}
