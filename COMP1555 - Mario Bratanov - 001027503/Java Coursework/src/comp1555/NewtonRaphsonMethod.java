package comp1555;

import static comp1555.CommonCode.clearLinkedLData;
import static comp1555.CommonCode.clearTableData;
import static comp1555.CommonCode.getDecimalPoints;
import static comp1555.TablePlotting.NewtonRData;

/**
 *
 * @author lilbrtnv
 */
public class NewtonRaphsonMethod extends COMP1555 {

//<editor-fold defaultstate="collapsed" desc="Referenced code from lectures : only the core part : adapted and modified the method to work for my program">
    public static void FirstF() { //x-x^2
        clearLinkedLData(NewtonRaphsonLinkedL);
        clearTableData(NewtonRData);
        int counter = 0;
        double xInitial = Double.parseDouble(xValueUserText.getText());
        double difference = 0.0;
        
        do {
            
            double fXinitial = xInitial - Math.pow(xInitial, 2);
            double derivative = 1 - 2 * xInitial;
            double xsum = xInitial - (fXinitial) / (derivative);//xn+1
            double Fxsum = xsum - Math.pow(xsum, 2);//check to see if the approximation is close to the real answer
            difference = Math.abs(xsum - xInitial);
            newtonRaphson.add(xInitial, Fxsum);
            if (counter == 1) { //start counting from 1
                NewtonRaphsonLinkedL.head.setNewtonRaphson(getDecimalPoints(xInitial)); //add the first value as a head
            } else {
                NewtonRaphsonLinkedL.addLast(getDecimalPoints(xInitial)); //Add every other item after the first
            }
            NewtonRData[counter][0] = counter + 1;
            NewtonRData[counter][1] = getDecimalPoints(xInitial);
            NewtonRData[counter][2] = getDecimalPoints(fXinitial);
            NewtonRData[counter][3] = getDecimalPoints(derivative);
            NewtonRData[counter][4] = getDecimalPoints(difference);
            NewtonRData[counter][5] = getDecimalPoints(xsum);
            NewtonRData[counter][6] = getDecimalPoints(Fxsum);
            xInitial = xsum; //x0 = x1
            System.out.println((counter + 1) + ": {" + getDecimalPoints(xInitial) + "}");
            counter++;
        } while (difference > 0.00001);
        System.out.println("Newton-Raphson method converged after " + "{" + counter + "}" + " iterations!");
    }
    
    public static void SecondF() { //ln(x+1)+1
        clearLinkedLData(NewtonRaphsonLinkedL);
        clearTableData(NewtonRData);
        int counter = 0;
        double xInitial = Double.parseDouble(xValueUserText.getText());
        double difference = 0.0;
        
        do {
            
            double fXinitial = (Math.log(xInitial + 1)) + 1;
            double derivative = 1 / (xInitial + 1);
            double xsum = xInitial - ((fXinitial) / (derivative));//x1 = x0 - (f(x)/f'(x))
            double Fxsum = (Math.log(xsum + 1)) + 1;
            difference = Math.abs(xsum - xInitial);
            newtonRaphson.add(xInitial, Fxsum);
            if (counter == 1) { //start counting from 1
                NewtonRaphsonLinkedL.head.setNewtonRaphson(getDecimalPoints(xInitial)); //add the first value as a head
            } else {
                NewtonRaphsonLinkedL.addLast(getDecimalPoints(xInitial)); //Add every other item after the first
            }
            NewtonRData[counter][0] = counter + 1;
            NewtonRData[counter][1] = getDecimalPoints(xInitial);
            NewtonRData[counter][2] = getDecimalPoints(fXinitial);
            NewtonRData[counter][3] = getDecimalPoints(derivative);
            NewtonRData[counter][4] = getDecimalPoints(difference);
            NewtonRData[counter][5] = getDecimalPoints(xsum);
            NewtonRData[counter][6] = getDecimalPoints(Fxsum);
            xInitial = xsum; //x0 = x1
            System.out.println((counter + 1) + ": {" + getDecimalPoints(xInitial) + "}");
            counter++;
        } while (difference > 0.00001);
        System.out.println("Newton-Raphson method converged after " + "{" + counter + "}" + " iterations!");
    }
    
    public static void ThirdF() { //e^x-3x
        clearLinkedLData(NewtonRaphsonLinkedL);
        clearTableData(NewtonRData);
        int counter = 0;
        double xInitial = Double.parseDouble(xValueUserText.getText());
        double difference = 0.0;
        
        do {
            
            double fXinitial = (Math.exp(xInitial) - (3 * xInitial));
            double derivative = (Math.exp(xInitial) - 3);
            double xsum = xInitial - (fXinitial) / (derivative);//x1 = x0 - (f(x)/f'(x))
            double Fxsum = (Math.exp(xsum) - (3 * xsum));
            difference = Math.abs(xsum - xInitial);
            newtonRaphson.add(xInitial, Fxsum);
            if (counter == 1) { //start counting from 1
                NewtonRaphsonLinkedL.head.setNewtonRaphson(getDecimalPoints(xInitial)); //add the first value as a head
            } else {
                NewtonRaphsonLinkedL.addLast(getDecimalPoints(xInitial)); //Add every other item after the first
            }
            NewtonRData[counter][0] = counter + 1;
            NewtonRData[counter][1] = getDecimalPoints(xInitial);
            NewtonRData[counter][2] = getDecimalPoints(fXinitial);
            NewtonRData[counter][3] = getDecimalPoints(derivative);
            NewtonRData[counter][4] = getDecimalPoints(difference);
            NewtonRData[counter][5] = getDecimalPoints(xsum);
            NewtonRData[counter][6] = getDecimalPoints(Fxsum);
            xInitial = xsum; //x0 = x1
            System.out.println((counter + 1) + ": {" + getDecimalPoints(xInitial) + "}");
            counter++;
        } while (difference > 0.00001);
        System.out.println("Newton-Raphson method converged after " + "{" + counter + "}" + " iterations!");
    }
//</editor-fold>
}
