package edu.kit.informatik;

public class Point {
    private int x;
    private int y;
    private boolean isLeftConnected;
    private boolean isRightConnected;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isLeftConnected() {
        return isLeftConnected;
    }

    public void setLeftConnected(boolean leftConnected) {
        isLeftConnected = leftConnected;
    }

    public boolean isRightConnected() {
        return isRightConnected;
    }

    public void setRightConnected(boolean rightConnected) {
        isRightConnected = rightConnected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Point p = (Point) o;
        return x == p.x && y == p.y;
    }
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
