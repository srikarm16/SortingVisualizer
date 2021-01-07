package Sorts;

import MainVisualizer.Visualizer;

public class MergeSort implements Sort
{
    private Visualizer visualizer;
    private int sleep = 5000000;

    @Override
    public void sort(Visualizer visualizer, int[] values)
    {
        this.visualizer = visualizer;
        mergeSort(0, values.length - 1);
    }

    public void mergeSort(int left, int right)
    {
        if (left < right)
        {
            int mid = (left + right) / 2;

            mergeSort(left, mid);
            mergeSort(mid + 1, right);

            merge(left, mid, mid + 1, right);
        }
    }

    public void merge(int left, int leftEnd, int right, int rightEnd)
    {
        int index = left;
        int[] values = visualizer.getArray();
        while (left <= leftEnd && right <= rightEnd)
            if (values[left] <= values[right])
                visualizer.changeVal(index++, values[left++], sleep);
            else
                visualizer.changeVal(index++, values[right++], sleep);

        if (left > leftEnd)
            for (int i = right; i <= rightEnd; i++)
                visualizer.changeVal(index++, values[i], sleep);
        else
            for (int i = left; i <= leftEnd; i++)
                visualizer.changeVal(index++, values[i], sleep);

    }

    @Override
    public String toString()
    {
        return "Merge Sort";
    }
}
