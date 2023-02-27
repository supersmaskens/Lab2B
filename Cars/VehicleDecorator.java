package Cars;

import Models.IModel;
import Navigation.Positionable;

import java.awt.*;

import static java.lang.System.out;

public abstract class VehicleDecorator implements IVehicle{

    private final IVehicle vehicle;

    public VehicleDecorator(IModel model, double enginePower,
                            double xPosition, double yPosition, double direction){
        vehicle = new Vehicle(model, enginePower, xPosition, yPosition, direction);
    }
    public abstract double speedFactor();
    @Override
    public double getX() {
        return vehicle.getX();
    }

    @Override
    public double getY() {
        return vehicle.getY();
    }

    @Override
    public double getDirection() {
        return vehicle.getDirection();
    }

    @Override
    public double getCurrentSpeed() {
        return vehicle.getCurrentSpeed();
    }

    @Override
    public Positionable getPositionable() {
        return vehicle.getPositionable();
    }

    @Override
    public void setPositionable(Positionable positionable) {
        vehicle.setPositionable(positionable);
    }

    @Override
    public void setX(double xPosition) {
        vehicle.setX(xPosition);
    }

    @Override
    public void setY(double yPosition) {
        vehicle.setY(yPosition);
    }

    @Override
    public void setDirection(double direction) {
        vehicle.setDirection(direction);
    }

    @Override
    public double getEnginePower() {
        return vehicle.getEnginePower();
    }

    @Override
    public String getModelName() {
        return vehicle.getModelName();
    }

    @Override
    public Color getColor() {
        return vehicle.getColor();
    }

    @Override
    public void setColor(Color color) {
        vehicle.setColor(color);
    }

    @Override
    public void startEngine() {
        vehicle.startEngine();
    }

    @Override
    public void stopEngine() {
        vehicle.stopEngine();
    }

    @Override
    public void move() {
        vehicle.move();
    }

    @Override
    public void gas(double amount, double speedFactor) {
        vehicle.gas(amount,speedFactor);
    }

    public void gas(double amount){
        gas(amount, speedFactor());
    }

    @Override
    public void brake(double amount, double speedFactor) {
        vehicle.brake(amount, speedFactor);
    }

    public void brake(double amount){
        brake(amount, speedFactor());
    }

    @Override
    public void turnRight() {
        vehicle.turnRight();
    }

    @Override
    public void turnLeft() {
        vehicle.turnLeft();
    }
}
