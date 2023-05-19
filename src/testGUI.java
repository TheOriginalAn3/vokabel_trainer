import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class testGUI extends JFrame{
    private int width;
    private int hight;
    private String title;
    private ImageIcon logoIcon = new ImageIcon("resources/images//logo_BingImageCreator.png"); //Create imageIcon Obj from png image

    //---------------------------------------------Labels---------------------------------------------
    
    
    //---------------------------------------------Code and Methods---------------------------------------------
    //Get necesarry info for creating a GUI
    public testGUI(int width, int hight, String title) {
        this.width = width;
        this.hight = hight;
        this.title = title;
        
        //Create GUI
        JLabel label = new JLabel(); //Create label and set text
        label.setText(title);
        label.setIcon(logoIcon);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);


        this.setTitle(title);
        this.setSize(width, hight); // Set the size of the UI
        this.add(label);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit out of application when "X" is clicked
        this.setVisible(true); // Make UI Visible
        this.setIconImage(logoIcon.getImage()); //Set App logo to ImageIcon obj
        //this.getContentPane().setBackground(new Color(5,5,5,5));
    }   
}
