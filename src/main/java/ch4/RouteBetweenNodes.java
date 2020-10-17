package ch4;

import java.util.LinkedList;

public class RouteBetweenNodes {

    boolean search(Graph g, Node start, Node end) {
        if (start == end) return true;

        // Operates as Queue
        LinkedList<Node> q = new LinkedList<>();

        for (Node u : g.nodes) {
            u.state = State.Unvisited;
        }

        start.state = State.Visiting;

        q.add(start);
        Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst();
            if (u != null) {
                for (Node v : u.children) {
                    if (v.state == State.Unvisited) {
                        if (v == end) {
                            return true;
                        } else {
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Node n = new Node("0");
        Node one = new Node("1");
        Node [] adj0 = { one };
        n.children = adj0;

        Node two = new Node("2");
        Node [] adj1 = { two };
        one.children = adj1;

        Node three =  new Node("3");
        Node [] adj2 = { n };
        two.children = adj2;

        Node [] adj3 = { two };
        three.children = adj3;

        RouteBetweenNodes routeBetweenNodes = new RouteBetweenNodes();
        Node [] graphNodes = { n, one, two, three };
        Graph g = new Graph(graphNodes);
        System.out.println(routeBetweenNodes.search(g, n, three));

    }
}
