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

    public String getContents() {
        return contents;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Locker other = (Locker) obj;
        return this.lockerID.equals(other.lockerID);
    }
}
