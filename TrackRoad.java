package edu.kit.informatik;

import java.util.Objects;

public class TrackRoad extends RailRoad {
    private Point start;
    private Point end;
    private int id;
    //composition
    private RailRoad rail;

    public TrackRoad(Point start, Point end) {
        rail = new RailRoad(start, end);
        this.start = rail.getStart();
        this.end = rail.getEnd();
        this.start.setRightConnected(true);
        this.end.setLeftConnected(true);
    }

    @Override
    public RailRoad revert() {
        Point newStart = this.end;
        Point newEnd = this.start;
        newStart.setLeftConnected(false);
        newStart.setRightConnected(false);
        return new TrackRoad(newStart, newEnd);
    }

    @Override
    public Point getStart() {
        return start;
    }

    @Override
    public Point getEnd() {
        return end;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrackRoad trackRoad = (TrackRoad) o;
        return (this.start.equals(trackRoad.start) && this.end.equals(trackRoad.end)) ||
                (this.end.equals(trackRoad.start) && this.start.equals(trackRoad.end));
    }

    @Override
    public String toString() {
        String result;
        result = "t " + id + " " + start + " -> " + end + " " + length();
        return result;
    }
}
