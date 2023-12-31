package examples.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyApplication extends JFrame {
    private Container contentPane;
    private JLabel label = new JLabel();

    public MyApplication() {
        setTitle("My Application");
        contentPane = getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 105);
        start();
    }

    public static void main(String[] args) {
        MyApplication frame = new MyApplication();
        frame.setSize(150, 75);
        frame.pack();
        frame.setVisible(true);
    }

    public void start() {
        label.setBackground(Color.BLACK);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setText("No button clocked yet");

        JButton button1 = new JButton();
        button1.setText("Button 1");
        button1.addActionListener((ActionEvent event) -> buttonClicked(button1.getText()));

        JButton button2 = new JButton();
        button2.setText("Button 2");
        button2.addActionListener((ActionEvent event) -> buttonClicked(button2.getText()));

        JPanel northPanel = new JPanel();
        northPanel.add(label);
        contentPane.add(northPanel, BorderLayout.NORTH);

        JPanel centralPanel = new JPanel();
        centralPanel.add(button1);
        centralPanel.add(button2);
        contentPane.add(centralPanel);
    }

    private void buttonClicked(String text) {
        label.setText(text + " is clicked!");
    }
}
