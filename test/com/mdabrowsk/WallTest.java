package com.mdabrowsk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WallTest
{
    List<Block> list = new ArrayList<>();
    Structure wall = new Wall(list);


    @BeforeEach
    void setUp()
    {
        list.add(new BlockImpl("blue","clay"));
        list.add(new CompositeBlockImpl(List.of(new BlockImpl("yellow","metal"),
                new BlockImpl("purple","metal"),
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
    }
    @Test
    void findBlockByColor()
    {
        Optional<Block> blockOptional = wall.findBlockByColor("transparent");
        assertTrue(blockOptional.isPresent());
        assertEquals("transparent", blockOptional.get().getColor());
        assertEquals("glass", blockOptional.get().getMaterial());
    }
    @Test
    void findBlockByColorEasyCase()
    {
        Optional<Block> blockOptional = wall.findBlockByColor("blue");
        assertTrue(blockOptional.isPresent());
        assertEquals("blue", blockOptional.get().getColor());
        assertEquals("clay", blockOptional.get().getMaterial());
    }

    @Test
    void findBlockByColorNotFoundCase()
    {
        Optional<Block> blockOptional = wall.findBlockByColor("not existing color");
        assertTrue(blockOptional.isEmpty());
    }

    @Test
    void findBlocksByMaterial()
    {
        List<Block> blockOptional = wall.findBlocksByMaterial("glass");
        assertEquals(1, blockOptional.size());
        assertEquals("glass", blockOptional.get(0).getMaterial());
        assertEquals("transparent", blockOptional.get(0).getColor());

    }
    @Test
    void findBlocksByMaterialNotFoundCase()
    {
        List<Block> blockOptional = wall.findBlocksByMaterial("not existing material");
        assertEquals(0, blockOptional.size());
    }

    @Test
    void count()
    {
        assertEquals(11,wall.count());
    }
}