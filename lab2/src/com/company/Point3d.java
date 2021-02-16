package com.company;
//трёхмерный класс точки
public class Point3d extends Point2d {
    private double xCrd; //координата x
    private double yCrd; //координата y
    private double zCrd; //координата z

    //конструктор инициализации
    public Point3d(double x, double y, double z) {
        super (x,y);
        zCrd = z;
    }

    //Конструктор по умолчанию
    public Point3d() {
        this (0.0, 0.0, 0.0);
    }

    //Возвращение z
    public double getZ(){
        return zCrd;
    }

    //Установка значения z
    public void setZ (double val) {
        zCrd = val;
    }

    //сравнение двух объектов
    public boolean isEquals (Point3d obj) {
        return this.xCrd == obj.xCrd && this.yCrd == obj.yCrd && this.zCrd == obj.zCrd;
    }

    //метод для вычисления расстояния
    public double distanceTo (Point3d obj){
        //координаты точек
        double x1 = this.xCrd;
        double y1 = this.yCrd;
        double z1 = this.zCrd;
        double x2 = obj.xCrd;
        double y2 = obj.yCrd;
        double z2 = obj.zCrd;

        //вычисление расстояния
        double l = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2) + Math.pow((z2 - z1), 2));
        int res = (int) Math.round(l*100);
        return (double) res / 100;
    }
}
