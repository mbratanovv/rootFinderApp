package comp1555;

import static comp1555.CommonCode.clearArrayData;
import static comp1555.CommonCode.clearTableData;
import static comp1555.CommonCode.getDecimalPoints;
import static comp1555.FunctionPlotting.frame;
import static comp1555.TablePlotting.BisectionData;
import javax.swing.JOptionPane;

/**
 *
 * @author lilbrtnv
 */
public class BisectionMethod extends COMP1555 {

//<editor-fold defaultstate="collapsed" desc="Referenced code from lectures : only the core part : adapted and modified the method to work for my program">
    public static void FirstF() { //x-x^2
        clearArrayData(BisectionArray);
        clearTableData(BisectionData);
        int counter = 0;
        double difference = 0.0;
        double xLeftBound = Double.parseDouble(xLeftBisectionB.getText()); //Lower bound
        double xRightBound = Double.parseDouble(xRightBisectionB.getText()); //Right bound
        double FxLeftBound = xLeftBound - Math.pow(xLeftBound, 2);
        double FxRightBound = xRightBound - Math.pow(xRightBound, 2);
        double xNext, FxNext;
        if (xLeftBound >= xRightBound) {
            JOptionPane.showMessageDialog(frame, "The lower bound should be < the upper bound! ");
        } else {
            do {
                
                xNext = (xLeftBound + xRightBound) / 2.0; //Middle point
                FxNext = xNext - Math.pow(xNext, 2); //F(Middle point)
                difference = Math.abs(xRightBound - xLeftBound) / 2;
                BisectionData[counter][0] = counter + 1;
                BisectionData[counter][1] = getDecimalPoints(xLeftBound);
                BisectionData[counter][2] = getDecimalPoints(xNext);
                BisectionData[counter][3] = getDecimalPoints(xRightBound);
                BisectionData[counter][4] = getDecimalPoints(FxNext);
                BisectionData[counter][5] = getDecimalPoints(difference);
                if (FxLeftBound * FxNext > 0) {
                    xLeftBound = xNext;
                    FxLeftBound = FxNext;
                } else if (FxRightBound * FxNext > 0) {
                    xRightBound = xNext;
                    FxRightBound = FxNext;
                }
                bisection.add(xNext, FxNext);//adding the graphs to the chart
                counter++;
            } while (difference > 0.00001);
            System.out.println("Bisection method converged after " + "{" + counter + "}" + " iterations!");
        }
    }
    
    
    
    public static void SecondF() { //ln(x+1)+1
        clearArrayData(BisectionArray);
        clearTableData(BisectionData);
        int counter = 0;
        double difference = 0.0;
        double xLeftBound = Double.parseDouble(xLeftBisectionB.getText());
        double xRightBound = Double.parseDouble(xRightBisectionB.getText());
        double FxLeftBound = (Math.log(xLeftBound + 1)) + 1;
        double FxRightBound = (Math.log(xRightBound + 1)) + 1;
        double xNext, FxNext;
        if (xLeftBound >= xRightBound) {
            JOptionPane.showMessageDialog(frame, "The lower bound should be < the upper bound! ");
        } else {
            do {
                
                xNext = (xLeftBound + xRightBound) / 2.0;
                FxNext = (Math.log(xNext + 1)) + 1;
                difference = Math.abs(xRightBound - xLeftBound) / 2;
                BisectionData[counter][0] = counter + 1;
                BisectionData[counter][1] = getDecimalPoints(xLeftBound);
                BisectionData[counter][2] = getDecimalPoints(xNext);
                BisectionData[counter][3] = getDecimalPoints(xRightBound);
                BisectionData[counter][4] = getDecimalPoints(FxNext);
                BisectionData[counter][5] = getDecimalPoints(difference);
                if (FxLeftBound * FxNext > 0) {
                    xLeftBound = xNext;
                    FxLeftBound = FxNext;
                } else if (FxRightBound * FxNext > 0) {
                    xRightBound = xNext;
                    FxRightBound = FxNext;
                }
                bisection.add(xNext, FxNext);//adding the graphs to the chart
                counter++;
            } while (difference > 0.00001);
            System.out.println("Bisection method converged after " + "{" + counter + "}" + " iterations!");
        }
    }
    
    
    
    public static void ThirdF() { //e^x-3x
        clearArrayData(BisectionArray);
        clearTableData(BisectionData);
        int counter = 0;
        double difference = 0.0;
        double xLeftBound = Double.parseDouble(xLeftBisectionB.getText());
        double xRightBound = Double.parseDouble(xRightBisectionB.getText());
        double FxLeftBound = (Math.exp(xLeftBound) - (3 * xLeftBound));
        double FxRightBound = (Math.exp(xRightBound) - (3 * xRightBound));
        double xNext, FxNext;
        if (xLeftBound >= xRightBound) {
            JOptionPane.showMessageDialog(frame, "The lower bound should be < the upper bound! ");
        } else {
            do {
                
                xNext = (xLeftBound + xRightBound) / 2.0;
                FxNext = (Math.exp(xNext) - (3 * xNext));
                difference = Math.abs(xRightBound - xLeftBound) / 2;
                BisectionData[counter][0] = counter + 1;
                BisectionData[counter][1] = getDecimalPoints(xLeftBound);
                BisectionData[counter][2] = getDecimalPoints(xNext);
                BisectionData[counter][3] = getDecimalPoints(xRightBound);
                BisectionData[counter][4] = getDecimalPoints(FxNext);
                BisectionData[counter][5] = getDecimalPoints(difference);
                if (FxLeftBound * FxNext > 0) {
                    xLeftBound = xNext;
                    FxLeftBound = FxNext;
                } else if (FxRightBound * FxNext > 0) {
                    xRightBound = xNext;
                    FxRightBound = FxNext;
                }
                bisection.add(xNext, FxNext);//adding the graphs to the chart
                counter++;
            } while (difference > 0.00001);
            System.out.println("Bisection method converged after " + "{" + counter + "}" + " iterations!");
        }
    }
//</editor-fold>
}
