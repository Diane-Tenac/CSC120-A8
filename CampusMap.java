import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        Building Burton= new Building("Burton Hall", "46 College Ln, Northampton, MA 01063", 5);
        Building Sabin_Reed= new Building("Sabin Reed Hall", "44 College Ln, Northampton, MA 01063", 5);
        Cafe CCafe= new Cafe("Campus Center Cafe", "100 Elm Street Northampton, MA 01063", 2);
        Cafe Campus_Cafe= new Cafe("Campus Cafe", "7 Neilson Drive, Northampton, MA 01063", 4,true);
        Library Neilson= new Library("Neilson_Library", "7 Neilson Drive, Northampton, MA 01063", 4, true);
        Library Hillyer= new Library("Hillyer Arts Library", "22 Elm, Northampton, MA 01063", 2, true);
        Library Josten= new Library("Josten Performing Arts Library", "22 Elm, Northampton, MA 01063", 2, true);
        House Talbot= new House("Talbot House", "25 Prospect Street, Northampton, MA 01063", 4, false,false);
        House Cutter= new House("Cutter House", "10 Prospect Street, Northampton, MA 01063", 3, true,true);
        House Dawes= new House("Dawes House", "18 Henshaw Avenue, Northampton, MA 01063", 2, true);

// Adding buildings to the map
myMap.addBuilding(Burton);
myMap.addBuilding(Sabin_Reed);
myMap.addBuilding(CCafe);
myMap.addBuilding(Campus_Cafe);
myMap.addBuilding(Cutter);
myMap.addBuilding(Neilson);
myMap.addBuilding(Hillyer);
myMap.addBuilding(Talbot);
myMap.addBuilding(Dawes);
myMap.addBuilding(Josten);
        System.out.println(myMap);
    }
    
}
