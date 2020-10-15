package ch3;

import java.util.LinkedList;

abstract class Animal {
    private int order;
    protected String name;

    public Animal(String n) {
        name = n;
    }

    public void setOrder(int ord) {
        order = ord;
    }

    public int getOrder() {
        return order;
    }

    // Compare orders of animals to return the older item
    public boolean isOlderThan(Animal a) {
        return this.order < a.getOrder();
    }

    @Override
    public String toString() {
        return "{" + name + "}";
    }
}

public class AnimalQueue {

    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0; // Acts as timestamp

    public void enqueue(Animal a) {
        // Order is used as a soft of timestamp, so that we can compare the insertion order of a dog to a cat
        a.setOrder(order);
        order++;

        if (a instanceof Dog) dogs.addLast((Dog) a);
        else if (a instanceof Cat) cats.addLast((Cat) a);
    }

    public Animal dequeueAny() {
        // Look at tops of dog and cat queues, and pop the queue with the oldest value
        if (dogs.size() == 0) {
            return dequeueCats();
        } else if (cats.size() == 0) {
            return dequeueDogs();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if(dog.isOlderThan(cat)) {
            return dequeueDogs();
        } else {
            return dequeueCats();
        }
    }

    public Dog dequeueDogs() {
        return dogs.poll();
    }

    public Cat dequeueCats() {
        return cats.poll();
    }

    public static void main(String[] args) {
        AnimalQueue animalQueue = new AnimalQueue();

        Dog dog1 = new Dog("Doggy");
        animalQueue.enqueue(dog1);
        Cat cat1 = new Cat("Catty");
        animalQueue.enqueue(cat1);

        Dog dog2 = new Dog("Steven");
        animalQueue.enqueue(dog2);

        Dog dog3 = new Dog("Edward");
        animalQueue.enqueue(dog3);


        Cat cat2 = new Cat("Floffy");
        animalQueue.enqueue(cat2);

        Animal animal = animalQueue.dequeueAny();
        System.out.println(animal);

        Cat cat = animalQueue.dequeueCats();
        System.out.println(cat);

        Dog dog = animalQueue.dequeueDogs();
        System.out.println(dog);
    }
}

class Dog extends Animal {

    public Dog(String n) {
        super(n);
    }
}

class Cat extends Animal {

    public Cat(String n) {
        super(n);
    }
}
