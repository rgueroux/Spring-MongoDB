package hello;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "clients")
public class Customer {

    @Id
    public String id;
    public String firstName;
    public String lastName;

    public Date birthDate;
    public String email;
    public String address;

    public Customer() {}
    public Customer(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s', birthDate='%s', email='%s', address='%s']",
                id, firstName, lastName, birthDate, email, address);
    }
}
