package Cars;
import Navigation.Positionable;
import Transport.*;

/**
 * A workshop for transportables.
 * @param <T>
 */
public class Workshop<T extends ITransportable> implements ITransporter<T> {
    private final Positionable positionable;
    /**
     * The name says it all.
     */
    private final Transporter_Helper transporter;

    /**
     * Basic constructor for a workshop.
     * @param capacity The total amount of transportables able to be "transported" at a time
     */
    public Workshop(double xPosition, double yPosition, double direction, int capacity) {
        positionable = new Positionable(xPosition, yPosition, direction);
        transporter = new Transporter_Helper(capacity, new Positionable(positionable));
    }

    /**
     * Allows the workshop to load and unload transportables.
     */
    public void loadableOn() {
        transporter.loadableOn();
    }

    /**
     * Prevents the worklshop from loading and unloading transportables.
     */
    public void loadableOff() {
        transporter.loadableOff();
    }

    /**
     * Checks if the workshop contains a given transportable.
     */
    public boolean contains(T t) {
        return transporter.contains(t);
    }

    /**
     * Checks if the workshop is empty.
     */
    public boolean isEmpty() {
        return transporter.isEmpty();
    }

    @Override
    public void updateTransporterPosition() {
        transporter.updatePosition(positionable);
    }

    @Override
    public void updateTransports() {
        transporter.updateTransports();
    }

    /**
     * Loads a given transportable into the workshop.
     */
    public boolean load(T t) {
        return transporter.load(t);
    }

    /**
     * unloads a given transportable from the workshop.
     */
    public boolean unload(T t) {
        return transporter.unload(t);
    }

    /**
     * Updates the position of all transportables that are currently held by the workshop.
     */

}