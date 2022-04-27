package com.baykov;

import javax.swing.*;
import java.awt.*;

public class RoundButton extends JButton {

    public RoundButton(String label) {
        super(label);
        setForeground(Color.WHITE);
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        // makes the buttons round
        setPreferredSize(size);
        setContentAreaFilled(false);
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.GRAY);
            // button color is gray when pressed
        } else {
            g.setColor(Color.ORANGE);
            // button color is orange
        }
        g.fillOval(0, 0, getSize().width-1, getSize().height-1);
        // fills the frame of the button perfectly

        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawOval(0, 0, getSize().width-1, getSize().height-1);
        // draws the frame of the button
    }
}
