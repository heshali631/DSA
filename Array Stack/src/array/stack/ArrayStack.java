/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package array.stack;

public class ArrayStack {
    private int capacity;
    private Object[] stack;
    private int top;
    
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.stack = new Object[capacity];
        this.top = -1;
    }
    
    public ArrayStack() {
        this(10);
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public boolean isFull() {
        return top == capacity - 1;
    }
    
    public int size() {
        return top + 1;
    }
    
    public boolean push(Object element) {
        if (isFull()) {
            return false;
        }
        stack[++top] = element;
        return true;
    }
    
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        Object element = stack[top];
        stack[top--] = null;
        return element;
    }
    
    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return stack[top];
    }
    
    public void clear() {
        for (int i = 0; i <= top; i++) {
            stack[i] = null;
        }
        top = -1;
    }
    
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        
        System.out.println("Is empty? " + stack.isEmpty());
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack size: " + stack.size());
        
        System.out.println("Popped: " + stack.pop());
        System.out.println("Top element after pop: " + stack.peek());
        
        stack.push(40);
        stack.push(50);
        stack.push(60);
        
        System.out.println("Is full? " + stack.isFull());
        
        stack.clear();
        System.out.println("Is empty after clear? " + stack.isEmpty());
    }
}