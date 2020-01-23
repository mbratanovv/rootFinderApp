package comp1555;

import static comp1555.CommonCode.getDecimalPoints;
import static comp1555.TablePlotting.SecantData;

/**
 *
 * @author lilbrtnv
 */
public class SecantMethod extends COMP1555 {

//<editor-fold defaultstate="collapsed" desc="Referenced code from lectures : only the core part : adapted and modified the method to work for my program">
    public static void FirstF() { //x-x^2
        int counter = 0;
        double xInitial = Double.parseDouble(xValueUserText.getText());
        double xInitial2 = 1.5*(xInitial);
        double difference = 0.0;
        
        do {
            
            double fxInitial = xInitial - Math.pow(xInitial, 2); //f(xInitial)
            double fxInitial2 = xInitial2 - Math.pow(xInitial2, 2); //f(xInitial2)
            double xsum = xInitial - (((xInitial - xInitial2) * fxInitial) / (fxInitial - fxInitial2)); //whole formula
            double updatedFunction = xsum - Math.pow(xsum, 2); //new function for the graph
            difference = Math.abs(xInitial - xInitial2);
            secant.add(xsum, updatedFunction);//adding the graphs to the chart
            SecantData[counter][0] = counter + 1;
            SecantData[counter][1] = getDecimalPoints(xInitial);
            SecantData[counter][2] = getDecimalPoints(xInitial2);
            SecantData[counter][3] = getDecimalPoints(fxInitial);
            SecantData[counter][4] = getDecimalPoints(fxInitial2);
            SecantData[counter][5] = getDecimalPoints(difference);
            SecantData[counter][6] = getDecimalPoints(xsum);
            xInitial2 = xInitial; //updating the values for the next iteration
            xInitial = xsum;
            System.out.println((counter + 1) + ": {" + getDecimalPoints(xsum) + "}");
            counter++;
        } while (difference > 0.00001);
        System.out.println("Secant method converged after " + "{" + counter + "}" + " iterations!");
    }
    
    public static void SecondF() { //ln(x+1)+1
        int counter = 0;
        double xInitial = Double.parseDouble(xValueUserText.getText());
        double xInitial2 = xInitial + 1.5;
        double difference = 0.0;
        
        do {
            
            double fxInitial = (Math.log(xInitial + 1)) + 1; //f(xInitial)
            double fxInitial2 = (Math.log(xInitial2 + 1)) + 1; //f(xInitial2)
            double xsum = xInitial - (((xInitial - xInitial2) * fxInitial) / (fxInitial - fxInitial2)); //whole formula
            double updatedFunction = (Math.log(xsum + 1)) + 1; //new function for the graph
            difference = Math.abs(xInitial - xInitial2);
            secant.add(xsum, updatedFunction); //adding the graphs to the chart
            SecantData[counter][0] = counter + 1;
            SecantData[counter][1] = getDecimalPoints(xInitial);
            SecantData[counter][2] = getDecimalPoints(xInitial2);
            SecantData[counter][3] = getDecimalPoints(fxInitial);
            SecantData[counter][4] = getDecimalPoints(fxInitial2);
            SecantData[counter][5] = getDecimalPoints(difference);
            SecantData[counter][6] = getDecimalPoints(xsum);
            xInitial2 = xInitial; //updating the values for the next iteration
            xInitial = xsum;
            System.out.println((counter + 1) + ": {" + getDecimalPoints(xsum) + "}");
            counter++;
        } while (difference > 0.00001);
        System.out.println("Secant method converged after " + "{" + counter + "}" + " iterations!");
        
    }
    
    public static void ThirdF() { //e^x-3x
        int counter = 0;
        double xInitial = Double.parseDouble(xValueUserText.getText());
        double xInitial2 = xInitial + 1.5;
        double difference = 0.0;
        
        do {
            
            double fxInitial = (Math.exp(xInitial) - (3 * xInitial)); //f(xInitial)
            double fxInitial2 = (Math.exp(xInitial2) - (3 * xInitial2)); //f(xInitial2)
            double xsum = xInitial - (((xInitial - xInitial2) * fxInitial) / (fxInitial - fxInitial2)); //whole formula
            double updatedFunction = (Math.exp(xsum) - (3 * xsum)); //new function for the graph
            difference = Math.abs(xInitial - xInitial2);
            secant.add(xsum, updatedFunction); //adding the graphs to the chart
            SecantData[counter][0] = counter + 1;
            SecantData[counter][1] = getDecimalPoints(xInitial);
            SecantData[counter][2] = getDecimalPoints(xInitial2);
            SecantData[counter][3] = getDecimalPoints(fxInitial);
            SecantData[counter][4] = getDecimalPoints(fxInitial2);
            SecantData[counter][5] = getDecimalPoints(difference);
            SecantData[counter][6] = getDecimalPoints(xsum);
            xInitial2 = xInitial; //updating the values for the next iteration
            xInitial = xsum;
            System.out.println((counter + 1) + ": {" + getDecimalPoints(xsum) + "}");
            counter++;
        } while (difference > 0.00001);
        System.out.println("Secant method converged after " + "{" + counter + "}" + " iterations!");
    }
//</editor-fold>
}
