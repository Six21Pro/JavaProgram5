import java.awt.event.*; 
import javax.swing.*; 
import java.awt.*; 
import java.util.*; 
import java.util.Stack;

public class SimpleCalculator extends JFrame implements ActionListener { 

    // create a textfield 
    private JTextField output; 

    //private JButton bd;
    private JButton [] bts = new JButton[20];       //  twenty buttons .
    String inputS="";//String used to set the textfield

    // default constrcutor 
    public SimpleCalculator() { 

        // set ouput area
        output = new JTextField(21); 
        output.setPreferredSize(new Dimension(30, 40));
        output.setFont(new Font("Arial", Font.PLAIN, 20));
        output.setHorizontalAlignment(SwingConstants.RIGHT);

        // create number buttons and some operators 
        // create a button object
        bts[0] = new JButton("(");
        bts[1] = new JButton(")");
        bts[2] = new JButton("%");
        bts[3] = new JButton("CE");
        bts[4] = new JButton("7");
        bts[5] = new JButton("8");
        bts[6] = new JButton("9");
        bts[7] = new JButton("/");
        bts[8] = new JButton("4");
        bts[9] = new JButton("5");
        bts[10] = new JButton("6");
        bts[11] = new JButton("*");
        bts[12] = new JButton("1");
        bts[13] = new JButton("2");
        bts[14] = new JButton("3");
        bts[15] = new JButton("-");
        bts[16] = new JButton("0");
        bts[17] = new JButton(".");
        bts[18] = new JButton("=");
        bts[19] = new JButton("+");

        for(int i=0; i<20; i++){
            // set button size
            bts[i].setPreferredSize(new Dimension(80, 40));
            // set font size for button
            bts[i].setFont(new Font("Arial", Font.PLAIN, 20));
        }

        // set button background color
        bts[0].setBackground(new Color(204, 204, 204)); //grey
        bts[1].setBackground(new Color(204, 204, 204)); //grey
        bts[2].setBackground(new Color(204, 204, 204)); //grey
        bts[3].setBackground(new Color(204, 204, 204)); //grey
        bts[7].setBackground(new Color(204, 204, 204)); //grey
        bts[11].setBackground(new Color(204, 204, 204)); //grey
        bts[15].setBackground(new Color(204, 204, 204)); //grey
        bts[19].setBackground(new Color(204, 204, 204)); //grey
        // add action listener
        for(int i=0; i<20;i++){//actionListener added to every button
            bts[i].addActionListener(this); 
        }

        // make light blue color for = button
        bts[18].setContentAreaFilled(false);
        bts[18].setBorderPainted(true);
        bts[18].setOpaque(true);
        bts[18].setForeground(Color.WHITE);
        bts[18].setBackground(new Color(51, 153, 255)); //light blue// =sign button

        // create a panel 
        JPanel p = new JPanel(); //panel named p
        p.add(output);

        for(int i=0; i<20;i++){//buttons added to p
            p.add(bts[i]);
        }

        // add panel to frame 
        this.add(p); 

        // set frame size
        setSize(360, 320); 
    } 

    public void actionPerformed(ActionEvent e) 
    { 

        String s = e.getActionCommand(); //String s equals the symbol of the button pressed
        String pfixed="";//string will be used to represent the result of the postfix class
        String inputS=output.getText();//inputS set to the value within the textfield
        inputS= inputS+s;//inputS equals its current value with s added to the end
        output.setText(inputS);//textfield set to the new inputS

        System.out.println("Button pressed: " + s);//output the button pressed
        if (s=="CE"){//if CE was pressed //textfield is reset to blank
            output.setText("");
        }

        if(s=="="){//if = was pressed
            InfixToPostfix a=new InfixToPostfix();//a= new InfixtoPostFix class
            pfixed=a.toPostfix(output.getText());//pfixed equals the postfix expression of the value in the textfield
            PostFixCalculator h= new PostFixCalculator();//h= new PostFixCalculator class
            System.out.println("postfix: "+pfixed);//output the post fixed expression
            double z=h.eval(pfixed);//z equals value returned from h.eval(pfixed)

            inputS= inputS+z;//inputS set to previous textfield value plus z
            output.setText(inputS);//at this point the equation is complete
        }
    }
} 

