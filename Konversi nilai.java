import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KonversiNilai extends Application {

    @Override
    public void start(Stage stage) {
        TextField inputField = new TextField();
        ComboBox<String> modeBox = new ComboBox<>();
        Button konversiButton = new Button("Konversi");
        Label hasilLabel = new Label();

        modeBox.getItems().addAll("Angka ke Huruf", "Huruf ke Angka");
        modeBox.setValue("Angka ke Huruf");

        konversiButton.setOnAction(e -> {
            String input = inputField.getText().trim();
            String mode = modeBox.getValue();

            try {
                if (mode.equals("Angka ke Huruf")) {
                    double nilai = Double.parseDouble(input);
                    if (nilai < 0 || nilai > 100) {
                        hasilLabel.setText("Nilai harus 0 - 100");
                    } else {
                        hasilLabel.setText("Nilai Huruf: " + konversiAngkaKeHuruf(nilai));
                    }
                } else {
                    hasilLabel.setText("Nilai Angka: " + konversiHurufKeAngka(input.toUpperCase()));
                }
            } catch (Exception ex) {
                hasilLabel.setText("Input tidak valid.");
            }
        });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(new Label("Nilai:"), 0, 0);
        grid.add(inputField, 1, 0);
        grid.add(new Label("Mode:"), 0, 1);
        grid.add(modeBox, 1, 1);
        grid.add(konversiButton, 1, 2);
        grid.add(hasilLabel, 1, 3);

        Scene scene = new Scene(grid, 350, 200);
        stage.setTitle("Konversi Nilai");
        stage.setScene(scene);
        stage.show();
    }

    private String konversiAngkaKeHuruf(double nilai) {
        if (nilai >= 85) return "A";
        else if (nilai >= 80) return "A-";
        else if (nilai >= 75) return "B+";
        else if (nilai >= 70) return "B";
        else if (nilai >= 65) return "B-";
        else if (nilai >= 60) return "C";
        else if (nilai >= 50) return "D";
        else return "E";
    }

    private String konversiHurufKeAngka(String huruf) {
        return switch (huruf) {
            case "A" -> "≥ 85";
            case "A-" -> "80 - 84";
            case "B+" -> "75 - 79";
            case "B" -> "70 - 74";
            case "B-" -> "65 - 69";
            case "C" -> "60 - 64";
            case "D" -> "50 - 59";
            case "E" -> "< 50";
            default -> "Huruf tidak dikenal";
        };
    }

    public static void main(String[] args) {
        launch(args);
    }
        }
