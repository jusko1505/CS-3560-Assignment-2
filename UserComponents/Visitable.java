package UserComponents;

public interface Visitable {
    public void Tweet(Tweet myTweet, Visitor v);
    public void accept(Visitor visitor);
}
