package DefinigClassPractice;

import java.util.ArrayList;

public class ForumPost {
    public String author;
    public String text;
    public int upVotes;

    public ArrayList<String> replies = new ArrayList<>();

    public ForumPost(String author, String text, int upVotes) {
        this.author = author;
        this.text = text;
        this.upVotes = upVotes;
    }

    public ForumPost(String author, String text) {
        this.author = author;
        this.text = text;
        this.upVotes = 0;
    }

    public String format() {
        String result = (text + " / by " + author + ", " + upVotes + " votes.\n");
        if(!replies.isEmpty()){
            for (String reply: replies ) {
                result += (("- " + reply + "\n"));
            }
        }
        return result;
    }
}
