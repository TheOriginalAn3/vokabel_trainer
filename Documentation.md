# <u>**About**</u>

This file will document how this code works.

The code can be found inside the source folder.
> - [Project Folder] (where you cloned the git)
>   - /src

There are defferent files for different classes. Use this table to navigate the document and go to the specific Class:

### <u>Classes: </u>

- [App.java](#appjava)
- [MyGUI2.java](#myguijava)


## App.java

This app starts with the normal configuration for a Java Project. It has a main Class that has the main method.

```java
public class App {
    public static void main(String[] args) throws Exception {
```

Next a test string is printed.
```java
System.out.println("Hello, World!");
```

Then a new GUI Object is created. This then initializes the [GUI](#myguijava)
```java
MyGUI2 myGUI = new MyGUI2(); //Create GUI
    }
}
```


## MyGUI.java
Imports for this class are ignored as long as they are from the java.swing or java.awt class.

The class MyGUI2 extends `javax.swing.JFrame`. This eliminates the need to create an JPane object for out RootPane[^RootPane]. By extending `javax.swing.JFrame` our class acts as the RootPane[^RootPane].
```java
public class MyGUI2 extends javax.swing.JFrame {
```

After that, we reserve some space in the memory for the GUI Objects we are going to create later in this code. Colors are also saved as a variable so that we can change the color of multiple GUI Elements at the same time and so that we dont have to create a new Color Object every time we want to use a color.
```java
    // Declare Variables (reserve sapce in memory)
    private JPanel leftMenuPanel;
    private JPanel centerPanel;

    private JPanel rightWordsPanel;
    private JLabel rightWordsLabel;
    private JLabel rightWordsLabelCount;

    private JPanel wrongWordsPanel;
    private JLabel wrongWordsLabel;
    private JLabel wrongWordsLabelCount;

    // Colors
    private final Color priamryColor_RichBlack = new java.awt.Color(0x020c12);
    private final Color secondaryColor_EerieBlack = new java.awt.Color(0x181a1b);
    private final Color accentColor_MidnightGreen = new java.awt.Color(0x003c3c);
    private final Color textColor_AzureWeb = new java.awt.Color(0xf0ffff);
    private final Color contrastColor_MayaBlue = new java.awt.Color(0x6dbcee);
    // End of variable declaration
```

Next comes the standard constructor for this class
```java
    public MyGUI2(){
```

Inside the constructor we set the proprieties for our RootPane[^RootPane].
```java
        // this.[...] reffers to THIS JFrame. This is possible because this class extends javax.swing.JFrame
        this.setName("Vocabulary Trainer by Selin & Andrei");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 500);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
```

We then create a new pane (The Menu Pane on the Left side) and add all necessary Child-Components[^ChildComponent] to it. When adding a Child-Component[^ChildComponent] to a Parent-Component[^ParentComponent] it is possible to initialize the object directly inside the .add() method. This is used just to spare some clutter in the code.
```java
// -------------------- Left Menu Panel --------------------
        leftMenuPanel = new JPanel();
        leftMenuPanel.setPreferredSize(new Dimension(200, 100));
        leftMenuPanel.setBackground(secondaryColor_EerieBlack); // (<- This uses the created color variable)

        // Sub-Panels of Menu Panel
        leftMenuPanel.add(rightWordsPanel = new JPanel(), CENTER_ALIGNMENT); // <- rightWordsPanel is initialized directly in the method.
        rightWordsPanel.add(rightWordsLabel = new JLabel("Right Words: "), LEFT_ALIGNMENT);
        rightWordsPanel.add(rightWordsLabelCount = new JLabel("871"), RIGHT_ALIGNMENT);

        leftMenuPanel.add(wrongWordsPanel = new JPanel(), CENTER_ALIGNMENT);
        wrongWordsPanel.add(wrongWordsLabel = new JLabel("Wrong Words: "), LEFT_ALIGNMENT);
        wrongWordsPanel.add(wrongWordsLabelCount = new JLabel("126"), RIGHT_ALIGNMENT);
```

Then we create another new pane (The Pane Right of the Menu Pane) and add all necessary Child-Components[^ChildComponent] to it.
```java
        // ---------------------- Center Panel ----------------------
        centerPanel = new JPanel();
        centerPanel.setBackground(priamryColor_RichBlack);
```

Then finally, we add all components to the Root-Pane[^RootPane] and we "show"/"display" the UI to the User.
```java
        this.add(leftMenuPanel, BorderLayout.WEST); 
        this.add(centerPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
```













[^RootPane]: Main GUI that we use
[^ChildComponent]: Components (in this case: diffrent swing and awt objects) that are "nested" inside a parent-component[^ParentComponent]
[^ParentComponent]: A Component (in this case: A pane object) that "holds" one or multiple Child-Components[^ChildComponent]