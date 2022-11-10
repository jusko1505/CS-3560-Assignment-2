package UserComponents;
import java.util.*;
// a singleton that holds all "positive words"
public class PositiveDict {
    private static PositiveDict positiveDict = null;
    private static HashSet<String> dict = new HashSet<String>();

    private PositiveDict(){
    }

    public static PositiveDict getPositiveDictInstance(){
        if(positiveDict == null){
            positiveDict = new PositiveDict();
            dict.add("good");
            dict.add("great");
            dict.add("excellent");
        }
        return positiveDict;
    }

    public void addToDict(String word){
        dict.add(word);
    }

    public HashSet<String> getDict(){
        return dict;
    }
}
