package MainVisualizer;

import Sorts.*;

import javax.swing.JFrame;
import java.util.ArrayList;

public class Application
{
    private final JFrame frame;
    private final Visualizer visualizer;
    
    public Application()
    {
        frame = new JFrame("Sorting Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        visualizer = new Visualizer();
        frame.add(visualizer);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public void run()
    {
        ArrayList<Sort> sorts = new ArrayList<>();
        sorts.add(new BubbleSort());
        sorts.add(new SelectionSort());
        sorts.add(new InsertionSort());
        sorts.add(new MergeSort());
        sorts.add(new QuickSort());

        for (Sort sort : sorts)
        {
            visualizer.sleep(1000000000);
            visualizer.shuffleArray();
            visualizer.sleep(1000000000);
            visualizer.runSort(sort);
        }
    }

    public static void main(String[] args)
    {
        Application application = new Application();
        application.run();
    }
}
