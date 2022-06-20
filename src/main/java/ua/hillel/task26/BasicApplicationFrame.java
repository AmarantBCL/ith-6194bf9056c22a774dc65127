package ua.hillel.task26;

import javax.swing.*;
import java.awt.*;

public class BasicApplicationFrame {
    public BasicApplicationFrame() {
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Calculator v1.0");
        mainFrame.setBounds(100, 70, 400, 500);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        var top = new JPanel();
        top.setLayout(new BorderLayout());
        var inputField = new JTextField();
        inputField.setEditable(false);
        top.add(inputField, BorderLayout.CENTER);
        mainFrame.add(top, BorderLayout.NORTH);

        var bottom = new JPanel();
        bottom.setLayout(new GridLayout(5, 4));

        var btnAddActionListener = new AddButtonActionListener(inputField);

        var acBtn = new JButton("AC");
        acBtn.addActionListener(event -> inputField.setText(""));
        bottom.add(acBtn);

        var calcBtn = new JButton("=");
        calcBtn.addActionListener(event ->
                inputField.setText(ResultOperation.calculate(inputField.getText())));
        bottom.add(calcBtn);

        var plusBtn = new JButton("+");
        plusBtn.addActionListener(btnAddActionListener);
        bottom.add(plusBtn);

        var minusBtn = new JButton("-");
        minusBtn.addActionListener(btnAddActionListener);
        bottom.add(minusBtn);

        var multiplyBtn = new JButton("*");
        multiplyBtn.addActionListener(btnAddActionListener);
        bottom.add(multiplyBtn);

        var divideBtn = new JButton("/");
        divideBtn.addActionListener(btnAddActionListener);
        bottom.add(divideBtn);

        var squareRootBtn = new JButton("√");
        squareRootBtn.addActionListener(event -> {
            if (inputField.getText().isEmpty()) return;
            double result = Double.parseDouble(ResultOperation.calculate(
                    inputField.getText()).replace(",", "."));
            inputField.setText(String.valueOf(ResultOperation.DECIMAL_FORMAT.format(Math.sqrt(result))));
        });
        bottom.add(squareRootBtn);

        for (int i = 0; i <= 9; i++) {
            var btn = new JButton(String.valueOf(i));
            btn.addActionListener(btnAddActionListener);
            bottom.add(btn);
        }

        mainFrame.add(bottom, BorderLayout.CENTER);
        mainFrame.setVisible(true);
    }
}
