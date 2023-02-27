package Cars;

import Cars.Boat;
import Navigation.Positionable;
import Transport.*;

import java.awt.*;

/**
 * A ferry that can transport various kinds of transportables.
 */

public class Ferry<T extends ITransportable> extends Boat implements ITransporter<T> {
    /**
     * Transporter_Helper declaration
     * so that the classes methods can be used.
     */
    private final Transporter_Helper transporter;

    /**
     *  Basic constructor for a ferry.
     * @param capacity max amount of Transportables.
     */

    public Ferry(double xPosition, double yPosition, double direction, int capacity) {
        super(Color.blue,250, "Ferry X3", xPosition, yPosition, direction);
        transporter = new Transporter_FIFO(capacity, new Positionable(getPositionable()));
    }

    /**
     * Overloaded Ferry for standard use with 30 capacity.
     */
    public Ferry() {
        this(0,0,0,30);
    }

    /**
     * Specific speed factor for Ferry.
     * @return factor used when decreasing throttle to gas.
     */
    public double speedFactor() {
        return getEnginePower() * 0.01 * 1.25;
    }

    /**
     * Checking if ferry contains
     * @param t Transportable
     * @return true if ferry contains t Transportable
     */
    public boolean contains(T t) {
        return transporter.contains(t);
    }

    /**
     * Return true if the ferry is not currently transporting anything.
     */
    public boolean isEmpty() {
        return transporter.isEmpty();
    }

    @Override
    public void updateTransporterPosition() {
        transporter.updatePosition(getPositionable());
    }

    /**
     * Allows the ferry to transport.
     */
    public void loadableOn() {
        transporter.loadableOn();
    }

    /**
     * Prevents the ferry from transporting.
     */
    public void loadableOff() {
        transporter.loadableOff();
    }
    /**
     * Loads transportable if there is space left in on the ferry.
     * @param t Transportable
     * @return true if t was loaded.
     */
    public boolean load(T t) {
        return transporter.load(t);
    }



    /**
     * Calls unload().
     */
    public boolean unload(T t) {
        return transporter.unload(t);
    }


    public void updateTransports() {
        transporter.updateTransports();
    }
}
