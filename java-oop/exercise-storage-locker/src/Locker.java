public class Locker {

    // Private variables
    private String lockerID;
    private boolean isOccupied;
    private String contents;

    // Constructor
    public Locker(String lockerID) {
        this.lockerID = lockerID;
        this.isOccupied = false;
        this.contents = "";
    }

    public String getLockerID() {
        return lockerID;
    }

    public void setLockerID(String lockerID) {
        this.lockerID = lockerID;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    // Stores item. Only one item can be stored. Sets occupied to true.
    public void storeItem(String item) {
        contents = item;
        isOccupied = true;
    }

    // Removes item, sets occupied to false.
    public void removeItem() {
        contents = "";
        isOccupied = false;
    }

    // toString method returns information on locker
    @Override
    public String toString() {
        return "Locker ID: " + lockerID + ", Occupied: " + isOccupied + ", Contents: " + contents;
    }



}
