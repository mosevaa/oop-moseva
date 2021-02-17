package com.company;
//трёхмерный класс точки
public class Point3d extends Point2d {
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
        return this.getX() == obj.getX() && this.getY() == obj.getY() && this.zCrd == obj.zCrd;
    }

    //метод для вычисления расстояния
    public double distanceTo (Point3d obj){
        //вычисление расстояния
        double l = Math.sqrt(Math.pow((this.getX() - obj.getX()), 2) + Math.pow((this.getY() - obj.getY()), 2) + Math.pow((this.getZ() - obj.getZ()), 2));
        return l;
    }
}
