package warehouse;

public class Address {
    private String street, city, country;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Adress(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }


    public String toSingleLine() {
        return street + " , " + city + " , " + country;
    }
}
