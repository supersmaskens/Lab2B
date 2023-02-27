package MVCandMain;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SpeedView extends JFrame {
    private static final int X = 600;
    private static final int Y = 240;

    public DrawSpeed drawspeed = new DrawSpeed(150, 200);
    Buttons buttons;


    public SpeedView(String title, CarController cc){
        buttons = new Buttons(cc);
        initComponents(title);
    }

    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawspeed);

        this.add(buttons.initializeSpinners());

        this.add(buttons.initializeSpeedPanel(X));


        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


}
