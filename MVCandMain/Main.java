package MVCandMain;


public class Main {
    public static void main(String[] args) {
        // Instance of this class
        World world = new World();
        Buttons buttons = new Buttons(new CarController(world));
        DrawPanel drawPanel = new DrawPanel(800, 800);
        DrawSpeed drawSpeed = new DrawSpeed(150, 220);

        // Start a new view and send a reference of self
        CarView frame = new CarView("CarSim 1.0", 800, 1080);
        frame.addPanel(drawPanel);
        frame.addPanel(drawSpeed);
        frame.addPanel(buttons.initializeSpinners());
        frame.addPanel(buttons.initializeControlPanel(800));
        frame.finishFrame();
        //SpeedView speedy = new SpeedView("Speedy", cc);
        world.addObserver(drawPanel);
        world.addObserver(drawSpeed);
        world.updateObservers();
        // Start the timer
        world.start();
    }



}
