package UserComponents;
/* Implements the Visitor.java interface */
public class userObserverNotifier implements Visitor {
    
    /*
     * A mixture of the Visitor/Observer patterns. 
     * The outside is the visitor pattern. Inside is
     * an obeserver pattern functionality that goes 
     * through an observable's observers and update()'s
     * them
     */
    
    @Override
    public void visit(User u) {
        if(u.getObservers() == null){
            return;
        }
        for(Observer ob: u.getObservers()){
            ob.update();
        }

        
    }
    
}
