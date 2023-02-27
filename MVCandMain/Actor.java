package MVCandMain;

import java.awt.image.BufferedImage;
import java.io.IOException;

import Cars.Car;
import Cars.Saab95;
import Cars.Scania;
import Cars.Volvo240;

import javax.imageio.ImageIO;

import static java.lang.System.out;

public class Actor {
    private BufferedImage image;
    private final Car car;


    private Actor(Car car) {
        this.car = car;
    }

    public static Actor Volvo240(double xPosition, double yPosition, double direction){
        Actor actor = new Actor(new Volvo240(xPosition,yPosition,direction));
        try {
            actor.setImage(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return actor;
    }
    public static Actor Saab95(double xPosition, double yPosition, double direction){
        Actor actor = new Actor(new Saab95(xPosition,yPosition,direction));
        try {
            actor.setImage(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return actor;
    }
    public static Actor Scania(double xPosition, double yPosition, double direction){
        Actor actor = new Actor(new Scania(xPosition,yPosition,direction));
        try {
            actor.setImage(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return actor;
    }
    public BufferedImage getImage(){
        return image;
    }

    private void setImage(BufferedImage image) {
        this.image = image;
    }
    public String getModelName(){
        return car.getModelName();
    }

    public void moveit(){
        invertDirection();
        car.move();
    }
    void invertDirection(){
        if(car.getX() >= 684 || car.getX() < 0) {
            car.setDirection((car.getDirection() + Math.PI) % (2 * Math.PI));
        }
    }

    public int getX(){
        return (int) Math.round(car.getX());
    }
    public int getY(){
        return (int) Math.round(car.getY());
    }
    public double getCurrentSpeed(){
        return car.getCurrentSpeed();
    }
    public void setY(double yPosition){
        car.setY(yPosition);
    }
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        car.gas(gas);
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        car.brake(brake);
    }

    void turboOn() {
        if(car instanceof Saab95){
            ((Saab95) car).setTurboOn();
        }
    }
    void turboOff() {
        if(car instanceof Saab95){
            ((Saab95) car).setTurboOff();
        }
    }
    void liftUp() {
        if(car instanceof Scania){
            ((Scania) car).increaseTiltFlatbed();
        }
    }
    void liftDown() {
        if(car instanceof Scania){
            ((Scania) car).decreaseTiltFlatbed();
        }
    }
    void startEngine(){
        car.startEngine();
    }
    void stopEngine(){
        car.stopEngine();
    }
}
