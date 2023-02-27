package MVCandMain;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements IObservable {

    ArrayList<Actor> actors = new ArrayList<>();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
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
        for(Actor actor : actors) {
            g.drawImage(actor.getImage(), actor.getX(), actor.getY(), null); // see javadoc for more info on the parameters
        }
    }
}
