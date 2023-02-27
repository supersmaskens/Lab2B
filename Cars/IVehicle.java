package Cars;

import Navigation.Positionable;

import java.awt.*;

public interface IVehicle {
    double getX();

    double getY();

    double getDirection();

    double getCurrentSpeed();

    Positionable getPositionable();

    void setPositionable(Positionable positionable);

    void setX(double xPosition);

    void setY(double yPosition);

    void setDirection(double direction);


    /**
     * Gives the engine power.
     * @return Engine power.
     */
    double getEnginePower();

    /**
     * Gives the name of the model.
     * @return Name of the cars model.
     */
    String getModelName();

    /**
     * Gives the color of the car.
     * @return A copy of the cars current color.
     */
    Color getColor();

    /**
     * Sets a new color for the car.
     * @param color The new color.
     */
    void setColor(Color color);

    /**
     * Sets the current speed to 0.1.
     */
    void startEngine();

    /**
     * Sets the current speed to 0.
     */
    void stopEngine();

    void move();


    /**
     * Increases the currentSpeed value.
     * Calls incrementSpeed with a value between 0 and 1.
     * @param amount Should be between 0 and 1.
     */
    void gas(double amount, double speedFactor);


    /**
     * Decreases the currentSpeed value.
     * Calls decrementSpeed with a value between 0 and 1.
     * @param amount Should be between 0 and 1.
     */
    void brake(double amount, double speedFactor);

    void turnRight();
    void turnLeft();
}
