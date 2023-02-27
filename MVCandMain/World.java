package MVCandMain;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class World {
    ArrayList<Actor> actors = new ArrayList<>();
    ArrayList<IObservable> observers = new ArrayList<>();

    public void addObserver(IObservable o){
        observers.add(o);
    }
    public void updateObservers(){
        ArrayList<Actor> update = new ArrayList<>(actors);
        for (IObservable o : observers){
            o.receiveUpdatedActors(update);
        }
    }
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private final Timer timer = new Timer(delay, new TimerListener());
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Actor actor : actors) {
                actor.moveit();
            }
            updateObservers();
        }
    }
    public void start(){
        timer.start();
    }

    void gas(int amount) {
        for (Actor actor : actors) {
            actor.gas(amount);
        }
    }

    void brake(int amount) {
        for (Actor actor : actors) {
            actor.brake(amount);
        }
    }

    void turboOn() {
        for (Actor actor : actors) {
            actor.turboOn();
        }
    }
    void turboOff() {
        for (Actor actor : actors) {
            actor.turboOff();
        }
    }
    void liftUp() {
        for (Actor actor : actors) {
            actor.liftUp();
        }
    }
    void liftDown() {
        for (Actor actor : actors) {
            actor.liftDown();
        }
    }
    void startAll(){
        for(Actor actor: actors){
            actor.startEngine();
        }
    }
    void stopAll(){
        for(Actor actor: actors){
            actor.stopEngine();
        }
    }
    void removeCar(int index){
        actors.remove(index);
        updateYPosAfterRemoval();
    }
    void updateYPosAfterRemoval(){
        for(int i = 0; i < actors.size(); i++){
            actors.get(i).setY(i * 80);
        }
    }
    void addCar(String modelName) {
        if (actors.size() >= 10) {
            return;
        }
        int yPosition = actors.size() * 80;
        if (modelName.equals("Volvo240")){
            Actor actor = Actor.Volvo240(0,yPosition,0);
            actors.add(actor);
        }
        if (modelName.equals("Saab95")){
            Actor actor = Actor.Saab95(0,yPosition,0);
            actors.add(actor);
        }
        if (modelName.equals("Scania")){
            Actor actor = Actor.Scania(0, yPosition, 0);
            actors.add(actor);
        }
    }
}
