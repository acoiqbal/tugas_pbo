import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KonversiMataUang extends Application {

    private static final double KURS = 15500.0; // Kurs 1 USD = 15.500 Rupiah

    @Override
    public void start(Stage stage) {
        TextField inputField = new TextField();
        ComboBox<String> modeBox = new ComboBox<>();
        Button konversiButton = new Button("Konversi");
        Label hasilLabel = new Label();

        modeBox.getItems().addAll("Dollar ke Rupiah", "Rupiah ke Dollar");
        modeBox.setValue("Dollar ke Rupiah");

        konversiButton.setOnAction(e -> {
            try {
                double nilai = Double.parseDouble(inputField.getText());
                String mode = modeBox.getValue();

                if (mode.equals("Dollar ke Rupiah")) {
                    double hasil = nilai * KURS;
                    hasilLabel.setText(String.format("Hasil: Rp %, .2f", hasil));
                } else {
                    double hasil = nilai / KURS;
                    hasilLabel.setText(String.format("Hasil: $ %, .2f", hasil));
                }
            } catch (NumberFormatException ex) {
                hasilLabel.setText("Input tidak valid. Masukkan angka.");
            }
        });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(new Label("Masukkan Nilai:"), 0, 0);
        grid.add(inputField, 1, 0);
        grid.add(new Label("Mode Konversi:"), 0, 1);
        grid.add(modeBox, 1, 1);
        grid.add(konversiButton, 1, 2);
        grid.add(hasilLabel, 1, 3);

        Scene scene = new Scene(grid, 350, 200);
        stage.setTitle("Konversi Dollar ⇄ Rupiah");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
