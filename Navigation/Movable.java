package Navigation;

import Utilities.MyUtil;

import static java.lang.System.out;


/**
 * Abstract for anything that should be able to move.
 */

public class Movable implements IMovable {

    /**
     * represents the movers current speed, used when calculating new position after moving.
     */
    private double currentSpeed;
    private Positionable positionable;

    /**
     * Basic constructor for a movable.
     *
     * @param xPosition
     * @param yPosition
     * @param direction
     */
    public Movable(double xPosition, double yPosition, double direction) {
        this.positionable = new Positionable(xPosition, yPosition, direction);
        this.currentSpeed = 0;
    }
    public void setPositionable(Positionable positionable){
        this.positionable = new Positionable(positionable);
    }
    public Positionable getPositionable(){
        return new Positionable(positionable);
    }

    /**
     * Constructor that sets the initial speed to 0.
     */

    public double getX() {
        return positionable.getxPosition();
    }

    /**
     * Sets a new X position.
     *
     * @param xPosition New X position.
     */
    public void setX(double xPosition) {
        positionable = new Positionable(xPosition, getY(), getDirection());
    }

    /**
     * Gives the current Y position.
     *
     * @return Current Y position.
     */
    public double getY() {
        return positionable.getyPosition();
    }

    /**
     * Sets a new Y position.
     *
     * @param yPosition New Y Position.
     */
    public void setY(double yPosition) {
        positionable = new Positionable(getX(), yPosition, getDirection());
    }

    /**
     * Gives the current direction.
     *
     * @return Current direction.
     */
    public double getDirection() {
        return positionable.getDirection();
    }

    /**
     * Sets a new direction.
     *
     * @param direction New direction.
     */
    public void setDirection(double direction) {
        positionable = new Positionable(getX(), getY(), direction);
    }


    /**
     * Gives the current speed.
     *
     * @return Current speed.
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Sets a new currentSpeed value.
     */

    public void setCurrentSpeed(double newSpeed) {
        currentSpeed = newSpeed;
    }

    /**
     * Changes the current X and Y coordinates based on objects currentSpeed value and direction.
     */
    public void move() {
        positionable = new Positionable(getX() + Math.cos(getDirection()) * getCurrentSpeed(),
                getY() - Math.sin(getDirection()) * getCurrentSpeed(), getDirection());
    }

    /**
     * Updates the position of a mover.
     *
     * @param xPosition New x position.
     * @param yPosition New y position.
     * @param direction New direction.
     */

    /**
     * Changes direction by one degree (PI / 180) to the left.
     */
    public void turnLeft() {
        setDirection((getDirection() + (Math.PI / 180)) % (Math.PI * 2));
    }

    /**
     * Changes direction by one degree (PI / 180) to the right.
     */
    public void turnRight() {
        setDirection((getDirection() - (Math.PI / 180)) % (Math.PI * 2));
    }

    /**
     * Sets a new higher currentSpeed value.
     * New value will be between 0 and enginePower.
     *
     * @param amount Should be between 0 and 1.
     */
    public void incrementSpeed(double amount, double speedFactor, double max) {
        setCurrentSpeed(MyUtil.clamp(getCurrentSpeed() + speedFactor * amount,
                0, max));
    }

    /**
     * Sets a new lower currentSpeed value.
     * New value will be between 0 and enginePower.
     *
     * @param amount Should be between 0 and 1.
     */
    public void decrementSpeed(double amount, double speedFactor, double max) {
        setCurrentSpeed(MyUtil.clamp(getCurrentSpeed() - speedFactor * amount,
                0, max));
    }



}
