import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    JFrame frame;//outer boundary of calculator
    JTextField field;//a screen to show up the operations being performed and resulted answers
    JButton[] numericButtons = new JButton[10];//an array of buttons from 0 to 9
    JButton[] operationButtons = new JButton[9];//an array of functional buttons like '+', '*', etc...
    JButton addButton, subButton, mulButton, divButton, eqlButton, clrButton, delButton, decButton, negButton;//9 functional buttons
    JPanel panel;//a window which will have all the components organized in a particular manner

    Font myFont = new Font("Ink Free", Font.BOLD, 30);//font of all buttons and result string

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {

        frame = new JFrame("My Calculator");//title of my calculator
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//to close the frame
        frame.setSize(420, 550);//defining the size of the frame
        frame.setResizable(false);//restricting the size of the frame
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.CYAN);
        

        //Making the Screen of Calculator
        field = new JTextField();//instantiating the screen of calculator
        field.setBounds(50, 25, 300, 60);
        field.setFont(myFont);
        field.setEditable(false);//restricting controls to edit values displayed on screen
        field.setBackground(Color.LIGHT_GRAY);
        field.setSelectedTextColor(Color.BLUE);

        //Deploying the buttons on the frame

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqlButton = new JButton("=");
        clrButton = new JButton("clr");
        delButton = new JButton("del");
        decButton = new JButton(".");
        negButton = new JButton("neg");

        //assigning these buttons a particular position
        operationButtons[0] = addButton;
        operationButtons[1] = subButton;
        operationButtons[2] = mulButton;
        operationButtons[3] = divButton;
        operationButtons[4] = eqlButton;
        operationButtons[5] = clrButton;
        operationButtons[6] = delButton;
        operationButtons[7] = decButton;
        operationButtons[8] = negButton;

        for(int i=0; i<operationButtons.length; i++){
            operationButtons[i].addActionListener(this);
            operationButtons[i].setFont(myFont);
            operationButtons[i].setFocusable(false);
        }

        for(int i=0; i<numericButtons.length; i++){
            numericButtons[i] = new JButton(String.valueOf(i));
            numericButtons[i].addActionListener(this);
            numericButtons[i].setFont(myFont);
            numericButtons[i].setFocusable(false);
        }

        negButton.setBounds(50, 430, 90, 50);
        negButton.setBackground(Color.DARK_GRAY);
        negButton.setForeground(Color.WHITE);
        delButton.setBounds(150, 430, 90, 50);
        delButton.setBackground(Color.DARK_GRAY);
        delButton.setForeground(Color.WHITE);
        clrButton.setBounds(250, 430, 90, 50);
        clrButton.setBackground(Color.DARK_GRAY);
        clrButton.setForeground(Color.WHITE);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,8,8));
        panel.setBackground(Color.orange);

        panel.add(numericButtons[1]);
        panel.add(numericButtons[2]);
        panel.add(numericButtons[3]);
        panel.add(addButton);

        panel.add(numericButtons[4]);
        panel.add(numericButtons[5]);
        panel.add(numericButtons[6]);
        panel.add(subButton);

        panel.add(numericButtons[7]);
        panel.add(numericButtons[8]);
        panel.add(numericButtons[9]);
        panel.add(mulButton);

        panel.add(decButton);
        panel.add(numericButtons[0]);
        panel.add(eqlButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(field);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0; i<numericButtons.length; i++){
            if(e.getSource() == numericButtons[i]){
                field.setText(field.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource() == decButton){
            field.setText(field.getText().concat("."));
        }

        if(e.getSource() == addButton){
            num1 = Double.parseDouble(field.getText());
            operator = '+';
            field.setText("");
        }
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(field.getText());
            operator = '-';
            field.setText("");
        }
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(field.getText());
            operator = '*';
            field.setText("");
        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(field.getText());
            operator = '/';
            field.setText("");
        }

        if(e.getSource() == eqlButton){
            num2 = Double.parseDouble((field.getText()));
            switch(operator){
                case '+':
                result = num1 + num2;
                break;

                case '-':
                result = num1 - num2;
                break;

                case '*':
                result = num1 * num2;
                break;

                case '/':
                result = (num1 / num2);    
                break;
            }
            field.setText(String.valueOf(result));
            num1 = result;
        }

        if(e.getSource() == clrButton){
            field.setText("");
        }

        if(e.getSource() == delButton){
            String str = field.getText();
            field.setText("");

            for(int i=0; i<str.length()-1; i++){
                field.setText(field.getText() + str.charAt(i));
            }
        }

        if(e.getSource() == negButton){
            double temp = Double.parseDouble((field.getText()));
            temp = temp * -1;
            field.setText(String.valueOf(temp));
        }
    }
}
