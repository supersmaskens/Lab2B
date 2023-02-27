package Transport;

import Navigation.Positionable;

public class Transporter_FIFO extends Transporter_Helper {
    public Transporter_FIFO(int capacity, Positionable positionable){
        super(capacity,positionable);
    }
    @Override
    public boolean unload(ITransportable t){
        if (canLoad && currentTransports.contains(t)
                && t == currentTransports.get(0)) {
            return currentTransports.remove(t);
        }
        return false;
    }
}
