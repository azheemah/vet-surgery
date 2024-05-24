package src;
import java.util.Date;

public class Animal {
    private String name;
    private String species;
    private Date registrationDate;

    public Animal(String name, String species, Date registrationDate) {
        this.name = name;
        this.species = species;
        this.registrationDate = registrationDate;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public Date getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(Date registrationDate) { this.registrationDate = registrationDate; }
}
