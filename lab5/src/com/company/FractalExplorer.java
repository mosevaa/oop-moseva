package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

public class FractalExplorer {
    private int size;
    private JImageDisplay jDisplay;
    private FractalGenerator fractal;
    private Rectangle2D.Double range;

    public FractalExplorer (int display_size) {
        size = display_size;
        range = new Rectangle2D.Double();
        fractal = new Mandelbrot();
        fractal.getInitialRange(range);
        jDisplay = new JImageDisplay(display_size, display_size);
    }

    public void createAndShowGUI () {
        jDisplay.setLayout(new BorderLayout());
        JFrame frame = new JFrame();

        frame.add(jDisplay, BorderLayout.CENTER);

        JButton button = new JButton("Reset");
        ResetButtonHandler clearAction = new ResetButtonHandler();
        button.addActionListener(clearAction);

        MyMouseListener mouse = new MyMouseListener();
        jDisplay.addMouseListener(mouse);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        String[] items = {"Mandelbrot", "Tricorn", "BurningShip"};
        JComboBox comboBox = new JComboBox(items);

        JLabel label = new JLabel("Fractal:");
        JPanel panelBox = new JPanel();
        panelBox.add(label);
        panelBox.add(comboBox);
        frame.add(panelBox, BorderLayout.NORTH);

        ChooseButtonHandler chooseAction = new ChooseButtonHandler();
        comboBox.addActionListener(chooseAction);

        JButton saveButton = new JButton("Save Image");
        



        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void drawFractal () {
        for (int x = 0; x < size; x ++) {
            for (int y = 0; y < size; y ++) {
                double xCoord = fractal.getCoord(range.x,range.x + range.width, size, x);
                double yCoord = fractal.getCoord(range.y, range.y + range.height, size, y);
                int iterations = fractal.numIterations(xCoord,yCoord);

                if (iterations == -1) jDisplay.drawPixel(x,y,0);
                else {
                    float hue = 0.7f + (float) iterations / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    jDisplay.drawPixel(x, y, rgbColor);
                }
            }
        }
        jDisplay.repaint();
    }

    public class ResetButtonHandler implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            fractal.getInitialRange(range);
            drawFractal();
        }


    }

    public class ChooseButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox combo = (JComboBox)e.getSource();
            String name = (String) combo.getSelectedItem();
            if (name == "Mandelbrot"){
                fractal = new Mandelbrot();
            }
            if (name == "Tricorn") {
                fractal = new Tricorn();
            }
            if (name == "BurningShip") {
                fractal = new BurningShip();
            }
            fractal.getInitialRange(range);
            drawFractal();
        }
    }

    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            double xCoord = fractal.getCoord(range.x, range.x+range.width, size,x);

            int y = e.getY();
            double yCoord = fractal.getCoord(range.y, range.y+range.height, size,y);

            fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);

            drawFractal();
        }
    }

    public static void main (String[] args) {

        FractalExplorer display = new FractalExplorer(800);
        display.createAndShowGUI();
        display.drawFractal();
    }
}