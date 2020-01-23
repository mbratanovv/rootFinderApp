package comp1555;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author lilbrtnv
 */
public class FunctionPlotting extends COMP1555 {

    static JFrame frame = new JFrame();

    public static void First() { //x-x^2
        ClearChartData();

        double IterationsCounter = Double.parseDouble(iterations.getText());
        if (IterationsCounter <= -10) {
            JOptionPane.showMessageDialog(frame, "Please enter a number >= -10 ");
        } else {
            for (double i = -10; i < IterationsCounter; i += 0.8) {
                function.add(i, i - Math.pow(i, 2));
            }
        }

    }

    public static void Second() { //ln(x+1)+1
        ClearChartData();
        double IterationsCounter = Double.parseDouble(iterations.getText());
        if (IterationsCounter <= -0.99) {
            JOptionPane.showMessageDialog(frame, "Please enter a number >= -0.99 ");
        } else {
            for (double i = -0.99; i < IterationsCounter; i += 0.15) {
                function.add(i, (Math.log(i + 1)) + 1);
            }
        }
    }

    public static void Third() { //e^x-3x
        ClearChartData();
        double IterationsCounter = Double.parseDouble(iterations.getText());
        if (IterationsCounter <= -10) {
            JOptionPane.showMessageDialog(frame, "Please enter a number >= -10 ");
        } else {
            for (double i = -10; i < IterationsCounter; i += 0.15) {
                function.add(i, (Math.exp(i) - (3 * i)));
            }
        }

    }

    public static void ClearChartData() {
        function.clear();
        newtonRaphson.clear();
        secant.clear();
        bisection.clear();
    }

}
