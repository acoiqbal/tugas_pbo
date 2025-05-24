package No5;

public class Main {
    public static void main(String[] args) {
        StackArray SA = new StackArray();
        StackArrayList SAL = new StackArrayList();
        StackLinkedList SLL = new StackLinkedList();
        StackVector SV = new StackVector();

        System.out.println("ARRAY: ");
        SA.push(1);
        SA.push(2);
        SA.push(3);
        SA.push(4);
        SA.push(5);
        System.out.println("PEEK: " + SA.peek());
        System.out.println("POP: " + SA.pop());
        System.out.println("EMPTY: " + SA.empty());
        System.out.println("TO STRING: " + SA.toString());

        System.out.println("\nARRAYLIST: ");
        SAL.push(1);
        SAL.push(2);
        SAL.push(3);
        SAL.push(4);
        SAL.push(5);
        System.out.println("PEEK: " + SAL.peek());
        System.out.println("POP: " + SAL.pop());
        System.out.println("EMPTY: " + SAL.empty());
        System.out.println("TO STRING: " + SAL.toString());

        System.out.println("\nLINKED LIST: ");
        SLL.push(1);
        SLL.push(2);
        SLL.push(3);
        SLL.push(4);
        SLL.push(5);
        System.out.println("PEEK: " + SLL.peek());
        System.out.println("POP: " + SLL.pop());
        System.out.println("EMPTY: " + SLL.empty());
        System.out.println("TO STRING: " + SLL.toString());

        System.out.println("\nVECTOR: ");
        SV.push(1);
        SV.push(2);
        SV.push(3);
        SV.push(4);
        SV.push(5);
        System.out.println("PEEK: " + SV.peek());
        System.out.println("POP: " + SV.pop());
        System.out.println("EMPTY: " + SV.empty());
        System.out.println("TO STRING: " + SV.toString());
    }
}