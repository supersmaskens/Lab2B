package MVCandMain;


import static java.lang.System.out;


public class CarController {

    private final World world;

    public CarController(World world){
        this.world = world;
    }

    void gas(int amount) {
        world.gas(amount);
    }

    void brake(int amount) {
        world.brake(amount);
    }

    void turboOn() {
        world.turboOn();
    }
    void turboOff() {
        world.turboOff();
    }
    void liftUp() {
        world.liftUp();
    }
    void liftDown() {
        world.liftDown();
    }
    void startAll(){
        world.startAll();
    }
    void stopAll(){
        world.stopAll();
    }
    void removeCar(int index){
        world.removeCar(index);
    }
    void addCar(String modelName) {
        world.addCar(modelName);
    }
    int amountOfCars(){
        return world.actors.size();
    }
}
