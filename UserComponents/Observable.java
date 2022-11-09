package UserComponents;
import java.util.*;

public interface Observable {
    public void addObserver(Observer ob);
    public List<Observer> getObservers();
}
