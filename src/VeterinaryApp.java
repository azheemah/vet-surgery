package src;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Date;

public class VeterinaryApp extends Application {
    private  Store store = new Store();
    private int currentIndex = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Veterinary Surgery Management");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);

        Label ownerNameLabel = new Label("Owner Name:");
        TextField ownerNameField = new TextField();
        grid.add(ownerNameLabel, 0, 0);
        grid.add(ownerNameField, 1, 0);

        Label petNameLabel = new Label("Pet Name:");
        TextField petNameField = new TextField();
        grid.add(petNameLabel, 0, 1);
        grid.add(petNameField, 1, 1);

        Label petSpeciesLabel = new Label("Species:");
        TextField petSpeciesField = new TextField();
        grid.add(petSpeciesLabel, 0, 2);
        grid.add(petSpeciesField, 1, 2);

        Label petGenderLabel = new Label("Gender:");
        TextField petGenderField = new TextField();
        grid.add(petGenderLabel, 0, 3);
        grid.add(petGenderField, 1, 3);

        Label petAgeLabel = new Label("Age:");
        TextField petAgeField = new TextField();
        grid.add(petAgeLabel, 0, 4);
        grid.add(petAgeField, 1, 4);

        Label petAddressLabel = new Label("Address:");
        TextField petAddressField = new TextField();
        grid.add(petAddressLabel, 0, 5);
        grid.add(petAddressField, 1, 5);

        Label petColorLabel = new Label("Color:");
        TextField petColorField = new TextField();
        grid.add(petColorLabel, 0, 6);
        grid.add(petColorField, 1, 6);

        Label petIllnessesLabel = new Label("Illnesses:");
        TextField petIllnessesField = new TextField();
        grid.add(petIllnessesLabel, 0, 7);
        grid.add(petIllnessesField, 1, 7);

        Button saveButton = new Button("Save Record");
        Button displayButton = new Button("Display Next Record");
        grid.add(saveButton, 0, 8);
        grid.add(displayButton, 1, 8);

        Label messageLabel = new Label();
        grid.add(messageLabel, 0, 9, 2, 1);

        saveButton.setOnAction(e -> {
            try {
                String ownerName = ownerNameField.getText();
                String petName = petNameField.getText();
                String species = petSpeciesField.getText();
                String gender = petGenderField.getText();
                int age = Integer.parseInt(petAgeField.getText());
                if (age < 0 || age > 30 {// Assuming pets' age should reasonably be between 0 and 30
                    messageLabel.settext("Invalid age input! Age must be between 0 and 3-.");
                    return;
                }
                String address = petAddressField.getText();
                String color = petColorField.getText();
                String illnesses = petIllnessesField.getText();
                Pet pet = new Pet(petName, species, new Date(), ownerName, gender, age, address, color, illnesses);
                store.addAnimal(pet);
                messageLabel.setText("Record saved successfully!");

                // Clear fields
                ownerNameField.clear();
                petNameField.clear();
                petSpeciesField.clear();
                petGenderField.clear();
                petAgeField.clear();
                petAddressField.clear();
                petColorField.clear();
                petIllnessesField.clear();
            } catch (NumberFormatException ex) {
                messageLabel.setText("Invalid input! Age must be a number.");
            }
        });

        displayButton.setOnAction(e -> {
            if (!store.getAnimals().isEmpty()) {
                Pet pet = (Pet) store.getAnimal(currentIndex);
                messageLabel.setText(String.format("Owner: %s, Pet: %s, Species: %s", pet.getOwnerName(), pet.getName(), pet.getSpecies()));
                currentIndex = (currentIndex + 1) % store.getAnimals().size();
            } else {
                messageLabel.setText("No records available.");
            }
        });

        Button saveFileButton = new Button("Save to File");
        Button loadFileButton = new Button("Load from File");
        grid.add(saveFileButton, 0, 10);
        grid.add(loadFileButton, 1, 10);

        saveFileButton.setOnAction(e -> {
            try {
                store.saveToFile("pets.txt");
                messageLabel.setText("Records saved to file.");
            } catch (IOException ex) {
                messageLabel.setext("Failed to save records: " = ex.getMessage ());
            }
        });
        
        loadFileButton.setOnAction(e -> {
            try {
                store.loadFromFile("pets.txt");
                messageLabel.setText("Records loaded from file.");
            } catch (IOExeption ex) {
                messageLabel.settext("Failed to load records : " + ex.getMessage());
            }
        });

        Button searchButton = new Button("Search");
        TextField searchField = new TextField();
        grid.add(new Label("Search by Pet Name:"), 0, 11);
        grid.add(searchField, 1, 11);
        grid.add(searchButton, 1, 12);

        searchButton.setOnAction(e -> {
            String searchName = searchField.getText();
            for (Animal animal : store.getAnimals()) {
                if (animal.getName().equalsIgnoreCase(searchName) && animal instanceof Pet) {
                    Pet pet = (Pet) animal;
                    messageLabel.setText(String.format("Found: Owner: %s, Pet: %s, Species: %s", pet.getOwnerName(), pet.getName(), pet.getSpecies()));
                    return;
                }
            }
            messageLabel.setText("Pet not found.");
        });

        Scene scene = new Scene(grid, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
