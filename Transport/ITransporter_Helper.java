package Transport;

import Navigation.Positionable;


public interface ITransporter_Helper {
    void loadableOn();
    void loadableOff();
    boolean canTransport(ITransportable t);
    void updatePosition(Positionable positionable);
    boolean load(ITransportable t);
    boolean unload(ITransportable t);
    boolean contains(ITransportable t);
    boolean isEmpty();
    void updateTransports();

}
