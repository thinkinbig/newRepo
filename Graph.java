package edu.kit.informatik;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<RailRoad> roads;

    public Graph() {
        this.roads = new ArrayList<>();
    }

    public void add(RailRoad road) {
        if (roads.size() == 0) {
            road.setId(1);
            roads.add(road);
            return;
        }
        if (road.getEnd() != null) {
            for (int i = 0; i < roads.size(); i++) {
                RailRoad temp = roads.get(i);
                if (temp.getStart().equals(road.getStart())) {
                    if (!temp.getStart().isLeftConnected()) {
                        road = road.revert();
                        road.getEnd().setRightConnected(true);
                        road.setId(roads.size() + 1);
                        roads.add(road);
                        return;
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                if (temp.getEnd().equals(road.getEnd())) {
                    if (temp.getEnd().isRightConnected() == false) {
                        road = road.revert();
                        road.getStart().setLeftConnected(true);
                        road.setId(roads.size() + 1);
                        roads.add(road);
                        return;
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                if (temp.getEnd().equals(road.getStart()) || temp.getStart().equals(road.getEnd())) {
                    road.setId(roads.size() + 1);
                    roads.add(road);
                    return;
                }
            }
        } else {
            road.setId(roads.size() + 1);
            roads.add(road);
        }
    }
    public void list() {
        if (roads.size() == 0) {
            throw new IllegalArgumentException();
        } else {
            for (int i = 0; i < roads.size(); i++) {
                Terminal.printLine(roads.get(i));
            }
        }
    }
    public void delete(int id) {
        int count = 0;
        if (roads.size() == 0) {
            throw new IllegalArgumentException();
        }
        RailRoad road = null;
        for (int i = 0; i < roads.size(); i++) {
            if (id == roads.get(i).getId()) {
                road = roads.get(i);
            }
        }
        Point point1 = road.getStart();
        if (road.getEnd() == null) {
            throw new IllegalArgumentException();
        }
        Point point2 = road.getEnd();
        point1.setRightConnected(false);
        point2.setLeftConnected(false);
        for (int i = 0; i < roads.size(); i++) {
            Point start = roads.get(i).getStart();
            Point end = roads.get(i).getEnd();
            if (start.isLeftConnected() == false && start.isRightConnected() == true) {
                count++;
            }
            if (start.isLeftConnected() == true && start.isRightConnected() == false) {
                count++;
            }
            if (end.isLeftConnected() == false && end.isRightConnected() == true) {
                count++;
            }
            if (end.isLeftConnected() == true && end.isRightConnected() == false) {
                count++;
            }
        }
        if (count > 4) {
            throw new IllegalArgumentException();
        }
        roads.remove(road);
        return;
    }
}
