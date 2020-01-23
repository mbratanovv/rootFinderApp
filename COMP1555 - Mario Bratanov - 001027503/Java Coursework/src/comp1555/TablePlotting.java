package comp1555;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

/**
 *
 * @author Mario Bratanov - 001027503
 */
public class TablePlotting extends JFrame {
    
    static Object[][] NewtonRData = new Object[150][7];
    String[] NewtonRValuesNames = {"Iteration", "Xn", "F(Xn)", "F'(Xn)", "Difference", "Xn+1(Answer after each iteration)", "Approximation check with real answer"};
    
    static Object[][] SecantData = new Object[150][7];
    String[] SecantValuesNames = {"Iteration", "Xn", "Xn-1", "F(Xn)", "F(Xn-1)", "Difference", "Answer, after each iteration"};
    
    static Object[][] BisectionData = new Object[150][6];
    String[] BisectionValuesNames = {"Iteration", "LeftBound", "Answer, after each iteration(midpoint)", "RightBound", "F(midpoint)", "Difference"};
    
    public TablePlotting() {
        GUI();
    }
    
    private void GUI() {
        JPanel table1 = new JPanel(new BorderLayout());
        JPanel table2 = new JPanel(new BorderLayout());
        JPanel table3 = new JPanel(new BorderLayout());
        JTabbedPane tableTabs = new JTabbedPane();

//<editor-fold defaultstate="collapsed" desc="Tables">
        JTable newtonR = new JTable(NewtonRData, NewtonRValuesNames);
        newtonR.setEnabled(false);
        
        JTable secant = new JTable(SecantData, SecantValuesNames);
        secant.setEnabled(false);
        
        JTable bisection = new JTable(BisectionData, BisectionValuesNames);
        bisection.setEnabled(false);
        
        table1.add(new JScrollPane(newtonR));
        table2.add(new JScrollPane(secant));
        table3.add(new JScrollPane(bisection));
//</editor-fold>

        //add Tabs
        tableTabs.addTab("Newton-Raphson", null, table1, "Newton-Raphson Table Data");
        tableTabs.addTab("Secant", null, table2, "Secant Table Data");
        tableTabs.addTab("Bisection", null, table3, "Bisection Table Data");
        
        add(tableTabs, BorderLayout.CENTER);
        
        setSize(800, 650);
        setLocationRelativeTo(null);
        setTitle("Table");
        setVisible(true);
    }
    
}
