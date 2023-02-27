package MVCandMain;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawSpeed extends JPanel implements IObservable{

    ArrayList<Actor> actors = new ArrayList<>();
    public DrawSpeed(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);
    }
    @Override
    public void receiveUpdatedActors(ArrayList<Actor> actors) {
        this.actors = actors;
        repaint();
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int ySpace = 1;
        for(Actor actor : actors) {
            char[] text = speed(actor);
            g.drawChars(text, 0,
                    text.length, 0, 20 * ySpace++); // see javadoc for more info on the parameters
        }
    }

    private char[] speed(Actor actor){
        String speed = actor.getModelName() +
                " (" + actors.indexOf(actor) + "): " + actor.getCurrentSpeed();
        String s = speed.substring(5);
        return s.toCharArray();
    }
}
