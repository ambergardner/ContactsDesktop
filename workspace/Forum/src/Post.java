
public class Post {
    int replyId;
    String text;
    String author;

    public Post(int replyId, String author, String text) {
        this.replyId = replyId;
        this.text = text;
        this.author = author;
    }
}
