package test;
import Cars.*;
import org.junit.Test;

import java.awt.*;

public class TestBoat {
    /**
     * Load and unload Ferry
     */
    @Test
    public void loadFerry() {
        Ferry<PassengerCar> ferry = new Ferry<PassengerCar>();
        Volvo240 car = new Volvo240();
        ferry.loadableOn();
        ferry.load(car);
        assert(ferry.contains(car));
    }
    @Test
    public void unloadFerry() {
        Ferry<PassengerCar> ferry = new Ferry<PassengerCar>();
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        ferry.loadableOn();
        ferry.load(saab);
        ferry.load(volvo);
        ferry.unload(saab);
        assert(ferry.contains(volvo) && !ferry.contains(saab));
    }
    @Test
    public void unloadEmptyFerry() {
        Ferry<PassengerCar> ferry = new Ferry<PassengerCar>();
        Volvo240 car = new Volvo240();
        ferry.loadableOff();
        ferry.load(car);
        ferry.unload(car);
        ferry.unload(car);
        assert(ferry.isEmpty());
    }
    @Test
    public void loadFullFerry() {
        Ferry<PassengerCar> ferry = new Ferry<PassengerCar>(0,0,0,0);
        Volvo240 car = new Volvo240();
        ferry.load(car);
        assert(!ferry.contains(car));
    }

    @Test
    public void basicFerryStuff(){
        Ferry<PassengerCar> ferry = new Ferry<PassengerCar>(0,0,0,0);
        ferry.setColor(Color.red);
        assert(ferry.getModelName().equals("Ferry X3") && ferry.getColor().equals(Color.red));
    }
    @Test
    public void goingForHundo(){
        Ferry<PassengerCar> ferry = new Ferry<PassengerCar>();
        Volvo240 car = new Volvo240();
        ferry.loadableOn();
        ferry.load(car);
        ferry.gas(1);
        ferry.move();
        ferry.updateTransporterPosition();
        ferry.updateTransports();
        ferry.brake(1);
        assert(car.getX() == 3.125 && ferry.getCurrentSpeed() == 0);
    }
    @Test
    public void startNStop(){
        Ferry<PassengerCar> ferry = new Ferry<PassengerCar>();
        ferry.startEngine();
        ferry.move();
        ferry.stopEngine();
        assert(ferry.getCurrentSpeed() == 0 && ferry.getX() == 0.1);
    }
}
