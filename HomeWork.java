/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoubleLinkList;

/**
 *
 * @author admin
 */
public class BDList {
    Node head, tail;
    int size; 

    public BDList() {
        head = tail = null;
        size = 0;
    }
    
    private boolean isEmpty () {
        return head == null;
    }
    
    private void display1 () {
        Node cu = head;
        while (cu != null) {
            System.out.println(cu.infor);
            cu = cu.next;
        }
        System.out.println("");
    }
    
    private void display2 () {
        Node cu = tail;
        while (cu != null) {
            System.out.println(cu.infor);
            cu = cu.pre;
        }
        System.out.println("");
    }
    
    private void addFirst (Student value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
            size ++;
        } else {
            head.pre = node;
            node.next = head;
            head = node;
            size ++;
        }
    }
    
    private void addLast (Student value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
            size ++;
        } else {
            tail.next = node;
            node.pre = tail;
            tail = node;
            size ++;
        }
    }
    
    private void addIndex (Student value, int index) {
        if (index < 0 || index >= size) return; 
        
        if (index == 0) {
            addFirst(value);
        } else if (index == size - 1) {
            addLast(value);
        } else {
            Node node = new Node(value);
            if (index < size / 2) {
                Node cu = head;             
                int count = 0;   
                while (count != index - 1) {
                    cu = cu.next;
                    count ++;
                }
                node.next = cu.next;
                cu.next.pre = node;
                node.pre = cu;
                cu.next = node;
                size ++;
            } else {
                Node cu = tail;
                int count = size - 1;
                while (count != index) {
                    cu = cu.pre;
                    count --;
                }
                node.pre = cu.pre;
                cu.pre.next = node;
                node.next = cu;
                cu.pre = node;
                size ++;
            }            
        }
    }
    
    private Student deleteFirst () {
        if (isEmpty()) {
            return null;
        }
        if (head.next == null) {
            Student value = head.infor;
            head = tail = null;
            size --;
            return value;
        } else {
            Student value = head.infor;
            head.next.pre = null;
            head = head .next;
            size --;
            return value;
        }
    }
    
    private Student deleteLast () {
        if (isEmpty()) {
            return null;
        }
        if (tail.pre == null) {
            Student value = tail.infor;
            head = tail = null;
            size --;
            return value;
        } else {
            Student value = tail.infor;
            tail.pre.next = null;
            tail = tail.pre;
            size --;
            return value;
        }
    }
    
    private Student deleteIndex (int index) {
        if (index < 0 || index >= size) return null; 
        
        if (index == 0) {
            return deleteFirst();
        } else if (index == size - 1) {
            return deleteLast();
        } else {
            if (index < size / 2) {
                Node cu = head;
                int count = 0;
                while (count != index - 1) {
                    cu = cu.next;
                    count ++;
                }
                Node value = cu.next;
                cu.next.next.pre = cu;
                cu.next = cu.next.next;
                size --;
                return value.infor;
            } else {
                Node cu = tail;
                int count = size - 1;
                while (count != index + 1) {
                    cu = cu.pre;
                    count --;
                }
                Node value = cu.pre;
                cu.pre.pre.next = cu;
                cu.pre = cu.pre.pre;
                size --;
                return value.infor;
            }            
        }
    }
    
    public static void main(String[] args) {
        BDList myList = new BDList();
        
        myList.addFirst(new Student("one", 1));    
        myList.addFirst(new Student("two", 2));
        myList.addLast(new Student("three", 3));
        myList.addLast(new Student("three", 3));
        myList.addLast(new Student("three", 3));
        myList.addLast(new Student("three", 3));
        myList.addLast(new Student("three", 3));
        myList.addLast(new Student("four", 4));
        myList.addIndex(new Student("addIndex", 999), 6);
        myList.deleteFirst();
        myList.deleteLast();
        myList.deleteIndex(5);
        myList.display1();
    }
}
