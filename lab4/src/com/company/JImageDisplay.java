package com.company;

import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

public class JImageDisplay extends JComponent{
    private BufferedImage image;

    public JImageDisplay (int h, int w) {
        image = new BufferedImage(h,w, 'TYPE_INT_RGB');
        Dimension size = new Dimension(h,w);
        super.getPreferredSize(size);
    }
}
