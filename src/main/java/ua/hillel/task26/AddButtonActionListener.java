package ua.hillel.task26;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ua.hillel.task26.CalculatorConstants.ERROR_MESSAGE;

public class AddButtonActionListener implements ActionListener {
    private final JTextField input;

    public AddButtonActionListener(JTextField input) {
        this.input = input;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var btn = (JButton) e.getSource();
        if (input.getText().contains(ERROR_MESSAGE)) input.setText("");
        if (CalculatorConstants.CORRECT_OPERATIONS.contains(btn.getText())) {
            input.setText(input.getText() + " " + btn.getText() + " ");
        } else {
            input.setText(input.getText() + btn.getText());
        }
    }
}
