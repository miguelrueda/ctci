package ch7;

import java.util.HashMap;
import java.util.LinkedList;

enum Orientation {

    LEFT, TOP, RIGHT, BOTTOM;

    public Orientation getOpposite() {
        switch (this) {
            case LEFT: return RIGHT;
            case RIGHT: return LEFT;
            case TOP: return BOTTOM;
            case BOTTOM: return TOP;
            default: return null;
        }
    }
}

enum Shape {
    INNER, OUTER, FLAT;

    public Shape getOpposite() {
        switch (this) {
            case INNER: return OUTER;
            case OUTER: return INNER;
            default: return null;
        }
    }
}

class Puzzle {
    private LinkedList<Piece> pieces;
    private Piece[][] solution;
    private int size;

    public Puzzle(int size, LinkedList<Piece> pieces) {}

    // Put piece into the solution, turn it appropriately, and remove from list
    private void setEdgeInSolution(LinkedList<Piece> pieces, Edge edge, int row, int column, Orientation orientation) {
        Piece piece = edge.getParentPiece();
        piece.setEdgeAsOrientation(edge, orientation);
        pieces.remove(piece);
        solution[row][column] = piece;
    }

    // Find the matching piece in piecesToSearch and insert it at row, column
    private boolean fitNextEdge(LinkedList<Piece> piecesToSearch, int row, int col) {
        return false;
    }

    public boolean solve() {
        return false;
    }
}

class Piece {
    private HashMap<Orientation, Edge> edges = new HashMap<>();

    public Piece(Edge[] edgesList) {}

    // Rotate edges by 'numberRotations'
    public void rotateEdgesBy(int numberRotations) {}

    public boolean isCorner() {
        return false;
    }
    public boolean isBorder() {
        return false;
    }
    public void setEdgeAsOrientation(Edge edge, Orientation orientation) {

    }
}

class Edge {
    private Shape shape;
    private Piece parentPiece;
    public Edge(Shape shape) {}
    public boolean fitsWith(Edge edge) {
        return false;
    }
    public Piece getParentPiece() {
        return null;
    }
}

public class Jigsaw {}