package domain;

public class BlogTopic {

    private String text;

    public BlogTopic(String text) {
        this.text = text;
    }

    public String getText(){
        return this.text;
    }
}