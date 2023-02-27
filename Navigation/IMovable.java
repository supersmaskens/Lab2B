package Navigation;

/**
 * Interface for movable objects.
 * NOTE: Does not include any required attributes (X position, direction, etc).
 */
public interface IMovable {
    /**
     * Should change the objects coordinates.
     */
    void move();

    /**
     * Should shift the objects direction to the left.
     */
    void turnLeft();
    /**
     * Should shift the objects direction to the left.
     */
    void turnRight();

    /**
     * Should update the objects position.
     */
    void setCurrentSpeed(double speed);
    void setDirection(double direction);
    void incrementSpeed(double amount, double speedFactor, double max);

    void decrementSpeed(double amount, double speedFactor, double max);

    double getX();
    void setX(double xPosition);
    double getY();
    void setY(double yPosition);
    double getDirection();
    double getCurrentSpeed();
    void setPositionable(Positionable positionable);
    Positionable getPositionable();
}
