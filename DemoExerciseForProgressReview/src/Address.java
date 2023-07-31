public class Address {
    private String city;
    private String country;
    private String street;

    public Address(String country, String city, String street) {
        this.city = city;
        this.country = country;
        this.street = street;
    }

    public Address() {

    }

    public String printAddress() {
        return new String(String.format("""
                                           Country: %s
                                           City: %s
                                           Street: %s
                                        """, country, city, street));
    }

}
