package ru.grigorev.algorithms.lesson4;

import ru.grigorev.algorithms.lesson4.webinar.Cat;

/**
 * @author Dmitriy Grigorev
 */
public class LinkIteratorApp {
    public static void main(String[] args) {
        DoubleRelatedList list = new DoubleRelatedList();

        Cat barsik = new Cat(3, "BARSIK");
        Cat murzik = new Cat(5, "MURZIK");
        Cat vaska = new Cat(5, "VASKA");

        list.insertTail(barsik);

        DoubleRelatedList.DRLIterator iter = list.getCustomIterator();

        System.out.println("current: " + iter.current());
        iter.insertBefore(murzik);
        iter.insertAfter(vaska);

        for (Cat c : list) {
            System.out.println(c);
        }
    }
}
