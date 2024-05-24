package src;
public class Location {
    private String address;
    private String city;
    private String postCode;

    public Location(String address, String city, String postCode) {
        this.address = address;
        this.city = city;
        this.postCode = postCode;
    }

    // Getters and Setters
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getPostCode() { return postCode; }
    public void setPostCode(String postCode) { this.postCode = postCode; }
}
