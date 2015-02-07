package net.alexanders.calculator;

import net.alexanders.calculator.externalutilities.SpringUtilities;
import net.alexanders.calculator.externalutilities.integerFilter;

import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcPanel extends JFrame implements ActionListener {
    public static JButton closeButton, addButton, subtractButton, multiplyButton, divideButton, modulusButton;
    public static JTextField op1, op2;
    public static JLabel r;
    public CalcPanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new SpringLayout());
        createGUIObjects();
        panel.add(op1);
        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(op2);
        panel.add(multiplyButton);
        panel.add(divideButton);
        panel.add(r);
        panel.add(closeButton);
        panel.add(modulusButton);

        SpringUtilities.makeGrid(panel, 3, 3, 3, 3, 3, 3);
        this.getContentPane().add(panel);
        this.setVisible(true);
    }

    public void createGUIObjects()
    {
        op1 = new JTextField("0");
        op2 = new JTextField("0");
        PlainDocument tempdoc = ((PlainDocument)op1.getDocument());
        tempdoc.setDocumentFilter(new integerFilter());
        op1.setDocument(tempdoc);
        tempdoc = ((PlainDocument)op2.getDocument());
        tempdoc.setDocumentFilter(new integerFilter());
        op2.setDocument(tempdoc);
        addButton = new JButton("Add");
        addButton.setActionCommand("2");
        addButton.setMnemonic('a');
        addButton.addActionListener(this);
        subtractButton = new JButton("Subtract");
        subtractButton.setActionCommand("3");
        subtractButton.setMnemonic('s');
        subtractButton.addActionListener(this);
        multiplyButton = new JButton("Multiply");
        multiplyButton.setActionCommand("4");
        multiplyButton.setMnemonic('m');
        multiplyButton.addActionListener(this);
        divideButton = new JButton("Divide");
        divideButton.setActionCommand("5");
        divideButton.setMnemonic('d');
        divideButton.addActionListener(this);
        modulusButton = new JButton("Modulus");
        modulusButton.setActionCommand("6");
        modulusButton.setMnemonic('m');
        modulusButton.addActionListener(this);
        closeButton = new JButton("Close");
        closeButton.setActionCommand("1");
        closeButton.setMnemonic('c');
        closeButton.addActionListener(this);
        r = new JLabel("0");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(Integer.parseInt(e.getActionCommand())) {
            case 1: System.exit(0); break;
            case 2: addNumbers(); break;
            case 3: subtractNumbers(); break;
            case 4: multiplyNumbers(); break;
            case 5: divideNumbers(); break;
            case 6: moduloNumbers(); break;
        }

    }

    private void addNumbers() {
        r.setText(String.valueOf(Double.parseDouble(op1.getText()) + Double.parseDouble(op2.getText())));
    }
    private void subtractNumbers(){
        r.setText(String.valueOf(Double.parseDouble(op1.getText()) - Double.parseDouble(op2.getText())));
    }
    private void multiplyNumbers(){
        r.setText(String.valueOf(Double.parseDouble(op1.getText()) * Double.parseDouble(op2.getText())));
    }
    private void divideNumbers() throws NumberFormatException{
        if(Double.parseDouble(op2.getText()) == 0){
            r.setText("Error! Can't divide by 0");
            return;
        }
        r.setText(String.valueOf(Double.parseDouble(op1.getText()) / Double.parseDouble(op2.getText())));
    }
    private void moduloNumbers()throws NumberFormatException{
        if(Double.parseDouble(op2.getText()) == 0){
            r.setText("Error! Can't divide by 0");
            return;
        }
        r.setText(String.valueOf(Double.parseDouble(op1.getText()) % Double.parseDouble(op2.getText())));
    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = CalcPanel.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
