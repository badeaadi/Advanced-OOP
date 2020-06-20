package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondFrame {
    private JFrame frame;

    public SecondFrame(String text) {
        frame = new JFrame("Results");
        JButton backButton = new JButton("Back to Menu");
        JLabel label = new JLabel("<html><pre>" + text + "</pre></html>");
        frame.add(backButton, BorderLayout.WEST);
        frame.add(label, BorderLayout.CENTER);

        frame.setSize(1000, 500);
        frame.setVisible(true);

        backButton.addActionListener(actionEvent -> close());
    }

    private void close() {
        frame.setVisible(false);
        frame.dispose();
    }
}
