package comp1555;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import slinkedlist.SLinkedList;

/**
 *
 * @author Mario Bratanov - 001027503
 */

/*Bibliography
 Math.exp() - returns the euler's number "e" to the power of a double value
 Math.abs() - returns the absolute value of a number
 */
public class COMP1555 extends JFrame implements ActionListener {

    //XYLine Chart 
    XYSeriesCollection wholeData = new XYSeriesCollection();
    static XYSeries function = new XYSeries("Function");
    static XYSeries newtonRaphson = new XYSeries("Newton-Raphson");
    static XYSeries secant = new XYSeries("Secant");
    static XYSeries bisection = new XYSeries("Bisection");
    XYLineAndShapeRenderer straightLine = new XYLineAndShapeRenderer();
    XYLineAndShapeRenderer curvedLine = new XYSplineRenderer();
    
    //Data Structures
    static SLinkedList NewtonRaphsonLinkedL = new SLinkedList();
    static ArrayList<Double> SecantArray = new ArrayList<>();
    static ArrayList<Double> BisectionArray = new ArrayList<>();
    
    //Text Fields
    static JTextField xValueUserText = new JTextField("");
    static JTextField iterations = new JTextField("");
    static JTextField xLeftBisectionB = new JTextField("");
    static JTextField xRightBisectionB = new JTextField("");
    
    static JTabbedPane tabs = new JTabbedPane();
    
    //Radio Buttons & Button
    static JRadioButton method1 = new JRadioButton("Newthon-Raphson", false);
    static JRadioButton method2 = new JRadioButton("Secant", false);
    static JRadioButton method3 = new JRadioButton("Bisection", false);
    static ButtonGroup methodsgroup = new ButtonGroup();
    static JButton table = CommonCode.makeButton("Table", "TableData", "Plot the data in table format");
    
    //Slider
    static final int minimumValue = 1;
    static final int maximumValue = 16;
    static final int init = 8;
    static JSlider decimalPoints = new JSlider(JSlider.HORIZONTAL, minimumValue, maximumValue, init);

    public static void main(String[] args) {
        // Mario Bratanov - 001027503
        COMP1555 jc = new COMP1555();
    }

    public COMP1555() {
        GUI();
    }

    public void GUI() {
//<editor-fold defaultstate="collapsed" desc="Panels">
        JPanel function1 = new JPanel();
        JPanel function2 = new JPanel();
        JPanel function3 = new JPanel();
        JPanel centerPanel = new JPanel(new BorderLayout());
//        centerPanel.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.blue));
        JPanel centerNorthPanel = new JPanel(new GridBagLayout());
        JPanel centerCenterPanel = new JPanel(new GridBagLayout());
        JPanel centerSouthPanel = new JPanel(new BorderLayout());
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel bottomSouthPanel = new JPanel(new BorderLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
//</editor-fold>
        

//<editor-fold defaultstate="collapsed" desc="Labels">
        //Labels
        JLabel functions1 = new JLabel("5. Function(x - x^2) ");
        JLabel functions2 = new JLabel("5. Function(ln(x+1) + 1) ");
        JLabel functions3 = new JLabel("5. Function(e^x - 3x) ");
        
        
        JLabel xValueUserLabel = new JLabel("1.X: ");
        c.ipady = 10;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        centerNorthPanel.add(xValueUserLabel, c);
        
        //X value text box
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        centerNorthPanel.add(xValueUserText, c);
        xValueUserText.setHorizontalAlignment(JTextField.RIGHT);
        
        
        JLabel xLeftBisectionValue = new JLabel("Lower: ");
        c.ipady = 10;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        centerNorthPanel.add(xLeftBisectionValue, c);
        
        //Left Bound text box
        xLeftBisectionB.setEditable(false);
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 3;
        c.gridy = 0;
        centerNorthPanel.add(xLeftBisectionB, c);
        xLeftBisectionB.setHorizontalAlignment(JTextField.RIGHT);
        
        
        JLabel iterationsLabel = new JLabel("2.Iterations: ");
        c.ipady = 10;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        centerNorthPanel.add(iterationsLabel, c);
        
        //Iterations text box
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        centerNorthPanel.add(iterations, c);
        iterations.setHorizontalAlignment(JTextField.RIGHT);

        
        JLabel xRightBisectionValue = new JLabel("Upper: ");
        c.ipady = 10;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 1;
        centerNorthPanel.add(xRightBisectionValue, c);
        
        //Right Bound text box
        xRightBisectionB.setEditable(false);
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 3;
        c.gridy = 1;
        centerNorthPanel.add(xRightBisectionB, c);
        xRightBisectionB.setHorizontalAlignment(JTextField.RIGHT);


        JLabel methods = new JLabel("3.Pick a method: ");
        c.gridx = 0;
        c.gridy = 2;
        centerCenterPanel.add(methods, c);
        
        
        JLabel decP = new JLabel("4.Decimal points: ");
        centerSouthPanel.add(decP, BorderLayout.WEST);
        
        //Slider
        decimalPoints.setMajorTickSpacing(1);
        decimalPoints.setPaintTicks(true);
        decimalPoints.setPaintLabels(true);
        decimalPoints.setName("Decimal Points: ");
        centerSouthPanel.add(decimalPoints, BorderLayout.CENTER);
//</editor-fold>
        
        
//<editor-fold defaultstate="collapsed" desc="RadioButtons">
        //Radio Buttons
        method1.addActionListener(this);
        method1.setActionCommand("Newton-Raphson");
        c.gridx = 1;
        c.gridy = 2;
        centerCenterPanel.add(method1, c);
        
        method2.addActionListener(this);
        method2.setActionCommand("Secant");
        c.gridx = 2;
        c.gridy = 2;
        centerCenterPanel.add(method2, c);
        
        method3.addActionListener(this);
        method3.setActionCommand("Bisection");
        c.gridx = 3;
        c.gridy = 2;
        centerCenterPanel.add(method3, c);
        
        //Adding buttons to the buttons group
        methodsgroup.add(method1);
        methodsgroup.add(method2);
        methodsgroup.add(method3);
//</editor-fold>
        
        
//<editor-fold defaultstate="collapsed" desc="Buttons">
        //Buttons
        JButton firstFun = CommonCode.makeButton("Calculate", "FirstFunction", "Plot the function");
        firstFun.addActionListener(this);
        
        JButton secondFun = CommonCode.makeButton("Calculate", "SecondFunction", "Plot the function");
        secondFun.addActionListener(this);
        
        JButton thirdFun = CommonCode.makeButton("Calculate", "ThirdFunction", "Plot the function");
        thirdFun.addActionListener(this);
        
        //Table button actions
        table.addActionListener(this);
        table.setActionCommand("tableOpen");   
        centerSouthPanel.add(table,BorderLayout.EAST);
//</editor-fold>
        

//<editor-fold defaultstate="collapsed" desc="LineChart">
        //setting up the LineChart with all the methods
        JFreeChart XYLineChart = ChartFactory.createXYLineChart(
                null,
                "X",
                "Y",
                wholeData,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        wholeData.addSeries(function);
        wholeData.addSeries(newtonRaphson);
        wholeData.addSeries(secant);
        wholeData.addSeries(bisection);
        
        XYPlot plotter = XYLineChart.getXYPlot();
        plotter.setRangeGridlinePaint(Color.BLACK);
        plotter.setDomainGridlinePaint(Color.BLACK);
        plotter.setRenderer(straightLine);
        
        ChartPanel newChart = new ChartPanel(XYLineChart);
//</editor-fold>

        
//<editor-fold defaultstate="collapsed" desc="Frame">
        tabs.addTab("Function 1", null, function1, "x-x^2");
        tabs.addTab("Function 2", null, function2, "ln(x+1)+1");
        tabs.addTab("Function 3", null, function3, "e^x-3x");
        
        function1.add(functions1);
        function1.add(firstFun);
        
        function2.add(functions2);
        function2.add(secondFun);
        
        function3.add(functions3);
        function3.add(thirdFun);
        
        bottomSouthPanel.add(newChart, BorderLayout.SOUTH);
        bottomPanel.add(bottomSouthPanel, BorderLayout.SOUTH);
        
        centerPanel.add(centerNorthPanel, BorderLayout.NORTH);
        centerPanel.add(centerCenterPanel, BorderLayout.CENTER);
        centerPanel.add(centerSouthPanel, BorderLayout.SOUTH);
        
        add(tabs, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);      
//</editor-fold>
        setSize(900, 1040);
        setLocationRelativeTo(null);
        setTitle("Mathematical Root Finder");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    //need to add:
    //for the bisection : to check if the upper bound is > then the lower and if it is not to pop up a messageBox with error message
//<editor-fold defaultstate="collapsed" desc="Actions">
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("tableOpen")) {
            TablePlotting tp = new TablePlotting();
            System.out.println("Table Panel is opened.");
        }
        
        if (e.getActionCommand().equals("Bisection")) {
            if (method3.isSelected()) {
                xValueUserText.setEditable(false);
                xLeftBisectionB.setEditable(true);
                xRightBisectionB.setEditable(true);
            } else {
                xValueUserText.setEditable(true);
                xLeftBisectionB.setEditable(false);
                xRightBisectionB.setEditable(false);
            }
        }

        if (e.getActionCommand().equals("Secant")) {
            if (method2.isSelected()) {
                xValueUserText.setEditable(true);
                xLeftBisectionB.setEditable(false);
                xRightBisectionB.setEditable(false);
            }
        }
        
        if (e.getActionCommand().equals("Newton-Raphson")) {
            if (method1.isSelected()) {
                xValueUserText.setEditable(true);
                xLeftBisectionB.setEditable(false);
                xRightBisectionB.setEditable(false);
            }
        }
        
//<editor-fold defaultstate="collapsed" desc="FirstFunction">
        if (e.getActionCommand().equals("FirstFunction")) {
            if (!method3.isSelected() && iterations.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter a number of iterations. ");
            } else if (method3.isSelected() && iterations.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter a number of iterations. ");
            } else {
                FunctionPlotting.First();
                if (method1.isSelected()) {
                    if (xValueUserText.getText().equals("") && iterations.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter a value for X and number of iterations. ");
                    } else if (xValueUserText.getText().equals("") && !iterations.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter a value for X. ");
                    } else if (!xValueUserText.getText().equals("") && iterations.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter a number of iterations. ");
                    } else {
                        NewtonRaphsonMethod.FirstF();
                    }
                } else if (method2.isSelected()) {
                    if (xValueUserText.getText().equals("") && iterations.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter a value for X and number of iterations. ");
                    } else if (xValueUserText.getText().equals("") && !iterations.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter a value for X. ");
                    } else if (!xValueUserText.getText().equals("") && iterations.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter a number of iterations. ");
                    } else {
                        SecantMethod.FirstF();
                    }
                } else if (method3.isSelected()) {
                    if (iterations.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter a number of iterations. ");
                    } else if (xLeftBisectionB.getText().equals("") && xRightBisectionB.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter lower and upper bounds for Bisection method! ");
                    } else if (xLeftBisectionB.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter lower bound for Bisection method! ");
                    } else if (xRightBisectionB.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter upper bound for Bisection method! ");
                    } else {
                        BisectionMethod.FirstF();
                    }
                }
            }
        }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="SecondFunction">
        if (e.getActionCommand().equals("SecondFunction")) {
            if (!method3.isSelected() && iterations.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter a number of iterations. ");
            } else if (method3.isSelected() && iterations.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter a number of iterations. ");
            } else {
                FunctionPlotting.Second();
                if (method1.isSelected()) {
                    if (xValueUserText.getText().equals("") && iterations.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter a value for X and number of iterations. ");
                    } else if (xValueUserText.getText().equals("") && !iterations.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter a value for X. ");
                    } else if (!xValueUserText.getText().equals("") && iterations.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter a number of iterations. ");
                    } else {
                        NewtonRaphsonMethod.SecondF();                         
                    }
                } else if (method2.isSelected()) {
                    if (xValueUserText.getText().equals("") && iterations.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter a value for X and number of iterations. ");
                    } else if (xValueUserText.getText().equals("") && !iterations.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter a value for X. ");
                    } else if (!xValueUserText.getText().equals("") && iterations.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter a number of iterations. ");
                    } else {
                        SecantMethod.SecondF();
                    }
                } else if (method3.isSelected()) {
                    if (iterations.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter a number of iterations. ");
                    } else if (xLeftBisectionB.getText().equals("") && xRightBisectionB.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter lower and upper bounds for Bisection method! ");
                    } else if (xLeftBisectionB.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter lower bound for Bisection method! ");
                    } else if (xRightBisectionB.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter upper bound for Bisection method! ");
                    } else {
                        BisectionMethod.SecondF();
                    }
                }
            }
        }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="ThirdFunction">
        if (e.getActionCommand().equals("ThirdFunction")) {
            if (!method3.isSelected() && iterations.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter a number of iterations. ");
            } else if (method3.isSelected() && iterations.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter a number of iterations. ");
            } else {
                FunctionPlotting.Third();
                if (method1.isSelected()) {
                    if (xValueUserText.getText().equals("") && iterations.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter a value for X and number of iterations. ");
                    } else if (xValueUserText.getText().equals("") && !iterations.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter a value for X. ");
                    } else if (!xValueUserText.getText().equals("") && iterations.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter a number of iterations. ");
                    } else {
                        NewtonRaphsonMethod.ThirdF();
                    }
                } else if (method2.isSelected()) {
                    if (xValueUserText.getText().equals("") && iterations.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter a value for X and number of iterations. ");
                    } else if (xValueUserText.getText().equals("") && !iterations.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter a value for X. ");
                    } else if (!xValueUserText.getText().equals("") && iterations.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter a number of iterations. ");
                    } else {
                        SecantMethod.ThirdF();
                    }
                } else if (method3.isSelected()) {
                    if (iterations.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter a number of iterations. ");
                    } else if (xLeftBisectionB.getText().equals("") && xRightBisectionB.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter lower and upper bounds for Bisection method! ");
                    } else if (xLeftBisectionB.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter lower bound for Bisection method! ");
                    } else if (xRightBisectionB.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter upper bound for Bisection method! ");
                    } else {
                        BisectionMethod.ThirdF();
                    }
                }
            }
        }
//</editor-fold>
    }
}
//</editor-fold>

    
