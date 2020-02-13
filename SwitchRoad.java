package edu.kit.informatik;

public class SwitchRoad extends RailRoad{
    private int id;
    private Point start;
    private Point end;
    private Point end1;
    private Point end2;
    private boolean isSwitched;
    //composition
    private RailRoad road1;
    private RailRoad road2;

    public SwitchRoad(Point start, Point end1, Point end2) {
        this.start = start;
        this.end1 = end1;
        this.end2 = end2;
        road1 = new RailRoad(start, end1);
        road2 = new RailRoad(start, end2);
    }
    public void switches(Point end) {
        if (!isSwitched) {
            if (end.equals(end1)) {
                start.setRightConnected(true);
                end1.setLeftConnected(true);
                isSwitched = true;
                this.end = end1;
                return;
            }
            if (end.equals(end2)) {
                start.setRightConnected(true);
                end2.setLeftConnected(true);
                isSwitched = true;
                this.end = end2;
                return;
            }
            throw new IllegalArgumentException();
        } else {
            if (end.equals(end1)) {
                end1.setLeftConnected(true);
                end2.setLeftConnected(false);
                this.end = end1;
                return;
            }
            if (end.equals(end2)) {
                end2.setLeftConnected(true);
                end1.setLeftConnected(false);
                this.end = end2;
                return;
            }
            throw new IllegalArgumentException();
        }
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
    public Point getStart() {
        return start;
    }

    @Override
    public Point getEnd() {
        return end;
    }

    public Point getEnd1() {
        return road1.getEnd();
    }

    public Point getEnd2() {
        return road2.getEnd();
    }
    @Override
    public String toString() {
        String result;
        if (!isSwitched) {
            result = "s " + id + " " + start + " -> " + end1 + "," + end2;
        } else {
            result = "s " + id + " " + start + " -> " + end1 + "," + end2 + length();
        }
        return result;
    }
}
