package DefinigClassPractice;

public class main {
    public static void main(String[] args) {
        ForumPost post1 = new ForumPost("Steven", "How to find use for every Microsoft product.");
        post1.replies.add("I like Google!");
        post1.replies.add("Ugh, Microsoft... :(");

        ForumPost post2 = new ForumPost("Edward", "Ford Focus for sale. First owner. Good mileage.", 300);

        System.out.print(post1.format());

        System.out.print(post2.format());
    }
}
