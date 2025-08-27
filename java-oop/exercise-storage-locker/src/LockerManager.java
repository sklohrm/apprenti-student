import java.util.ArrayList;

public class LockerManager {

    // Private variables
    private ArrayList<Locker> lockers;

    /**
     * Locker Manager which allows creation and deletion of lockers, as well as displaying all lockers.
     */
    public LockerManager() {
        lockers = new ArrayList<>();
    }

    // Adds a new locker to the list
    public void addLocker(String lockerID) {
        if (this.getLocker(lockerID) == null) {
            lockers.add(new Locker(lockerID));
        }
    }

    /**
     * Retrieves locker by its ID, returns null if specified locker doesn't exist
     * @param lockerID ID of the {@code Locker} to retrieve.
     * @return         The {@code Locker} object that matches the given ID.
     * <br>            Returns {@code null} if the Locker isn't found.
     */
    public Locker getLocker(String lockerID) {
        for (Locker locker : lockers) {
            if (locker.getLockerID().equals(lockerID)) {
                return locker;
            }
        }
        return null;
    }

    /**
     * Removes a locker by its ID
     * @param lockerID The ID of the locker to remove.
     */
    public void removeLocker(String lockerID) {
        lockers.removeIf(locker -> locker.getLockerID().equals(lockerID));
    }

    /**
     * Display the information of all lockers.
     */
    public void displayAllLockers() {
        for (Locker locker : lockers) {
            System.out.println(locker.toString());
        }
    }


}
