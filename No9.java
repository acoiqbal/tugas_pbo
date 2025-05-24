public class No9 {

        // Fungsi untuk menghitung jumlah jalur dari titik (x, y)
        public static int countPaths(int[][] grid, int x, int y, int[][] memo) {
            // Jika posisi (x, y) berada di luar batas grid atau tidak dapat dilalui
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
                return 0;
            }

            // Jika kita sudah mencapai titik tujuan (sudut kanan bawah)
            if (x == grid.length - 1 && y == grid[0].length - 1) {
                return 1;
            }

            // Cek apakah sudah dihitung sebelumnya (memoization)
            if (memo[x][y] != -1) {
                return memo[x][y];
            }

            // Hitung jalur ke bawah dan ke kanan
            int down = countPaths(grid, x + 1, y, memo);
            int right = countPaths(grid, x, y + 1, memo);

            // Simpan hasil di memo untuk menghindari perhitungan ulang
            memo[x][y] = down + right;
            return memo[x][y];
        }

        // Fungsi utama untuk menghitung semua jalur yang dapat dilalui
        public static int countTotalPaths(int[][] grid) {
            // Membuat array memo untuk menyimpan hasil perhitungan yang telah dilakukan
            int[][] memo = new int[grid.length][grid[0].length];

            // Inisialisasi array memo dengan -1
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    memo[i][j] = -1;
                }
            }

            // Mulai menghitung jalur dari titik awal (0, 0)
            return countPaths(grid, 0, 0, memo);
        }

        public static void main(String[] args) {
            // Peta grid 2D (1 = dapat dilalui, 0 = tidak dapat dilalui)
            int[][] grid = {
                    {1, 1, 0, 0, 1},
                    {1, 0, 1, 0, 1},
                    {1, 1, 1, 1, 0},
                    {0, 0, 1, 0, 1},
                    {1, 1, 1, 1, 1}
            };

            // Menampilkan jumlah jalur yang dapat dilalui
            System.out.println("Jumlah jalur yang dapat dilalui: " + countTotalPaths(grid));
        }
    }

