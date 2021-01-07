package Sorts;

import MainVisualizer.Visualizer;

public class QuickSort implements Sort
{
    Visualizer visualizer;
    private int sleep = 5000000;

    @Override
    public void sort(Visualizer visualizer, int[] values)
    {
        this.visualizer = visualizer;
        quickSort(values, 0, values.length - 1);
    }

    private void quickSort(int[] values, int start, int end)
    {
        if (start < end)
        {
            int pivot = pivotArray(values, start, end);
            quickSort(values, start, pivot - 1);
            quickSort(values, pivot + 1, end);
        }
    }

    private int pivotArray(int[] values, int start, int end)
    {
        int pivot = end;
        end--;

        while (start <= end)
        {
            if (values[start] > values[pivot])
            {
                visualizer.swapIndex(start, end, sleep);
                visualizer.swapIndex(end, pivot, sleep);
                pivot--;
                end--;
            }
            else
                start++;
        }

        return pivot;
    }

    @Override
    public String toString()
    {
        return "Quick Sort";
    }
}
