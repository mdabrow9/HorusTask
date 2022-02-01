package com.mdabrowsk;


class BlockImpl implements Block
{
    public BlockImpl(String color, String material)
    {
        this.color = color;
        this.material = material;
    }

    private String color;

    private String material;

    @Override
    public String getColor()
    {
        return color;
    }

    @Override
    public String getMaterial()
    {
        return material;
    }
}
