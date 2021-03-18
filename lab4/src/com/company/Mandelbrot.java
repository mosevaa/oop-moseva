package com.company;

import java.awt.geom.Rectangle2D;

public class Mandelbrot  extends FractalGenerator {
    public static final int MAX_ITERATIONS = 2000;
    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }

    @Override
    public int numIterations(double x, double y) {
        int iteration = 0;
        double z_real = 0;
        double z_imaginary = 0;
        while ((iteration < MAX_ITERATIONS) && (z_real*z_real+z_imaginary*z_imaginary < 4)) {
            double z_real_new = z_real*z_real - z_imaginary*z_imaginary+x;
            double z_imaginary_new = z_real*z_imaginary +y;
            z_imaginary=z_imaginary_new;
            z_real=z_real_new;
            iteration+=1;
        }
        if (iteration==MAX_ITERATIONS) return -1;
        return iteration;
    }
}
