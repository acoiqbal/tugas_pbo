import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.List;

public class CsvCrudApp extends Application {

    private final String CSV_FILE = "data.csv";
    private final ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
    private TableView<ObservableList<String>> tableView = new TableView<>();

    @Override
    public void start(Stage primaryStage) {
        loadCsv();

        Button addButton = new Button("Tambah");
        Button editButton = new Button("Ubah");
        Button deleteButton = new Button("Hapus");
        Button saveButton = new Button("Simpan");

        HBox buttonBox = new HBox(10, addButton, editButton, deleteButton, saveButton);
        buttonBox.setPadding(new Insets(10));

        VBox root = new VBox(10, tableView, buttonBox);
        root.setPadding(new Insets(10));

        addButton.setOnAction(e -> addRow());
        editButton.setOnAction(e -> editRow());
        deleteButton.setOnAction(e -> deleteRow());
        saveButton.setOnAction(e -> saveCsv());

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Aplikasi CRUD CSV");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadCsv() {
        data.clear();
        tableView.getColumns().clear();
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            List<String[]> allRows = reader.readAll();
            if (allRows.isEmpty()) return;

            String[] headers = allRows.get(0);
            for (int i = 0; i < headers.length; i++) {
                final int colIndex = i;
                TableColumn<ObservableList<String>, String> column = new TableColumn<>(headers[i]);
                column.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(colIndex)));
                column.setCellFactory(TextFieldTableCell.forTableColumn());
                column.setOnEditCommit(event -> {
                    event.getRowValue().set(colIndex, event.getNewValue());
                });
                tableView.getColumns().add(column);
            }

            for (int i = 1; i < allRows.size(); i++) {
                ObservableList<String> row = FXCollections.observableArrayList(allRows.get(i));
                data.add(row);
            }

            tableView.setItems(data);
            tableView.setEditable(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addRow() {
        ObservableList<String> newRow = FXCollections.observableArrayList();
        for (int i = 0; i < tableView.getColumns().size(); i++) {
            newRow.add("");
        }
        data.add(newRow);
    }

    private void editRow() {
        TablePosition pos = tableView.getSelectionModel().getSelectedCells().get(0);
        tableView.edit(pos.getRow(), pos.getTableColumn());
    }

    private void deleteRow() {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            data.remove(selectedIndex);
        }
    }

    private void saveCsv() {
        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE))) {
            // Write headers
            String[] headers = tableView.getColumns().stream()
                    .map(TableColumn::getText)
                    .toArray(String[]::new);
            writer.writeNext(headers);

            // Write rows
            for (ObservableList<String> row : data) {
                writer.writeNext(row.toArray(new String[0]));
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sukses");
            alert.setHeaderText(null);
            alert.setContentText("Data berhasil disimpan!");
            alert.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
