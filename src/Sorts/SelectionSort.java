package Sorts;

import MainVisualizer.Visualizer;

public class SelectionSort implements Sort
{
    private int sleep = 16000000;
    @Override
    public void sort(Visualizer visualizer, int[] values)
    {
        long start = System.currentTimeMillis();
        for (int i = 0; i < values.length; i++)
        {
            int minIndex = i;
            for (int j = i; j < values.length; j++)
                if (values[j] < values[minIndex])
                    minIndex = j;

            visualizer.swapIndex(i, minIndex, sleep);
        }
        System.out.println("Selection Sort: " + (System.currentTimeMillis() - start) + " ms");
    }

    @Override
    public String toString()
    {
        return "Selection Sort";
    }
}
