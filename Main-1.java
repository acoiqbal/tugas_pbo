package No6;

public class Main {
    public static void main(String[] args) {
        QueueArray QA = new QueueArray();
        QueueArrayList QAL = new QueueArrayList();
        QueueLinkedList QLL = new QueueLinkedList();
        QueueVector QV = new QueueVector();

        System.out.println("ARRAY: ");
        QA.offer(1);
        QA.offer(2);
        QA.offer(3);
        QA.offer(4);
        QA.offer(5);
        System.out.println("PEEK: " + QA.peek());
        System.out.println("POP: " + QA.poll());
        System.out.println("EMPTY: " + QA.isEmpty());

        System.out.println("\nARRAYLIST: ");
        QAL.offer(1);
        QAL.offer(2);
        QAL.offer(3);
        QAL.offer(4);
        QAL.offer(5);
        System.out.println("PEEK: " + QAL.peek());
        System.out.println("POP: " + QAL.poll());
        System.out.println("EMPTY: " + QAL.isEmpty());

        System.out.println("\nLINKED LIST: ");
        QLL.offer(1);
        QLL.offer(2);
        QLL.offer(3);
        QLL.offer(4);
        QLL.offer(5);
        System.out.println("PEEK: " + QLL.peek());
        System.out.println("POP: " + QLL.poll());
        System.out.println("EMPTY: " + QLL.isEmpty());

        System.out.println("\nVECTOR: ");
        QV.offer(1);
        QV.offer(2);
        QV.offer(3);
        QV.offer(4);
        QV.offer(5);
        System.out.println("PEEK: " + QV.peek());
        System.out.println("POP: " + QV.poll());
        System.out.println("EMPTY: " + QV.isEmpty());
    }
}
