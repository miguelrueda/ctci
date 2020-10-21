package ch9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class PathNode {
    private Person person = null;
    private PathNode previousNode = null;

    public PathNode(Person p, PathNode previous) {
        person = p;
        previousNode = previous;
    }

    public Person getPerson() {
        return person;
    }

    public LinkedList<Person> collapse(boolean startsWithRoot) {
        LinkedList<Person> path = new LinkedList<Person>();
        PathNode node = this;
        while (node != null) {
            if (startsWithRoot) {
                path.addLast(node.person);
            } else {
                path.addFirst(node.person);
            }
            node = node.previousNode;
        }
        return path;
    }
}

class Machine {
    public Person getPersonWithID(int personID) {
        return null;
    }
}

class Server {
    HashMap<Integer, Machine> machines = new HashMap<Integer, Machine>();
    HashMap<Integer, Integer> personToMachineMap = new HashMap<>();

    public Machine getMachineWithId(int machineId) {
        return machines.get(machineId);
    }

    public int getMachineIDForUser(int personID) {
        Integer machineID = personToMachineMap.get(personID);
        return machineID == null ? -1 : machineID;
    }

    public Person getPersonWithID(int personID) {
        Integer machineID = personToMachineMap.get(personID);
        if (machineID == null) return null;

        Machine machine = getMachineWithId(machineID);
        if (machine == null) return null;

        return machine.getPersonWithID(personID);
    }
}

class Person {
    private ArrayList<Integer> friends = new ArrayList<>();
    private int personID;
    private String info;

    public Person(int id) {
        this.personID = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ArrayList<Integer> getFriends() {
        return friends;
    }

    public int getID() {
        return personID;
    }

    public void addFriends(int id) {
        friends.add(id);
    }
}

class BFSData {
    public Queue<PathNode> toVisit = new LinkedList<PathNode>();
    public HashMap<Integer, PathNode> visited = new HashMap<>();

    public BFSData(Person root) {
        PathNode sourcePath = new PathNode(root, null);
        toVisit.add(sourcePath);
        visited.put(root.getID(), sourcePath);
    }

    public boolean isFinished() {
        return toVisit.isEmpty();
    }
}

public class SocialNetwork {
    LinkedList<Person> findPathBiBFS(HashMap<Integer, Person> people, int source, int destination) {
        BFSData sourceData = new BFSData(people.get(source));
        BFSData destData = new BFSData(people.get(destination));

        while (!sourceData.isFinished() && !destData.isFinished()) {
            // Search out from source
            Person collision = searchLevel(people, sourceData, destData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision.getID());
            }
            // Search out from destination
            collision = searchLevel(people, destData, sourceData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision.getID());
            }
        }
        return null;
    }

    private LinkedList<Person> mergePaths(BFSData source, BFSData dest, int collisionID) {
        return null;
    }

    // Search one level and return collision if any
    Person searchLevel(HashMap<Integer, Person> people, BFSData primary, BFSData secondary) {
        // We only want to search one level at a time. Count how many nodes are currently in the primary's level and only
        // do that many nodes. We'll continue to add nodes to the end
        int count = primary.toVisit.size();
        for(int i = 0; i < count; i++) {
            // Pull out first node
            PathNode pathNode = primary.toVisit.poll();
            int personID = pathNode.getPerson().getID();

            // Check if it's already been visited
            if (secondary.visited.containsKey(personID)) {
                return pathNode.getPerson();
            }

            // Add friends to queue
            Person person = pathNode.getPerson();
            ArrayList<Integer> friends = person.getFriends();
            for (int friendId: friends) {
                if (!primary.visited.containsKey(friendId)) {
                    Person friend = people.get(friendId);
                    PathNode next = new PathNode(friend, pathNode);
                    primary.visited.put(friendId, next);
                    primary.toVisit.add(next);
                }
            }
        }
        return null;
    }
}
