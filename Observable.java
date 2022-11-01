import java.util.*;
public interface Observable {
    public void addObserver(Observer ob);
    //public void notifyObservers(); -> funcionality in userObserverNotifiter(visitor)
    public List<Observer> getObservers();
}
