package com.company;

/**
 * This class represents a specific location in a 2D map.  Coordinates are
 * integer values.
 **/
public class Location
{
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())  return false;
        if (!(o instanceof Location)) return false;
        Location loc = (Location) o;
        return loc.xCoord == xCoord && loc.yCoord == yCoord;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + xCoord;
        result = 31 * result + yCoord;
        return result;
    }
}
