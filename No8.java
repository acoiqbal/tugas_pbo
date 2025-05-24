public class No8 {
        public static void main(String[] args) {
            int[][] adjacency = {
                    {0, 12, 0, 8, 0, 0, 5},
                    {0, 0, 16, 0, 0, 5, 0},
                    {0, 0, 0, 0, 4, 0, 0},
                    {0, 3, 0, 0, 0, 0, 0},
                    {0, 6, 0, 0, 0, 2, 0},
                    {16, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 7, 0}
            };
            for (int i = 0; i < adjacency.length; i++) {
                System.out.print("[");
                for (int j = 0; j < adjacency[i].length; j++) {
                    System.out.print(adjacency[i][j]);
                    if (adjacency[i][j] > 10) {
                        System.out.print(" ");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println("]");
            }
        }
    }

