package UserComponents;

import java.util.List;
public abstract class userComponent {
    public List<userComponent> getUserComponents(userComponent uc){
        throw new UnsupportedOperationException();
    }
    public String getID(){
        throw new UnsupportedOperationException();
    }
}
