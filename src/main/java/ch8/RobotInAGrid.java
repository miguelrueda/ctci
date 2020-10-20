package ch8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public String toString() {
        return "{ " + row + ", " + col + " }";
    }
}

public class RobotInAGrid {

    ArrayList<Point> getPath(boolean [][] maze) {
        if (maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
            return path;
        }
        return null;
    }

    boolean getPath(boolean [][] maze, int row, int col, ArrayList<Point> path) {
        // If out of bounds or not available return
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }

        boolean isAtOrigin = (row == 0) && (col == 0);

        // If there's a path from the start to here, add my location
        if (isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) {
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }
        return false;
    }

    public ArrayList<Point> getPath2(boolean [][] maze) {
        if (maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
            return path;
        }
        return null;
    }

    public boolean getPath(boolean [][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
        System.out.println("Row " + row + ", col " + col);
        // If out of bounds or not available return
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }

        Point p = new Point(row, col);

        // If we've already visited this cell return
        if (failedPoints.contains(p)) {
            return false;
        }
        boolean isAtOrigin = (row == 0) && (col == 0);
        // If there's a path from start to my current location, add my location
        if (isAtOrigin || getPath(maze, row, col -1, path, failedPoints) ||
                getPath(maze, row - 1, col, path, failedPoints)) {
            System.out.println("Adding " + p.toString());
            path.add(p);
            return true;
        }

        failedPoints.add(p);
        return false;
    }

    public static void main(String[] args) {
        RobotInAGrid robotInAGrid = new RobotInAGrid();
        boolean [][] maze = {
                {true, true, true, true},
                {false, false, true, false},
                {false, false, true, false},
                {true, true, true, true}
        };
        ArrayList<Point> path = robotInAGrid.getPath2(maze);
        path.forEach(System.out::println);
    }
}
