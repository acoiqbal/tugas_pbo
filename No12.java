import java.awt.*;

    import java.awt.Point;
public class No12 {


        // Fungsi menghitung jarak Manhattan antar dua titik
        public static int manhattanDistance(Point p1, Point p2) {
            return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
        }

        // Fungsi mencari rumah tempat kumpul terbaik
        public static Point findMeetingPlace(Point[] houseLocations, Point kakekHouse, int D) {
            Point bestMeetingPoint = null;
            int minTotalDistance = Integer.MAX_VALUE;

            for (Point candidate : houseLocations) {
                // Hitung jarak bolak-balik kakek ke kandidat
                int jarakBolakBalik = manhattanDistance(kakekHouse, candidate) * 2;
                if (jarakBolakBalik <= D) {
                    // Hitung total jarak semua rumah ke kandidat
                    int totalDistance = 0;
                    for (Point house : houseLocations) {
                        totalDistance += manhattanDistance(house, candidate);
                    }

                    // Jika total jarak lebih kecil, update kandidat terbaik
                    if (totalDistance < minTotalDistance) {
                        minTotalDistance = totalDistance;
                        bestMeetingPoint = candidate;
                    }
                }
            }

            return bestMeetingPoint;
        }

        // Contoh penggunaan
        public static void main(String[] args) {
            Point[] houses = {
                    new Point(0, 0),
                    new Point(2, 2),
                    new Point(3, 1),
                    new Point(5, 0),
                    new Point(1, 3)
            };
            Point kakek = new Point(0, 0);
            int D = 8;

            Point meetingPlace = findMeetingPlace(houses, kakek, D);
            if (meetingPlace != null) {
                System.out.println("Tempat kumpul terbaik: (" + meetingPlace.x + ", " + meetingPlace.y + ")");
            } else {
                System.out.println("Tidak ada rumah yang memenuhi syarat kakek.");
            }
        }
    }

