package src;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Animal> animals;

    public Store() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public Animal getAnimal(int index) {
        if (index >= 0 && index < animals.size()) {
            return animals.get(index);
        }
        return null;
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (Animal animal : animals) {
                if (animal instanceof Pet) {
                    Pet pet = (Pet) animal;
                    writer.write(String.format("%s,%s,%s,%s,%s,%d,%s,%s,%s,%b%n",
                            pet.getOwnerName(), pet.getName(), pet.getSpecies(), pet.getGender(), sdf.format(pet.getRegistrationDate()),
                            pet.getAge(), pet.getAddress(), pet.getColor(), pet.getIllnesses(), pet.isPaid()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 10) {
                    Pet pet = new Pet(parts[1], parts[2], sdf.parse(parts[4]), parts[0], parts[3], Integer.parseInt(parts[5]), parts[6], parts[7], parts[8]);
                    pet.setPaid(Boolean.parseBoolean(parts[9]));
                    animals.add(pet);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public Pet searchByName(String name) {
        for (Animal animal : animals) {
            if (animal instanceof Pet && animal.getName().equalsIgnoreCase(name)) {
                return (Pet) animal;
            }
        }
        return null;
    }

    public void swapAnimals(int index1, int index2) {
        if (index1 >= 0 && index1 < animals.size() && index2 >= 0 && index2 < animals.size()) {
            Animal temp = animals.get(index1);
            animals.set(index1, animals.get(index2));
            animals.set(index2, temp);
        }
    }
}
