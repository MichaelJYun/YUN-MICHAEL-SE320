/**
 * Author: Michael Yun
 * Assignment: Assignment-1
 * 
 * This program will utilize exception handling in order to return the value of
 * the user-given index of an array
 * filled with random numbers, or an error message if out of bounds.
 **/

public class GenericStack<E> {

    static final int DEFAULT_CAPACITY = 5;
    private E[] elements;
    int size;

    public GenericStack() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public GenericStack(int initialCapacity) {
        elements = (E[]) new Object[initialCapacity];
    }

    public int getSize() {
        return size;
    }

    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        return elements[size - 1]; //returns "top" of stack
    }

    public void push(E o) {

        if (size == elements.length) { //size being equal to elements.length would mean one more than allowed was added
            doubleArraySize();
        }
        elements[size] = o;
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        E value = elements[--size]; //change value to right before top of stack
        elements[size] = null;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("stack: [");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void doubleArraySize() {
        int doubleSize = elements.length * 2;
        E[] doubleArray = (E[]) new Object[doubleSize];
        System.arraycopy(elements, 0, doubleArray, 0, size); //method used to copy elements from one array (elements) to another (doubleArray)
        elements = doubleArray;
    }

    //main method used to test the code's functionality
    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Top element: " + stack.peek());

        stack.push(6); //trigger array doubling in size

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Size of stack after pop: " + stack.getSize());

        System.out.println(stack);
    }
}
