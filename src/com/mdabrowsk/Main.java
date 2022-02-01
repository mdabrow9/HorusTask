package com.mdabrowsk;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args)
    {
        //struktura do testów
        List<Block> list = new ArrayList<>();
        list.add(new BlockImpl("red","clay"));
        list.add(new BlockImpl("silver","iron"));
        list.add(new BlockImpl("brown","fiber"));
        list.add(new CompositeBlockImpl(List.of(new BlockImpl("yellow","metal"),
                                                new BlockImpl("purple","metal"),
                                                new BlockImpl("red","wood")
                )));
        list.add(new CompositeBlockImpl(List.of(new BlockImpl("yellow","ceramics"),
                                                new CompositeBlockImpl(List.of(
                                                        new BlockImpl("purple","metal"),
                                                        new BlockImpl("silver","clay")
                                                )),
                                                new BlockImpl("red","wood")
        )));
        list.add(new CompositeBlockImpl(List.of(new BlockImpl("yellow","ceramics"),
                                                new CompositeBlockImpl(List.of(
                                                        new BlockImpl("purple","metal"),
                                                         new CompositeBlockImpl(List.of(
                                                                new CompositeBlockImpl(List.of(
                                                                        new BlockImpl("transparent","glass"),
                                                                        new BlockImpl("pink","iron"),
                                                                        new CompositeBlockImpl(List.of())
                                                                        )),
                                                                new BlockImpl("red","clay")
                                                                )),
                                                        new BlockImpl("silver","clay")
                                                )),
                                                new BlockImpl("red","wood")
        )));

        System.out.println(new Wall(list).findBlockByColor("transparent").get().getMaterial());
    }
}




