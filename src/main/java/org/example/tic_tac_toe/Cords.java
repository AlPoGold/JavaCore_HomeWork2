package org.example.tic_tac_toe;

import java.io.Serializable;

public class Cords
{
    final private int number;

    public Cords(final int number)
    {
        this.number = number;
    }

    public int getIndex()
    {
        return number;
    }

    public String toString()
    {
        return Integer.toString(number);
    }

}
