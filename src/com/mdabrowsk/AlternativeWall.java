package com.mdabrowsk;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * alternatywna implementacja interfejsu Structure
 * opiera się ona na tym że nie wyciąga ona Bloków ze środka struktury
 * podobnie jak Wall korzysta z funkcji pomocniczych posiadających funkcje jako parametr
 */
class AlternativeWall implements Structure
{
    private List<Block> blocks;

    public AlternativeWall(List<Block> blocks)
    {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color)
    {
        return getBlockStreamBySearchParameterAndFunction(color, Block::getColor).findAny();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material)
    {

        return getBlockStreamBySearchParameterAndFunction(material, Block::getMaterial).collect(Collectors.toList());
    }

    @Override
    public int count()
    {
        return blocks.size();
    }


    private Stream<Block> getBlockStreamBySearchParameterAndFunction(String parameter, Function<Block, String> getPropertyFunction)
    {
        return blocks.stream().filter(e -> getPropertyFunction.apply(e).contains(parameter));
    }
}
