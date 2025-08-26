import java.util.ArrayList;

public class LockerManager {

    // Private variables
    private ArrayList<Locker> lockers;

    // Constructor
    public LockerManager() {
        lockers = new ArrayList<>();
    }

    // Adds a new locker to the list
    public void addLocker(String lockerID) {
        if (this.getLocker(lockerID) == null) {
            lockers.add(new Locker(lockerID));
        }
    }


    // Retrieves locker by its ID, returns null if specified locker doesn't exist
    public Locker getLocker(String lockerID) {
        for (Locker locker : lockers) {
            if (locker.getLockerID().equals(lockerID)) {
                return locker;
            }
        }
        return null;
    }

    // Removes a locker by its ID
    public void removeLocker(String lockerID) {
        for (int i = 0; i < lockers.size(); i++) {
            if (lockers.get(i).getLockerID().equals(lockerID)) {
                lockers.remove(i);
                break;
            }
        }
    }

    public void displayAllLockers() {
        for (Locker locker : lockers) {
            System.out.println(locker.toString());
        }
    }


}
