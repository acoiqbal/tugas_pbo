import java.util.Scanner;
import java.util.Stack;

public class ReverseStringWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string dari user
        System.out.print("Masukkan string: ");
        String input = scanner.nextLine();

        // Buat stack untuk karakter
        Stack<Character> stack = new Stack<>();

        // Push semua karakter ke dalam stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Pop dan cetak karakter dari stack (reverse)
        System.out.print("Hasil dibalik: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

        scanner.close();
    }
}
