package com.mdabrowsk;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Wall implements Structure
{
    private List blocks;
    @Override
    public Optional findBlockByColor(String color)
    {
        return Optional.empty();
    }

    @Override
    public List findBlocksByMaterial(String material)
    {
        return null;
    }

    @Override
    public int count()
    {
        return 0;
    }

}
