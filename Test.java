package edu.kit.informatik;

public class Test {
    public static void main(String[] args) {
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,2);
        Point p3 = new Point(2,2);
        Point p4 = new Point(2,0);
        RailRoad road1 = new TrackRoad(p1, p2);
        RailRoad road2 = new TrackRoad(p2, p3);
        RailRoad road3 = new TrackRoad(p3, p4);
        RailRoad road4 = new TrackRoad(p4, p1);
        Graph g = new Graph();
        g.add(road1);
        g.add(road2);
        g.add(road3);
        g.add(road4);
        g.delete(1);
        g.delete(4);
        g.list();
    }
}
