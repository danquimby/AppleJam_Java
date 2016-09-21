package com.danquimby.apple_jam.Utilites.Animation;

/**
 * Created by Quimby on 21.09.2016.
 */
public class FrameDimension {
    private int y;
    private int x;
    private int width;
    private int height;
    public FrameDimension()
    {
        this.x = this.y = this.width = this.height = 0;
    }
    public FrameDimension(int x,int y)
    {
        setX(x);
        setY(y);
        this.width = this.height = 0;
    }

    public FrameDimension(int x,int y, int width,int height)
    {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }
    @Override
    public boolean equals(Object other){
        if (other instanceof FrameDimension)
        {
            FrameDimension frameDimension = (FrameDimension) other;
            return this.x ==  frameDimension.x && this.y ==  frameDimension.y && this.width ==  frameDimension.width && this.height ==  frameDimension.height;
        }
        return false;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}