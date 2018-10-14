package ru.grigorev.algorithms.lesson4.webinar;

public class MainClass {
    public static void main(String[] args) {
        RelatedList rl = new RelatedList();
        rl.insert(new Cat(2, "cat-1"));
        rl.insert(new Cat(2, "cat-2"));
        rl.insert(new Cat(2, "cat-3"));
        rl.insert(new Cat(2, "cat-4"));
        System.out.println(rl);
        System.out.println(rl.remove());
        System.out.println(rl);
    }
}
