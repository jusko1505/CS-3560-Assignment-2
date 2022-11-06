package UserComponents;


public class userObserverNotifier implements Visitor {

    @Override
    public void visit(User u) {
        // TODO Auto-generated method stub
        if(u.getObservers()==null){
            return;
        }
        for(Observer ob: u.getObservers()){
            ob.update();
        }

        
    }

    /*
    public void visit(UserGroup ug){
        /functionality
    }
     */
    

    
    
    

    
    
}
