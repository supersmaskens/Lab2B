package Cars;

import java.awt.*;

import Models.CarModel;
import Navigation.IMovable;
import Navigation.Movable;
import Navigation.Positionable;


/**
 * Abstract class representing a car.
 */
public abstract class Car extends VehicleDecorator{

    private final int nrDoors;
    /**
     * Basic constructor for a car.
     * @param nrDoors Number of doors.
     * @param color Color of the car.
     * @param enginePower Engine power, also serves as max speed.
     * @param name Model name for the car.
     * @param xPosition Initial X position.
     * @param yPosition Initial Y position.
     * @param direction Initial direction.
     */
    public Car(int nrDoors, Color color, double enginePower, String name,
               double xPosition, double yPosition, double direction) {
        super(new CarModel(color, name), enginePower, xPosition, yPosition, direction);
        this.nrDoors = nrDoors;
    }

    /**
     * Number of doors that the car has.
     */
    public int getNrDoors() {
        return nrDoors;
    }


}

