package GUI;

import Entities.Map;
import Services.RunnableThread;
import Services.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Frame {

    private JFrame frame;
    private JButton button_roads, button_towns, button_transports;
    private JTextField textfield = new JTextField("Search roads from some town here", 20);

    public Frame(Map myMap) {
        frame = new JFrame("Action");
        button_roads = new JButton("Display Roads");
        button_towns = new JButton("Display Towns");
        button_transports = new JButton("Display transports");

        textfield.setHorizontalAlignment(JTextField.CENTER);
        frame.add(button_roads);
        frame.add(button_towns);
        frame.add(button_transports);
        frame.add(textfield);
        /*
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);*/

        frame.setLayout(new GridLayout(2,3));
        frame.setSize(1000,500);
        frame.setVisible(true);

        button_roads.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new SecondFrame(myMap.textRoads());
            }
        });
        button_towns.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                RunnableThread myThread = new RunnableThread();
                new SecondFrame(myMap.textTowns());
                FileWriter fw  = null;
                try {
                    fw = new FileWriter(new File("console.csv"), true);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    UserService.getInstance().writetime("textTowns" + ",thread: " + myThread.getName(), fw);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        button_transports.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new SecondFrame(myMap.textTransports());
            }
        });
        textfield.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SecondFrame(myMap.findRoad(textfield.getText()));
            }
        });
        textfield.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textfield.setText("");
            }
        });
    }
}