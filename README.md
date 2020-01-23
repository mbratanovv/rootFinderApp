# rootFinderApp
Second Year Java Coursework
Description of the application: 
This is an app which uses mathematical methods to compute and plot the best approximation to the actual root of three functions.
Its GUI is rather simplistic, in order to be easier and more functional for the user. The Interface presents both a graphical and tabular solution with history showing the iterations and how close the method can get to the real root if it converges. The program's functionality helps the user in a way that he will get notified when he enters a wrong value or doesn't give any input at all. Also, the GUI is made in such a way that the user can examine the answer in both forms simultaneously. 

Technical part of the application :
The app contains 9 classes, "COMP1555" being the main one.
- "BisectionMethod", "NewtonRaphsonMethod", "SecantMethod" are classes for the three mathematical methods which compute the roots.
- "FunctionPlotting" and "TablePlotting" contains the data for the table and graph.
- "CommonCode" is extension of the main class and it contains some helpful methods.
- Both linkedlist classes contain the necessary data for the linkedlist data structure, in which the data from one of the methods is stored.
