package Navigation;

public class Positionable {
    /**
     * Represents position on X-axis.
     */
    private final double xPosition;
    /**
     * Represents position on Y-axis.
     */
    private final double yPosition;
    /**
     * Represents direction and should always be between -2 * PI and 2 * PI.
     */
    private final double direction;
    public Positionable(double xPosition,double yPosition, double direction){
        this.xPosition=xPosition;
        this.yPosition=yPosition;
        this.direction=direction;
    }
    public Positionable(Positionable positionable){
        this.xPosition = positionable.xPosition;
        this.yPosition = positionable.yPosition;
        this.direction = positionable.direction;
    }
    public double getDirection() {
        return direction;
    }

    public double getxPosition() {
        return xPosition;
    }

    public double getyPosition() {
        return yPosition;
    }

}
