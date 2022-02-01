package com.mdabrowsk;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Wall implements Structure
{
    private List<Block> blocks;

    public Wall(List<Block> blocks)
    {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color)
    {
        return findBlocksByProperty(color, blocks, Block::getColor).stream().findAny();
    }

    @Override
    public int count()
    {
        return count(blocks);
    }


    @Override
    public List<Block> findBlocksByMaterial(String material)
    {
        return findBlocksByProperty(material, blocks, Block::getMaterial);
    }



    private int count(List<Block> blocks)
    {
        int count = 0;
        for (Block block : blocks)
        {
            if(block instanceof CompositeBlock)
            {
                count += count(((CompositeBlock) block).getBlocks());
            }
            else
            {
                count++;
            }
        }
        return count;
    }

    private List<Block> findBlocksByProperty(String color, List<Block> blocks, Function<Block, String> getPropertyFunction)
    {
        List<Block> result = new ArrayList<>();
        for(Block block : blocks)
        {
            if(block instanceof CompositeBlock)
            {
                result.addAll(findBlocksByProperty(color, ((CompositeBlock)block).getBlocks(), getPropertyFunction));

            }
            else
            {
                if(getPropertyFunction.apply(block).equals(color))
                {
                    result.add(block);
                }
            }
        }
        return result;
    }
}
