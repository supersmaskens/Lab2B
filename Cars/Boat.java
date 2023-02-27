package Cars;

import java.awt.*;

import Models.BoatModel;
import Models.IModel;
import Navigation.IMovable;
import Navigation.Movable;
import Navigation.Positionable;

/**
 * Abstract class representing a boat.
 */

public abstract class Boat extends VehicleDecorator {

    /**
     * Basic constructor for a boat.
     */
    public Boat(Color color, double enginePower, String name,
                double xPosition, double yPosition, double direction) {
        super(new BoatModel(color, name),enginePower,xPosition,yPosition,direction);
    }

}