package Cars;

import Models.IModel;
import Navigation.IMovable;
import Navigation.Movable;
import Navigation.Positionable;

import java.awt.*;

public class Vehicle implements IVehicle{

    public final IModel model;

    private final IMovable movable;



    /**
     * Engine power of the vehicle.
     */
    public final double enginePower;

    public Vehicle(IModel model, double enginePower,
                   double xPosition, double yPosition, double direction){
        this.model = model;
        this.enginePower = enginePower;
        this.movable = new Movable(xPosition, yPosition, direction);
    }
    public double getX(){
        return movable.getX();
    }

    public double getY(){
        return movable.getY();
    }

    public double getDirection(){
        return movable.getDirection();
    }

    public double getCurrentSpeed(){
        return movable.getCurrentSpeed();
    }

    public Positionable getPositionable(){
        return new Positionable(movable.getPositionable());
    }

    public void setPositionable(Positionable positionable){
        movable.setPositionable(positionable);
    }

    public void setX(double xPosition){
        setPositionable(new Positionable(xPosition, getY(), getDirection()));
    }


    public void setY(double yPosition){
        setPositionable(new Positionable(getX(), yPosition, getDirection()));
    }

    public void setDirection(double direction){
        setPositionable(new Positionable(getX(), getY(), direction));
    }



    /**
     * Gives the engine power.
     * @return Engine power.
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * Gives the name of the model.
     * @return Name of the cars model.
     */
    public String getModelName() {
        return model.getModelName();
    }

    /**
     * Gives the color of the car.
     * @return A copy of the cars current color.
     */
    public Color getColor() {
        return model.getColor();
    }

    /**
     * Sets a new color for the car.
     * @param color The new color.
     */
    public void setColor(Color color) {
        model.setColor(color);
    }

    /**
     * Sets the current speed to 0.1.
     */
    public void startEngine() {
        movable.setCurrentSpeed(0.1);
    }

    /**
     * Sets the current speed to 0.
     */
    public void stopEngine() {
        movable.setCurrentSpeed(0);
    }

    public void move(){
        movable.move();
    }



    /**
     * Increases the currentSpeed value.
     * Calls incrementSpeed with a value between 0 and 1.
     * @param amount Should be between 0 and 1.
     */
    public void gas(double amount, double speedFactor) {
        movable.incrementSpeed(Math.min(amount, 1), speedFactor, enginePower);
    }


    /**
     * Decreases the currentSpeed value.
     * Calls decrementSpeed with a value between 0 and 1.
     * @param amount Should be between 0 and 1.
     */
    public void brake(double amount, double speedFactor) {
        movable.decrementSpeed(Math.min(amount, 1), speedFactor, enginePower);
    }

    public void turnRight(){
        movable.turnRight();
    }
    public void turnLeft(){
        movable.turnLeft();
    }

}
