package MainVisualizer;

import Sorts.Sort;

import javax.swing.JPanel;
import java.awt.*;
import java.util.Random;

public class Visualizer extends JPanel
{
    public static final int WIDTH = 1180;
    public static final int HEIGHT = 720;

    private static final int BAR_WIDTH = 2;
    private static final int NUM_BARS = WIDTH/BAR_WIDTH;
    private static final int HEIGHT_MULTIPLIER = HEIGHT/NUM_BARS;

    private final int[] array;
    private String sortName = "";

    private long start;
    private long totalPaintTime;
    private boolean isRunning = false;

    public Visualizer()
    {
        setBackground(Color.DARK_GRAY);
        array = new int[NUM_BARS];
        for (int i = 0; i < NUM_BARS; i++)
            array[i] = i;
    }

    public void shuffleArray()
    {
        sortName = "Shuffling";
        Random rand = new Random();
        for (int i = 0; i < array.length; i++)
        {
            int index = rand.nextInt(array.length - 1);
            swapIndex(i, index, 1000000);
        }
    }

    public void swapIndex(int i, int j, int ns)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        animate(ns);
    }

    public void changeVal(int index, int value, int ns)
    {
        array[index] = value;
        animate(ns);
    }

    public void animate(int ns)
    {
        repaint();
        sleep(ns);
    }

    public void sleep(int nanoseconds)
    {
        long start = System.nanoTime();
        long end = System.nanoTime() - start;
        while (end < nanoseconds)
            end = System.nanoTime() - start;
    }

    public void runSort(Sort sort)
    {
        isRunning = true;
        totalPaintTime = 0; 
        sortName = sort.toString();
        start = System.currentTimeMillis();
        sort.sort(this, array);
        isRunning = false;
    }

    public int[] getArray()
    {
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        long startPaint = System.currentTimeMillis();

        Graphics2D graphics = (Graphics2D)g;
        super.paintComponent(graphics);

        graphics.setColor(Color.WHITE);

        for (int i = 0; i < NUM_BARS; i++)
        {
            int height = array[i] * HEIGHT_MULTIPLIER;
            int x = i * BAR_WIDTH;
            int y = HEIGHT - height;

            graphics.fillRect(x, y, BAR_WIDTH, height);
        }
//        System.out.println(System.currentTimeMillis() - startPaint + " paint time");
//        totalPaintTime += System.currentTimeMillis() - startPaint;
//        System.out.println(totalPaintTime);

//        if (isRunning)
//        {
//            long currSortTime = System.currentTimeMillis() - totalPaintTime - this.start;
//            graphics.drawString(sortName + ": " + currSortTime + " ms", 8, 20);
//        }
//        else
            graphics.drawString(sortName, 8, 20);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(WIDTH, HEIGHT);
    }
}
