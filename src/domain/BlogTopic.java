package domain;

public class BlogTopic {

    private Person author;
    private String text;

    public BlogTopic(Person author, String text)
    {
        this.author = author;
        this.text = text;
    }

    public Person getAuthor(){
        return this.author;
    }
    public String getText(){
        return this.text;
    }
}