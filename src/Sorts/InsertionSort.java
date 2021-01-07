package Sorts;

import MainVisualizer.Visualizer;

public class InsertionSort implements Sort
{
    private int sleep = 600000;

    @Override
    public void sort(Visualizer visualizer, int[] values)
    {
        long start = System.currentTimeMillis();
        for (int i = 0; i < values.length - 1; i++)
        {
            if (values[i + 1] < values[i])
            {
                int j = i;
                while (values[j + 1] < values[j])
                {
                    visualizer.swapIndex(j + 1, j, sleep);
                    if (j == 0)
                        break;
                    j--;
                }
            }
        }
        System.out.println("Insertion Sort: " + (System.currentTimeMillis() - start) + " ms");
    }

    @Override
    public String toString()
    {
        return "Insertion Sort";
    }
}
