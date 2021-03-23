package com.company;

import java.awt.geom.Rectangle2D;

public class BurningShip extends FractalGenerator{
    int MAX_ITERATIONS = 2000;
    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -2.5;
        range.height = 4;
        range.width = 4;
    }

    @Override
    public int numIterations(double x, double y) {
        int iteration = 0;


        double z_real = 0;
        double z_imaginary = 0;

        while (iteration < MAX_ITERATIONS && z_real * z_real + z_imaginary * z_imaginary < 4)
        {
            double z_realUpdated = z_real * z_real - z_imaginary * z_imaginary + x;
            double z_imaginaryUpdated = 2 * Math.abs(z_real) * Math.abs(z_imaginary) + y;
            z_real = z_realUpdated;
            z_imaginary = z_imaginaryUpdated;
            iteration += 1;
        }


        if (iteration == MAX_ITERATIONS)
        {
            return -1;
        }

        return iteration;
    }

    public String toString(){
        return "BurningShip";
    }
}

