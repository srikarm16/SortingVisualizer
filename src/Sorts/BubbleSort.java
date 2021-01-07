package Sorts;

import MainVisualizer.Visualizer;

public class BubbleSort implements Sort
{
    private int sleep = 650000;

    @Override
    public void sort(Visualizer visualizer, int[] values)
    {
        long start = System.currentTimeMillis();
        for (int i = 0; i < values.length; i++)
            for (int j = 1; j < values.length - i; j++)
                if (values[j - 1] > values[j])
                    visualizer.swapIndex(j, j - 1, sleep);
        System.out.println(toString() + ": " + (System.currentTimeMillis() - start));
    }

    @Override
    public String toString()
    {
        return "Bubble Sort";
    }
}
