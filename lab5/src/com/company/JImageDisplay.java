package com.company;

import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

public class JImageDisplay extends JComponent{
    private BufferedImage image;

    public BufferedImage getImage(){
        return image;
    }

    public JImageDisplay (int h, int w) {
        image = new BufferedImage(h,w, BufferedImage.TYPE_INT_RGB);
        Dimension size = new Dimension(h,w);
        super.setPreferredSize(size);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,0,0,image.getWidth(),image.getHeight(),null);

    }

    public void clearImage() {
        for (int i=0; i < image.getHeight(); i++ ) {
            for (int j = 0; j < image.getWidth(); j ++) {
                drawPixel(i,j,0);
            }
        }
    }

    public void drawPixel (int x, int y, int rgbColor) {
        image.setRGB(x,y,rgbColor);
    }
}
