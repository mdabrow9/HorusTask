package com.mdabrowsk;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * implementacja interfejsu CompositeBlock
 * kolor zwraca jako połączenie nazw rozdzielonych separatorem
 * materiał analogicznie
 * wykorzystywany do implementacji jest wzorzec kompozyt
 */
class CompositeBlockImpl  implements CompositeBlock
{
    public static final String SEPARATOR = "-";
    List<Block> blocks;

    public CompositeBlockImpl(List<Block> blocks)
    {
        this.blocks = blocks;
    }

    @Override
    public String getColor()
    {
        return getProperty(Block::getColor);
    }

    @Override
    public String getMaterial()
    {
        return getProperty(Block::getMaterial);

    }

    private String getProperty(Function<Block, String> supplierFunc)
    {
        List<String> strings = new LinkedList<>();
        for(Block block: blocks)
        {
            if(block instanceof CompositeBlockImpl)
            {
                strings.addAll(((CompositeBlockImpl) block).getBlocks().stream().map(supplierFunc::apply).filter(e -> !e.equals("")).collect(Collectors.toList()));
            }
            else
            {
                strings.add(supplierFunc.apply(block));
            }
        }
        return strings.size()>0? String.join(SEPARATOR, strings) : "";
    }

    @Override
    public List<Block> getBlocks()
    {
        return blocks;
    }
}