package com.mdabrowsk;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompositeBlockImplTest
{
    private CompositeBlock block = new CompositeBlockImpl(List.of(new BlockImpl("yellow","metal"),
                                                                new BlockImpl("purple","wood")
                                                            ));
    private CompositeBlock block2 = new CompositeBlockImpl(List.of( new BlockImpl("yellow","ceramics"),
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
                                                            ));


    @Test
    void getColor()
    {
        assertEquals("yellow-purple" , block.getColor());
    }
    @Test
    void getColorNestedCase()
    {
        assertEquals("yellow-purple-transparent-pink-red-silver-red" , block2.getColor());
    }
    @Test
    void getMaterialNestedCase()
    {
        assertEquals("ceramics-metal-glass-iron-clay-clay-wood" , block2.getMaterial());
    }

    @Test
    void getMaterial()
    {
        assertEquals("metal-wood" , block.getMaterial());
    }

    @Test
    void getBlocks()
    {
        assertEquals(2, block.getBlocks().size());
        assertEquals("yellow", block.getBlocks().get(0).getColor());
        assertEquals("purple", block.getBlocks().get(1).getColor());
        assertEquals("metal", block.getBlocks().get(0).getMaterial());
        assertEquals("wood", block.getBlocks().get(1).getMaterial());

    }
}