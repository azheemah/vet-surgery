package src;
import java.util.Date;

public class Pet extends Animal {
    private String ownerName;
    private String gender;
    private int age;
    private String address;
    private String color;
    private String illnesses;
    private boolean paid;

    public Pet(String name, String species, Date registrationDate, String ownerName, String gender, int age, String address, String color, String illnesses) {
        super(name, species, registrationDate);
        this.ownerName = ownerName;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.color = color;
        this.illnesses = illnesses;
        this.paid = false;
    }

    // Getters and Setters
    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getIllnesses() { return illnesses; }
    public void setIllnesses(String illnesses) { this.illnesses = illnesses; }

    public boolean isPaid() { return paid; }
    public void setPaid(boolean paid) { this.paid = paid; }
}
