import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LabelButtonApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Membuat label dan button
        Label label = new Label("Halo, ini label!");
        Button button = new Button("Klik Saya");

        // Event saat tombol ditekan
        button.setOnAction(e -> label.setText("Tombol ditekan!"));

        // Layout
        VBox layout = new VBox(10); // Jarak 10 piksel antar komponen
        layout.getChildren().addAll(label, button);

        // Scene
        Scene scene = new Scene(layout, 300, 150);

        // Stage
        primaryStage.setTitle("Contoh JavaFX: Label dan Tombol");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
