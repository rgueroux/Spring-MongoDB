package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CustomerRepository repository;

//    @Override
//    public Customer findByEmail(String email){
//        Query query = new Query();
//        query.addCriteria(Criteria.where("lastname").is(email));
//        return mongoTemplate.findOne(query, Customer.class);
//    }

//    @Override
//    public Person findOneByName(String name) {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("name").is(name));
//        return mongoTemplate.findOne(query, Person.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();
// save a couple of customers
        repository.save(new Customer("Alice", "Smith", "9 rue du poireau"));
        repository.save(new Customer("Bob", "Smith", "1 rue de Feu"));
// fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();
// fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Alice"));
        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : repository.findByLastName("Smith")) {
            System.out.println(customer);
        }
//        List<Customer> maListe = findByEmail("Smith");
//        System.out.println(maListe);
    }
}