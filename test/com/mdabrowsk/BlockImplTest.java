package com.mdabrowsk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlockImplTest
{
    private final Block block = new BlockImpl("red","wood");

    @Test
    void getColor()
    {
        assertEquals("red",block.getColor());
    }

    @Test
    void getMaterial()
    {
        assertEquals("wood",block.getMaterial());
    }
}