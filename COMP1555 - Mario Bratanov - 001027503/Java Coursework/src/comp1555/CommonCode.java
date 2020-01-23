package comp1555;

import java.util.ArrayList;
import javax.swing.JButton;
import slinkedlist.SLinkedList;
import static slinkedlist.SLinkedList.LinkedListCount;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mario Bratanov - 001027503
 */
public class CommonCode extends COMP1555 {
    
//<editor-fold defaultstate="collapsed" desc="Referenced code from Year 1 - Coursework">
    //Automatic method for creating a button
    public static JButton makeButton(
            String buttonName,
            String actionCommand,
            String toolTipText) {
        
        JButton button = new JButton(buttonName);
        button.setActionCommand(actionCommand);
        button.setToolTipText(toolTipText);
        
        return button;
    }
//</editor-fold>
    
    public static void clearTableData(Object[][] TableD) {
        for (int i = 0; i < TableD.length; i++) {
            for (int j = 0; j < TableD[i].length; j++) {
                TableD[i][j] = null;
            }
        }
    }
    
    public static void clearArrayData(ArrayList ArrayD) {
        if (!ArrayD.isEmpty()) {
            ArrayD.clear();
        }
    }
    
    public static void clearLinkedLData(SLinkedList LinkedLD) {
        while (LinkedListCount(LinkedLD) > 1) {
      LinkedLD.removeLast();
    }
    }
    
//<editor-fold defaultstate="collapsed" desc="Written with the small help from Jelani Akoto - colleague">
    public static Double getDecimalPoints(Double decPoints) {
        //Get the number in decimalSpinner, format number to decimalSpinner number and convert result to Double
        Double decimal = Double.parseDouble(String.format("%." + (Integer) decimalPoints.getValue() + "f", decPoints));
        return decimal;
    }
//</editor-fold>

    
}
