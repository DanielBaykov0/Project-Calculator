package com.baykov;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    private static JFrame frame;
    private static JTextField textField;
    private static final RoundButton[] numberButtons = new RoundButton[10];
    private static final JButton[] functionButtons = new JButton[10];
    private static JButton addButton;
    private static JButton subButton;
    private static JButton mulButton;
    private static JButton divButton;
    private static JButton sqrButton;
    private static JButton decButton;
    private static JButton equButton;
    private static JButton delButton;
    private static JButton clrButton;
    private static JButton negButton;
    private static final Font myFont = new Font("Quicksand", Font.BOLD, 25);
    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char operator;

    Calculator() {

        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // frame exits on escape
        frame.setSize(400, 450);
        frame.getContentPane().setBackground(Color.BLACK);
        // frame background color is black
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        // Move window to center

        textField = new JTextField();
        textField.setBounds(30, 30, 350, 60);
        textField.setBackground(Color.BLACK);
        textField.setFont(myFont);
        textField.setForeground(Color.WHITE);
        // sets the text color in the text field to white
        textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // sets the border color of the text field to black
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        // sets the text in the text field to right alignment
        textField.setEditable(false);

        addButton = new RoundButton("+");
        subButton = new RoundButton("-");
        mulButton = new RoundButton("*");
        divButton = new RoundButton("/");
        decButton = new RoundButton(".");
        equButton = new RoundButton("=");
        delButton = new RoundButton("<-");
        clrButton = new RoundButton("C");
        sqrButton = new RoundButton("\u221A");
        // inserts the square sign
        negButton = new RoundButton("+/-");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = sqrButton;
        functionButtons[9] = negButton;

        for (int i = 0; i < 10; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new RoundButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        JPanel panel = new JPanel();
        panel.setBounds(30, 100, 350, 300);
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        panel.setBackground(Color.BLACK);

        panel.add(clrButton);
        panel.add(negButton);
        panel.add(sqrButton);
        panel.add(delButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(mulButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(equButton);
        panel.add(addButton);


        frame.add(panel);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
                textField.setCaretColor(Color.WHITE);
            }
        }

        if (e.getSource() == decButton && !textField.getText().contains(".")) {
            textField.setText(textField.getText() + decButton.getText());
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == sqrButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '\u221A';
            textField.setText("");
        }

        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");

            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }

        if (e.getSource() == clrButton) {
            textField.setText("");
        }

        if (e.getSource() == negButton) {
            double negative = Double.parseDouble(textField.getText());
            negative *= -1;
            textField.setText(String.valueOf(negative));
        }

        if (e.getSource() == sqrButton) {
            result = Math.sqrt(num1);
            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
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
                        result = num1 / num2;
                    break;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
        }
    }
}





