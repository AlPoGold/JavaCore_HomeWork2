package org.example.tic_tac_toe;

import java.util.ArrayList;
import java.util.Iterator;

public class Lines implements Iterable<Line>
{
    private ArrayList<Line> lines = new ArrayList<Line>();
    public Lines()
    {
        int[][] rawLines = {
                { 0, 1, 2 },
                { 3, 4, 5 },
                { 6, 7, 8 },
                { 0, 3, 6 },
                { 1, 4, 7 },
                { 2, 5, 8 },
                { 0, 4, 8 },
                { 2, 4, 6 }
        };

        for (int[] rawLine : rawLines)
        {
            Line line = new Line(rawLine[0], rawLine[1], rawLine[2]);
            lines.add(line);
        }
    }
    public Iterator<Line> iterator()
    {
        return lines.iterator();
    }
}