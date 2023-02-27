package Transport;

import Navigation.Positionable;

import java.util.ArrayList;

/**
 * A helper that can be used by transporters for transporting.
 */

public class Transporter_Helper implements ITransporter_Helper{

    private Positionable positionable;
    /**
     * List of transportables currently being transported.
     */
    final ArrayList<ITransportable> currentTransports;

    /**
     * Amount of transportables able to be carried at once.
     */
    private final int capacity;
    /**
     * A flag representing whether a transporter is able to load new transportables.
     */
    boolean canLoad;

    /**
     * Flags 'canLoad' as true.
     */
    public void loadableOn() {
        canLoad = true;
    }
    /**
     * Flags 'canLoad' as false.
     */
    public void loadableOff() {
        canLoad = false;
    }

    /**
     * Basic constructor, 'int' parameter decides capacity.
     */
    public Transporter_Helper(int capacity, Positionable positionable) {
        currentTransports = new ArrayList<>();
        this.capacity = capacity;
        this.positionable = positionable;
    }

    public void updatePosition(Positionable positionable){
        this.positionable = new Positionable(positionable);
    }
    /**
     * Checks if a given transportable can be loaded.
     */
    public boolean canTransport(ITransportable t) {
        return canLoad && !t.beingTransported();
    }

    /**
     * Loads a given transportable into the transporter, returns true if it succeeds.
     */
    public boolean load(ITransportable t) {
        if(canTransport(t) && !contains(t)
                && currentTransports.size() < capacity){
            t.beTransported();
            return currentTransports.add(t);
        }
        return false;
    }

    /**
     * Unloads a given transportable from the transporter, returns true if it succeeds.
     */
    public boolean unload(ITransportable t) {
        if (canLoad && currentTransports.contains(t)) return currentTransports.remove(t);
        return false;
    }


    /**
     * Returns true if transporter is carrying the given transportable.
     */
    public boolean contains(ITransportable t)  {
        return currentTransports.contains(t);
    }

    /**
     * Updates the position of a specific transportable.
     */
    public void updateTransport(ITransportable t, Positionable positionable) {
        if(currentTransports.contains(t)) {
            t.updatePosition(positionable);
        }
    }

    /**
     * Returns true if transporter isn't carrying anything.
     */
    public boolean isEmpty() {
        return currentTransports.isEmpty();
    }

    /**
     * Used to set the position and direction of all transportables currently being transported.
     */
    public void updateTransports() {
        for (ITransportable t : currentTransports) {
            updateTransport(t, positionable);
        }
    }
}

