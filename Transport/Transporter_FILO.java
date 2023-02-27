package Transport;

import Navigation.Positionable;

public class Transporter_FILO extends Transporter_Helper{
    public Transporter_FILO(int capacity, Positionable positionable){
        super(capacity, positionable);
    }
    @Override
    public boolean unload(ITransportable t){
        if (canLoad && currentTransports.contains(t)
                && t == currentTransports.get(currentTransports.size()-1)) {
            return currentTransports.remove(t);
        }
        return false;
    }
}
