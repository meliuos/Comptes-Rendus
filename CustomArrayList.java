public class CustomArrayList {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    // Default constructor
    public CustomArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // Constructor with initial size
    public CustomArrayList(int initialSize) {
        this.elements = new Object[initialSize];
        this.size = 0;
    }

    // Add an object to the end of the CustomArrayList
    public void add(Object obj) {
        ensureCapacity();
        elements[size++] = obj;
    }

    // Add an object at a specific position in the CustomArrayList
    public void add(int index, Object x) {
        ensureCapacity();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        // Shift elements to make space for the new element
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = x;
        size++;
    }

    // Get an object from a given position in the CustomArrayList
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }

    // Get the number of objects currently in the CustomArrayList
    public int size() {
        return size;
    }

    // Check whether the CustomArrayList is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check whether a particular object exists in the CustomArrayList
    public boolean isIn(Object x) {
        return find(x) != -1;
    }

    // Find the position of the first occurrence of an object
    public int find(Object x) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(x)) {
                return i;
            }
        }
        return -1;
    }

    // Remove the first occurrence of an object from the CustomArrayList
    public void remove(Object x) {
        int index = find(x);
        if (index != -1) {
            // Shift elements to remove the found element
            System.arraycopy(elements, index + 1, elements, index, size - index - 1);
            elements[--size] = null; // Set the last element to null
        }
    }

    // Ensure the capacity of the CustomArrayList
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            elements = java.util.Arrays.copyOf(elements, newCapacity);
        }
    }

    public static void main(String[] args) {
        CustomArrayList customList = new CustomArrayList();
        customList.add("Apple");
        customList.add("Banana");
        customList.add("Orange");

        System.out.println("CustomArrayList size: " + customList.size());
        System.out.println("Is CustomArrayList empty? " + customList.isEmpty());

        System.out.println("Index of 'Banana': " + customList.find("Banana"));

        customList.add(1, "Grapes");
        System.out.println("After adding 'Grapes' at index 1: " + customList.get(1));

        System.out.println("Is 'Apple' in the list? " + customList.isIn("Apple"));

        customList.remove("Banana");
        System.out.println("After removing 'Banana', size: " + customList.size());
    }
}
