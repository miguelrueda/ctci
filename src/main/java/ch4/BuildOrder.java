package ch4;

import java.util.*;

public class BuildOrder {

    // Find a correct build order
    Project [] findBuildOrder(String [] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    // Build the graph, adding the edge (a,b) if b is dependent on a. Assumes a pair is listed in "build order"
    //The pair (a, b) in dependencies indicates that b depends on a and a must be built before b
    Graph buildGraph(String [] projects, String [][] dependencies) {
        Graph graph = new Graph();
        for(String project : projects) {
            graph.getOrCreateNode(project);
        }

        for (String [] dependency: dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }
        return graph;
    }

    // Return a list of the projects a correct build order
    Project [] orderProjects(ArrayList<Project> projects) {
        Project[] order = new Project[projects.size()];

        // Add roots to the build order first
        int endOfList = addNonDependent(order, projects, 0);

        int toBeProcessed = 0;
        while (toBeProcessed < order.length) {
            Project current = order[toBeProcessed];
            // We have a circular dependency since there are no remaining projects with zero dependencies
            if (current == null) {
                return null;
            }

            // Remove myself as a dependency
            ArrayList<Project> children = current.getChildren();
            for (Project child: children) {
                child.decrementDependencies();
            }

            // Add children that have no one depending on them
            endOfList = addNonDependent(order, children, endOfList);
            toBeProcessed++;
        }
        return order;
    }

    int addNonDependent(Project [] order, ArrayList<Project> projects, int offset) {
        for (Project project: projects) {
            if (project.getNumberDependencies() == 0) {
                order[offset] = project;
                offset++;
            }
        }
        return offset;
    }

    class Graph {
        private ArrayList<Project> nodes = new ArrayList<>();
        private HashMap<String, Project> map = new HashMap<>();

        public Project getOrCreateNode(String name) {
            if (!map.containsKey(name)) {
                Project node = new Project(name);
                nodes.add(node);
                map.put(name, node);
            }
            return map.get(name);
        }

        public void addEdge(String startName, String endName) {
            Project start = getOrCreateNode(startName);
            Project end = getOrCreateNode(endName);
            start.addNeighbor(end);
        }

        public ArrayList<Project> getNodes() {
            return nodes;
        }
    }

    enum State {
        COMPLETE,
        PARTIAL,
        BLANK
    }

    class Project {

        private State state = State.BLANK;
        private ArrayList<Project> children = new ArrayList<>();
        private HashMap<String, Project> map = new HashMap<>();
        private String name;
        private int dependencies = 0;

        public Project(String n) {
            name = n;
        }

        public void addNeighbor(Project node) {
            if (!map.containsKey(node.getName())) {
                children.add(node);
                map.put(node.getName(), node);
                node.incrementDependencies();
            }
        }

        public void incrementDependencies() {
            dependencies++;
        }

        public void decrementDependencies() {
            dependencies--;
        }

        public String getName() {
            return name;
        }

        public ArrayList<Project> getChildren() {
            return children;
        }

        public int getNumberDependencies() {
            return dependencies;
        }

        public State getState() {
            return state;
        }

        public void setState(State st) {
            state = st;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    Stack<Project> findBuildOrder2(String [] projects, String [][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects2(graph.getNodes());
    }

    Stack<Project> orderProjects2(ArrayList<Project> projects) {
        Stack<Project> stack = new Stack<>();
        for (Project project: projects) {
            if (project.getState() == State.BLANK) {
                if (!doDFS(project, stack)) {
                    return null;
                }
            }
        }
        return stack;
    }

    boolean doDFS(Project project, Stack<Project> stack) {
         if(project.getState() == State.PARTIAL) {
             return false; // Cycle
         }

         if (project.getState() == State.BLANK) {
             project.setState(State.PARTIAL);
             ArrayList<Project> children = project.getChildren();
             for (Project child: children) {
                 if (!doDFS(child, stack)) {
                     return false;
                 }
             }
             project.setState(State.COMPLETE);
             stack.push(project);
         }
         return true;
    }

    public static void main(String[] args) {
        BuildOrder buildOrder = new BuildOrder();

        String [] projects = {"a", "b", "c", "d", "e", "f", "g"};
        String [] dep_a = {"a", "e"};
        String [] dep_b = {"d", "g"};
        String [] dep_c = {"f", "b"};
        String [] dep_d = {"f", "c"};
        String [] dep_e = {"f", "a"};
        String [] dep_f = {"a", "e"};
        String [][] dependencies = {
                dep_a,
                dep_b,
                dep_c,
                dep_d,
                dep_e,
                dep_f,
        };
        Stack<Project> buildOrder2 = buildOrder.findBuildOrder2(projects, dependencies);
        Iterator<Project> iterator = buildOrder2.iterator();
        while (iterator.hasNext()) {
            Project next = iterator.next();
            System.out.println(next.name);
        }
    }
}
