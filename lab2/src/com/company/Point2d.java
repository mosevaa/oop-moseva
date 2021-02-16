package com.company;

/**  двумерный класс точки. **/
public class Point2d {
    /** координата X **/
    private double xCrd;
    /**  координата Y **/
    private double yCrd;
    /** Конструктор **/
    public Point2d ( double x,  double y) {
        xCrd = x;
        yCrd = y;
    }
    /** Конструктор по умолчанию. **/
    public Point2d () {
        //Вызовите конструктор с двумя параметрами и определите источник.
        this(0, 0);
    }
    /** Возврат координаты X **/
    public double getX () {
        return xCrd;
    }
    /** Возврат координаты Y **/
    public double getY () {
        return yCrd;
    }
    /** Присвоение значения координаты X. **/
    public void setX ( double val) {
        xCrd = val;
    }
    /**  Присвоение значения координаты Y. **/
    public void  setY ( double val) {
        yCrd = val;
    }
}
