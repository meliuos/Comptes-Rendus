public class CustomStack {
    private int capacity;
    private int[] stackArray;
    private int top;

    public CustomStack(int capacity) {
        this.capacity = capacity;
        this.stackArray = new int[capacity];
        this.top = -1; // Initialize top to -1 for an empty stack
    }

    // Method to add a new element to the stack
    public void addElement(int element) {
        if (!stackIsFull()) {
            top++;
            stackArray[top] = element;
            System.out.println("Added element: " + element);
        } else {
            System.out.println("Stack is full. Cannot add element.");
        }
    }

    // Method to remove an element from the stack
    public void removeElement() {
        if (!stackIsEmpty()) {
            System.out.println("Removed element: " + stackArray[top]);
            top--;
        } else {
            System.out.println("Stack is empty. Cannot remove element.");
        }
    }

    // Method to return the most recent addition (top) of the stack
    public int lastInStack() {
        if (!stackIsEmpty()) {
            return stackArray[top];
        } else {
            System.out.println("Stack is empty. No elements to return.");
            return -1; // Indicate an empty stack
        }
    }

    // Method to check if the stack is empty
    public boolean stackIsEmpty() {
        return top == -1;
    }

    // Method to check if the stack is full
    public boolean stackIsFull() {
        return top == capacity - 1;
    }

    public static void main(String[] args) {
        // Example usage of CustomStack
        CustomStack customStack = new CustomStack(5);

        customStack.addElement(10);
        customStack.addElement(20);
        customStack.addElement(30);

        System.out.println("Last in stack: " + customStack.lastInStack());

        customStack.removeElement();
        customStack.removeElement();

        System.out.println("Is stack empty? " + customStack.stackIsEmpty());
        System.out.println("Is stack full? " + customStack.stackIsFull());
    }
}
