import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KonversiPanjang extends Application {

    String[] satuan = {"km", "hm", "dam", "m", "dm", "cm", "mm"};
    double[] faktor = {1e3, 1e2, 1e1, 1, 1e-1, 1e-2, 1e-3}; // faktor terhadap meter

    @Override
    public void start(Stage stage) {
        // Komponen
        TextField inputField = new TextField();
        ComboBox<String> dariBox = new ComboBox<>();
        ComboBox<String> keBox = new ComboBox<>();
        Button konversiButton = new Button("Konversi");
        Label hasilLabel = new Label();

        // Isi ComboBox
        dariBox.getItems().addAll(satuan);
        keBox.getItems().addAll(satuan);
        dariBox.setValue("m");
        keBox.setValue("cm");

        // Event konversi
        konversiButton.setOnAction(e -> {
            try {
                double nilaiInput = Double.parseDouble(inputField.getText());
                String dari = dariBox.getValue();
                String ke = keBox.getValue();

                // Konversi ke meter
                double meter = nilaiInput * getFaktor(dari);
                // Konversi ke satuan tujuan
                double hasil = meter / getFaktor(ke);

                hasilLabel.setText(String.format("%.3f %s", hasil, ke));
            } catch (NumberFormatException ex) {
                hasilLabel.setText("Input tidak valid!");
            }
        });

        // Layout
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(20));

        grid.add(new Label("Nilai:"), 0, 0);
        grid.add(inputField, 1, 0);
        grid.add(new Label("Dari:"), 0, 1);
        grid.add(dariBox, 1, 1);
        grid.add(new Label("Ke:"), 0, 2);
        grid.add(keBox, 1, 2);
        grid.add(konversiButton, 1, 3);
        grid.add(hasilLabel, 1, 4);

        Scene scene = new Scene(grid, 300, 250);
        stage.setTitle("Konversi Panjang SI");
        stage.setScene(scene);
        stage.show();
    }

    // Mendapatkan faktor konversi ke meter
    private double getFaktor(String satuanInput) {
        for (int i = 0; i < satuan.length; i++) {
            if (satuan[i].equals(satuanInput)) {
                return faktor[i];
            }
        }
        return 1; // default (meter)
    }

    public static void main(String[] args) {
        launch(args);
    }
}
