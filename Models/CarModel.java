package Models;

import java.awt.*;

public class CarModel implements IModel{
    /**
     * Color of the car.
     */
    private Color color;

    /**
     * The car model name.
     */
    private final String modelName;


    /**
     * Constructor for car.
     * @param color sets car color
     * @param modelName sets modelName
     */
    public CarModel(Color color, String modelName){
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