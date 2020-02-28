package edu.kit.informatik;

public class RailRoad {
    private Point start;
    private Point end;
    private int id;

    public RailRoad() {}

    public RailRoad(Point start, Point end) {
        this.start = start;
        this.end = end;
        if (start.getX() != end.getX() && start.getY() != end.getY()) {
            throw new IllegalArgumentException();
        }
    }

    public int length() {
        int xDis = getStart().getX() - getEnd().getX();
        int yDis = getStart().getY() - getEnd().getY();
        return (int) Math.sqrt(xDis * xDis + yDis * yDis);
    }

    public RailRoad revert() {
        Point newStart = this.getEnd();
        Point newEnd = this.getStart();
        return new RailRoad(newStart, newEnd);
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
