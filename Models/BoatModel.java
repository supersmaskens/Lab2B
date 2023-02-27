package Models;

import java.awt.*;

public class BoatModel implements IModel{
    /**
     * Color of the boat.
     */
    private Color color;

    /**
     * The boat model name.
     */
    private final String modelName;
    public BoatModel(Color color, String modelName){
        this.color=color;
        this.modelName = modelName;
    }
    public Color getColor() {
        return new Color(color.getRed(),color.getGreen(),color.getBlue(),color.getAlpha());
    }

    public void setColor(Color clr) {
        color = new Color(clr.getRed(),clr.getGreen(),clr.getBlue(),clr.getAlpha());
    }

    public String getModelName() {
        return modelName;
    }


}
